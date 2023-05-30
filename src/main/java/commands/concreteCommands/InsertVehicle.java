package commands.concreteCommands;

import authorization.User;
import collection.Vehicle;
import collection.VehicleCollection;
import collection.edit.VehicleCreate;
import commands.Command;
import dataBase.Database;
import parsers.Parsing;
import validation.values.KeyValidator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * The type Insert vehicle.
 */
public class InsertVehicle implements Command {
    private final Parsing parser;

    /**
     * Instantiates a new Insert vehicle.
     *
     * @param parser the parser
     */
    public InsertVehicle(Parsing parser) {
        this.parser = parser;
    }

    @Override
    public void execute(String keyArgument) {
        VehicleCreate vehicleCreate = new VehicleCreate(parser);
        final String newKey = keyArgument;
        KeyValidator keyValidator = new KeyValidator(keyArgument);
        if (keyValidator.isValid()) {
            if (VehicleCollection.keySet().stream().anyMatch(key -> key.equals(newKey))) {
                System.out.println("Элемент с таким ключом уже есть");
            } else {
                String key = keyArgument;
                Vehicle vehicle = vehicleCreate.create();
                vehicle.setUUID(UUID.randomUUID());
                vehicle.setKey(keyArgument);
                vehicle.setUserLogin(User.getLogin());
                Database dataBase = Database.getInstance();
                ResultSet resultSet = dataBase.getNewId("vehicle_sequence");
                Long id = null;
                try {
                    resultSet.next();
                    id = resultSet.getLong(1);
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }
                vehicle.setId(id);
                int update = dataBase.addVehicleToDatabase("vehicles", vehicle);


                if (update > 0) {
                    VehicleCollection.add(key, vehicle);

                    System.out.println("Элемент успешно добавлен в коллекцию");
                }
            }
        }


    }

    @Override
    public String description() {
        return "insert" + " null {element}" + " : добавить новый элемент с заданным ключом";
    }
}
