package collection;

import parsers.ParserFromFileToCollection;

import java.util.*;

public class VehicleCollection {

    public static Map<String, Vehicle> vehicleHashMapCollection = new LinkedHashMap<>();

    private final static Date dateOfInitialization = new Date();
    private static Date dateOfLastChange = new Date();


    public static void read(String FILE_PATH){

        vehicleHashMapCollection = ParserFromFileToCollection.read(FILE_PATH);

        /* вывести коллекцию сразу после иницилизации
       for (Map.Entry<UUID, Vehicle> entry : vehicleHashMapCollection.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
        System.out.println(vehicleHashMapCollection);*/
    }

    public static void clear(){
        dateOfLastChange = new Date();
        vehicleHashMapCollection.clear();
    }

    public static void remove(UUID id){
        dateOfLastChange = new Date();
        vehicleHashMapCollection.remove(id);
    }
    public static long getCountVehicleCollection(){ return vehicleHashMapCollection.size(); }

    public static Collection<String> getKeys(){
        return vehicleHashMapCollection.keySet();
    }
    public static boolean hasElement(String key) {return vehicleHashMapCollection.get(key) != null;}
    public static Collection<Vehicle> getVehicles(){
        return vehicleHashMapCollection.values();
    }
    public static Map<String, Vehicle> getVehicleCollection() {
        return vehicleHashMapCollection;
    }
    public static Date getDateOfInitialization() {
        return dateOfInitialization;
    }
    public static Date getDateOfLastChange() {
        return dateOfLastChange;
    }

    public static Set<Map.Entry<String, Vehicle>> getEntrySet(){
        return vehicleHashMapCollection.entrySet();
    }

    public static void add(String key, Vehicle vehicle) {
        dateOfLastChange = new Date();
        vehicleHashMapCollection.put(key, vehicle);
    }
}


