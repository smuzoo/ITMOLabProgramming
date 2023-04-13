package collection;

//import validators.fields.CoordinatesValidator;
//import validators.fields.ImpactSpeedValidator;
//import validators.fields.NameValidator;
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
    private final Map<Fields, Consumer<String>> setters = new LinkedHashMap<>();


    public Vehicle(String name, Coordinates coordinates, Long enginePower, VehicleType type, FuelType fuelType) {
    }

    public Vehicle(UUID id, String name, Coordinates coordinates, LocalDateTime creationDate, Long enginePower, VehicleType type, FuelType fuelType) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.enginePower = enginePower;
        this.type = type;
        this.fuelType = fuelType;
        this.id = id;
    }

    public Map<Fields, Predicate<String>> getNotNullSetters() {
        return notNullSetters;
    }
}




