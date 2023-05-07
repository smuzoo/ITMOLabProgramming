package collection;

import org.jetbrains.annotations.Nullable;

/**
 * The enum Vehicle type.
 */
public enum VehicleType {
    /**
     * Car vehicle type.
     */
    CAR("CAR", "1"),
    /**
     * Boat vehicle type.
     */
    BOAT("BOAT", "2"),
    /**
     * Ship vehicle type.
     */
    SHIP("SHIP", "3"),
    /**
     * Motorcycle vehicle type.
     */
    MOTORCYCLE("MOTORCYCLE", "4"),
    NULL("null", "5"),
    /**
     * Chopper vehicle type.
     */
    CHOPPER("CHOPPER", "5");
    private final String name, order;

    VehicleType(String name, String order) {
        this.name = name;
        this.order = order;
    }

    /**
     * Gets vehicle type.
     *
     * @param s the s
     * @return the vehicle type
     */
    public static @Nullable VehicleType getVehicleType(String s) {
        VehicleType[] VehicleTypesValues = VehicleType.values();
        for (VehicleType vehicleType : VehicleTypesValues) {
            if (s.equals(vehicleType.getName()) || s.equals(vehicleType.getOrder())) {
                return vehicleType;
            }
        }
        return null;
    }

    /**
     * Gets string values.
     *
     * @return the string values
     */
    public static String getStringValues() {
        StringBuilder sb = new StringBuilder();
        for (VehicleType vehicleType : VehicleType.values()) {
            sb.append(vehicleType.getOrder()).append(" - ").append(vehicleType.getName()).append(" | ");
        }
        sb.delete(sb.length() - 3, sb.length()); // удаление последнего разделителя "| "
        return sb.toString();
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
     * Get order string.
     *
     * @return the string
     */
    public String getOrder() {
        return order;
    }

}
