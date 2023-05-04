package validation.values;

import validation.Validator;

/**
 * The type Key validator.
 */
public class KeyValidator extends Validator {
    /**
     * The Key.
     */
    protected final String key;

    /**
     * Instantiates a new Key validator.
     *
     * @param key the key
     */
    public KeyValidator(String key) {
        this.key = key;
    }

    private boolean isEmpty() {
        return key.equals("");
    }


    @Override
    protected void addAllErrors() {

    }
}
