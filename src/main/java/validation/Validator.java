package validation;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The type Validator.
 */
abstract public class Validator {
    private final Map<Validating, Errors> validatesMethods = new LinkedHashMap<>();

    /**
     * Add all errors.
     */
    abstract protected void addAllErrors();

    /**
     * Add error.
     *
     * @param method the method
     * @param error  the error
     */
    protected void addError(Validating method, Errors error) {
        validatesMethods.put(method, error);
    }

    /**
     * Validate all errors.
     *
     * @return the errors
     */
    protected Errors validateAll() {
        addAllErrors();
        for (Validating method : validatesMethods.keySet()) {
            if (method.notValidate()) {
                return validatesMethods.get(method);
            }
        }
        return Errors.NOTHAVEERRORS;
    }


    /**
     * Is valid boolean.
     *
     * @return the boolean
     */
    public boolean isValid() {
        Errors error = validateAll();
        if (error != Errors.NOTHAVEERRORS) {
            System.out.println(error);
            return false;
        }
        return true;
    }

    /**
     * Validate with exit.
     */
    public void validateWithExit() {
        boolean validation = isValid();
        if (!validation) System.exit(130);
    }


}
