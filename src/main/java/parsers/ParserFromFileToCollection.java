package parsers;


import collection.Coordinates;
import collection.FuelType;
import collection.Vehicle;
import collection.VehicleType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import validation.Errors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.UUID;

/**
 * The type Parser from file to collection.
 */
public class ParserFromFileToCollection {
    /**
     * Read linked hash map.
     *
     * @param fileName the file name
     * @return the linked hash map
     */
    public static LinkedHashMap<String, Vehicle> read(String fileName) {
        LinkedHashMap<String, Vehicle> vehicles = new LinkedHashMap<>();
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
                    Long enginePower = null;
                    String enginePowerText = element.getElementsByTagName("enginePower").item(0).getTextContent();


                    if (enginePowerText != null && !enginePowerText.isEmpty()) {
                        enginePower = Long.parseLong(enginePowerText);
                    } else {
                        enginePower = null;
                    }
                    VehicleType type = null;
                    try {
                        type = VehicleType.valueOf(element.getElementsByTagName("type").item(0).getTextContent());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Значение VehicleType неверно, было присвоено значение null "+Errors.INCORRECTENUMFORMATFROMFILE);
                    }

                    FuelType fuelType = null;
                    String fuelTypeStr = element.getElementsByTagName("fuelType").item(0).getTextContent();
                    if (fuelTypeStr != null && !fuelTypeStr.isEmpty()) {
                        try {
                            fuelType = FuelType.valueOf(fuelTypeStr);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Значение FuelType неверно, было присвоено значение null "+Errors.INCORRECTENUMFORMATFROMFILE);
                        }
                    }


                    String key = element.getElementsByTagName("key").item(0).getTextContent();
                    Vehicle vehicle = new Vehicle(UUID.randomUUID(), name, coordinates, enginePower, type, fuelType);
                    vehicles.put(key, vehicle);
                }
            }
        } catch (SAXException e) {
            System.out.println(Errors.IMPOSSIBLEXMLFILESTRUCTURE);
        } catch (IOException e) {
            System.out.println(Errors.IMPOSSIBLEREADFILE);
        } catch (ParserConfigurationException e) {
            System.out.println(Errors.IMPOSSIBLEPARSERCONFIGURATIONFROMFILE);
        } catch (NumberFormatException e) {
            System.out.println(Errors.INCORRECTNUMBERFORMATFROMFILE);
        /*} catch (IllegalArgumentException e) {
            System.out.println(Errors.INCORRECTENUMFORMATFROMFILE);*/

        }

        return vehicles;
    }

}
