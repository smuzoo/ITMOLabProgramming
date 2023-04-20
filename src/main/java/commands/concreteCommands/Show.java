package commands.concreteCommands;

import collection.VehicleCollection;
import commands.Command;

import static collection.VehicleCollection.vehicleHashMapCollection;

public class Show implements Command {


    @Override
    public void execute(String ignore){
        System.out.println("Коллекция HashMap<java.util.UUID, HumanBeing>");
        System.out.println("Дата последнего изменения коллекции: " + VehicleCollection.getDateOfLastChange());
        System.out.println("Дата создания коллекции: " + VehicleCollection.getDateOfInitialization());
        System.out.println("Количество элементов в коллекции: " + VehicleCollection.getCountVehicleCollection());
    }


    @Override
    public String description() {
        return "show :" + "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
