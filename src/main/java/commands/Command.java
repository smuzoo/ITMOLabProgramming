package commands;

/**
 * The interface Command.
 */
public interface Command {
    /**
     * Execute.
     *
     * @param argument the argument
     */
    void execute(String argument);

    /**
     * Description string.
     *
     * @return the string
     */
    String description();
}
