package validation.file;

import validation.Errors;
import validation.Validator;

import java.io.File;

/**
 * The type File to read write validator.
 */
public class FileToReadWriteValidator extends Validator {
    private final File file;

    /**
     * Instantiates a new File to read write validator.
     *
     * @param filename the filename
     */
    public FileToReadWriteValidator(File filename) {
        this.file = filename;
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

    private boolean isFileNotCanWrite() {
        return !file.canWrite();
    }

    @Override
    protected void addAllErrors() {
        addError(this::isFileNotExist, Errors.NOTEXISTFILE);
        addError(this::isFileNotCanRead, Errors.CANNOTREADFILE);
        addError(this::isFileNotCanWrite, Errors.CANNOTWRITEFILE);

    }
}

