package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpPageController {
	
	@FXML private TextField Test1;
	@FXML private TextField Password1;
	@FXML private TextField Location1;
	public void CreatingAUserAccount(ActionEvent event) throws IOException {
		
		String UserName = Test1.getText();
		String Password = Password1.getText();
		String Location = Location1.getText();
		//System.out.println(UserName);
		
		User user = new User();
		boolean nameAvailible = user.checkUser(UserName, Password)[0];
		System.out.println(nameAvailible);
		if (nameAvailible == false) {
			System.out.println("get here1");
			user.createUser(UserName, Password, Location);
			
			
			Parent LoginPageParent = FXMLLoader.load(getClass().getResource("/application/HomePage.fxml"));
			Scene LoginPageView = new Scene(LoginPageParent);
			
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(LoginPageView);
			window.show();
			//create functionality to show error message if the user name is taken
		}
		System.out.println("get here 2");
		
		Parent LoginPageParent = FXMLLoader.load(getClass().getResource("/application/HomePage.fxml"));
		Scene LoginPageView = new Scene(LoginPageParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(LoginPageView);
		window.show();
		
	}
	
	@FXML private Button HomeButton;
	public void GoToHomePage(ActionEvent event1) throws IOException {
		Parent GoToHomePageParent = FXMLLoader.load(getClass().getResource("/application/HomePage.fxml"));
		Scene GoToHomePageView = new Scene(GoToHomePageParent);
		
		Stage window1 = (Stage) ((Node) event1.getSource()).getScene().getWindow();
		window1.setScene(GoToHomePageView);
		window1.show();
	}
	
	

}
