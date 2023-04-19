package commands.concreteCommands;
import commands.*;
import parsers.ConsoleParser;

import java.util.Map;


public class Help implements Command {


    @Override
    public void execute(String ignore) {
        Controller controller = new Controller(new ConsoleParser());
        Map<String, Command> commandMap = controller.getCommands();
        for(Command command : commandMap.values()){
            System.out.println(command.description());
        }

    }

    @Override
    public String description() {
        return null;
    }
}
