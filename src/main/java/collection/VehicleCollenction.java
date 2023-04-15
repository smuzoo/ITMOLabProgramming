package collection;

import Parsers.ParserFromFileToCollection;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VehicleCollenction {
    private static Map<UUID, Vehicle> vehicleHashMapCollection = new HashMap<>();



    public static void read(String FILE_PATH){

        vehicleHashMapCollection = ParserFromFileToCollection.read(FILE_PATH);
    }
}


