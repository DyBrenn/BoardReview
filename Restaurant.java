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
import java.util.*;

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
	                        	/* Store all reviews */
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
	         /* get 5 most recent reviews */
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
	public String[][] dataMine(String restaurant) {
		String rtrn[][] = new String[3][5];
		try {
			 restaurant = restaurant.toLowerCase();
	         File inputFile = new File("restaurants.xml");
	         DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	         Document doc = docBuilder.parse(inputFile);
	         Node root = doc.getFirstChild();
	         NodeList list = doc.getElementsByTagName("restaurant");
	         String[] low = new String[5];
	         int a = 0;
	         boolean low5 = false;
	         String[] med = new String[5];
	         int b = 0;
	         boolean med5 = false;
	         String[] high = new String[5];
	         int c = 0;
	         boolean high5 = false;
	         for (int temp = 0; temp < list.getLength(); temp++) {
	        	 Node node = list.item(temp);
	        	 if (node.getNodeType() == Node.ELEMENT_NODE) {
	                 Element eElement = (Element) node;
	                 /* when correct restaurant is found, mine through reviews to determine general opinion of restaurant*/
	                 if (restaurant.equals(eElement.getElementsByTagName("name").item(0).getTextContent())) {
	                        NodeList reviews = eElement.getElementsByTagName("reviews");
	                        for (int temp2=0; temp2<reviews.getLength(); temp2++) {
	                        	Random rand = new Random();
	                        	float chance = rand.nextFloat();
	                        	/* Save 5 high/medium/low reviews */
	                        	Element rev = (Element) node;
	                        	String rating = rev.getElementsByTagName("rating").item(temp2).getTextContent();
	                        	int score = Integer.parseInt(rating);
	                        	if (score < 4) {
	                        		String review = new String();
	                        		if (a > 5) {
	                        			a = 0;
	                        			low5 = true;
	                        		}
	                        		review += rev.getElementsByTagName("reviewer").item(temp2).getTextContent();
		                        	review += ",";
		                        	String rating2 = rev.getElementsByTagName("rating").item(temp2).getTextContent();
		                        	review += rating2;
		                        	review += ",";
		                        	review += rev.getElementsByTagName("comments").item(temp2).getTextContent();
		                        	if (low5 & chance > .50) {
		                        		low[a] = review;
		                        	}
		                        	else {
		                        	low[a] = review;
		                        	}
		                        	a += 1;
	                        	}
	                        	if (score > 7) {

	                        		String review = new String();
	                        		if (b > 5) {
	                        			b = 0;
	                        			med5 = true;
	                        		}
	                        		review += rev.getElementsByTagName("reviewer").item(temp2).getTextContent();
		                        	review += ",";
		                        	String rating2 = rev.getElementsByTagName("rating").item(temp2).getTextContent();
		                        	review += rating2;
		                        	review += ",";
		                        	review += rev.getElementsByTagName("comments").item(temp2).getTextContent();
		                        	if (med5 & chance > .50) {
		                        		med[b] = review;
		                        	}
		                        	else {
		                        	med[b] = review;
		                        	}
		                        	b += 1;
	                        	}
	                        	if (3 <= score & score <= 7) {

	                        		String review = new String();
	                        		if (c > 5) {
	                        			c = 0;
	                        			high5 = true;
	                        		}
	                        		review += rev.getElementsByTagName("reviewer").item(temp2).getTextContent();
		                        	review += ",";
		                        	String rating2 = rev.getElementsByTagName("rating").item(temp2).getTextContent();
		                        	review += rating2;
		                        	review += ",";
		                        	review += rev.getElementsByTagName("comments").item(temp2).getTextContent();
		                        	if (high5 & chance > .50) {
		                        		high[c] = review;
		                        	}
		                        	else {
		                        	high[c] = review;
		                        	}
		                        	c += 1;
	                        	}
	                        	
	                        }
	                        
	                        
	                        
	        	 }
	         }
	         }
	         
	         rtrn[0] = low;
	         rtrn[1] = med;
	         rtrn[2] = high;
	         
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

