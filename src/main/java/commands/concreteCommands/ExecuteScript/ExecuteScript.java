package commands.concreteCommands.ExecuteScript;

import commands.Command;
import commands.CommandController;
import parsers.FileParser;
import parsers.NameParser;
import parsers.ParserController;
import validation.commands.ArgValidator;
import validation.commands.RecursionValidator;
import validation.file.FileToReadValidator;

import java.util.List;

public class ExecuteScript implements Command {

    private final int MAX_RECURSION = 300;

    private static int recursion;


    public ExecuteScript() {
        recursion++;
    }

    @Override
    public void execute(String FILEPATH){
        ArgValidator argValidator = new ArgValidator(FILEPATH);
        if(argValidator.isValid()){
            FileToReadValidator FileToReadValidator = new FileToReadValidator(FILEPATH);
            if(FileToReadValidator.isValid()) {
                RecursionValidator recursionValidator = new RecursionValidator(FILEPATH);
                if(recursionValidator.isValid()) {
                    ParserController parser = new ParserController(new FileParser(FILEPATH), NameParser.PARSERFILE);
                    CommandController commandController = new CommandController(parser);
                    ExecuteScriptLogger.addFile(FILEPATH);
                    while (parser.getNameParser() != NameParser.PARSERCONSOLE & recursion < MAX_RECURSION) {
                        String request = parser.getNewLine();
                        commandController.executeCommand(request);
                        ExecuteScriptLogger.delete(FILEPATH);

                    }
                }

            }

        }
    }


    @Override
    public String description() {
        return "execute_script " + "file_name" +  " : считать и исполнить скрипт из указанного файла. В скрипте содержатся" +
                " команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
