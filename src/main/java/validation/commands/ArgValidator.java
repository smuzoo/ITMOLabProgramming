package validation.commands;

import validation.Errors;
import validation.Validator;

/**
 * The type Arg validator.
 */
public class ArgValidator extends Validator {
    /**
     * The Arg.
     */
    protected String arg;

    /**
     * Instantiates a new Arg validator.
     *
     * @param arg the arg
     */
    public ArgValidator(String arg) {
        this.arg = arg;
    }

    /**
     * Is not has arg boolean.
     *
     * @return the boolean
     */
    protected boolean isNotHasArg() {
        return arg.equals("");
    }

    @Override
    protected void addAllErrors() {
        addError(this::isNotHasArg, Errors.NOTHASARG);

    }
}
