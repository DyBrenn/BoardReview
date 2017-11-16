import java.io.File;

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

public class Restaurant {

	public static void main(String[] args) {

	}
	public static void favorite_forum(String restaurant, String user, String text) {
	}
	public String[] get_restaurant(String restaurant) {
		String rtrn[] = new String[8];
		try {
			 restaurant = restaurant.toLowerCase();
	         File inputFile = new File("restaurants.xml");
	         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	         Document doc = docBuilder.parse(inputFile);
	         Node root = doc.getFirstChild();
	         NodeList list = doc.getElementsByTagName("restaurant");
	         String location = new String();
	         int score = 0;
	         int reviewers = 0;
	         String[] num = new String[5];
	         for (int temp = 0; temp < list.getLength(); temp++) {
	        	 Node node = list.item(temp);
	        	 if (node.getNodeType() == Node.ELEMENT_NODE) {
	                 Element eElement = (Element) node;
	                 /* when correct restaurant is found, add all aspects of review*/
	                 if (restaurant.equals(eElement.getElementsByTagName("name").item(0).getTextContent())) {
	                        location = eElement.getElementsByTagName("location").item(0).getTextContent();
	                        NodeList reviews = eElement.getElementsByTagName("reviews");
	                        for (int temp2=0; temp2<reviews.getLength(); temp2++) {
	                        	String review = new String();
	                        	Element rev = (Element) node;
	                        	review += rev.getElementsByTagName("reviewer").item(temp2).getTextContent();
	                        	review += ",";
	                        	String rating = rev.getElementsByTagName("rating").item(temp2).getTextContent();
	                        	review += rating;
	                        	review += ",";
	                        	review += rev.getElementsByTagName("comments").item(temp2).getTextContent();
	                        	review += ",";
	                        	if (reviews.getLength()-1 - temp2 < 5) {
	                        	num[reviews.getLength()-1 - temp2] = review;
	                        	}
	                        	score += Integer.parseInt(rating);
	                        	reviewers += 1;
	                        }
	                        
	                        
	        	 }
	         }
	         }
	                    
	         int avg = score / reviewers;
	         String avg2 = Integer.toString(avg);
	         rtrn[0] = restaurant;
	         rtrn[1] = avg2;
	         rtrn[2] = location;
	         rtrn[3] = num[0];
	         rtrn[4] = num[1];
	         rtrn[5] = num[2];
	         rtrn[6] = num[3];
	         rtrn[7] = num[4];
	         return rtrn;
	         }catch (Exception e) {
		         e.printStackTrace();
		      }
		return rtrn;
	}
	public static void review(String restaurant, String user, String score, String text) {
		try {
	         File inputFile = new File("restaurants.xml");
	         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	         Document doc = docBuilder.parse(inputFile);
	         Node root = doc.getFirstChild();
	         NodeList list = doc.getElementsByTagName("restaurant");
	         
	         for (int temp = 0; temp < list.getLength(); temp++) {
	        	 Node node = list.item(temp);
	        	 if (node.getNodeType() == Node.ELEMENT_NODE) {
	                 Element eElement = (Element) node;
	                 /* when correct restaurant is found, add all aspects of review*/
	                 if (restaurant.equals(eElement.getElementsByTagName("name").item(0).getTextContent())) {
	                	 	Element rest = doc.createElement("reviews");
	                	 	eElement.appendChild(rest);
	                        Element reviewer = doc.createElement("reviewer");
	                        reviewer.setTextContent(user);
	                        rest.appendChild(reviewer);
	                        Element rating = doc.createElement("rating");
	                        rating.setTextContent(score);
	                        rest.appendChild(rating);
	                        Element review = doc.createElement("comments");
	                        review.setTextContent(text);
	                        rest.appendChild(review);
	                        
	                        
	        	 }
	         }
	         }
	                    
	                 
	                     
	         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	         Transformer transformer = transformerFactory.newTransformer();
	         DOMSource domSource = new DOMSource(doc);
	         StreamResult streamResult = new StreamResult(new File("restaurants.xml"));
	         transformer.transform(domSource, streamResult);
	         }catch (Exception e) {
		         e.printStackTrace();
		      }
		
	}

}
