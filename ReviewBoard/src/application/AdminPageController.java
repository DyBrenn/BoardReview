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

public class AdminPageController {
	
	@FXML private  TextField username;
	@FXML private TextField nameofRestaurant;
	@FXML private TextField specialization;
	@FXML private TextField location9;
	@FXML private  TextField usernameToDelete;
	@FXML private  TextField RestaurantToBeMined;
	
	@FXML private  Button GiveAdminRights;
	@FXML private Button CreateRestaurant;
	@FXML private Button DeleteUser;
	@FXML private Button mineButton;
	
	public void AdminRights(ActionEvent event) throws IOException {
		String usernamex = username.getText();
		Admin admin = new Admin();
		admin.addAdmin(usernamex);
		
	}
	
	public void CreateRestaurant(ActionEvent event) throws IOException {
		String nameofRestaurantx = nameofRestaurant.getText();
		String specializationx= specialization.getText(); 
		String locationx = location9.getText();
		
		Admin admin = new Admin();
		admin.addRestaurant(nameofRestaurantx, specializationx, locationx);
	}
	
	public void DeleteUser(ActionEvent event) throws IOException {
		Admin admin = new Admin();
		String usernameToDeletex = usernameToDelete.getText();
		admin.removeUser(usernameToDeletex);
	
	}
	
	public void MineData(ActionEvent event) throws IOException {
		String RestaurantToBeMinedx = RestaurantToBeMined.getText();
		Admin admin = new Admin();
		//admin.dataMine(RestaurantToBeMinedx);
		//
	}
	
	@FXML private Button HomeButton20;
	public void GoToHomePage(ActionEvent event1) throws IOException {
		Parent GoToHomePageParent = FXMLLoader.load(getClass().getResource("/application/HomePage.fxml"));
		Scene GoToHomePageView = new Scene(GoToHomePageParent);
		
		Stage window1 = (Stage) ((Node) event1.getSource()).getScene().getWindow();
		window1.setScene(GoToHomePageView);
		window1.show();
	}

}
