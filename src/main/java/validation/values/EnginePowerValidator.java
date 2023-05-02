package validation.values;

import validation.Errors;
import validation.Validator;

public class EnginePowerValidator  extends Validator {
    final private String enginePower;

    public EnginePowerValidator(String enginePower) {
        this.enginePower = enginePower;
    }

    private boolean isNotCanTransformEnginePower(){
        try{
            Long.parseLong(enginePower);
        }catch (NumberFormatException e){
            return true;
        }
        return false;
    }

    private boolean isLowerEnginePower(){
        return Long.parseLong(enginePower) < 0;
    }


    @Override
    protected void addAllErrors() {
        addError(this::isNotCanTransformEnginePower, Errors.NOTCANTRANSFORMTOLONG);
        addError(this::isLowerEnginePower, Errors.ENGINEPOWERLOWERZERO);

    }
}
