package validation.commands;

import commands.concreteCommands.ExecuteScript.ExecuteScriptLogger;
import validation.Errors;
import validation.Validator;

import java.util.List;

public class RecursionValidator extends Validator {


    private final String nameFile;

    public RecursionValidator(String nameFile) {
        this.nameFile = nameFile;
    }

    private boolean isRecursion(){
        return ExecuteScriptLogger.contains(nameFile);
    }

    @Override
    public void addAllErrors(){
        addError(this::isRecursion, Errors.RECURSION);
    }
}
