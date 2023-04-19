package collection;

import parsers.ParserFromFileToCollection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class VehicleCollenction {
    public static Map<UUID, Vehicle> vehicleHashMapCollection = new LinkedHashMap<>();



    public static void read(String FILE_PATH){

        vehicleHashMapCollection = ParserFromFileToCollection.read(FILE_PATH);
        for (Map.Entry<UUID, Vehicle> entry : vehicleHashMapCollection.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
        System.out.println(vehicleHashMapCollection);
    }
}


