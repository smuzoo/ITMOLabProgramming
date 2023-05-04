package commands.concreteCommands;

import commands.Command;

/**
 * The type Exit.
 */
public class Exit implements Command {

    @Override
    public void execute(String ignore) {
        System.exit(0);
    }

    @Override
    public String description() {
        return "exit : завершить программу (без сохранения в файл)";
    }
}
