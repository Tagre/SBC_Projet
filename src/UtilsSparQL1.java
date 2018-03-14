import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import Objets.Classe;
import Objets.Element;

public class UtilsSparQL1 {
	
	/**
	 * Classe qui permet de chercher les/la classe auquel appartient l'駘鑪ent donn� en argument
	 * @param element
	 * @throws IOException 
	 */
	public static void searchSubClasses(Classe classe, int nbClasses) throws IOException{
		//Set URL
		String debutSparQl="https://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=SELECT+%3Fclass%0D%0AWHERE%7B%0D%0A+";
		
		String stringToTra="<http%3A%2F%2Fdbpedia.org%2Fresource%2FInnovation_economics>";
		String stringToTra2="<http://dbpedia.org/class/yago/WikicatAbbotsOfArbroath>";
		stringToTra2=stringToTra2.replace(":", "%3A");
		stringToTra2=stringToTra2.replace("/", "%2F");
		System.out.println(stringToTra2);
		String finSparQl="+rdfs%3AsubClassOf+%3Fclass%0D%0A%0D%0A%7D%0D%0ALIMIT+1000&format=text%2Fhtml&CXML_redir_for_subjs=121&CXML_redir_for_hrefs=&timeout=30000&debug=on&run=+Run+Query+";
				
				
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
		
	public static void main(String[] args) throws IOException{
		searchSubClasses(new Classe("test"), 10);
	}

}
