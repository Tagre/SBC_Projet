package Objets;

import java.util.ArrayList;


public class Element {
	
	String name;
	ArrayList<Classe> classes=new ArrayList<Classe>();
	
	public Element(String name){
		this.name=name;
	}
	
	public Element(String name, ArrayList<Classe> classes){
		this.name=name;
		this.classes=classes;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Classe> getClasses() {
		return classes;
	}

	public void setClasses(ArrayList<Classe> classes) {
		this.classes = classes;
	}
	
	
	

}
