import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.sql.DriverManager;

public class Admin extends User{

	public static void main(String[] args){
	}
	private static void addAdmin(String user) {
		try {
	         File inputFile = new File("users.xml");
	         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	         Document doc = docBuilder.parse(inputFile);
	         Node root = doc.getFirstChild();
	         NodeList list = doc.getElementsByTagName("user");
	         
	         for (int temp = 0; temp < list.getLength(); temp++) {
	        	 Node node = list.item(temp);
	        	 if (node.getNodeType() == Node.ELEMENT_NODE) {
	                 Element eElement = (Element) node;
	                 if (user.equals(eElement.getElementsByTagName("username").item(0).getTextContent())) {
	                        eElement.getElementsByTagName("admin").item(0).setTextContent("true");
	        	 }
	         }
	         }
	                    
	                 
	                     
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource domSource = new DOMSource(doc);
	         StreamResult streamResult = new StreamResult(new File("users.xml"));
	         transformer.transform(domSource, streamResult);
	         }catch (Exception e) {
		         e.printStackTrace();
		      }
		
	}
	private static void addRestaurant(String rest_name, String specialization, String location) {
		try {
			 rest_name = rest_name.toLowerCase();
			 File inputFile = new File("restaurants.xml");
	         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	         Document doc = docBuilder.parse(inputFile);
	         Node db = doc.getFirstChild();
	         Element rest = doc.createElement("restaurant"); /*create field for restaurant*/
	         db.appendChild(rest);
	         Element name = doc.createElement("name"); /*add field for restaurant name*/
	         name.setTextContent(rest_name);
	         rest.appendChild(name);
	         Element type = doc.createElement("specialization"); /*create field for type of restaurant
	         													(food served)*/
	         type.setTextContent(specialization);
	         rest.appendChild(type);
	         Element loc = doc.createElement("location"); /*create field for location*/
	         loc.setTextContent(location);
	         rest.appendChild(loc);
	         Element fav = doc.createElement("favorite");
	         fav.setTextContent("0");
	         rest.appendChild(fav);
	         /*doc.getDocumentElement().normalize();*/
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource domSource = new DOMSource(doc);
	         StreamResult streamResult = new StreamResult(new File("restaurants.xml"));
	         System.out.println("");
	         transformer.transform(domSource, streamResult);

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
	}
	private static void dataMine(String[] args) {
		
	}
	private static void resetRest() { /* resets restaurant database*/
		try {
			 File inputFile = new File("reset.xml");
	         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	         Document doc = docBuilder.parse(inputFile);
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource domSource = new DOMSource(doc);
	         StreamResult streamResult = new StreamResult(new File("restaurants.xml"));
	         transformer.transform(domSource, streamResult);
		} catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	private static void resetUser() { /* resets restaurant database*/
		try {
			 File inputFile = new File("reset.xml");
	         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	         Document doc = docBuilder.parse(inputFile);
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource domSource = new DOMSource(doc);
	         StreamResult streamResult = new StreamResult(new File("users.xml"));
	         transformer.transform(domSource, streamResult);
		} catch (Exception e) {
	         e.printStackTrace();
	      }
	}
}
