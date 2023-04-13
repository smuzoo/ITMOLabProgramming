package Parsers;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import collection.*;


public class ParserFile extends Parser {
            File inputFile = new File("vehicle.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc;

    {
        try {
            doc = dBuilder.parse(inputFile);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("vehicle");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    Element coordinatesElement = (Element) element.getElementsByTagName("coordinates").item(0);
                    Double x = Double.parseDouble(coordinatesElement.getElementsByTagName("x").item(0).getTextContent());
                    Double y = Double.parseDouble(coordinatesElement.getElementsByTagName("y").item(0).getTextContent());
                    Coordinates coordinates = new Coordinates(x, y);
                    Long enginePower = Long.parseLong(element.getElementsByTagName("enginePower").item(0).getTextContent());
                    VehicleType type = VehicleType.valueOf(element.getElementsByTagName("type").item(0).getTextContent().toUpperCase());
                    FuelType fuelType = FuelType.valueOf(element.getElementsByTagName("fuelType").item(0).getTextContent().toUpperCase());
                    Vehicle vehicle = new Vehicle(name, coordinates, enginePower, type, fuelType);
                    // Do something with the vehicle object
                }
            }

    public ParserFile() throws ParserConfigurationException {
    }

    @Override
    public String getNewLine() {
        return null;
    }
}
/*class Vehicle {
    private String name;
    private Coordinates coordinates;
    private Long enginePower;
    private VehicleType type;
    private FuelType fuelType;

    public Vehicle(String name, Coordinates coordinates, Long enginePower, VehicleType type, FuelType fuelType) {
        this.name = name;
        this.coordinates = coordinates;
        this.enginePower = enginePower;
        this.type = type;
        this.fuelType = fuelType;
    }

    // Getters and setters
}

class Coordinates {
    private Double x;
    private Double y;

    public Coordinates(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    // Getters and setters
}

enum VehicleType {
    CAR, TRUCK, MOTORCYCLE, BUS
}

enum FuelType {
    GASOLINE, DIESEL, ELECTRIC, HYBRID
}*/
