package Objets;

public class Classe {

		String Classes[];
		String Properties[];
		
		public Classe(){
			
		}
		
		public Classe(String[] Classes, String[] Properties){
			this.setClasses(Classes);
			this.setProperties(Properties);
		}
		
		public String[] getClasses(){
			return this.Classes;
			
		}
	
		public String[] getProperties(){
			return this.Properties;
			
		}
		
		public void setClasses(String[] Classes){
		      this.Classes = Classes ;
		   }
		
		public void setProperties(String[] Properties){
		      this.Properties = Properties ;
		   }
		
		
}
