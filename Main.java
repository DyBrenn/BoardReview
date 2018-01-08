package application;
	
import javafx.application.Application;
import java.util.LinkedList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	
	public static LinkedList<Stage> StageResults = new LinkedList<Stage>();
	public static LinkedList <String> FxmlResults = new LinkedList<String>();
	public static LinkedList<Boolean> StageWithValues = new LinkedList<Boolean>();
	
	public static String UserNameX = new String("My Name");
	public static String RestaurantNameX = new String("My Name");
	
	public static boolean Decision = false;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/HomePage.fxml"));
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
