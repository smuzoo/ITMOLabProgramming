import collection.VehicleCollenction;
import org.jetbrains.annotations.NotNull;


public class Main {
    public static void main(String @NotNull [] args) {
        //valid на filepath
        final String FILEPATH = args[0];
        VehicleCollenction.read(FILEPATH);


    }

}
