package Objets;

import java.util.ArrayList;

public class Classe {
	
	String name;
	ArrayList<Classe> subClasses=new ArrayList<Classe>();
	ArrayList<Classe> surClasses=new ArrayList<Classe>();
	ArrayList<Classe> equiClasses=new ArrayList<Classe>();
	ArrayList<String> properties=new ArrayList<String>();
	ArrayList<Element> elements = new ArrayList<Element>();
	
	public Classe(String name){
		this.name=name;
	}
	
	public ArrayList<Classe> getSubClasses() {
		return subClasses;
	}

	public void setSubClasses(ArrayList<Classe> subClasses) {
		this.subClasses = subClasses;
	}

	public ArrayList<Classe> getSurClasses() {
		return surClasses;
	}

	public void setSurClasses(ArrayList<Classe> surClasses) {
		this.surClasses = surClasses;
	}

	public ArrayList<Classe> getEquiClasses() {
		return equiClasses;
	}

	public void setEquiClasses(ArrayList<Classe> equiClasses) {
		this.equiClasses = equiClasses;
	}

	public Classe(String name, ArrayList<Classe> classes, ArrayList<String> properties){
		this.name=name;
		this.subClasses=classes;
		this.properties=properties;
	}
	
	public void addElement(Classe classe, String propertie){
		subClasses.add(classe);
		properties.add(propertie);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getProperties() {
		return properties;
	}

	public void setProperties(ArrayList<String> properties) {
		this.properties = properties;
	}

	public ArrayList<Element> getElements() {
		return elements;
	}

	public void setElements(ArrayList<Element> elements) {
		this.elements = elements;
	}
	
	
		
		
}
