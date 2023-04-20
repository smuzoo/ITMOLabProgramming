import collection.VehicleCollenction;
import commands.Controller;
import org.jetbrains.annotations.NotNull;
import parsers.ConsoleParser;
import parsers.ParserController;
import validation.env.EnvValidator;
import validation.file.FileToReadWriteValidator;

import static parsers.NameParser.PARSER_CONSOLE;


public class Main {
    public static void main(String @NotNull [] args) {
        //valid на filepath
        EnvValidator envValidator = new EnvValidator(args.length);
        envValidator.validateWithExit();
        final String FILEPATH = args[0];
        VehicleCollenction.read(FILEPATH);
        //не надо вроде
        /*ileNameValidator nameFileValidator = new FileNameValidator(FILEPATH);
        nameFileValidator.validateWithExit();*/
        //не работает почему-то
        /*FileToReadWriteValidator fileValidatorToReadAndWrite = new FileToReadWriteValidator(FILEPATH);
        fileValidatorToReadAndWrite.validateWithExit();*/
        ConsoleParser parser = new ConsoleParser();
        Controller controller = new Controller(parser);
        String request;
        while(!((request = parser.getNewLine()).equals("exit"))){
            controller.executeCommand(request);
        }




    }

}
