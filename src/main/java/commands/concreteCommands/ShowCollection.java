package commands.concreteCommands;

import collection.Vehicle;
import collection.VehicleCollection;
import commands.Command;

import java.util.Map;
import java.util.UUID;

public class ShowCollection implements Command {
    @Override
    public void execute(String ignore){
        Map<UUID, Vehicle> humanBeingCollection = VehicleCollection.getHumanBeingCollection();
        for(Vehicle human : humanBeingCollection.values()){
            System.out.println(human);
        }
    }

    @Override
    public String description(){
        return "show" + " : вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
