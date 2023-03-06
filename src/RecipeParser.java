import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedReader;

/**
 * 
 * @author sethm DESCRIPTION: takes recipe objects from json file and parses
 *         them
 */
public class RecipeParser {

	public static Recipe recipeReader(File f) {

		Recipe recipe = new Recipe();

		try (Scanner in = new Scanner(new FileReader(f))) {

			String currentLine = in.nextLine();
			String[] headers = currentLine.split("\t");
			
		

			// gets name units and nutrition values.
			while (in.hasNext()) {

				List<String> tags = new ArrayList<String>();

				String[] values = in.nextLine().split("\t");

				String title = values[0];
				//String type = value[1]
				String prepTime = values[2];
				String cookTime = values[3];
				double servings = Double.parseDouble(values[4]);
				double calories = Double.parseDouble(values[5]);
				

				// 
				///for (int i = 3; i < values.length; i++) {

					//nutritionValues.add(Float.parseFloat(values[i]));

					// System.out.printf("Numbers = %.3f\n", nutritionValues.get(i-2));

				//}
				recipe.setTitle(title); 
				recipe.setCookTime(cookTime);
				recipe.setServing(servings);
				recipe.setCalories(calories);
				
				//.add(new Recipe(title, Tags, prepTime, cookTime, servings, ingredients, caloreis, fat, carbs, protein, directions));

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
		return recipe;
	}
}



	
