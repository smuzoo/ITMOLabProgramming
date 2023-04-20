package commands.concreteCommands;

import collection.Vehicle;
import collection.VehicleCollection;
import collection.edit.VehicleCreate;
import commands.Command;
import parsers.Parsing;

import java.util.UUID;

public class Insert implements Command {
    private final Parsing parser;

    public Insert(Parsing parser) {
        this.parser = parser;
    }

    @Override
    public void execute(String argumentID) {
        VehicleCreate vehicleCreate = new VehicleCreate(parser);
        UUID id = null;
        if(argumentID.equals("null")){
            id = UUID.randomUUID();
         id = UUID.fromString(argumentID);
            }

        if (id != null){
            Vehicle vehicle = vehicleCreate.create();
            vehicle.setId(id);
            VehicleCollection.add(vehicle);
            System.out.println("Элемент успешно добавлен в коллекцию");
        }


    }

    @Override
    public String description() {
        return "insert" + " null {element}" + " : добавить новый элемент с заданным ключом";
    }
}
