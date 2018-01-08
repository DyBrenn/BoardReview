package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePageContoller  {
	
	public static String RestaurantName;
	
	//Functionality for the signin button to switch to login screen
	
	public void SwitchToLogin(ActionEvent event) throws IOException {
		
		Parent LoginPageParent = FXMLLoader.load(getClass().getResource("/application/LogIn.fxml"));
		Scene LoginPageView = new Scene(LoginPageParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(LoginPageView);
		window.show();
	}
	
	@FXML private TextField SearchBar;
	@FXML private Button GoButton1;
	private String Comment;
	
	public static String   CommentData[] = new String[5];
	public static String reviews[] = new String[15];
	

	
	@FXML
	public void SearchRestaurant(ActionEvent event) throws IOException {
		
		
		String ToFind = SearchBar.getText();
		Restaurant rest = new Restaurant();
		String[] data = rest.get_restaurant(ToFind);
		CommentData = data;
		
		Main mainx = new Main();
		String ResName = mainx.RestaurantNameX;
		mainx.RestaurantNameX = ToFind;
		System.out.println(mainx.RestaurantNameX);
		RestaurantName = ToFind;
		
		
		
		Label TitleNameofRes = new Label("Name of Restaurant");
		

		Label Rating = new Label(data[1]);
		Label TitleRating = new Label("Average of the Restaurant");

		
		
		//ReviewTextArea.appendText("TESTING");
		
		
		
		
		reviews = rest.sortReviews(ToFind);
		
		
		
		
	
		
		
		
		Parent RestaurantPageParent = FXMLLoader.load(getClass().getResource("/application/RestaurantPage.fxml"));
		Scene RestaurantPageView = new Scene(RestaurantPageParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(RestaurantPageView);
		window.show();
		
		
	}
	
	@FXML private Button GoToProfile1;
	public void SwitchToProfile(ActionEvent event) throws IOException {

		Parent ProfilePageParent = FXMLLoader.load(getClass().getResource("/application/ProfilePage.fxml"));
		Scene ProfilePageView = new Scene(ProfilePageParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(ProfilePageView);
		window.show();
		
		LoginPageController  LGC = new LoginPageController();
		String name1 = LGC.SignedInName;
		System.out.println(name1);
		
	}
	
	

	 
	 
	


	
	
	




	
	
	
	
	
	

}
