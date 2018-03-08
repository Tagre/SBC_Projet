
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainInterface extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("Interface.fxml"));
	    
        Scene scene = new Scene(root, 1000, 650);
    
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
		stage.show();
		stage.sizeToScene();
		stage.setMaximized(true);
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

}