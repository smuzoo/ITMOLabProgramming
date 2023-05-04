package validation.file;

import validation.Errors;
import validation.Validator;

import java.io.File;

/**
 * The type File to read validator.
 */
public class FileToReadValidator extends Validator {
    private final File file;

    /**
     * Instantiates a new File to read validator.
     *
     * @param filename the filename
     */
    public FileToReadValidator(String filename) {
        this.file = new File(filename);
    }

    /**
     * Is file not exist boolean.
     *
     * @return the boolean
     */
    protected boolean isFileNotExist() {
        return !file.exists();
    }

    /**
     * Is file not can read boolean.
     *
     * @return the boolean
     */
    protected boolean isFileNotCanRead() {
        return !file.canRead();
    }


    @Override
    protected void addAllErrors() {
        addError(this::isFileNotExist, Errors.NOTEXISTFILE);
        addError(this::isFileNotCanRead, Errors.CANNOTREADFILE);


    }
}

