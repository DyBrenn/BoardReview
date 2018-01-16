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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginPageController {
	
	//
	public static String SignedInName;
	
	public void SwitchToSingUp(ActionEvent event1) throws IOException {
		Parent SignUpPageParent = FXMLLoader.load(getClass().getResource("/application/SignUp1.fxml"));
		Scene SignUpPageView = new Scene(SignUpPageParent);
		
		Stage window1 = (Stage) ((Node) event1.getSource()).getScene().getWindow();
		window1.setScene(SignUpPageView);
		window1.show();
	}
	
	@FXML private Button HomeButton;
	public void GoToHomePage(ActionEvent event1) throws IOException {
		Parent GoToHomePageParent = FXMLLoader.load(getClass().getResource("/application/HomePage.fxml"));
		Scene GoToHomePageView = new Scene(GoToHomePageParent);
		
		Stage window1 = (Stage) ((Node) event1.getSource()).getScene().getWindow();
		window1.setScene(GoToHomePageView);
		window1.show();
	}
	
	
	
	
	@FXML private TextField LogUserName;
	@FXML private TextField LogPassword;
	@FXML private Pane DisplayPane;
	public void SigNIN(ActionEvent event1) throws IOException {
		
		String UserName = LogUserName.getText();
		String Password = LogPassword.getText();
		User user = new User();
		boolean result[] = new boolean[2];
		result = user.checkUser(UserName,Password);
		
		boolean CombinationResult = result[1];
		
		
		
		
		if (CombinationResult == true) {
			boolean AdminStatus = user.checkAdmin(UserName);
			if (AdminStatus == true) {
				
				Parent SignUpPageParent = FXMLLoader.load(getClass().getResource("/application/HomePage.fxml"));
				Scene SignUpPageView = new Scene(SignUpPageParent);
				
				Stage window1 = (Stage) ((Node) event1.getSource()).getScene().getWindow();
				window1.setScene(SignUpPageView);
				window1.show();
				
				
			}else {
				
			Parent SignUpPageParent = FXMLLoader.load(getClass().getResource("/application/HomePage.fxml"));
			Scene SignUpPageView = new Scene(SignUpPageParent);
			
			Stage window1 = (Stage) ((Node) event1.getSource()).getScene().getWindow();
			window1.setScene(SignUpPageView);
			window1.show();
			}
		}
		Main mainx = new Main();
		String name1 = mainx.UserNameX;
		System.out.println(name1);
		mainx.UserNameX = UserName;
		System.out.println(mainx.UserNameX);
		SignedInName = UserName;
	
	}

}
