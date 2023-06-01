package commands.concreteCommands;

import collection.Vehicle;
import collection.VehicleCollection;
import collection.edit.VehicleCreate;
import commands.Command;
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
        //Stream<Map.Entry<String, Vehicle>> vehicleFilter =vehicleEntrySet.stream().filter().filter(vehicleInCollection -> vehicleInCollection.setValue().compareTo(vehicle) < 0 &&

        //Добавить Датабазу и UserValidator
        try {
            vehicleEntrySet.removeIf(vehicleInCollection -> vehicleInCollection.getValue().compare(vehicle) < 0);
            System.out.println("Все элементы больше заданного были удалены");
        } catch (NullPointerException e) {
            System.out.println("У одного из сравниваемых объектов сила двигателя null, их невозможно сравнить");
        }
    }

    @Override
    public String description() {
        return "remove_greater" + " {element}" + " : удалить из коллекции все элементы, превышающие заданный";
    }
}
