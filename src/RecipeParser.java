import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.NoSuchElementException;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonKey;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import com.github.cliftonlabs.json_simple.Jsoner;
import javax.swing.text.Document;
import org.jsoup.*;
import com.github.cliftonlabs.json_simple.JsonArray;

/**
 * 
 * @author sethm
 * DESCRIPTION: takes recipe objects from json file and parses them 
 */
public class RecipeParser  {
		
	String file = "Recipes.json";

	public void jsonToArray(File f) {
		JsonObject recipe = new JsonObject();
		try {
			
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
	}
	
	
	
 }
