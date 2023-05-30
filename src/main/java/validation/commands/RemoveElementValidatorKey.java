package validation.commands;

import collection.VehicleCollection;
import validation.Errors;

public class RemoveElementValidatorKey extends RemoveGreaterKeyValidator {


    public RemoveElementValidatorKey(String argument) { super(argument); }
    protected boolean isNotHasElement(){
        String key = argument;
        return !VehicleCollection.hasElement(key);
    }
    @Override
    protected void addAllErrors() {
        addError(this::isNotHasArgument, Errors.NOTHASARGUMENT);
        addError(this::isNotHasElement, Errors.NOTHASELEMENT);

    }
}
