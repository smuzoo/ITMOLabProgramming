package commands.concreteCommands;

import collection.Vehicle;
import collection.VehicleCollection;
import commands.Command;
import parsers.ConsoleParser;
import parsers.FileConstant;
import validation.Errors;
import validation.file.FileToReadWriteValidator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class Save implements Command {

    @Override
    public void execute(String ignore) {
        String FILE_PATH = FileConstant.getFilePath();
        ConsoleParser parser = new ConsoleParser();
        FileToReadWriteValidator fileValidatorToReadAndWrite = new FileToReadWriteValidator(new File(FILE_PATH));
        while (!fileValidatorToReadAndWrite.isValid()) {
            System.out.println("Введите название нового файла");
            FILE_PATH = parser.getNewLine();
            FileConstant.setFilePath(FILE_PATH);
            fileValidatorToReadAndWrite = new FileToReadWriteValidator(new File(FILE_PATH));
        }
        try {
            PrintWriter writer = new PrintWriter(FILE_PATH, "UTF-8");

            writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.println("<vehicles>");

            VehicleCollection.getVehicles().forEach(vehicle -> {
                writer.println("  <vehicle>");
                writer.println("    <name>" + vehicle.getName() + "</name>");
                writer.println("    <coordinates>");
                writer.println("      <x>" + vehicle.getCoordinates().getX() + "</x>");
                writer.println("      <y>" + vehicle.getCoordinates().getY() + "</y>");
                writer.println("    </coordinates>");
                writer.println("    <enginePower>" + vehicle.getEnginePower() + "</enginePower>");
                writer.println("    <type>" + vehicle.getVehicleType().toString() + "</type>");
                writer.println("    <fuelType>" + vehicle.getFuelType().toString() + "</fuelType>");
                writer.println("    <key>" + VehicleCollection.keySet().stream().filter(key -> VehicleCollection.getVehicleHashMapCollection().get(key).equals(vehicle)).toArray()[0] + "</key>");
                writer.println("  </vehicle>");
            });

            writer.println("</vehicles>");
            writer.close();
            System.out.println("Коллекция была успешна записана в файл");
        } catch (IOException e) {
            System.out.println(Errors.IMPOSSIBLEWRITETOFILE);
        }


    }

    @Override
    public String description() {
        return  "save" + " : сохранить коллекцию в файл";
    }
}
