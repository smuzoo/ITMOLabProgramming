package collection;


import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
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

    public Map<Fields, Consumer<String>> getSetters() {
        return setters;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public UUID getId() {
        return id;
    }
}




