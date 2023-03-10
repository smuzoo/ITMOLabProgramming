package collection;

public enum VehicleType {
    CAR("CAR", "1"),
    BOAT("BOAT", "2"),
    SHIP("SHIP", "3"),
    MOTORCYCLE("MOTORCYCLE", "4"),
    CHOPPER("CHOPPER", "5");
    private final String name, order;
    VehicleType(String name, String order){
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
        for (VehicleType vehicleType : VehicleType.values()) {
            sb.append(vehicleType.getOrder()).append(" - ").append(vehicleType.getName()).append(" | ");
        }
        sb.delete(sb.length() - 3, sb.length()); // удаление последнего разделителя "| "
        return sb.toString();
    }

}
