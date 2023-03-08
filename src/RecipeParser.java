import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;

/**
 * 
 * @author sethm DESCRIPTION: takes information from recipe.txt and returns recipe object
 */
public class RecipeParser {

	public static List<Recipe> recipeReader(File f) {

		List<Recipe> recipeList = new ArrayList<>();
		Recipe recipe = new Recipe();
		try (Scanner in = new Scanner(new FileReader(f))) {

			String currentLine = in.nextLine();
			//String[] headers = currentLine.split("\t");

			// takes info from .txt file and sets them to the appropriate variables 
			while (in.hasNext()) {

				List<String> tags = new ArrayList<String>();
				Map<String, Double> ingredients = new HashMap<String, Double>();
				List<String> units = new ArrayList<String>();
				List<String> directions = new ArrayList<String>();
				String[] values = in.nextLine().split("\t");

				String title = values[0];
				String type = values[1];
				String prepTime = values[2];
				String cookTime = values[3];
				double servings = Double.parseDouble(values[4]);
				double calories = Double.parseDouble(values[5]);
				double fat = Double.parseDouble(values[6]);
				double carbs = Double.parseDouble(values[7]);
				double protein = Double.parseDouble(values[8]);

				recipe.setTitle(title);
				recipe.setType(type);
				recipe.setPrepTime(prepTime);
				recipe.setCookTime(cookTime);
				recipe.setServing(servings);
				recipe.setCalories(calories);
				recipe.setFat(fat);
				recipe.setCarbs(carbs);
				recipe.setProtein(protein);

				for (int i = 9; i <= 20; i++) {
					if (!values[i].equalsIgnoreCase("none")) {

						tags.add(values[i]);
					}
				}
				recipe.setTag(tags);
				for (int i = 21; i <= 28; i++) {
					if (values[i].equalsIgnoreCase("none")) {
						break;
					} else {
						directions.add(values[i]);
					}
				}
				recipe.setDirections(directions);

				for (int i = 29; i + 2 < values.length; i += 3) {
					ingredients.put(values[i], Double.parseDouble(values[i + 1]));
					units.add(values[i + 2]);
				}
				recipe.setIngredients(ingredients);
				recipe.setUnits(units);
				recipeList.add(recipe);
			}

			in.close();

		} catch (ArrayIndexOutOfBoundsException e) {

			System.err.println("Array index out of bounds: " + e);

			e.printStackTrace();

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (NumberFormatException e) {

			e.printStackTrace();

		}
		return recipeList;
	}
}
