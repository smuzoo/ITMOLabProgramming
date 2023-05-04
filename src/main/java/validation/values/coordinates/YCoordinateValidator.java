package validation.values.coordinates;

import validation.Errors;
import validation.Validator;

/**
 * The type Y coordinate validator.
 */
public class YCoordinateValidator extends Validator {
    private final String y;

    /**
     * Instantiates a new Y coordinate validator.
     *
     * @param y the y
     */
    public YCoordinateValidator(String y) {
        this.y = y;
    }

    private boolean isNotCanTransformY() {
        try {
            Double.parseDouble(y);
        } catch (NumberFormatException e) {
            return true;
        }

        return false;
    }


    @Override
    protected void addAllErrors() {

        addError(this::isNotCanTransformY, Errors.NOTCANTRANSFORMTODOUBLE);


    }
}
