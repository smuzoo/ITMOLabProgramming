package commands;


import parsers.Parsing;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    private final Map<String, Command> commandMap
            = new HashMap<>();
    final Parsing parser;


    public Controller(Parsing parser) {
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
        //addCommand("show", new);

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

