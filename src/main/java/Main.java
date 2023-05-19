import authorization.Authentication;
import collection.VehicleCollection;
import commands.CommandController;
import org.jetbrains.annotations.NotNull;
import parsers.ConsoleParser;
import parsers.FileConstant;
import validation.env.EnvValidator;
import validation.file.FileToReadWriteValidator;

import java.io.File;
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

