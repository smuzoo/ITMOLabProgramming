package validation.env;

import validation.Errors;
import validation.Validator;

public class EnvValidator extends Validator {
    private final int lenghtArgs;

    public EnvValidator(int lenghtArgs) {
        this.lenghtArgs = lenghtArgs;
    }
    public boolean validateOnHaveEnvironment(){
        return lenghtArgs == 0;
    }

    @Override
    protected void addAllErrors() {
        addError(() -> validateOnHaveEnvironment(), Errors.NOTHAVEENVIRONMENT);

    }
}
