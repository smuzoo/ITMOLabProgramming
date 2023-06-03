package commands.concreteCommands;

import authorization.User;
import collection.Vehicle;
import collection.VehicleCollection;
import collection.edit.VehicleCreate;
import commands.Command;
import dataBase.Database;
import parsers.Parsing;

import java.util.Map;
import java.util.Set;

/**
 * The type Remove greater.
 */
public class RemoveGreater implements Command {

    private final Parsing parsing;

    /**
     * Instantiates a new Remove greater.
     *
     * @param parsing the parsing
     */
    public RemoveGreater(Parsing parsing) {
        this.parsing = parsing;
    }


    @Override
    public void execute(String ignore) {
        VehicleCreate vehicleCreate = new VehicleCreate(parsing);
        Vehicle vehicle = vehicleCreate.create();
        Set<Map.Entry<String, Vehicle>> vehicleEntrySet = VehicleCollection.getEntrySet();

        try {
            String userLogin = User.getLogin();
            vehicleEntrySet.removeIf(vehicleInCollection -> {
                boolean isUserVehicle = vehicleInCollection.getValue().compare(vehicle) < 0;
                boolean isCreatedByCurrentUser = vehicleInCollection.getValue().getUserLogin().equals(userLogin);
                return isUserVehicle && isCreatedByCurrentUser;
            });

            System.out.println("Все элементы больше заданного, созданные текущим пользователем, были удалены");

            Database database = Database.getInstance();
            for (Map.Entry<String, Vehicle> entry : vehicleEntrySet) {
                String key = entry.getKey();
                database.deleteByKey("vehicles", key);
            }



        } catch (NullPointerException e) {
            System.out.println("У одного из сравниваемых объектов сила двигателя null, их невозможно сравнить");
        }
    }


    @Override
    public String description() {
        return "remove_greater" + " {element}" + " : удалить из коллекции все элементы, превышающие заданный";
    }
}
