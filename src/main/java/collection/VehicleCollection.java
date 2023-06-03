package collection;

import dataBase.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

/**
 * The type Vehicle collection.
 */
public class VehicleCollection {

    private final static Date dateOfInitialization = new Date();
    /**
     * The constant vehicleHashMapCollection.
     */
    public static Map<String, Vehicle> vehicleHashMapCollection = new LinkedHashMap<>();
    private static Date dateOfLastChange = new Date();

    /**
     * Clear.
     */
    public static void clear() {
        dateOfLastChange = new Date();
        vehicleHashMapCollection.clear();
    }

    /**
     * Remove.
     *
     * @param key the key
     */
    public static void remove(String key) {
        dateOfLastChange = new Date();
        vehicleHashMapCollection.remove(key);
    }

    public static void addVehicle(String key, Vehicle vehicle){
        vehicleHashMapCollection.put(key, vehicle);
    }

    /**
     * Get count vehicle collection long.
     *
     * @return the long
     */
    public static long getCountVehicleCollection() {
        return vehicleHashMapCollection.size();
    }

    /**
     * Key set collection.
     *
     * @return the collection
     */
    public static Collection<String> keySet() {
        return vehicleHashMapCollection.keySet();
    }

    /**
     * Has element boolean.
     *
     * @param key the key
     * @return the boolean
     */
    public static boolean hasElement(String key) {
        return vehicleHashMapCollection.get(key) != null;
    }

    /**
     * Get vehicles collection.
     *
     * @return the collection
     */
    public static Collection<Vehicle> getVehicles() {
        return vehicleHashMapCollection.values();
    }

    /**
     * Gets vehicle hash map collection.
     *
     * @return the vehicle hash map collection
     */
    public static Map<String, Vehicle> getVehicleHashMapCollection() {
        return vehicleHashMapCollection;
    }

    /**
     * Gets vehicle collection.
     *
     * @return the vehicle collection
     */
    public static Map<String, Vehicle> getVehicleCollection() {
        return vehicleHashMapCollection;
    }

    /**
     * Gets date of initialization.
     *
     * @return the date of initialization
     */
    public static Date getDateOfInitialization() {
        return dateOfInitialization;
    }

    /**
     * Gets date of last change.
     *
     * @return the date of last change
     */
    public static Date getDateOfLastChange() {
        return dateOfLastChange;
    }

    /**
     * Get entry set.
     *
     * @return the set
     */
    public static Set<Map.Entry<String, Vehicle>> getEntrySet() {
        return vehicleHashMapCollection.entrySet();
    }

    /**
     * Add.
     *
     * @param key     the key
     * @param vehicle the vehicle
     */
    public static void add(String key, Vehicle vehicle) {
        dateOfLastChange = new Date();
        vehicleHashMapCollection.put(key, vehicle);
    }
    public static void readFromDatabase() {
        Database database = Database.getInstance();
        ResultSet vehicleObject = database.getVehicles();
        try {
            while (vehicleObject.next()) {
                Long id = vehicleObject.getLong("id");
                String name = vehicleObject.getString("name");
                LocalDateTime creationDate = vehicleObject.getTimestamp("creation_date").toLocalDateTime();
                int x = vehicleObject.getInt("coordinate_x");
                double y = vehicleObject.getDouble("coordinate_y");
                Long enginePower = vehicleObject.getLong("engine_power");
                VehicleType vehicleType = VehicleType.valueOf(vehicleObject.getString("vehicle_type"));
                FuelType fuelType = FuelType.valueOf(vehicleObject.getString("fuel_type"));
                UUID uuid = UUID.fromString(vehicleObject.getString("uuid"));
                String key = vehicleObject.getString("key");
                String userLogin = vehicleObject.getString("user_login");
                Vehicle vehicle = new Vehicle(id, uuid, name, new Coordinates(x, y), creationDate, enginePower, vehicleType, fuelType, key, userLogin);
                addVehicle(key, vehicle);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public boolean containsKey(String key) {
        return keySet().stream().anyMatch(mapKey -> mapKey.equals(key));
    }


    public static Vehicle getVehicle(String key) {
        return vehicleHashMapCollection.get(key);
    }
}


