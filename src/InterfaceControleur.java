import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class InterfaceControleur implements Initializable {
	
	@FXML
	TextField TF_ObjetSource, TF_SurClasse, TF_SousClasse, TF_EquiClasse, TF_Element;
	@FXML 
	CheckBox CB_SurClasse, CB_SousCLasse, CB_EquiClasse, CB_Element, CB_Propertie;
	@FXML
	WebView WV_Graph;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	@FXML
	public void ClickBT_Reload(ActionEvent event){
		
	}
	
	

}
