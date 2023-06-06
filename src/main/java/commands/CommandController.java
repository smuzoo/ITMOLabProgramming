package commands;


import authorization.Authentication;
import authorization.User;
import commands.concreteCommands.*;
import commands.concreteCommands.ExecuteScript.ExecuteScript;
import parsers.Parsing;
import validation.values.NotEqualsValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Command controller.
 */
public class CommandController {
    /**
     * The Parsing.
     */
    final Parsing parsing;
    private final Map<String, Command> commandMap
            = new HashMap<>();
    private List<String> historyFiles;


    /**
     * Instantiates a new Command controller.
     *
     * @param parsing the parsing
     */
    public CommandController(Parsing parsing) {
        this.parsing = parsing;
        initialization();
    }

    /**
     * Instantiates a new Command controller.
     *
     * @param parsing      the parsing
     * @param historyFiles the history files
     */
    public CommandController(Parsing parsing, List<String> historyFiles) {
        this.parsing = parsing;
        this.historyFiles = historyFiles;
        initialization();
    }


    /**
     * Execute command.
     *
     * @param commandText the command text
     */
    public void executeCommand(String commandText) {
        final String[] commandWithArgument = commandText.split(" ");
        final String commandName = commandWithArgument.length > 0 ? commandWithArgument[0] : "";
        final String argument = commandWithArgument.length > 1 ? commandWithArgument[1] : "";
        Command command = getCommand(commandName);
        if (!User.isLogin()) {
            String action;
            System.out.println("У вас нет доступа к командам, т.к. вы не вошли в систему");
            do {
                System.out.println("Хотите войти в систему? +" +
                        "\n"+ "(y/n/exit)");
                action = parsing.getNewLine();
            }while (!(new NotEqualsValidator(action, "y", "n", "exit").isValid()));
            if(action.equals("y")) Authentication.auth();
            else if (action.equals("exit")) System.exit(0);

        }
        if (command == null) System.out.println("Нет такой команды");
        else {
            command.execute(argument);
        }
    }


    private void initialization() {
        addCommand("info", new Info());
        addCommand("exit", new Exit());
        addCommand("help", new Help());
        addCommand("clear", new Clear());
        addCommand("remove_key", new RemoveKey());
        addCommand("show", new ShowCollection());
        addCommand("insert", new InsertVehicle(parsing));
        addCommand("execute_script", new ExecuteScript());
        addCommand("remove_greater", new RemoveGreater(parsing));
        addCommand("filer_greater_than_engine_power", new FilterGreaterThanEnginePower());
        addCommand("average_of_engine_power", new AverageOfEnginePower());
        addCommand("min_by_creation_date", new MinByCreationTime());
        addCommand("update_id", new UpdateKey());
        addCommand("replace_if_greater", new ReplaceIfGreater(parsing));
        addCommand("replace_if_lower", new ReplaceIfLower(parsing));


    }

    private void addCommand(String nameCommand, Command command) {
        commandMap.put(nameCommand, command);
    }


    /**
     * Gets commands.
     *
     * @return the commands
     */
    public Map<String, Command> getCommands() {
        return commandMap;
    }

    private Command getCommand(String commandName) {
        return commandMap.get(commandName);
    }
}

