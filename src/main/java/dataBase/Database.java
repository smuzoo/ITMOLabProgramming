package dataBase;

import collection.FuelType;
import collection.Vehicle;
import collection.VehicleType;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.UUID;

public class Database {
    DataBaseProperties config = new DataBaseProperties("localhost");
    String URL = config.getDatabaseUrl();
    String USER = config.getDatabaseUsername();
    String PASSWORD = config.getDatabasePassword();
    private static Database instance = null;
    private Connection connection;

    private Database() {


        try {
            // Подключаемся к базе данных
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            //System.err.println("Ошибка подключения к базе данных: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to establish a database connection.", e);
        }
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public boolean isExistInDB(String table, String field, String valueField) {
        String sqlRequest = "SELECT * FROM " + table + " WHERE " + field + " = ?";
        ResultSet resultSet = executePrepareStatement(sqlRequest, valueField);
        if (resultSet == null) return false;
        try {
            return resultSet.next();
        } catch (SQLException e) {
            System.err.println("Ошибка выполнения запроса: " + e.getMessage());
            return false;
        }
    }

    public void addUserToDB(String table, String login, String salt, String hash) {
        String sqlRequest = "INSERT INTO " + table + " (login, salt, hash) VALUES (?, ?, ?)";
        executePrepareStatement(sqlRequest, login, salt, hash);
    }

    public String getFieldByField(String table, String setField, String valueSetField, String getField) {
        String sqlRequest = "SELECT " + getField + " FROM " + table + " WHERE " + setField + " = ?";
        ResultSet resultSet = executePrepareStatement(sqlRequest, valueSetField);
        try {
            resultSet.next();
            return resultSet.getString(getField);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet getVehicles() {
        String sqlRequest = "SELECT * FROM vehicles";
        return executePrepareStatement(sqlRequest);
    }

    public ResultSet getNewId(String table) {
        String sqlRequest = "SELECT nextval (?)";
        return executePrepareStatement(sqlRequest, table);
    }

    public int addVehicleToDatabase(String table, Vehicle vehicle) {
        return addNewVehicle(table,vehicle.getId(), vehicle.getName(), vehicle.getCoordinates().getX(),
                vehicle.getCoordinates().getY(), vehicle.getCreationDate(), vehicle.getEnginePower(),
                vehicle.getVehicleType(), vehicle.getFuelType(), vehicle.getUserLogin(), vehicle.getUuid(), vehicle.getKey());
    }

    /*private int addNewVehicle(String table, String name, int x, double y, LocalDateTime creationDate,
                              Long enginePower, VehicleType vehicleType, FuelType fuelType, UUID id, String key) {
        String sqlRequest = "INSERT INTO " + table + " (name, coordinate_x, coordinate_y, creation_date, engine_power, " +
                "vehicle_type, fuel_type, uuid, key) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, x);
            preparedStatement.setDouble(3, y);
            preparedStatement.setTimestamp(4, Timestamp.valueOf(creationDate));
            preparedStatement.setLong(5, enginePower);
            preparedStatement.setString(6, vehicleType != null ? vehicleType.toString() : null);
            preparedStatement.setString(7, fuelType != null ? fuelType.toString() : null);
            preparedStatement.setObject(8, id);
            preparedStatement.setString(9, key);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
    private int addNewVehicle(String table, Long vehicleId, String name, int x, double y, LocalDateTime creationDate,
                              Long enginePower, VehicleType vehicleType, FuelType fuelType, String userLogin, UUID id, String key) {
        String sqlRequest = "INSERT INTO " + table + " (id, name, coordinate_x, coordinate_y, creation_date, engine_power, " +
                "vehicle_type, fuel_type, user_login, key) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Database db = Database.getInstance();
            connection = db.getConnection(); // Obtain the database connection
            preparedStatement = connection.prepareStatement(sqlRequest);
            preparedStatement.setLong(1, vehicleId);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, x);
            preparedStatement.setDouble(4, y);
            preparedStatement.setTimestamp(5, Timestamp.valueOf(creationDate));
            if (enginePower != null) {
                preparedStatement.setLong(6, enginePower);
            } else {
                preparedStatement.setNull(6, Types.BIGINT); // Set NULL for engine_power
            }
            preparedStatement.setString(7, vehicleType != null ? vehicleType.toString() : null);
            preparedStatement.setString(8, fuelType != null ? fuelType.toString() : null);
            preparedStatement.setString(9, userLogin);
            preparedStatement.setString(10, key);

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {

                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {

                }
            }
        }
    }



    public ResultSet executePrepareStatement(String sqlRequest, String... values) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            for (int i = 0; i < values.length; i++) {
                preparedStatement.setString(i + 1, values[i]);
            }
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            String sqlState = e.getSQLState();
            System.err.println("SQL state: " + sqlState);
            return null;
        }
    }

    public int truncateTable(String table) {
        String sqlRequest = "TRUNCATE TABLE " + table;
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sqlRequest);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteById(String table, UUID id) {
        String sqlRequest = "DELETE FROM " + table + " WHERE uuid = ?";
        try (PreparedStatement psmt = connection.prepareStatement(sqlRequest)) {
            psmt.setObject(1, id);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Метод для закрытия соединения с базой данных
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Ошибка закрытия соединения с базой данных: " + e.getMessage());
        }
    }
}

