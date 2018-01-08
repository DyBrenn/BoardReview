package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CommentPageController {
	
	
	LoginPageController  LGC = new LoginPageController();
	String name1 = LGC.SignedInName;
	
	HomePageContoller HPC = new HomePageContoller();
	String RestaurantName = HPC.RestaurantName;
	
	@FXML private  TextField score;
	@FXML private TextArea text;
	@FXML private Button Submit;
	
	
	public void AddReview(ActionEvent event) throws IOException {
		String scorex = score.getText();
		String textx = text.getText();
		
		Restaurant rest = new Restaurant();
		rest.review(RestaurantName, name1 , scorex, textx);
		
		
		
	}
	
	@FXML private Button HomeButton3;
	public void GoToHomePage(ActionEvent event1) throws IOException {
		Parent GoToHomePageParent = FXMLLoader.load(getClass().getResource("/application/HomePage.fxml"));
		Scene GoToHomePageView = new Scene(GoToHomePageParent);
		
		Stage window1 = (Stage) ((Node) event1.getSource()).getScene().getWindow();
		window1.setScene(GoToHomePageView);
		window1.show();
	}
	
	@FXML private TextField SearchBar3;
	@FXML private Button GoButton3;
	HomePageContoller HomePageControllerX = new HomePageContoller();
	Restaurant rest = new Restaurant();
	public static String reviews1[] = new String[15];
	
	@FXML
	public void SearchRestaurant3(ActionEvent event) throws IOException {
		
		
		String ToFind = SearchBar3.getText();
		System.out.println(ToFind);
		String[] data = rest.get_restaurant(ToFind);
		HomePageControllerX.CommentData = data;
		
		Main mainx = new Main();
		String ResName = mainx.RestaurantNameX;
		mainx.RestaurantNameX = ToFind;
		System.out.println(mainx.RestaurantNameX);
	
		
		reviews1 = rest.sortReviews(ToFind);
		HomePageControllerX.reviews = reviews1;
		
		Parent RestaurantPageParent = FXMLLoader.load(getClass().getResource("/application/RestaurantPage.fxml"));
		Scene RestaurantPageView = new Scene(RestaurantPageParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(RestaurantPageView);
		window.show();
		
		
	}
	
	
	

}
