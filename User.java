import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Attr;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.dom.DOMSource;

public class User{

	public static void main(String[] args){
	}
	public boolean[] checkUser(String user, String pass) {
		boolean rtrn[] = new boolean[2];
		try {
	         File inputFile = new File("users.xml");
	         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	         Document doc = docBuilder.parse(inputFile);
	         Node root = doc.getFirstChild();
	         NodeList list = doc.getElementsByTagName("user");
	         boolean found1 = false; /* is username in database*/
	         boolean found2 = false; /*is username and password combination in database*/
	         /*iterate through all of users in database*/
	         for (int temp = 0; temp < list.getLength(); temp++) {
	        	 Node node = list.item(temp);
	        	 if (node.getNodeType() == Node.ELEMENT_NODE) {
	                 Element eElement = (Element) node;
	                 /*when correct user is found, check password if correct, return true/false value*/
	                 if (user.equals(eElement.getElementsByTagName("username").item(0).getTextContent())) {
	                        found1 = true;
	                     }
	                 if (found1 == true) {
	                	 if (pass.equals(eElement.getElementsByTagName("password").item(0).getTextContent())) {
	                		 found2 = true;
	                 }
	                    	 }
	        	 }
	         }
	         rtrn[0] = found1;
	         rtrn[1] = found2;
	         }catch (Exception e) {
		         e.printStackTrace();
		      }
		return rtrn;
	}
	public boolean checkAdmin(String user) {
		boolean rtrn = false;
		try {
	         File inputFile = new File("users.xml");
	         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	         Document doc = docBuilder.parse(inputFile);
	         Node root = doc.getFirstChild();
	         NodeList list = doc.getElementsByTagName("user");
	         boolean found = false;
	         /*iterate through all of users in database*/
	         for (int temp = 0; temp < list.getLength(); temp++) {
	        	 Node node = list.item(temp);
	        	 if (node.getNodeType() == Node.ELEMENT_NODE) {
	                 Element eElement = (Element) node;
	                 /*when correct user is found, check if admin, return true/false value*/
	                 if (user.equals(eElement.getElementsByTagName("username").item(0).getTextContent())) {
	                	 if ("true".equals(eElement.getElementsByTagName("admin").item(0).getTextContent()))
	                        found = true;
	                    	 }
	        	 }
	         }
	         rtrn = found;
	         }catch (Exception e) {
		         e.printStackTrace();
		      }
		return rtrn;
	}
	public static void createUser(String user_name, String password, String location) {
		try {
			 user_name = user_name.toLowerCase();
			 location = location.toLowerCase();
			 File inputFile = new File("users.xml");
	         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	         Document doc = docBuilder.parse(inputFile);
	         Node db = doc.getFirstChild();
	         Element user = doc.createElement("user"); /*create field for user*/
	         db.appendChild(user);
	         Element username = doc.createElement("username"); /*create field for username*/
	         username.setTextContent(user_name);
	         user.appendChild(username);
	         Element password2 = doc.createElement("password"); /*create field for pass*/
	         password2.setTextContent(password);
	         user.appendChild(password2);
	         Element loc = doc.createElement("location"); /*create field for location*/
	         loc.setTextContent(location);
	         user.appendChild(loc);
	         Element admin = doc.createElement("admin"); /*determine if admin*/
	         admin.setTextContent("false");
	         user.appendChild(admin);
	         Element favorite = doc.createElement("favorite"); /*initialize favorite restaurant to none*/
	         favorite.setTextContent("none");
	         user.appendChild(favorite);
	         /*doc.getDocumentElement().normalize();*/
	         /*overwrites xml file with new data*/
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource domSource = new DOMSource(doc);
	         StreamResult streamResult = new StreamResult(new File("users.xml"));
	         transformer.transform(domSource, streamResult);

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
		
	}
	private static void changePass(String user, String curr_pass, String new_pass) {
		boolean found1 = false;
		try {
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
	                 /*when correct user is found, check password and if correct, update password*/
	                 if (user.equals(eElement.getElementsByTagName("username").item(0).getTextContent())) {
	                        found1 = true;
	                     }else {
	                    	 found1 = false;}
	                     
	                 if (curr_pass.equals(eElement.getElementsByTagName("password").item(0).getTextContent())) {
	                	 	if (found1 == true) {
	                    	 eElement.getElementsByTagName("password").item(0).setTextContent(new_pass);
	                	 	}
	                    	 }
	        	 }
	         }
	                    
	                 
	         /*overwrites xml file and prints new data*/
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource domSource = new DOMSource(doc);
	         StreamResult streamResult = new StreamResult(new File("users.xml"));
	         transformer.transform(domSource, streamResult);
	         }catch (Exception e) {
		         e.printStackTrace();
		      }
		
	}
	private static void changeLocation(String user, String loc) {
		try {
			 loc = loc.toLowerCase();
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
	                        eElement.getElementsByTagName("location").item(0).setTextContent(loc);
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
	public static void favorite(String user, String rest) {
		try {
			 String old_rest = new String();
			 rest = rest.toLowerCase();
			 File restFile = new File("restaurants.xml");
	         File inputFile = new File("users.xml");
	         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	         Document doc = docBuilder.parse(inputFile);
	         Document doc2 = docBuilder.parse(restFile);
	         Node root = doc.getFirstChild();
	         NodeList list = doc.getElementsByTagName("user");
	         NodeList list2 = doc2.getElementsByTagName("restaurant");
	         boolean found = false;
	         /*increase restaurants favorite number by one*/
	         for (int temp2 = 0; temp2 < list2.getLength(); temp2++) {
	        	 Node node2 = list2.item(temp2);
	        	 if (node2.getNodeType() == Node.ELEMENT_NODE) {
	                 Element eElement2 = (Element) node2;
	                 /* when correct restaurant is found, add all aspects of review*/
	                 if (rest.equals(eElement2.getElementsByTagName("name").item(0).getTextContent())) {
	                	 found = true;
	                	 int prev = Integer.parseInt(eElement2.getElementsByTagName("favorite").item(0).getTextContent());
	                	 prev += 1;
	                	 String fav = Integer.toString(prev);
	                	 eElement2.getElementsByTagName("favorite").item(0).setTextContent(fav);
	                 }
	        	 }
	         }
	      
	         if (found == true) {
		         for (int temp = 0; temp < list.getLength(); temp++) {
		        	 Node node = list.item(temp);
		        	 if (node.getNodeType() == Node.ELEMENT_NODE) {
		                 Element eElement = (Element) node;
		                 if (user.equals(eElement.getElementsByTagName("username").item(0).getTextContent())) {
		                	 	old_rest = eElement.getElementsByTagName("favorite").item(0).getTextContent();
		                        eElement.getElementsByTagName("favorite").item(0).setTextContent(rest);
		        	 }
		         }
		         }
	         }
	         if(old_rest != "none") {
	        	 for (int temp3 = 0; temp3 < list2.getLength(); temp3++) {
		        	 Node node3 = list2.item(temp3);
		        	 if (node3.getNodeType() == Node.ELEMENT_NODE) {
		                 Element eElement3 = (Element) node3;
		                 /* when correct restaurant is found, add all aspects of review*/
		                 if (old_rest.equals(eElement3.getElementsByTagName("name").item(0).getTextContent())) {
		                	 int prev = Integer.parseInt(eElement3.getElementsByTagName("favorite").item(0).getTextContent());
		                	 prev -= 1;
		                	 String fav = Integer.toString(prev);
		                	 eElement3.getElementsByTagName("favorite").item(0).setTextContent(fav);
		                 }
		        	 }
		         }
	         }
	                    
	                 
	                     
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         TransformerFactory transformerFactory2 = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         Transformer transformer2 = transformerFactory2.newTransformer();
	         DOMSource domSource = new DOMSource(doc);
	         DOMSource domSource2 = new DOMSource(doc2);
	         StreamResult streamResult = new StreamResult(new File("users.xml"));
	         StreamResult streamResult2 = new StreamResult(new File("restaurants.xml"));
	         transformer.transform(domSource, streamResult);
	         transformer2.transform(domSource2, streamResult2);
	         }catch (Exception e) {
		         e.printStackTrace();
		      }
		
	}
}
