package validation.commands;

import validation.Errors;
import validation.Validator;

public class ArgValidator extends Validator {
    protected String arg;

    public ArgValidator(String arg) {
        this.arg = arg;
    }

    protected boolean isNotHasArg(){
        return arg.equals("");
    }
    @Override
    protected void addAllErrors() {
        addError(this::isNotHasArg, Errors.NOTHASARG);

    }
}
