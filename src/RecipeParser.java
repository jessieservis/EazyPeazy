import java.util.List;
import java.util.Map;

import javax.swing.text.Document;

import org.jsoup.*;


public class RecipeParser implements Recipe {
	
	String title; 
	
	public Map<String, String> ingredientsWithQuantities(String htm){
		return null;
	}
	public List<String>ingredients (String html){
		
		return null; 
	}
	
	public List<String> Directions (String html){
		
		
		return null; 
	}
	
	public String Title(String html) {
		
		org.jsoup.nodes.Document doc = Jsoup.parse(html);
		
		return doc.select("h1.headline").text(); 
	}
	
	
	
 }
