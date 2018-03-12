import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import Objets.Classe;
 
public class GrabHTML {
 
 public static void Connect() throws Exception{
  String Elem;
  //Set URL
  URL url = new URL("https://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=select+distinct+%3FConcept+where+%7B%5B%5D+a+%3FConcept%7D+LIMIT+100&format=text%2Fhtml&CXML_redir_for_subjs=121&CXML_redir_for_hrefs=&timeout=30000&debug=on&run=+Run+Query+");
  URLConnection spoof = url.openConnection();
 
  //Spoof the connection so we look like a web browser
  spoof.setRequestProperty( "User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)" );
  BufferedReader in = new BufferedReader(new InputStreamReader(spoof.getInputStream()));
  String strLine = "";
 
  //Loop through every line in the source
  while ((strLine = in.readLine()) != null){
 
   //Prints each line to the console
	  if (strLine.contains("href")){
		  strLine = strLine.substring(17, strLine.length());
		  //System.out.println(strLine.indexOf(">")-1);
		  strLine = strLine.substring(0, strLine.indexOf(">")-1);
		  
		 // Elem = strLine + "\n";
   System.out.println(strLine);
		  //System.out.println(Elem);
	  }
  }
  
  
 
  System.out.println("End of page.");
 }
 
 public static void main(String[] args){
 
  try{
   //Calling the Connect method
   Connect();
  
  }catch(Exception e){
 
  }
 }
}