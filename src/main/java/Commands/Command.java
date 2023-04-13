package Commands;

public interface Command {
    void execute(String argument);
    String description();
}
