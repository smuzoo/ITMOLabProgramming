package collection;


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



    private Long enginePower; //Поле может быть null, Значение поля должно быть больше 0
    private VehicleType type; //Поле может быть null
    private FuelType fuelType; //Поле может быть null
    private  UUID id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final Map<Fields, Predicate<String>> notNullSetters = new LinkedHashMap<>();

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", enginePower=" + enginePower +
                ", type=" + type +
                ", fuelType=" + fuelType +
                ", id=" + id +
                "}";
    }

    private final Map<Fields, Consumer<String>> setters = new LinkedHashMap<>();



    public Vehicle(UUID id, String name, Coordinates coordinates,Long enginePower, VehicleType type, FuelType fuelType) {
        this.name = name;
        this.coordinates = coordinates;
        creationDate = LocalDateTime.now();
        this.enginePower = enginePower;
        this.type = type;
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

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
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
    /*{
        addNotNullSetter(Fields.NAME, this::setName);
        addNotNullSetter(Fields.COORDINATES, this::setCoordinates);
        addSetter(Fields.ENGINEPOWER, this::setEnginePower);
        addSetter(Fields.FUELTYPE, this::setFuelType);
        addSetter(Fields.VHICLETYPE, this::setType);
    }*/
}




