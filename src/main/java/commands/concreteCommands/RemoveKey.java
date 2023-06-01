package commands.concreteCommands;

import collection.VehicleCollection;
import commands.Command;
import dataBase.Database;
import validation.commands.RemoveElementValidatorKey;
import validation.values.UserVehicleValidator;

/**
 * The type Remove key.
 */
public class RemoveKey implements Command {
    @Override
    public void execute(String argument) {
        String key  = argument;
        RemoveElementValidatorKey removeElementValidatorKey = new RemoveElementValidatorKey(argument);
        if(removeElementValidatorKey.isValid()) {
            UserVehicleValidator userVehicleValidator = new UserVehicleValidator(VehicleCollection.getVehicle(key));
            if (userVehicleValidator.isValid()) {
                Database db = Database.getInstance();
                int update = db.deleteByKey("vehicles", key);
                if (update > 0) {
                    VehicleCollection.remove(key);
                    System.out.println("Элемент был удалён");
                }
            }
        }
    }

    @Override
    public String description() {
        return "remove_key" + " null" + " : удалить элемент из коллекции по его ключу";
    }
}
