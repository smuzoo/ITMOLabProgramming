import collection.VehicleCollection;
import commands.CommandController;
import org.jetbrains.annotations.NotNull;
import parsers.ConsoleParser;
import parsers.FileConstant;
import validation.env.EnvValidator;
import validation.file.FileToReadWriteValidator;

import java.io.File;


public class Main {
    public static void main(String @NotNull [] args) {
        //valid на filepath
        EnvValidator envValidator = new EnvValidator(args.length);
        envValidator.validateWithExit();
        final String FILEPATH = args[0];
        FileToReadWriteValidator fileValidatorToReadAndWrite = new FileToReadWriteValidator(new File(FILEPATH));
        fileValidatorToReadAndWrite.validateWithExit();
        FileConstant.setFilePath(FILEPATH);
        VehicleCollection.read(FILEPATH);
        ConsoleParser parser = new ConsoleParser();
        CommandController commandController = new CommandController(parser);
        String request;
        while(!((request = parser.getNewLine()).equals("exit"))){
            commandController.executeCommand(request);
        }




    }

}
