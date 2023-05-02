package validation.values;

import collection.VehicleCollection;
import validation.Errors;
import validation.Validator;

import java.util.UUID;

public class UUIDValidator extends Validator {

    protected final String id;

    public UUIDValidator(String id) {
        this.id = id;
    }

    private boolean isEmpty(){
        return id.equals("");
    }

    /*private boolean isNotCanTransformToUUID(){
        try {
            UUID.fromString(id);
        }catch (IllegalArgumentException e){
            return true;
        }
        return false;
    }*/




    @Override
    protected void addAllErrors() {
        addError(this::isEmpty, Errors.EMPTYFIELD);
        //addError(this::isNotCanTransformToUUID, Errors.NOTCANTRASFORMTOUUID);
        //addError(this::isUsed, Errors.UUIDUSUSED);
    }
}
