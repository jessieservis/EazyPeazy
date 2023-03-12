
import java.io.File;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * 
 * @author sethm I am going to try something out over the weekend so if you are
 *         reading this then know that if this doesn't work out. we will go back
 *         to the og plan
 */
public class Recipe {

	private String title;
	private String type;
	private List<String> Tags;
	private String prepTime;
	private String cookTime;
	double servings;
	double calories;
	double fat;
	double carbs;
	double protein;
	Map<String, Double> Ingredients;
	List<String> units;

	List<String> Directions;

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
	//this is nothing
	public String toString() {
		return String.format("%s\nPrep Time: %-5sCook Time: %-5s \nServings: %-5s\nCaloreis: %.1f"
				+ "\nFat: %.1f\nCarbs: %.1f\nProtein: %.1f\nTags: %s\nDirections:\n%s\nIngredients: %s\nUnits: %s",
				this.title, this.prepTime, this.cookTime, this.servings, this.calories, this.fat, this.carbs,
				this.protein, this.Tags, this.Directions, this.Ingredients, this.units);
	}

}
