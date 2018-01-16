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

public class ProfilePageController {
	
	LoginPageController  LGC = new LoginPageController();
	String name1 = LGC.SignedInName;
	
	HomePageContoller HPC = new HomePageContoller();
	String RestaurantName = HPC.RestaurantName;
	
	
	@FXML private Button GoToAdminPage;
	public void SwitchToAdminPage(ActionEvent event) throws IOException {
		
		User user = new User();
		
		if(user.checkAdmin(name1)) {
			Parent AdminPageParent = FXMLLoader.load(getClass().getResource("/application/AdminPage.fxml"));
			Scene ProfilePageView = new Scene(AdminPageParent);
			
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(ProfilePageView);
			window.show();
			
		}

		
	}
	
	@FXML private  TextField newPassword;
	@FXML private TextField password;
	@FXML private TextField location1;
	@FXML private  Button button1;
	@FXML private Button button2;
	
	
	
	@FXML private Button HomeButton;
	public void GoToHomePage(ActionEvent event1) throws IOException {
		Parent GoToHomePageParent = FXMLLoader.load(getClass().getResource("/application/HomePage.fxml"));
		Scene GoToHomePageView = new Scene(GoToHomePageParent);
		
		Stage window1 = (Stage) ((Node) event1.getSource()).getScene().getWindow();
		window1.setScene(GoToHomePageView);
		window1.show();
		System.out.println(name1);
	}
	
	public void ChangePassword(ActionEvent event) throws IOException {
		User user = new User();
		String newPasswordx = newPassword.getText();
		String Passwordx = password.getText();
		user.changePass(name1, Passwordx, newPasswordx);
		
	}
	public void ChangeLocation(ActionEvent event) throws IOException {
		User user = new User();
		String locationx = location1.getText();
		System.out.println("wtf");
		LoginPageController  LGC = new LoginPageController();
		String name2 = LGC.SignedInName;
		System.out.println("wtf");
		System.out.println(name2);
		user.changeLocation(name2, locationx);
		System.out.println(name1);
	

	}
	
	
	
	
	
	
	

}
