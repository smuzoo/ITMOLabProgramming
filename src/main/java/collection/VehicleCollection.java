package collection;

import parsers.ParserFromFileToCollection;

import java.util.*;

/**
 * The type Vehicle collection.
 */
public class VehicleCollection {

    private final static Date dateOfInitialization = new Date();
    /**
     * The constant vehicleHashMapCollection.
     */
    public static Map<String, Vehicle> vehicleHashMapCollection = new LinkedHashMap<>();
    private static Date dateOfLastChange = new Date();


    /**
     * Read.
     *
     * @param FILE_PATH the file path
     */
    public static void read(String FILE_PATH) {

        vehicleHashMapCollection = ParserFromFileToCollection.read(FILE_PATH);

        /* вывести коллекцию сразу после иницилизации
       for (Map.Entry<UUID, Vehicle> entry : vehicleHashMapCollection.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
        System.out.println(vehicleHashMapCollection);*/
    }

    /**
     * Clear.
     */
    public static void clear() {
        dateOfLastChange = new Date();
        vehicleHashMapCollection.clear();
    }

    /**
     * Remove.
     *
     * @param key the key
     */
    public static void remove(String key) {
        dateOfLastChange = new Date();
        vehicleHashMapCollection.remove(key);
    }

    /**
     * Get count vehicle collection long.
     *
     * @return the long
     */
    public static long getCountVehicleCollection() {
        return vehicleHashMapCollection.size();
    }

    /**
     * Key set collection.
     *
     * @return the collection
     */
    public static Collection<String> keySet() {
        return vehicleHashMapCollection.keySet();
    }

    /**
     * Has element boolean.
     *
     * @param key the key
     * @return the boolean
     */
    public static boolean hasElement(String key) {
        return vehicleHashMapCollection.get(key) != null;
    }

    /**
     * Get vehicles collection.
     *
     * @return the collection
     */
    public static Collection<Vehicle> getVehicles() {
        return vehicleHashMapCollection.values();
    }

    /**
     * Gets vehicle hash map collection.
     *
     * @return the vehicle hash map collection
     */
    public static Map<String, Vehicle> getVehicleHashMapCollection() {
        return vehicleHashMapCollection;
    }

    /**
     * Gets vehicle collection.
     *
     * @return the vehicle collection
     */
    public static Map<String, Vehicle> getVehicleCollection() {
        return vehicleHashMapCollection;
    }

    /**
     * Gets date of initialization.
     *
     * @return the date of initialization
     */
    public static Date getDateOfInitialization() {
        return dateOfInitialization;
    }

    /**
     * Gets date of last change.
     *
     * @return the date of last change
     */
    public static Date getDateOfLastChange() {
        return dateOfLastChange;
    }

    /**
     * Get entry set set.
     *
     * @return the set
     */
    public static Set<Map.Entry<String, Vehicle>> getEntrySet() {
        return vehicleHashMapCollection.entrySet();
    }

    /**
     * Add.
     *
     * @param key     the key
     * @param vehicle the vehicle
     */
    public static void add(String key, Vehicle vehicle) {
        dateOfLastChange = new Date();
        vehicleHashMapCollection.put(key, vehicle);
    }
}


