package commands.concreteCommands;

import commands.Command;
import parsers.ConsoleParser;

/**
 * The type Update id.
 */
public class UpdateID implements Command {
    @Override
    public void execute(String argument) {
        RemoveKey removeKey = new RemoveKey();
        removeKey.execute(argument);
        InsertVehicle insertVehicle = new InsertVehicle(new ConsoleParser());
        insertVehicle.execute(argument);


    }

    @Override
    public String description() {
        return "update_id " + "{element} " + ": обновить значение элемента коллекции, id которого равен заданному";
    }
}
