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

public class ProfileController {
	
	LoginPageController  LGC = new LoginPageController();
	String name1 = LGC.SignedInName;
	
	HomePageContoller HPC = new HomePageContoller();
	String RestaurantName = HPC.RestaurantName;
	
	
	@FXML private Button GoToAdminPage;
	public void SwitchToAdminPage(ActionEvent event) throws IOException {

		Parent AdminPageParent = FXMLLoader.load(getClass().getResource("/application/AdminPage.fxml"));
		Scene ProfilePageView = new Scene(AdminPageParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(ProfilePageView);
		window.show();
	}
	
	@FXML private  TextField newPassword;
	@FXML private TextField password;
	@FXML private TextField location1;
	
	@FXML private  Button button1;
	@FXML private Button button2;
	
	
	
	public void ChangePassword(ActionEvent event) throws IOException {
		User user = new User();
		String newPasswordx = newPassword.getText();
		String Passwordx = password.getText();
		user.changePass(name1, Passwordx, newPasswordx);
		
	}
	
	public void ChangeLocation(ActionEvent event) throws IOException {
		User user = new User();
		String locationx = location1.getText();
		user.changeLocation(name1, locationx);
	

	}
	
	
	
	

	

}




