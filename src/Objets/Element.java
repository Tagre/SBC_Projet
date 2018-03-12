package Objets;

import java.util.ArrayList;


public class Element {
	
	ArrayList<Classe> classes=new ArrayList<Classe>();
	
	public Element(){
		
	}
	
	public Element(ArrayList<Classe> classes){
		this.classes=classes;
		
	}

	public ArrayList<Classe> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<Classe> classes) {
		this.classes = classes;
	}
	
	
	

}
