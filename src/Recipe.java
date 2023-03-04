
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.Writer;
import java.util.NoSuchElementException;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonKey;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsonable;
import com.github.cliftonlabs.json_simple.Jsoner;

/**
 * 
 * @author sethm
 * I am going to try something out over the weekend
 * so if you are reading this then know that if this 
 * doesn't work out. we will go back to the og plan
 */
public interface Recipe {
	
	String Title(String html);
	List<String> ingredients (String html);
	List<String> Directions (String html);
	Map<String, String> ingredientsWithQuantities(String html);
	
	enum Keys implements JsonKey{
		Title("title"),
		Tags("tags"),
		PrepTime("Prep_time"),
		Servings("Servings"),
		Ingredients("ingredients"),
		Nutrition("nutrition"),
		Directions("Directions");
		
		private final String key;
		//private final Object value;
		
		Keys(String key){
			this.key = key;
			
		}
		
		
		
		public String getKey() {
			return key; 
		}


		public Object getValue() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
