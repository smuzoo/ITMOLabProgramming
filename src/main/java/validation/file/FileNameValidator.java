package validation.file;

import validation.Errors;
import validation.Validator;

public class FileNameValidator extends Validator {
    protected String FILEPATH;
    public FileNameValidator(String env){
        this.FILEPATH = env;
    }

    private boolean isOnNull() {
        return FILEPATH == null;
    }

    private boolean isOnEmpty() {
        return FILEPATH.equals("");
    }

    @Override
    protected void addAllErrors(){
        addError(this::isOnNull, Errors.WRONGENVIRONMENT);
        addError(this::isOnEmpty, Errors.EMPTYENVIRONMENT);
    }

}
