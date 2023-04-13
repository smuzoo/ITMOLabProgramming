package collection;

public enum FuelType {
    KEROSENE("KEROSENE", "1"),
    ALCOHOL("ALCOHOL", "2"),
    DIESEL("DIESEL", "3"),
    GASOLINE("GASOLINE","4"),
    NUCLEAR("NUCLEAR", "5");

    private final String name, order;
    FuelType(String name, String order){
        this.name = name;
        this.order = order;
    }
    public String getName() {
        return name;
    }
    public  String getOrder(){
        return order;
    }
    public static String getStringValues() {
        StringBuilder sb = new StringBuilder();
        for (FuelType fuelType : FuelType.values()) {
            sb.append(fuelType.getOrder()).append(" - ").append(fuelType.getName()).append(" | ");
        }
        sb.delete(sb.length() - 3, sb.length()); // удаление последнего разделителя "| "
        return sb.toString();
    }
}
