package validation.commands;

import validation.Validator;
import validation.Errors;
import validation.Validator;

public class RemoveGreaterKeyValidator extends Validator {
    protected String argument;
    public RemoveGreaterKeyValidator(String argument) { this.argument = argument; }
    protected boolean isNotHasArgument(){
        return argument.equals("");
    }

    @Override
    protected void addAllErrors() {
        addError(this::isNotHasArgument, Errors.NOTHASARGUMENT);

    }

}
