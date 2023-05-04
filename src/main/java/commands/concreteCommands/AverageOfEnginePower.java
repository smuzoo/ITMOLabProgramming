package commands.concreteCommands;

import collection.Vehicle;
import collection.VehicleCollection;
import commands.Command;

/**
 * The type Average of engine power.
 */
public class AverageOfEnginePower implements Command {
    @Override
    public void execute(String ignore) {
        float enginepower = VehicleCollection.getVehicles().stream()
                .mapToLong(Vehicle::getEnginePower).sum() / VehicleCollection.getVehicles().size();
        System.out.println(" Среднее  значение силы двигателя " + enginepower);


    }

    @Override
    public String description() {
        return "average_of_engine_power " + " : вывести среднее значение поля enginePower для всех элементов коллекции";
    }
}
