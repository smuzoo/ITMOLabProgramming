import collection.VehicleCollection;
import commands.CommandController;
import org.jetbrains.annotations.NotNull;
import parsers.ConsoleParser;
import validation.env.EnvValidator;
import validation.file.FileToReadWriteValidator;

import java.io.File;


public class Main {
    public static void main(String @NotNull [] args) {
        //valid на filepath
        EnvValidator envValidator = new EnvValidator(args.length);
        envValidator.validateWithExit();
        final String FILEPATH = args[0];
        VehicleCollection.read(FILEPATH);
        FileToReadWriteValidator fileValidatorToReadAndWrite = new FileToReadWriteValidator(new File(FILEPATH));
        fileValidatorToReadAndWrite.validateWithExit();
        ConsoleParser parser = new ConsoleParser();
        CommandController commandController = new CommandController(parser);
        String request;
        while(!((request = parser.getNewLine()).equals("exit"))){
            commandController.executeCommand(request);
        }




    }

}
