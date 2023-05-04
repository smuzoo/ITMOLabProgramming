package collection.edit;

import collection.Fields;
import collection.Vehicle;
import parsers.Parsing;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * The type Vehicle create.
 */
public class VehicleCreate {
    private final Parsing parser;

    /**
     * Instantiates a new Vehicle create.
     *
     * @param parser the parser
     */
    public VehicleCreate(Parsing parser) {
        this.parser = parser;
    }

    /**
     * Create vehicle.
     *
     * @return the vehicle
     */
    public Vehicle create() {
        Vehicle vehicle = new Vehicle();
        Map<Fields, Predicate<String>> notNullSetters = vehicle.getNotNullSetters();
        Map<Fields, Consumer<String>> setters = vehicle.getSetters();
        boolean isCorrectField;
        for (Fields field : notNullSetters.keySet()) {
            do {
                System.out.println(field);
                String fieldValue = parser.getNewLine();
                isCorrectField = notNullSetters.get(field).test(fieldValue);
            } while (!isCorrectField);

        }
        for (Fields field : setters.keySet()) {
            System.out.println(field);
            setters.get(field).accept(parser.getNewLine());
        }
        return vehicle;
    }
}
