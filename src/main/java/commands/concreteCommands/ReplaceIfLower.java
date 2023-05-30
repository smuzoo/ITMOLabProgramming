package commands.concreteCommands;

import collection.Vehicle;
import collection.VehicleCollection;
import collection.edit.VehicleCreate;
import commands.Command;
import parsers.Parsing;

import java.util.UUID;

/**
 * The type Replace if lower.
 */
public class ReplaceIfLower implements Command {

    private final Parsing parsing;

    /**
     * Instantiates a new Replace if lower.
     *
     * @param parsing the parsing
     */
    public ReplaceIfLower(Parsing parsing) {
        this.parsing = parsing;
    }

    @Override
    public void execute(String argument) {
        VehicleCreate vehicleCreate = new VehicleCreate(parsing);
        Vehicle vehicle = vehicleCreate.create();

        try {
            if (VehicleCollection.getVehicleCollection().get(argument).getEnginePower() > vehicle.getEnginePower()) {
                RemoveKey removeKey = new RemoveKey();
                removeKey.execute(argument);
                vehicle.setKey(argument);
                vehicle.setUUID(UUID.randomUUID());
                VehicleCollection.add(argument, vehicle);
            }
        } catch (NullPointerException e) {
            System.out.println("У одного из сравниваемых объектов сила двигателя null, их невозможно сравнить");
        }
    }


    @Override
    public String description() {
        return "replace_if_lower null {element} : заменить значение по ключу, если новое значение меньше старого";
    }
}
