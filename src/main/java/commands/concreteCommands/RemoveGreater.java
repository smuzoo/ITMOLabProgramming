package commands.concreteCommands;

import collection.Vehicle;
import collection.VehicleCollection;
import collection.edit.VehicleCreate;
import commands.Command;
import parsers.Parsing;

import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class RemoveGreater implements Command {

    private final Parsing parsing;

    public RemoveGreater(Parsing parsing) {
        this.parsing = parsing;
    }


    @Override
    public void execute(String ignore) {
        VehicleCreate vehicleCreate = new VehicleCreate(parsing);
        Vehicle vehicle = vehicleCreate.create();
        Set<Map.Entry<String, Vehicle>> vehicleEntrySet = VehicleCollection.getEntrySet();
        //Stream<Map.Entry<String, Vehicle>> vehicleFilter =vehicleEntrySet.stream().filter().filter(vehicleInCollection -> vehicleInCollection.setValue().compareTo(vehicle) < 0 &&
        vehicleEntrySet.removeIf(vehicleInCollection -> vehicleInCollection.getValue().compare(vehicle) < 0);
        System.out.println("Все элементы больше заданного были удалены");
    }

    @Override
    public String description() {
        return "remove_greater" + " {element}" + " : удалить из коллекции все элементы, превышающие заданный";
    }
}
