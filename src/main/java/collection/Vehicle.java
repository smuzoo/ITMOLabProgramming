package collection;


import validation.values.CoordinatesValidator;
import validation.values.EnginePowerValidator;
import validation.values.NameValidator;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class Vehicle {

    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private Long enginePower; //Поле может быть null, Значение поля должно быть больше 0
    private VehicleType vehicleType; //Поле может быть null
    private FuelType fuelType; //Поле может быть null
    private  UUID id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final Map<Fields, Predicate<String>> notNullSetters = new LinkedHashMap<>();

    private String key;

    @Override
    public String toString() {
        return  "\n" + "Vehicle " + id + "\n" +
                "name = " + name + "\n" +
                "coordinates = " + coordinates.getX() + "; " + coordinates.getX()+  "\n" +
                "creationDate = " + creationDate + "\n" +
                "enginePower = " + enginePower  + "\n" +
                "type = " + vehicleType + "\n" +
                "fuelType = " + fuelType;
    }

    private final Map<Fields, Consumer<String>> setters = new LinkedHashMap<>();



    public Vehicle(UUID id, String name, Coordinates coordinates, Long enginePower, VehicleType vehicleType, FuelType fuelType) {
        this.name = name;
        this.coordinates = coordinates;
        creationDate = LocalDateTime.now();
        this.enginePower = enginePower;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.id = id;
    }

    public Map<Fields, Predicate<String>> getNotNullSetters() {
        return notNullSetters;
    }
    public Vehicle(){
        this.creationDate = LocalDateTime.now();
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }



    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Long enginePower) {
        this.enginePower = enginePower;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = VehicleType.getVehicleType(vehicleType);
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = FuelType.getFuelType(fuelType);
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int compare(Vehicle vehicle){
        return (int) (this.getEnginePower() - vehicle.getEnginePower());
    }

    public void addSetter(Fields field, Consumer<String> consumer){
        setters.put(field, consumer);
    }
    public void addNotNullSetter(Fields field, Predicate<String> predicate){
        notNullSetters.put(field, predicate);
    }

    public Map<Fields, Consumer<String>> getSetters() {
        return setters;
    }

    public boolean setNotNullName(String name){
        NameValidator nameValidator = new NameValidator(name);
        if(nameValidator.isValid()){
            setName(name);
            return true;
        }
        return false;
    }

    public boolean setNotNullCoordinates(String coordinates) {

        String[] coords = coordinates.split(",");
        CoordinatesValidator coordinatesValidator = new CoordinatesValidator(coords);
        if(coordinatesValidator.isValid()){
            int x = Integer.parseInt(coords[0]);
            double y = Double.parseDouble(coords[1]);
            setCoordinates(new Coordinates(x,y));
            return true;
        }
        return false;
    }

    public boolean setEnginePower(String enginePower){
        if(enginePower.equals("")) {
            setEnginePower((Long) null);
            return true;
        }
        else{
            EnginePowerValidator enginePowerValidator = new EnginePowerValidator((enginePower));
            if(enginePowerValidator.isValid()){
                setEnginePower(Long.parseLong((enginePower)));
                return true;
            }
        }
        return false;
    }
    {
        addNotNullSetter(Fields.NAME, this::setNotNullName);
        addNotNullSetter(Fields.COORDINATES, this::setNotNullCoordinates);
        addSetter(Fields.ENGINEPOWER, this::setEnginePower);
        addSetter(Fields.FUELTYPE, this::setFuelType);
        addSetter(Fields.VHICLETYPE, this::setVehicleType);
    }
}




