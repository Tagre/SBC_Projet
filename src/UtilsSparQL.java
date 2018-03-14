import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import Objets.Classe;
import Objets.Element;

public class UtilsSparQL {
	
	/**
	 * Classe qui permet de chercher les/la classe auquel appartient l'駘鑪ent donn� en argument
	 * @param element
	 * @throws IOException 
	 */
	public static void searchClasses(Element element, int nbClasses) throws IOException{
		//Set URL
		String debutSparQl="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=SELECT+%3Finstance+%0D%0AWHERE%7B%0D%0A+";
		//String stringToTra="<http%3A%2F%2Fdbpedia.org%2Fresource%2FInnovation_economics>";
		String stringToTra="<"+element.getName()+">";
		//String stringToTra2="<http://dbpedia.org/resource/Innovation_economics>";
		stringToTra=stringToTra.replace(":", "%3A");
		stringToTra=stringToTra.replace("/", "%2F");
		//System.out.println(stringToTra2);
		String finSparQl="+a+%3Finstance.%0D%0A%7D%0D%0ALIMIT+"+nbClasses+"&format=text%2Fhtml&CXML_redir_for_subjs=121&CXML_redir_for_hrefs=&timeout=30000&debug=on&run=+Run+Query+";
				
				
		URL url = new URL(debutSparQl+stringToTra+finSparQl);
		URLConnection spoof = url.openConnection();
		 
		//Spoof the connection so we look like a web browser
		spoof.setRequestProperty( "User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)" );
		BufferedReader in = new BufferedReader(new InputStreamReader(spoof.getInputStream()));
		String strLine = "";
		//Loop through every line in the source
		while ((strLine = in.readLine()) != null){
			if (strLine.contains("href")){
				strLine = strLine.substring(17, strLine.length());
				strLine = strLine.substring(0, strLine.indexOf(">")-1);
				  
				element.getClasses().add(new Classe(strLine));
				System.out.println(strLine);
			}
		 
		//Prints each line to the console
		}
		 
		System.out.println("End of page.");
		 
	}
	
	/**
	 * Fonction qui permet de chercher les elements d'une classes (les nbElements premiers)
	 * @param element
	 * @param nbClasses
	 * @throws IOException
	 */
	public static void searchElement(Classe classe, int nbElements) throws IOException{
		//Set URL
		String debutSparQl="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=SELECT+%3Finstance+%0D%0AWHERE{%0D%0A+%3Finstance+a+";
		//String stringToTra="<"+element.getName()+">";
		String stringToTra="<http://dbpedia.org/ontology/Agent>";
		stringToTra=stringToTra.replace(":", "%3A");
		stringToTra=stringToTra.replace("/", "%2F");
		//System.out.println(stringToTra2);
		String finSparQl=".%0D%0A}%0D%0ALIMIT+"+nbElements+"&format=text%2Fhtml&CXML_redir_for_subjs=121&CXML_redir_for_hrefs=&timeout=30000&debug=on&run=+Run+Query+";
				
				
		URL url = new URL(debutSparQl+stringToTra+finSparQl);
		URLConnection spoof = url.openConnection();
		 
		//Spoof the connection so we look like a web browser
		spoof.setRequestProperty( "User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)" );
		BufferedReader in = new BufferedReader(new InputStreamReader(spoof.getInputStream()));
		String strLine = "";
		//Loop through every line in the source
		while ((strLine = in.readLine()) != null){
			if (strLine.contains("href")){
				strLine = strLine.substring(17, strLine.length());
				strLine = strLine.substring(0, strLine.indexOf(">")-1);
				  
				classe.getElements().add(new Element(strLine));
				System.out.println(strLine);
			}
		 
		//Prints each line to the console
		}
		 
		System.out.println("End of page.");
		 
	}
	
