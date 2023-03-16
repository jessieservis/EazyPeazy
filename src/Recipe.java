
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
public class Recipe {
	
	String title; 
	List<String> Ingredients;
	List<String> Directions ;
	List<String> Tag;
	Map<String, Double> Nutrition;
	int servings;
	String prepTime;
	String cookTime;
	
	
	public Recipe (String title, List<String> Ingredients, List<String> Directions,
				Map<String,Double> Nutrition, List<String> Tag, String prepTime,
				String CookTime) {
		this.title = title; 
		this.Directions = Directions;
		this.Ingredients = Ingredients;
	}
	
	public void setTitle(String title) {
		this.title = title; 
	}
	
	public void setIngredients (List<String> ingredients) {
		this.Ingredients = ingredients; 
	}
	
	public void setDirections(List<String> directions) {
		this.Directions = directions;
	}
	
	public void setTag (List<String> tag) {
		this.Tag = tag;
	}
	
	public void setNutrition (Map<String, Double> nutrition) {
		this.Nutrition = nutrition; 
	}
	
	public void setServing (int serving) {
		this.servings = serving; 
	}
	
	public void setCootTime (String cookTime) {
		this.cookTime = cookTime;
	}
	
	public void setPrepTime (String prepTime) {
		this.prepTime = prepTime;
	}
	
	public List<String> getTags(){
		return tag;
	}
	
	public String toString() {
		return " " ;
	}
	
	

	
}
