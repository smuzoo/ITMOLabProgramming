package commands;


import commands.concreteCommands.*;
import parsers.Parsing;

import java.util.HashMap;
import java.util.Map;

public class CommandController {
    private final Map<String, Command> commandMap
            = new HashMap<>();
    final Parsing parser;


    public CommandController(Parsing parser) {
        this.parser = parser;
        initialization();
    }


    public void executeCommand(String commandText){
        final String[] commandWithArgument = commandText.split(" ");
        final String commandName = commandWithArgument.length > 0 ? commandWithArgument[0] : "";
        final String argument = commandWithArgument.length > 1 ? commandWithArgument[1] : "";
        Command command = getCommand(commandName);
        if (command == null) System.out.println("Нет такой команды");
        else {
            command.execute(argument);
        }
    }
    private void initialization(){
        addCommand("info", new Info());
        addCommand("exit", new Exit());
        addCommand("help", new Help());
        addCommand("clear", new Clear());
        addCommand("remove_key", new RemoveKey());
        addCommand("show", new ShowCollection());
        addCommand("insert", new InsertVehicle(parser));
        addCommand("save", new Save());


    }

    private void addCommand(String nameCommand, Command command) {
        commandMap.put(nameCommand, command);
    }




    public Map<String, Command> getCommands() {
        return commandMap;
    }

    private Command getCommand(String commandName) {
        return commandMap.get(commandName);
    }
}

