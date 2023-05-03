package validation.values.coordinates;

import validation.Errors;
import validation.Validator;

public class YCoordinateValidator extends Validator {
    private String y;

    public YCoordinateValidator(String y) {
        this.y = y;
    }

    private boolean isNotCanTransformY(){
        try{
            Double.parseDouble(y);
        }catch (NumberFormatException e){
            return true;
        }

        return false;
    }


    @Override
    protected void addAllErrors() {

        addError(this::isNotCanTransformY, Errors.NOTCANTRANSFORMTODOUBLE);


    }
}
