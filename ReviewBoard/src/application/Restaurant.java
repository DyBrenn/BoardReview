package application;

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

	public void main(String[] args) {
	}
	public static void favorite_forum(String restaurant, String user, String text) {
	}
	public String[] get_restaurant(String restaurant) {
		String rtrn[] = new String[9];
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
	         String fav = new String();
	         String[] num = new String[5];
	         for (int temp = 0; temp < list.getLength(); temp++) {
	        	 Node node = list.item(temp);
	        	 if (node.getNodeType() == Node.ELEMENT_NODE) {
	                 Element eElement = (Element) node;
	                 /* when correct restaurant is found, add all aspects of review*/
	                 if (restaurant.equals(eElement.getElementsByTagName("name").item(0).getTextContent())) {
	                        location = eElement.getElementsByTagName("location").item(0).getTextContent();
	                        fav = eElement.getElementsByTagName("favorite").item(0).getTextContent();
	                        NodeList reviews = eElement.getElementsByTagName("reviews");
	                        for (int temp2=0; temp2<reviews.getLength(); temp2++) {
	                        	/* Store all reviews */
	                        	String review = new String();
	                        	Element rev = (Element) node;
	                        	review += "Customer: ";
	                        	review += rev.getElementsByTagName("reviewer").item(temp2).getTextContent();
	                        	review += "\n";
	                        	review += "Rating : " ;
	                        	String rating = rev.getElementsByTagName("rating").item(temp2).getTextContent();
	                        	review += rating;
	                        	review += "\n";
	                        	review += "Comment: ";
	                        	review += rev.getElementsByTagName("comments").item(temp2).getTextContent();
	                        	review += "\n";
	                        	review += "\n";
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
	         for (int i=0; i<5; i++) {
	        	 if (num[i] == null) {
	        		 num[i] = "";
	        	 }
	         }
	         rtrn[0] = restaurant;
	         rtrn[1] = avg2;
	         rtrn[2] = location;
	         rtrn[3] = num[0];
	         rtrn[4] = num[1];
	         rtrn[5] = num[2];
	         rtrn[6] = num[3];
	         rtrn[7] = num[4];
	         rtrn[8] = fav;
	         }catch (Exception e) {
		         e.printStackTrace();
		      }
		return rtrn;
	}
	public String[] sortReviews(String restaurant) {
		String rtrn[] = new String[15];
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
	                        		if (a > 4) {
	                        			a = 0;
	                        			low5 = true;
	                        		}
	                        		review += "Customer: ";
	                        		review += rev.getElementsByTagName("reviewer").item(temp2).getTextContent();
		                        	review += "\n";
		                        	review += "Rating: ";
		                        	String rating2 = rev.getElementsByTagName("rating").item(temp2).getTextContent();
		                        	review += rating2;
		                        	review += "\n";
		                        	review += "Comment: ";
		                        	review += rev.getElementsByTagName("comments").item(temp2).getTextContent();
		                        	review += "\n";
		                        	review += "\n";
		       
		                        	if (low5 & Math.random() > .50) {
		                        		low[a] = review;
		                        	}
		                        	if (low5 != true) {
		                        	low[a] = review;
		                        	}
		                        	a += 1;
	                        	}
	                        	if (3 <= score & score <= 7) {

	                        		String review = new String();
	                        		if (b > 4) {
	                        			b = 0;
	                        			med5 = true;
	                        		}
	                        		review += "Customer: ";
	                        		review += rev.getElementsByTagName("reviewer").item(temp2).getTextContent();
		                        	review += "\n";
		                        	review += "Rating: ";
		                        	String rating2 = rev.getElementsByTagName("rating").item(temp2).getTextContent();
		                        	review += rating2;
		                        	review += "\n";
		                        	review += "Comment: ";
		                        	review += rev.getElementsByTagName("comments").item(temp2).getTextContent();
		                        	review += "\n";
		                        	review += "\n";
		                     
		                        	if (med5 & Math.random() > .50) {
		                        		med[b] = review;
		                        	}
		                        	if (med5 != true) {
		                        	med[b] = review;
		                        	}
		                        	b += 1;
	                        	}
	                        	if (score > 7) {

	                        		String review = new String();
	                        		if (c > 4) {
	                        			c = 0;
	                        			high5 = true;
	                        		}
	                        		review += "Customer: ";
	                        		review += rev.getElementsByTagName("reviewer").item(temp2).getTextContent();
		                        	review += "\n";
		                        	review += "Rating: ";
		                        	String rating2 = rev.getElementsByTagName("rating").item(temp2).getTextContent();
		                        	review += rating2;
		                        	review += "\n";
		                        	review += "Comment: ";
		                        	review += rev.getElementsByTagName("comments").item(temp2).getTextContent();
		                        	review += "\n";
		                        	review += "\n";
		          
		                        	if (high5 & Math.random() > .50) {
		                        		high[c] = review;
		                        	}
		                        	if (high5 != true) {
		                        	high[c] = review;
		                        	}
		                        	c += 1;
	                        	}
	                        	
	                        }
	                        
	                        
	                        
	        	 }
	         }
	         }
	         for (int i=0; i<5; i++) {
	        	 if (low[i] == null) {
	        		 low[i] = "";
	        	 }
	        	 if (med[i] == null) {
	        		 med[i] = "";
	        	 }
	        	 if (high[i] == null) {
	        		 high[i] = "";
	        	 }
	        	 rtrn[i] = low[i];
	        	 rtrn[5+i] = med[i];
	        	 rtrn[10+i] = high[i];
	         }
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
	                	    Element opinion = doc.createElement("opinion");
	                	 	eElement.appendChild(opinion);
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
