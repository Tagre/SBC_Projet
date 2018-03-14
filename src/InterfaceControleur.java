import java.awt.CheckboxGroup;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Objets.Classe;
import Objets.Element;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class InterfaceControleur implements Initializable {
	
	@FXML TextField TF_ObjetSource, TF_SurClasse, TF_SousClasse, TF_EquiClasse, TF_Element, TF_Classe;
	@FXML CheckBox CB_SurClasse, CB_SousCLasse, CB_EquiClasse, CB_Element,CB_Classe , CB_Propertie;
	@FXML WebView WV_Graph;
	@FXML CheckBox CB_EntryElement, CB_EntryClasse;
	@FXML private WebEngine webEngine;
	
	private Classe entryC;
	private Element entryE;
	CheckboxGroup cbg;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		/*String pathHTML="file:///C:/Users/Tagre/git/SBC_Projet/src/Vizu.html";
		webEngine = WV_Graph.getEngine();
		File file = new File("src/Vizu.html");
		webEngine.load(file.toURI().toString());*/
	}
	
	@FXML
	public void ClasseEntry_change(ActionEvent event){
		if(CB_EntryElement.isSelected()){
			CB_EntryElement.setSelected(!CB_EntryClasse.isSelected());
		}
	}
	
	public void ElementEntry_change(ActionEvent event){
		if(CB_EntryClasse.isSelected()){
			CB_EntryClasse.setSelected(!CB_EntryElement.isSelected());
		}
	}
	
	@FXML
	public void ClickBT_Reload(ActionEvent event) throws IOException{
		if(CB_EntryElement.isSelected()){
			Element entry=new Element(TF_ObjetSource.getText());
			UtilsSparQL.searchClasses(entry, Integer.parseInt(TF_Classe.getText()));
			Make_Json(entry, 0);
		} else if (CB_EntryClasse.isSelected()){
			
		}
		String pathHTML="file:///C:/Users/Tagre/git/SBC_Projet/src/Vizu.html";
		webEngine = WV_Graph.getEngine();
		File file = new File("src/Vizu.html");
		webEngine.load(file.toURI().toString());
		
	}
	
	public void Make_Json(Element element, int cmptElmt) throws IOException{
		File file = new File("src/data.json");
	    BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    bw.write("{\n  \"graph\": [],\n  \"links\": [\n");
	    
	    for(int i=cmptElmt+1;i<element.getClasses().size()+1;i++){
	      bw.write("	{\"source\": "+i+", \"target\": "+cmptElmt+", \"weight\": \""+"propriété(a faire)"+"\"}");
	      if(i!=element.getClasses().size())
	        bw.write(",\n");
	    }
	    bw.write("],\n  \"nodes\": [\n");
	    
	    
	    bw.write("	{\"id\": \""+element.getName()+"\", \"type\": "+"\"circle\""+", \"label\": \""+element.getName()+"\"}");
	    bw.write(",\n");
	    
	    for(int i=0;i<element.getClasses().size();i++){
	      //mettre circle ou square selon si label ou non **A FAIRE**
	      bw.write("	{\"id\": \""+element.getClasses().get(i).getName()+"\", \"type\": "+"\"square\""+", \"label\": \""+element.getClasses().get(i).getName()+"\"}");
	      if(i!=element.getClasses().size()-1){
	        bw.write(",\n");
	      }
	    }
	    bw.write("],\n  \"directed\": false,\n  \"multigraph\": true\n}");
	    bw.close();
		System.out.println("Json construit");
	}

	
	
	
	

}
