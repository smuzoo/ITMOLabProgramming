package parsers;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import collection.*;
import validation.Errors;

public class ParserFromFileToCollection {
    public static LinkedHashMap<UUID, Vehicle> read(String fileName) {
        LinkedHashMap<UUID, Vehicle> vehicles = new LinkedHashMap<>();
        try (InputStream inputStream = new FileInputStream(fileName)) {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("vehicle");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    Element coordinatesElement = (Element) element.getElementsByTagName("coordinates").item(0);
                    int x = Integer.parseInt(coordinatesElement.getElementsByTagName("x").item(0).getTextContent());
                    double y = Double.parseDouble(coordinatesElement.getElementsByTagName("y").item(0).getTextContent());
                    Coordinates coordinates = new Coordinates(x, y);
                    Long enginePower = Long.parseLong(element.getElementsByTagName("enginePower").item(0).getTextContent());
                    VehicleType type = VehicleType.valueOf(element.getElementsByTagName("type").item(0).getTextContent());
                    FuelType fuelType = FuelType.valueOf(element.getElementsByTagName("fuelType").item(0).getTextContent());
                    Vehicle vehicle = new Vehicle(UUID.randomUUID(), name, coordinates, enginePower, type, fuelType);
                    vehicles.put(vehicle.getId(), vehicle);
                    System.out.println(vehicles);
                }
            }
        } catch (SAXException e) {
            System.out.println(Errors.IMPOSSIBLEXMLFILESTRUCTURE);

        } catch (IOException e){
            System.out.println(Errors.IMPOSSIBLEREADFILE);
        } catch (ParserConfigurationException e){
            System.out.println(Errors.IMPOSSIBLEPARSERCONFIGURATION);
        }

        return vehicles;
    }

}
