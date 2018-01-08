package application;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RestaurantPageController {
	
	Restaurant rest = new Restaurant();
	
	
	
	HomePageContoller HomePageControllerX = new HomePageContoller();
	@FXML
	public void SearchRestaurant2(ActionEvent event) throws IOException {
		
		
		String ToFind = SearchBar2.getText();
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
	
	
	
	
	
	@FXML private Button MakeComment;
	public void GoToCommentPage(ActionEvent event1) throws IOException {
		Parent GoToCommentPageParent = FXMLLoader.load(getClass().getResource("/application/CommentPage.fxml"));
		Scene GoToCommentPageView = new Scene(GoToCommentPageParent);
		
		Stage window1 = (Stage) ((Node) event1.getSource()).getScene().getWindow();
		window1.setScene(GoToCommentPageView);
		window1.show();
		
	}
	
	
	@FXML private Button HomeButton2;
	public void GoToHomePage(ActionEvent event1) throws IOException {
		Parent GoToHomePageParent = FXMLLoader.load(getClass().getResource("/application/HomePage.fxml"));
		Scene GoToHomePageView = new Scene(GoToHomePageParent);
		
		Stage window1 = (Stage) ((Node) event1.getSource()).getScene().getWindow();
		window1.setScene(GoToHomePageView);
		window1.show();
	}
	
	Main mainx = new Main();
	String name1 = mainx.UserNameX;
	


	
	
	@FXML private Button DisplayButton;
	@FXML   private TextArea ReviewTextArea;
	public void Display(ActionEvent event1) throws IOException {
		ReviewTextArea.clear();
		String Comments[] = HomePageControllerX.CommentData;
		
		for(int i =3; i<8; i++) {
			ReviewTextArea.appendText(Comments[i]);
		}
	
		
		
	}
	
	
	@FXML private Button GoodCommentDispButton;
	String[] AllComments = HomePageControllerX.reviews;
	public void GoodComDisplay(ActionEvent event1) throws IOException {
		ReviewTextArea.clear(); 
		
		for(int i =10; i<15; i++) {
			ReviewTextArea.appendText(AllComments[i]);
		}
		
		
		
	}
	
	@FXML private Button BadCommentDispButton;
	public void BadComDisplay(ActionEvent event1) throws IOException {
		ReviewTextArea.clear();
		
		for(int i =0; i<5; i++) {
			ReviewTextArea.appendText(AllComments[i]);
		}
	}
	
	
	@FXML private Button MixedCommentDispButton;
	public void MixedComDisplay(ActionEvent event1) throws IOException {
		ReviewTextArea.clear();
		
		
		for(int i =5; i<10; i++) {
			ReviewTextArea.appendText(AllComments[i]);
	
		}
	}
	
	
	@FXML private Button DisplayInfo;
	@FXML   private TextArea InfoTextArea;
	public void ShowInfo(ActionEvent event1) throws IOException {
		InfoTextArea.clear();
		String Comments[] = HomePageControllerX.CommentData;
		String rest = Comments[0];
		String score = Comments[1];
		String location = Comments[2];
		String fav = Comments[8];
		InfoTextArea.appendText("Name of Restaurant: "+ rest);
		InfoTextArea.appendText("\n ");
		InfoTextArea.appendText("\n ");
		InfoTextArea.appendText("Average Rating: "+ score);
		InfoTextArea.appendText("\n ");
		InfoTextArea.appendText("\n ");
		InfoTextArea.appendText("Location of Restaurant: "+ location);
		InfoTextArea.appendText("\n ");
		InfoTextArea.appendText("\n ");
		InfoTextArea.appendText("Amount of Favorites: "+ fav);
		
		/*
		 User user = new User();
		 user.favorite(name1, ToFind);
		 */
		
	}
	
	
	@FXML private Button FavButton;
	public void IncrementFavorite(ActionEvent event1) throws IOException {
		String Comments[] = HomePageControllerX.CommentData;
		String rest = Comments[0];
		
		User user = new User();
		 user.favorite(name1, rest);
	
	}
	
	
	@FXML private TextField SearchBar2;
	@FXML private Button GoButton2;
	private String Comment;
	
	public static String   CommentData[] = new String[5];
	public static String reviews1[] = new String[15];
	

	
	
	
	
	
	
	
	
	

}
