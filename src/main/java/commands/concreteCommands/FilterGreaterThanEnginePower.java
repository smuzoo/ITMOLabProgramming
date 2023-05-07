package commands.concreteCommands;

import collection.VehicleCollection;
import commands.Command;
import validation.values.EnginePowerValidator;

/**
 * The type Filter greater than engine power.
 */
public class FilterGreaterThanEnginePower implements Command {
    @Override
    public void execute(String argument) {
        EnginePowerValidator enginePowerValidator = new EnginePowerValidator(argument);
        if (enginePowerValidator.isValid()) {
            Long Largument = Long.parseLong(argument);
            VehicleCollection.getVehicles().stream()
                    .filter(vehicle -> {
                        Long enginePower = vehicle.getEnginePower();
                        return enginePower != null && enginePower.longValue() > Largument;
                    })
                    .forEach(System.out::println);
        }
    }


    @Override
    public String description() {
        return "filer_greater_than_engine_power" + " null" + " : вывести элементы, значение поля enginePower которых больше заданного";
    }
}
