package validation.values.coordinates;

import validation.Errors;
import validation.Validator;

/**
 * The type X coordinate validator.
 */
public class XCoordinateValidator extends Validator {

    private final String x;

    /**
     * Instantiates a new X coordinate validator.
     *
     * @param x the x
     */
    public XCoordinateValidator(String x) {
        this.x = x;
    }

    private boolean isNotCanTransformX() {
        try {
            Integer.parseInt(x);
        } catch (NumberFormatException e) {
            return true;
        }

        return false;
    }

    private boolean isLowerX() {
        return Integer.parseInt(x) < -661;
    }

    @Override
    protected void addAllErrors() {
        addError(this::isNotCanTransformX, Errors.NOTCANTRANSFORMTOINT);
        addError(this::isLowerX, Errors.LOWERX);

    }
}
