import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.node.ArrayNode;
//import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 
 * @author sethm I am going to try something out over the weekend so if you are
 *         reading this then know that if this doesn't work out. we will go back
 *         to the og plan
 */
public class Recipe {

	private String title;
	private String type;
	private List<String> Tags = new ArrayList<String>();;
	private String prepTime;
	private String cookTime;
	double servings;
	double calories;
	double fat;
	double carbs;
	double protein;
	Map<String, Double> Ingredients = new HashMap<String, Double>();
	List<String> units = new ArrayList<String>();

	List<String> Directions = new ArrayList<String>();

	public Recipe() {
		this.title = "Unknown";
		this.Tags = null;
		this.prepTime = " ";
		this.cookTime = " ";
		this.servings = 0.0;
		this.Ingredients = null;
		this.calories = 0.0;
		this.fat = 0.0;
		this.carbs = 0.0;
		this.protein = 0.0;
		this.Directions = null;
		this.units = null;
	}

	public Recipe(String title, String type, List<String> Tags, String prepTime, String cookTime, double servings,
			Map<String, Double> Ingredients, List<String> units, double calories, double fat, double carbs,
			double protein, List<String> Directions) {
		this.title = title;
		this.type = type;
		this.Tags = Tags;
		this.prepTime = prepTime;
		this.cookTime = cookTime;
		this.servings = servings;
		this.Ingredients = Ingredients;
		this.units = units;
		this.calories = calories;
		this.fat = fat;
		this.carbs = carbs;
		this.protein = protein;
		this.Directions = Directions;

	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setIngredients(Map<String, Double> map) {
		this.Ingredients = map;
	}

	public void setUnits(List<String> units) {
		this.units = units;
	}

	public void setDirections(List<String> directions) {
		this.Directions = directions;
	}

	public void setTag(List<String> tag) {
		this.Tags = tag;
	}

	public void setServing(double serving) {
		this.servings = serving;
	}

	public void setCookTime(String cookTime) {
		this.cookTime = cookTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public String getTitle() {
		return this.title;
	}

	public String getType() {
		return this.type;
	}

	public String toString() {
		// I am very much not a fan of having multiple loops and instantiations in a toString but this is
		// just making this work
		// Something has to hold the data of the "none" sections, whether its a counter
		// or a list
		List<String> tempTagList = new ArrayList<String>();
		for (int i = 0; i < Tags.size(); i++) {
			if (!Tags.get(i).equalsIgnoreCase("none")) {
				tempTagList.add(Tags.get(i));
			}
		}

		Map<String, Double> tempIngMap = Ingredients;
		for (Map.Entry<String, Double> entry : tempIngMap.entrySet()) {
			if (entry.getKey().equalsIgnoreCase("none") || entry.getValue() == 99) {
				tempIngMap.remove(entry.getKey());
			}
		}

		List<String> tempUnitList = new ArrayList<String>();
		for (int i = 0; i < units.size(); i++) {
			if (!units.get(i).equalsIgnoreCase("none")) {
				tempUnitList.add(units.get(i));
			}
		}

		return String.format("%s\nPrep Time: %-5sCook Time: %-5s \nServings: %-5s\nCalories: %.1f"
				+ "\nFat: %.1f\nCarbs: %.1f\nProtein: %.1f\nTags: %s\nDirections:\n%s\nIngredients: %s\nUnits: %s",
				this.title, this.prepTime, this.cookTime, this.servings, this.calories, this.fat, this.carbs,
				this.protein, tempTagList, this.Directions, tempIngMap, tempUnitList);
	}
	/**
	* @author camsona_url Returns a string formatted for printing recipes to file
	/
	public String print() {
		// Having a loop in a print method is a necessary evil unless we want to have a
		// string in here dedicated to holding the big directions string
		List<String> keySet = new ArrayList<String>();
		keySet.addAll(Ingredients.keySet());
		String temp = "";
		for (int i = 0; i < Directions.size() - 1; i++) {
			temp += Directions.get(i) + "&";
		}
		temp += Directions.get(Directions.size() - 1);
		
		return this.title + "\t" + this.type + "\t" + this.prepTime + "\t" + this.cookTime + "\t" + this.servings + "\t"
				+ this.calories + "\t" + this.fat + "\t" + this.carbs + "\t" + this.protein + "\t" + this.Tags.get(0)
				+ "\t" + this.Tags.get(1) + "\t" + this.Tags.get(2) + "\t" + this.Tags.get(3) + "\t" + this.Tags.get(4)
				+ "\t" + this.Tags.get(5) + "\t" + this.Tags.get(6) + "\t" + this.Tags.get(7) + "\t" + this.Tags.get(8)
				+ "\t" + this.Tags.get(9) + "\t" + this.Tags.get(10) + "\t" + temp + "\t" + keySet.get(0) + "\t"
				+ Ingredients.get(keySet.get(0)) + "\t" + units.get(0) + "\t" + keySet.get(1) + "\t"
				+ Ingredients.get(keySet.get(1)) + "\t" + units.get(1) + "\t" + keySet.get(2) + "\t"
				+ Ingredients.get(keySet.get(2)) + "\t" + units.get(2) + "\t" + keySet.get(3) + "\t"
				+ Ingredients.get(keySet.get(3)) + "\t" + units.get(3) + "\t" + keySet.get(4) + "\t"
				+ Ingredients.get(keySet.get(4)) + "\t" + units.get(4) + "\t" + keySet.get(5) + "\t"
				+ Ingredients.get(keySet.get(5)) + "\t" + units.get(5);
	}

}
