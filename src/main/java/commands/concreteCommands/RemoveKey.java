package commands.concreteCommands;

import collection.VehicleCollection;
import commands.Command;

import java.util.UUID;

public class RemoveKey implements Command {
    @Override
    public void execute(String argument){

            VehicleCollection.remove(argument);
            System.out.println("Элемент был удалён");

    }

    @Override
    public String description(){
        return "remove_key" + " null" + " : удалить элемент из коллекции по его ключу";
    }
}
