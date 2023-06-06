package commands.concreteCommands;

import collection.Vehicle;
import collection.VehicleCollection;
import collection.edit.VehicleCreate;
import commands.Command;
import parsers.Parsing;
import validation.commands.RemoveElementValidatorKey;

import java.util.UUID;


/**
 * The type Replace if greater.
 */
public class ReplaceIfGreater implements Command {

    private final Parsing parsing;

    /**
     * Instantiates a new Replace if greater.
     *
     * @param parsing the parsing
     */
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
                        RemoveKey removeKey = new RemoveKey();
                        removeKey.execute(entry.getKey());
                        vehicle.setKey(entry.getKey());
                        vehicle.setUUID(UUID.randomUUID());
                        VehicleCollection.add(entry.getKey(), vehicle);
                        System.out.println("Заменен объект со значением " + entry.getValue().toString());
                    });

            if (VehicleCollection.getVehicleCollection().get(argument) == null) {
                System.out.println("Объект не заменен, так как старый больше");
            }
        }
    }


    @Override
    public String description() {
        return "replace_if_greater null {element} : заменить значение по ключу, если новое значение больше старого";
    }
}
