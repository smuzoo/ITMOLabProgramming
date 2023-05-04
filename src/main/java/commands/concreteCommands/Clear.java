package commands.concreteCommands;

import collection.VehicleCollection;
import commands.Command;

/**
 * The type Clear.
 */
public class Clear implements Command {
    @Override
    public void execute(String ignore) {
        VehicleCollection.clear();
        System.out.println("Коллекция успешно очищена");
    }

    @Override
    public String description() {
        return "clear" + " : очистить коллекцию";
    }
}
