package collection;

import Parsers.ParserFromFileToCollection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class VehicleCollenction {
    public static Map<UUID, Vehicle> vehicleHashMapCollection = new LinkedHashMap<>();



    public static void read(String FILE_PATH){

        vehicleHashMapCollection = ParserFromFileToCollection.read(FILE_PATH);
        //System.out.println(vehicleHashMapCollection);
    }
}


