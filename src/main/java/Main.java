import collection.VehicleCollenction;

public class Main {
    public static void main(String[] args) {
        //valid на filepath
        final String FILEPATH = args[0];
        VehicleCollenction.read(FILEPATH);

    }
}
