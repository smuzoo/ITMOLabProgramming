package collection;
//import validators.Errors;


import validation.Errors;

/**
 * The enum Fields.
 */
public enum Fields {

    /**
     * Name fields.
     */
    NAME("имя", "не может быть null", 1),
    /**
     * Coordinates fields.
     */
    COORDINATES("координаты", "coordinate.x;coordinate.y (через точку c запятой), например {3;5} " +
            "поля не могут быть null, поле coordinate.x должно превышать значение " + Fields.MIM_X, 2),

    /**
     * X fields.
     */
    X("координата X", "поле не должно быть null и должно превышать " + Fields.MIM_X, 2),
    /**
     * Y fields.
     */
    Y("координата Y", "поле не должно быть null", 3),
    /**
     * Enginepower fields.
     */
    ENGINEPOWER("сила двигателя", "может быть null" + " но значение поля должно быть больше 0", 4),
    /**
     * Vhicletype fields.
     */
    VHICLETYPE("тип транспорта", "может быть " + VehicleType.getStringValues() + ", может быть null", 5),


    /**
     * Fueltype fields.
     */
    FUELTYPE("тип топлива", "может быть " + FuelType.getStringValues() + ", может быть null", 6);

    /**
     * The constant MIM_X.
     */
    public final static int MIM_X = -661;
    /**
     * The Name.
     */
    final String name, /**
     * Comments fields.
     */
    comments;
    /**
     * The Order.
     */
    final int order;

    Fields(String name, String comments, int order) {
        this.name = name;
        this.comments = comments;
        this.order = order;
    }

    /**
     * Get for order fields.
     *
     * @param order the order
     * @return the fields
     */
    public static Fields getForOrder(int order) {
        for (Fields field : Fields.values()) {
            if (field.order == order) return field;
        }
        System.out.println(Errors.NOTHASFIELD);
        return null;
    }

    @Override
    public String toString() {
        return "Введите значение поля " + name + " : " + comments;
    }
}

