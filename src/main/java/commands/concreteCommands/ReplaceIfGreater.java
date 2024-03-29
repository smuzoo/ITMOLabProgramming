package commands.concreteCommands;

import collection.Vehicle;
import collection.VehicleCollection;
import collection.edit.VehicleCreate;
import commands.Command;
import dataBase.Database;
import parsers.Parsing;
import validation.commands.RemoveElementValidatorKey;

import java.util.UUID;


/**
 * The type Replace if greater.
 */
public class ReplaceIfGreater implements Command {
    private final Parsing parsing;

    public ReplaceIfGreater(Parsing parsing) {
        this.parsing = parsing;
    }

    @Override
    public void execute(String argument) {
        RemoveElementValidatorKey removeElementValidatorKey = new RemoveElementValidatorKey(argument);
        if (removeElementValidatorKey.isValid()) {
            VehicleCreate vehicleCreate = new VehicleCreate(parsing);
            Vehicle vehicle = vehicleCreate.create();

            VehicleCollection.getVehicleCollection().entrySet().stream()
                    .filter(entry -> entry.getKey().equals(argument))
                    .filter(entry -> entry.getValue().getEnginePower() < vehicle.getEnginePower())
                    .findFirst()
                    .ifPresent(entry -> {
                        Vehicle currentVehicle = entry.getValue();

                        currentVehicle.setKey(entry.getKey());
                        currentVehicle.setUUID(UUID.randomUUID());
                        System.out.println("Заменен объект со значением " + currentVehicle);

                        Database dataBase = Database.getInstance();
                        int update = dataBase.updateVehicleInDatabase("vehicles", currentVehicle);

                        System.out.println(update > 0 ? "Данные объекта обновлены" : "Не удалось обновить данные объекта в базе данных");
                    });

            if (!VehicleCollection.getVehicleCollection().containsKey(argument)) {
                System.out.println("Объект не заменен, так как старый больше");
            }
        }
    }









    @Override
    public String description() {
        return "replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого";
    }
}
