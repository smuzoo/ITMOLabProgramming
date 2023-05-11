package collection;

import org.jetbrains.annotations.Nullable;

/**
 * The enum Fuel type.
 */
public enum FuelType {
    /**
     * Kerosene fuel type.
     */
    KEROSENE("KEROSENE", "1"),
    /**
     * Alcohol fuel type.
     */
    ALCOHOL("ALCOHOL", "2"),
    /**
     * Diesel fuel type.
     */
    DIESEL("DIESEL", "3"),
    /**
     * Gasoline fuel type.
     */
    GASOLINE("GASOLINE", "4"),
    /**
     * Null fuel type.
     */
    NULL("null", "5"),
    /**
     * Nuclear fuel type.
     */
    NUCLEAR("NUCLEAR", "6");

    private final String name, order;

    FuelType(String name, String order) {
        this.name = name;
        this.order = order;
    }

    /**
     * Gets fuel type.
     *
     * @param s the s
     * @return the fuel type
     */
    public static @Nullable FuelType getFuelType(String s) {
        FuelType[] fuelTypesValues = FuelType.values();
        for (FuelType fuelType : fuelTypesValues) {
            if (s.equals(fuelType.getName()) || s.equals(fuelType.getOrder())) {
                return fuelType;
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
        for (FuelType fuelType : FuelType.values()) {
            sb.append(fuelType.getOrder()).append(" - ").append(fuelType.getName()).append(" | ");
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
