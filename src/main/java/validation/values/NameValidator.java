package validation.values;

import validation.Errors;
import validation.Validator;

public class NameValidator extends Validator {
    final private String name;
    public NameValidator(String name) {
        this.name = name;
    }
    private boolean nameIsEmpty(){
        return name.trim().equals("");
    }

    @Override
    protected void addAllErrors() {
        addError(this::nameIsEmpty, Errors.EMPTYFIELD);

    }
}
