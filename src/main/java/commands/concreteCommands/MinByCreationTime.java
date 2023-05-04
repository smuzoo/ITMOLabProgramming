package commands.concreteCommands;

import collection.Vehicle;
import collection.VehicleCollection;
import commands.Command;

import java.util.Comparator;

/**
 * The type Min by creation time.
 */
public class MinByCreationTime implements Command {
    @Override
    public void execute(String argument) {
        System.out.println(VehicleCollection.getVehicles().stream().min(Comparator.comparing(Vehicle::getCreationDate)));
    }

    @Override
    public String description() {
        return "min_by_creation_date" + " : вывести любой объект из коллекции, значение поля creationDate которого является минимальным";
    }
}
