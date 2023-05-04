package validation.values;

import validation.Errors;
import validation.Validator;

/**
 * The type Coordinates validator.
 */
public class CoordinatesValidator extends Validator {


    final private String[] coordinates;
    private String x;
    private String y;

    /**
     * Instantiates a new Coordinates validator.
     *
     * @param args the args
     */
    public CoordinatesValidator(String[] args) {
        this.coordinates = args;
    }


    private boolean isNotHaveEnoughLength() {
        if (coordinates.length == 2) {
            this.x = coordinates[0];
            this.y = coordinates[1];
            return false;
        }
        return true;
    }

    private boolean isNotCanTransformX() {
        try {
            Integer.parseInt(x);
        } catch (NumberFormatException e) {
            return true;
        }

        return false;
    }

    private boolean isNotCanTransformY() {
        try {
            Double.parseDouble(y);
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
        addError(this::isNotHaveEnoughLength, Errors.NOTHASTWOCOORDINATES);
        addError(this::isNotCanTransformX, Errors.NOTCANTRANSFORMTOINT);
        addError(this::isLowerX, Errors.LOWERX);
        addError(this::isNotCanTransformY, Errors.NOTCANTRANSFORMTODOUBLE);

    }
}
