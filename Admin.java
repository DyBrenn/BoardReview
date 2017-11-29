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

	public static void main(String[] args) {
		      
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
	                    
	                 
	         /*Save changes to file*/            
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource domSource = new DOMSource(doc);
	         StreamResult streamResult = new StreamResult(new File("users.xml"));
	         transformer.transform(domSource, streamResult);
	         }catch (Exception e) {
		         e.printStackTrace();
		      }
		
	}
	private static void removeUser(String user) {
		try {
			 user = user.toLowerCase();
	         File inputFile = new File("users.xml");
	         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	         Document doc = docBuilder.parse(inputFile);
	         Node root = doc.getFirstChild();
	         NodeList list = doc.getElementsByTagName("user");
	         /*iterate through all of users in database*/
	         for (int temp = 0; temp < list.getLength(); temp++) {
	        	 Node node = list.item(temp);
	        	 if (node.getNodeType() == Node.ELEMENT_NODE) {
	                 Element eElement = (Element) node;
	                 /*when correct user is found, delete*/
	                 if (user.equals(eElement.getElementsByTagName("username").item(0).getTextContent())) {
	                	 eElement.getParentNode().removeChild(eElement);
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
	         Element opinion = doc.createElement("opinion");
	         fav.setTextContent("none");
	         rest.appendChild(fav);
	         /*doc.getDocumentElement().normalize();*/
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource domSource = new DOMSource(doc);
	         StreamResult streamResult = new StreamResult(new File("restaurants.xml"));
	         transformer.transform(domSource, streamResult);

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
	}
	public static void dataMine(String restaurant) {
		try {
			 restaurant = restaurant.toLowerCase();
	         File inputFile = new File("restaurants.xml");
	         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	         Document doc = docBuilder.parse(inputFile);
	         Node root = doc.getFirstChild();
	         NodeList list = doc.getElementsByTagName("restaurant");
	         int good = 0;
	         int okay = 0;
	         int bad  = 0;
	         for (int temp = 0; temp < list.getLength(); temp++) {
	        	 Node node = list.item(temp);
	        	 if (node.getNodeType() == Node.ELEMENT_NODE) {
	                 Element eElement = (Element) node;
	                 /* when correct restaurant is found, mine through reviews to determine general opinion of restaurant*/
	                 if (restaurant.equals(eElement.getElementsByTagName("name").item(0).getTextContent())) {
	                        NodeList reviews = eElement.getElementsByTagName("reviews");
	                        for (int temp2=0; temp2<reviews.getLength(); temp2++) {
	                        	Element rev = (Element) node;
	                        	String rating = rev.getElementsByTagName("rating").item(temp2).getTextContent();
	                        	int score = Integer.parseInt(rating);
	                        	if (score < 4) {
	                        		bad += 1;
	                        	}
	                        	if (score > 7) {
	                        		good += 1;
	                        	}
	                        	if (3 <= score & score <= 7) {
	                        		okay += 1;
	                        	}
	                        	
	                        }
	                        if (good > okay & good > bad) {
	                         String good2 = Integer.toString(good);
	           	        	 eElement.getElementsByTagName("opinion").item(0).setTextContent(good2);
	           	         }
	           	         if (okay > good & okay > bad) {
	           	        	String okay2 = Integer.toString(okay);
	           	        	eElement.getElementsByTagName("opinion").item(0).setTextContent(okay2);
	           	         }
	           	         if (bad > good & bad > okay) {
	           	        	String bad2 = Integer.toString(bad);
	           	        	eElement.getElementsByTagName("opinion").item(0).setTextContent(bad2);
	           	         }
	                        
	                        
	                        
	        	 }
	         }
	         }
	         
	         }catch (Exception e) {
		         e.printStackTrace();
		      }
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
