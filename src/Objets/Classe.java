package Objets;

import java.util.ArrayList;

public class Classe {

		ArrayList<Classe> classes=new ArrayList<Classe>();
		ArrayList<String> properties=new ArrayList<String>();
		
		public Classe(){
			
		}
		
		public Classe(ArrayList<Classe> classes, ArrayList<String> properties){
			this.classes=classes;
			this.properties=properties;
		}
		
		public void addElement(Classe classe, String propertie){
			classes.add(classe);
			properties.add(propertie);
		}

		public ArrayList<Classe> getClasses() {
			return classes;
		}

		public ArrayList<String> getProperties() {
			return properties;
		}

		public void setClasses(ArrayList<Classe> classes) {
			this.classes = classes;
		}

		public void setProperties(ArrayList<String> properties) {
			this.properties = properties;
		}
		
		
}
