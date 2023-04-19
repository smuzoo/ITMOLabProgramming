import collection.VehicleCollenction;
import org.jetbrains.annotations.NotNull;
import validation.*;
import validation.env.EnvValidator;
import validation.file.FileNameValidator;
import validation.file.FileToReadWriteValidation;


public class Main {
    public static void main(String @NotNull [] args) {
        //valid на filepath
        EnvValidator envValidator = new EnvValidator(args.length);
        envValidator.validateWithExit();
        final String FILEPATH = args[0];
        VehicleCollenction.read(FILEPATH);
        /*ileNameValidator nameFileValidator = new FileNameValidator(FILEPATH);
        nameFileValidator.validateWithExit();*/
        FileToReadWriteValidation fileValidatorToReadAndWrite = new FileToReadWriteValidation(FILEPATH);
        fileValidatorToReadAndWrite.validateWithExit();



    }

}
