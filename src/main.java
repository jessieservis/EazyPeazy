import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class main {

	public static void main(String[] args) {
	    RecipeParser r1 = new RecipeParser();
	    Document doc = null;
	    try {
	     doc = Jsoup.connect("https://www.allrecipes.com/recipes/17562/dinner/")
	    		.get();
	    }
	    catch (IOException e) {
	    	e.printStackTrace();
	    }
	    
	    String title = doc.title();
	    
	    System.out.println(title);

	}

}
