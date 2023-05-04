package commands.concreteCommands;

import commands.Command;
import commands.CommandController;
import parsers.ConsoleParser;

import java.util.Map;


/**
 * The type Help.
 */
public class Help implements Command {


    @Override
    public void execute(String ignore) {
        CommandController commandController = new CommandController(new ConsoleParser());
        Map<String, Command> commandMap = commandController.getCommands();
        for (Command command : commandMap.values()) {
            System.out.println(command.description());
        }

    }

    @Override
    public String description() {
        return "help" + " : показать доступные комманды";
    }
}
