package validation.values;

import validation.Errors;
import validation.Validator;

/**
 * The type Uuid validator.
 */
public class UUIDValidator extends Validator {

    /**
     * The Id.
     */
    protected final String id;

    /**
     * Instantiates a new Uuid validator.
     *
     * @param id the id
     */
    public UUIDValidator(String id) {
        this.id = id;
    }

    private boolean isEmpty() {
        return id.equals("");
    }



    @Override
    protected void addAllErrors() {
        addError(this::isEmpty, Errors.EMPTYFIELD);
        //addError(this::isNotCanTransformToUUID, Errors.NOTCANTRASFORMTOUUID);
        //addError(this::isUsed, Errors.UUIDUSUSED);
    }
}