	/**
	 * Classe qui permet de chercher les/la classe auquel appartient la classe donnée en argument
	 * @param element
	 * @throws IOException 
	 */
	public static void searchSurClasses(Classe classe, int nbClasses) throws IOException{
		//Set URL
		String debutSparQl="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=SELECT+%3Fclass%0D%0AWHERE{%0D%0A++";
		
		String stringToTra="<http%3A%2F%2Fdbpedia.org%2Fresource%2FInnovation_economics>";
		String stringToTra2="<"+classe.getName()+">";
		stringToTra2=stringToTra2.replace(":", "%3A");
		stringToTra2=stringToTra2.replace("/", "%2F");
		System.out.println(stringToTra2);
		String finSparQl="+rdfs%3AsubClassOf+%3Fclass%0D%0A%0D%0A}%0D%0ALIMIT+"+nbClasses+"&format=text%2Fhtml&CXML_redir_for_subjs=121&CXML_redir_for_hrefs=&timeout=30000&debug=on&run=+Run+Query+";
				
				
		URL url = new URL(debutSparQl+stringToTra2+finSparQl);
		URLConnection spoof = url.openConnection();
		 
		//Spoof the connection so we look like a web browser
		spoof.setRequestProperty( "User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)" );
		BufferedReader in = new BufferedReader(new InputStreamReader(spoof.getInputStream()));
		String strLine = "";
		 
		//Loop through every line in the source
		while ((strLine = in.readLine()) != null){
			
		if (strLine.contains("href")){
			strLine = strLine.substring(17, strLine.length());
			  
			strLine = strLine.substring(0, strLine.indexOf(">")-1);
			
			classe.getSurClasses().add(new Classe(strLine));
			System.out.println(strLine);
		}
		 
		//Prints each line to the console
		
		}
		 
		System.out.println("End of page.");
		 
	}
	
	/**
	 * Classe qui permet de chercher les/la classe auquel appartient la classe donnée en argument
	 * @param element
	 * @throws IOException 
	 */
	public static void searchSubClasses(Classe classe, int nbClasses) throws IOException{
		//Set URL
		String debutSparQl="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=SELECT+%3Fclass%0D%0AWHERE{%0D%0A++%3Fclass+rdfs%3AsubClassOf+";
		
		String stringToTra="<http%3A%2F%2Fdbpedia.org%2Fresource%2FInnovation_economics>";
		String stringToTra2="<"+classe.getName()+">";
		stringToTra2=stringToTra2.replace(":", "%3A");
		stringToTra2=stringToTra2.replace("/", "%2F");
		System.out.println(stringToTra2);
		String finSparQl="%0D%0A%0D%0A}%0D%0ALIMIT+"+nbClasses+"&format=text%2Fhtml&CXML_redir_for_subjs=121&CXML_redir_for_hrefs=&timeout=30000&debug=on&run=+Run+Query+";
				
				
		URL url = new URL(debutSparQl+stringToTra2+finSparQl);
		URLConnection spoof = url.openConnection();
		 
		//Spoof the connection so we look like a web browser
		spoof.setRequestProperty( "User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)" );
		BufferedReader in = new BufferedReader(new InputStreamReader(spoof.getInputStream()));
		String strLine = "";
		 
		//Loop through every line in the source
		while ((strLine = in.readLine()) != null){
			
		if (strLine.contains("href")){
			strLine = strLine.substring(17, strLine.length());
			strLine = strLine.substring(0, strLine.indexOf(">")-1);
			
			classe.getSubClasses().add(new Classe(strLine));
			System.out.println(strLine);
		}
		 
		//Prints each line to the console
		
		}
		 
		System.out.println("End of page.");
		 
	}
	
	/**
	 * Classe qui permet de chercher les/la classe auquel appartient la classe donnée en argument
	 * @param element
	 * @throws IOException 
	 */
	public static void searchEquiClasses(Classe classe, int nbClasses) throws IOException{
		//Set URL
		String debutSparQl="http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=SELECT+%3Fclass%0D%0AWHERE{%0D%0A++";
		String stringToTra2="<"+classe.getName()+">";
		stringToTra2=stringToTra2.replace(":", "%3A");
		stringToTra2=stringToTra2.replace("/", "%2F");
		System.out.println(stringToTra2);
		String finSparQl="+owl%3AequivalentClass+%3Fclass%0D%0A}%0D%0ALIMIT+"+nbClasses+"&format=text%2Fhtml&CXML_redir_for_subjs=121&CXML_redir_for_hrefs=&timeout=30000&debug=on&run=+Run+Query+";
				
				
		URL url = new URL(debutSparQl+stringToTra2+finSparQl);
		URLConnection spoof = url.openConnection();
		 
		//Spoof the connection so we look like a web browser
		spoof.setRequestProperty( "User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)" );
		BufferedReader in = new BufferedReader(new InputStreamReader(spoof.getInputStream()));
		String strLine = "";
		 
		//Loop through every line in the source
		while ((strLine = in.readLine()) != null){
			
		if (strLine.contains("href")){
			strLine = strLine.substring(17, strLine.length());
			strLine = strLine.substring(0, strLine.indexOf(">")-1);
			
			classe.getEquiClasses().add(new Classe(strLine));
			System.out.println(strLine);
		}
		 
		//Prints each line to the console
		
		}
		 
		System.out.println("End of page.");
		 
	}
	
	
		
	public static void main(String[] args) throws IOException{
		//searchClasses(new Element("test"), 10);
		searchElement(new Classe("stfd"), 5);
	}

}
