package commands.concreteCommands;

import collection.VehicleCollection;
import commands.Command;

/**
 * The type Info.
 */
public class Info implements Command {


    @Override
    public void execute(String ignore) {
        System.out.println("Коллекция HashMap<Key, HumanBeing>");
        System.out.println("Дата последнего изменения коллекции: " + VehicleCollection.getDateOfLastChange());
        System.out.println("Дата создания коллекции: " + VehicleCollection.getDateOfInitialization());
        System.out.println("Количество элементов в коллекции: " + VehicleCollection.getCountVehicleCollection());
    }


    @Override
    public String description() {
        return "info :" + "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
