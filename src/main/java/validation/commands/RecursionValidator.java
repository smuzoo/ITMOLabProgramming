package validation.commands;

import commands.concreteCommands.ExecuteScript.ExecuteScriptLogger;
import validation.Errors;
import validation.Validator;

/**
 * The type Recursion validator.
 */
public class RecursionValidator extends Validator {


    private final String nameFile;

    /**
     * Instantiates a new Recursion validator.
     *
     * @param nameFile the name file
     */
    public RecursionValidator(String nameFile) {
        this.nameFile = nameFile;
    }

    private boolean isRecursion() {
        return ExecuteScriptLogger.contains(nameFile);
    }

    @Override
    public void addAllErrors() {
        addError(this::isRecursion, Errors.RECURSION);
    }
}
