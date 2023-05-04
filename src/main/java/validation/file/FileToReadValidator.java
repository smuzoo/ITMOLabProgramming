package validation.file;

import validation.Errors;
import validation.Validator;

import java.io.File;

public class FileToReadValidator extends Validator {
    private File file;
    public FileToReadValidator(String filename){
        this.file = new File(filename);
    }
    protected boolean isFileNotExist(){
        return !file.exists();
    }
    protected boolean isFileNotCanRead(){
        return !file.canRead();
    }


    @Override
    protected void addAllErrors() {
        addError(this::isFileNotExist, Errors.NOTEXISTFILE);
        addError(this::isFileNotCanRead, Errors.CANNOTREADFILE);


    }
}

