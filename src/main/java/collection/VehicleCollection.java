package collection;

import parsers.ParserFromFileToCollection;

import java.util.*;

public class VehicleCollection {
    public static Map<UUID, Vehicle> vehicleHashMapCollection = new LinkedHashMap<>();

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
    public static Vehicle getVehicle(UUID id){
        return vehicleHashMapCollection.get(id);
    }
    public static boolean hasElement(UUID id) {return vehicleHashMapCollection.get(id) != null;}
    public static Collection<Vehicle> getHumanBeings(){
        return vehicleHashMapCollection.values();
    }
    public static Map<UUID, Vehicle> getHumanBeingCollection() {
        return vehicleHashMapCollection;
    }
    public static Date getDateOfInitialization() {
        return dateOfInitialization;
    }
    public static Date getDateOfLastChange() {
        return dateOfLastChange;
    }

    public static Set<Map.Entry<UUID, Vehicle>> getEntrySet(){
        return vehicleHashMapCollection.entrySet();
    }

}


