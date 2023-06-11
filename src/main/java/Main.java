import authorization.Authentication;
import collection.VehicleCollection;
import commands.CommandController;
import parsers.ConsoleParser;

import java.util.NoSuchElementException;


/**
 * The type Main.
 */
public class Main {
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args) {
        try {
            //Database db = Database.getInstance();
            VehicleCollection.readFromDatabase();
            Authentication.setReader(new ConsoleParser());
            Authentication.auth();
            ConsoleParser parser = new ConsoleParser();
            CommandController commandController = new CommandController(parser);
            String request;
            while (!((request = parser.getNewLine()).equals("exit"))) {
                commandController.executeCommand(request);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Неверный ввод, выход из программы");
        }
    }


}

