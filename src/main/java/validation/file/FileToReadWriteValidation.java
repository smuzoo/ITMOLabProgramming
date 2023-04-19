package validation.file;

import validation.Errors;
import validation.Validator;

import java.io.File;

public class FileToReadWriteValidation extends Validator {
    private String FILEPATH;
    public FileToReadWriteValidation(String FILEPATH){
        this.FILEPATH = FILEPATH;
    }
    private final File file = new File(FILEPATH);
    protected boolean isFileNotExist(){
        return !file.exists();
    }
    protected boolean isFileNotCanRead(){
        return !file.canRead();
    }
    private boolean isFileNotCanWrite(){
        return !file.canWrite();
    }

    @Override
    protected void addAllErrors() {
        addError(this::isFileNotExist, Errors.NOTEXISTFILE);
        addError(this::isFileNotCanRead, Errors.NOTCANREADFILE);
        addError(this::isFileNotCanWrite, Errors.NOTCANWRITEFILE);

    }
}
