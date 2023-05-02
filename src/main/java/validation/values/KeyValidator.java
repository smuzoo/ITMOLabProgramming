package validation.values;

import collection.VehicleCollection;
import validation.Validator;

public class KeyValidator  extends Validator {
    protected final String key;

    public KeyValidator(String key) {
        this.key = key;
    }
    private boolean isEmpty(){
        return key.equals("");
    }


    @Override
    protected void addAllErrors() {

    }
}
