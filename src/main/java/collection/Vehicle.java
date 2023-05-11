package collection;


import validation.values.CoordinatesValidator;
import validation.values.EnginePowerValidator;
import validation.values.NameValidator;
import validation.values.coordinates.XCoordinateValidator;
import validation.values.coordinates.YCoordinateValidator;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;


/**
 * The type Vehicle.
 */
public class Vehicle {

    private final Map<Fields, Predicate<String>> notNullSetters = new LinkedHashMap<>();
    private final Map<Fields, Consumer<String>> setters = new LinkedHashMap<>();
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int x;
    private double y;
    private Long enginePower; //Поле может быть null, Значение поля должно быть больше 0
    private VehicleType vehicleType; //Поле может быть null
    private FuelType fuelType; //Поле может быть null
    private UUID id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String key;

    {
        addNotNullSetter(Fields.NAME, this::setNotNullName);
        //addNotNullSetter(Fields.COORDINATES, this::setNotNullCoordinates);
        addNotNullSetter(Fields.X, this::setNotNullCoordinateX);
        addNotNullSetter(Fields.Y, this::setNotNullCoordinateY);
        addSetter(Fields.ENGINEPOWER, this::setEnginePower);
        addSetter(Fields.FUELTYPE, this::setFuelType);
        addSetter(Fields.VHICLETYPE, this::setVehicleType);
    }

    /**
     * Instantiates a new Vehicle.
     *
     * @param id          the id
     * @param name        the name
     * @param coordinates the coordinates
     * @param enginePower the engine power
     * @param vehicleType the vehicle type
     * @param fuelType    the fuel type
     */
    public Vehicle(UUID id, String name, Coordinates coordinates, Long enginePower, VehicleType vehicleType, FuelType fuelType) {
        this.name = name;
        this.coordinates = coordinates;
        creationDate = LocalDateTime.now();
        this.enginePower = enginePower;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
        this.id = id;
    }

    /**
     * Instantiates a new Vehicle.
     */
    public Vehicle() {
        this.creationDate = LocalDateTime.now();
    }

    /**
     * Gets key.
     *
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets key.
     *
     * @param key the key
     */
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "\n" + "Vehicle " + id + "\n" +
                "name = " + name + "\n" +
                "coordinates = " + coordinates.getX() + "; " + coordinates.getX() + "\n" +
                "creationDate = " + creationDate + "\n" +
                "enginePower = " + enginePower + "\n" +
                "type = " + vehicleType + "\n" +
                "fuelType = " + fuelType;
    }

    /**
     * Gets not null setters.
     *
     * @return the not null setters
     */
    public Map<Fields, Predicate<String>> getNotNullSetters() {
        return notNullSetters;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets coordinates.
     *
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Sets coordinates.
     *
     * @param coordinates the coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Sets creation date.
     *
     * @param creationDate the creation date
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets engine power.
     *
     * @return the engine power
     */
    public Long getEnginePower() {
        if (enginePower == null) {

            return null;
        } else {
            return enginePower;
        }
    }

    /**
     * Gets engine power as string.
     *
     * @return the engine power as string
     */
    public String getEnginePowerAsString() {
        return (enginePower != null) ? enginePower.toString() : "";
    }


    /**
     * Sets engine power.
     *
     * @param enginePower the engine power
     */
    public void setEnginePower(Long enginePower) {
        this.enginePower = enginePower;
    }

    /**
     * Gets vehicle type.
     *
     * @return the vehicle type
     */
    public VehicleType getVehicleType() {
        if (vehicleType == null) {
            return VehicleType.NULL;
        } else {
            return vehicleType;
        }
    }

    /**
     * Sets vehicle type.
     *
     * @param vehicleType the vehicle type
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = VehicleType.getVehicleType(vehicleType);
    }

    /**
     * Gets fuel type.
     *
     * @return the fuel type
     */
    public FuelType getFuelType() {
        if(fuelType == null){
        return FuelType.NULL;

        }else{
            return fuelType;
        }

    }

    /**
     * Sets fuel type.
     *
     * @param fuelType the fuel type
     */
    public void setFuelType(String fuelType) {
        this.fuelType = FuelType.getFuelType(fuelType);
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Compare int.
     *
     * @param vehicle the vehicle
     * @return the int
     */
    public int compare(Vehicle vehicle) {
        return (int) (this.getEnginePower() - vehicle.getEnginePower());
    }

    /**
     * Add setter.
     *
     * @param field    the field
     * @param consumer the consumer
     */
    public void addSetter(Fields field, Consumer<String> consumer) {
        setters.put(field, consumer);
    }

    /**
     * Add not null setter.
     *
     * @param field     the field
     * @param predicate the predicate
     */
    public void addNotNullSetter(Fields field, Predicate<String> predicate) {
        notNullSetters.put(field, predicate);
    }

    /**
     * Gets setters.
     *
     * @return the setters
     */
    public Map<Fields, Consumer<String>> getSetters() {
        return setters;
    }

    /**
     * Set not null name boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public boolean setNotNullName(String name) {
        NameValidator nameValidator = new NameValidator(name);
        if (nameValidator.isValid()) {
            setName(name);
            return true;
        }
        return false;
    }

    /**
     * Sets not null coordinates.
     *
     * @param coordinates the coordinates
     * @return the not null coordinates
     */
    public boolean setNotNullCoordinates(String coordinates) {

        String[] coords = coordinates.split(";");
        CoordinatesValidator coordinatesValidator = new CoordinatesValidator(coords);
        if (coordinatesValidator.isValid()) {
            int x = Integer.parseInt(coords[0]);
            double y = Double.parseDouble(coords[1]);
            setCoordinates(new Coordinates(x, y));
            return true;
        }
        return false;
    }

    /**
     * Set not null coordinate x boolean.
     *
     * @param argument the argument
     * @return the boolean
     */
    public boolean setNotNullCoordinateX(String argument) {
        XCoordinateValidator xCoordinateValidator = new XCoordinateValidator(argument);
        if (xCoordinateValidator.isValid()) {
            int x = Integer.parseInt(argument);
            setX(x);
            return true;
        }

        return false;
    }

    /**
     * Set not null coordinate y boolean.
     *
     * @param argument the argument
     * @return the boolean
     */
    public boolean setNotNullCoordinateY(String argument) {
        YCoordinateValidator yCoordinateValidator = new YCoordinateValidator(argument);
        if (yCoordinateValidator.isValid()) {
            double y = Double.parseDouble(argument);
            setY(y);
            setCoordinates(new Coordinates(x, y));
            return true;

        }

        return false;
    }

    /**
     * Set engine power boolean.
     *
     * @param enginePower the engine power
     * @return the boolean
     */
    public boolean setEnginePower(String enginePower) {
        if (enginePower.equals("")) {
            setEnginePower((Long) null);
            return true;
        } else {
            EnginePowerValidator enginePowerValidator = new EnginePowerValidator((enginePower));
            if (enginePowerValidator.isValid()) {
                setEnginePower(Long.parseLong((enginePower)));
                return true;
            }
        }
        return false;
    }




}




