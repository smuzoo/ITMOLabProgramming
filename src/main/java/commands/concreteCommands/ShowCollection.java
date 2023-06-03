package commands.concreteCommands;

import collection.Vehicle;
import collection.VehicleCollection;
import commands.Command;

import java.util.Collection;

/**
 * The type Show collection.
 */
public class ShowCollection implements Command {
    @Override
    public void execute(String ignore) {

        Collection<Vehicle> vehicles = VehicleCollection.getVehicles();

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }


    @Override
    public String description() {
        return "show" + " : вывести в стандартный поток вывода все элементы коллекции " +
                "и ключи к ним соответственно в строковом представлении";

    }
}
