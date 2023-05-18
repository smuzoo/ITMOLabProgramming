package commands.concreteCommands;

import collection.Vehicle;
import collection.VehicleCollection;
import collection.edit.VehicleCreate;
import commands.Command;
import parsers.Parsing;
import validation.values.KeyValidator;

import java.util.UUID;

/**
 * The type Insert vehicle.
 */
public class InsertVehicle implements Command {
    private final Parsing parser;

    /**
     * Instantiates a new Insert vehicle.
     *
     * @param parser the parser
     */
    public InsertVehicle(Parsing parser) {
        this.parser = parser;
    }

    @Override
    public void execute(String idArgument) {
        VehicleCreate vehicleCreate = new VehicleCreate(parser);
        final String newKey = idArgument;
        if (VehicleCollection.keySet().stream().anyMatch(key -> key.equals(newKey))) {
            System.out.println("Элемент с таким ключом уже есть");
        } else {
            KeyValidator keyValidator = new KeyValidator(idArgument);
            if (keyValidator.isValid()) {

                String key = idArgument;
                Vehicle vehicle = vehicleCreate.create();
                vehicle.setId(UUID.randomUUID());
                VehicleCollection.add(key, vehicle);
                System.out.println("Элемент успешно добавлен в коллекцию");
            }
        }


    }

    @Override
    public String description() {
        return "insert" + " null {element}" + " : добавить новый элемент с заданным ключом";
    }
}
