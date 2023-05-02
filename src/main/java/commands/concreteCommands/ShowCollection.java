package commands.concreteCommands;

import collection.VehicleCollection;
import commands.Command;

public class ShowCollection implements Command {
    @Override
    public void execute(String ignore){

        //Map<Key, Vehicle> vehicleCollection = VehicleCollection.getVehicleCollection();

        VehicleCollection.getKeys().forEach(System.out::println);
        VehicleCollection.getVehicles().forEach(System.out::println);

    }

    @Override
    public String description(){
        return "show" + " : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
