package validation.values;

import validation.Errors;
import validation.Validator;

/**
 * The type Name validator.
 */
public class NameValidator extends Validator {
    final private String name;

    /**
     * Instantiates a new Name validator.
     *
     * @param name the name
     */
    public NameValidator(String name) {
        this.name = name;
    }

    private boolean nameIsEmpty() {
        return name.trim().equals("");
    }

    @Override
    protected void addAllErrors() {
        addError(this::nameIsEmpty, Errors.EMPTYFIELD);

    }
}
