import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {

	public static void main( String [] args ) throws IOException{

		FileReader file = new FileReader("C:/Users/HP/Desktop/SBCTests/data.json");			// Fichier a traiter
		BufferedReader reader = new BufferedReader(file);

		String line = reader.readLine();

		File parsedFile = new File("C:/Users/HP/Desktop/SBCTests/result.json");		// Fichier ou écrire
		FileWriter fileToWrite = new FileWriter(parsedFile);

		fileToWrite.write("{"+"\n"+"\"graph\": [],"+"\n"+"\"links\": ["+"\n");		

		fileToWrite.write("\n");

		String id = "";
		String type = "";
		
		ArrayList<String> link = new ArrayList<String>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> size = new ArrayList<String>();
		
		while (line != null){
			if (line.contains("a href")){
				String[] tokens = line.split("\"");
				link.add(tokens[1]);
			}
			if (line.contains("pre") & line.contains("@")){
				String[] tokens = line.split("\"");
				date.add(tokens[1]);
			}
			if (line.contains("pre") & line.contains("&lt")){
				String[] tokens = line.split("\"");
				size.add(tokens[1]);
			}
			
			line = reader.readLine();
		}
		
		for (int i = 0; i < link.size(); i++){
			System.out.println(link.get(i));
			System.out.println(date.get(i));
			System.out.println(size.get(i));
		}
		

		if (id.equals("Class")){
			type = "cirle";
		}

		if (id.equals("Element")){
			type = "circle";
		}

		if (id.equals("Property")){
			type = "square";
		}

		fileToWrite.write("\"nodes\": ["+"\n");
		for (int i = 0; i<10; i++){
			fileToWrite.write("{\"id\": "+"\""+ "" +"\", "+"\"type\": "+"\""+ "" +"\", "+"\"label\": "+"\""+ "" +"\"},\n" );
		}

		file.close();
		fileToWrite.close();


	}

}


