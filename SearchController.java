package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchController {
	
	/*
	@FXML private TextField SearchBar1;
	@FXML private TextArea DispCommentsx;
	public void Search1(ActionEvent event) throws IOException {
		String ToFind = SearchBar1.getText();
		Restaurant rest = new Restaurant();
		String[] data = rest.get_restaurant(ToFind);
		String restaurant = data[0];
		String rating = data[1];
		String location = data[2];
		
		
		List<String>  DataComment1 =    new ArrayList<String>(Arrays.asList(data[3].split(",")));
		List<String>  DataComment2 =    new ArrayList<String>(Arrays.asList(data[4].split(",")));
		List<String>  DataComment3 =    new ArrayList<String>(Arrays.asList(data[5].split(",")));
		List<String>  DataComment4 =    new ArrayList<String>(Arrays.asList(data[6].split(",")));
		List<String>  DataComment5 =    new ArrayList<String>(Arrays.asList(data[7].split(",")));
		
		
		
		String user1 = DataComment1.get(0);
		String user2 = DataComment2.get(0);
		String user3 = DataComment3.get(0);
		String user4 = DataComment4.get(0);
		String user5 = DataComment5.get(0);
		
		String Rating1 = DataComment1.get(1);
		String Rating2 = DataComment2.get(1);
		String Rating3 = DataComment3.get(1);
		String Rating4 = DataComment4.get(1);
		String Rating5 = DataComment5.get(1);
		
		String Comment1 = new String();
		for (int i=2; i<DataComment1.size(); i++) {
		Comment1 += DataComment1.get(i);
		}
		
		String Comment2 = new String();
		for (int i=2; i<DataComment2.size(); i++) {
		Comment2 += DataComment2.get(i);
		}
		
		String Comment3 = new String();
		for (int i=2; i<DataComment3.size(); i++) {
		Comment3 += DataComment3.get(i);
		}
		
		String Comment4 = new String();
		for (int i=2; i<DataComment4.size(); i++) {
		Comment4 += DataComment4.get(i);
		}
		
		String Comment5 = new String();
		for (int i=2; i<DataComment5.size(); i++) {
		Comment5 += DataComment5.get(i);
		}
		
		
		
		DispCommentsx.appendText("Customer: "+user1 + "\n " + "Rating : " + Rating1 +  "\n " + "Comment: "
				+ Comment1+ "\n "+ "\n "+"\n " );
				
				DispCommentsx.appendText("Customer: "+ user2 + "\n " + "Rating : " + Rating2 +  "\n " + "Comment: "
						+ Comment2+ "\n "+ "\n "+"\n " );
				
				DispCommentsx.appendText("Customer: " + user3 + "\n " + "Rating : " + Rating3 +  "\n " + "Comment: "
						+ Comment3+ "\n "+ "\n "+"\n " );
				
				DispCommentsx.appendText("Customer: "+ user4 + "\n " + "Rating : " + Rating4 +  "\n " + "Comment: "
						+ Comment4+ "\n "+ "\n "+"\n " );
				
				DispCommentsx.appendText("Customer: "+ user5 + "\n " + "Rating : " + Rating5 +  "\n " + "Comment: "
						+ Comment5+ "\n "+ "\n "+"\n " );
		
		Parent RestaurantPageParent = FXMLLoader.load(getClass().getResource("/application/RestaurantPage.fxml"));
		Scene RestaurantPageView = new Scene(RestaurantPageParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(RestaurantPageView);
		window.show();
		
		
	}
	*/
	

	
	

}
