package validation.values.coordinates;

import validation.Errors;
import validation.Validator;

public class XCoordinateValidator extends Validator {

    private String x;

    public XCoordinateValidator(String x) {
        this.x = x;
    }

    private boolean isNotCanTransformX(){
        try{
            Integer.parseInt(x);
        }catch (NumberFormatException e){
            return true;
        }

        return false;
    }
    private boolean isLowerX(){
        return Integer.parseInt(x) < -661;
    }

    @Override
    protected void addAllErrors() {
        addError(this::isLowerX, Errors.LOWERX);
        addError(this::isNotCanTransformX, Errors.NOTCANTRANSFORMTOINT);
    }
}
