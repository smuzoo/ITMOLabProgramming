package collection;
//import validators.Errors;


import validation.Errors;

public enum Fields {

        NAME("имя", "не может быть null", 1),
        COORDINATES("координаты", "coordinate.x,coordinate.y (через запятую)" +
                "поля не могут быть null, поле coordinate.x должно превышать значение " + Fields.MIM_X, 2),
        ENGINEPOWER("сила двигателя", "может быть null" + " но значение поля должно быть больше 0", 3),
        VHICLETYPE("тип транспорта", "может быть " + VehicleType.getStringValues() + ", может быть null", 3),
        FUELTYPE("тип топлива", "может быть " + FuelType.getStringValues() + ", может быть null", 4);

        public final static float MIM_X = -661;
        final String name, comments;
        final int order;

        Fields(String name, String comments, int order) {
            this.name = name;
            this.comments = comments;
            this.order = order;
        }

        public static Fields getForOrder(int order){
            for(Fields field : Fields.values()){
                if(field.order == order) return  field;
            }
            System.out.println(Errors.NOTHASFIELD);
            return null;
        }

        @Override
        public String toString(){
            return "Введите значение поля " + name + " : " + comments;
        }
    }

