package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VehicleCollenction {
    private final String FILE_PATH;
    private Map<UUID, Vehicle> vehicleHashMapCollection = new HashMap<>();

    public VehicleCollenction(String file_path) {
        FILE_PATH = file_path;
    }

    public Map<UUID, Vehicle> read(){


        return vehicleHashMapCollection;
    }
}
