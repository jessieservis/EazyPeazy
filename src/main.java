import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File f = new File("Recipe.txt");
		List<Recipe> recipe = RecipeParser.recipeReader(f);
		
		RecipeSelector rs = new RecipeSelector();
		//RecipeSelector vs = new VeganDecorator();
		System.out.println(rs.desserts.get(0).print());
		//System.out.println(vs.VeganDessertSelector(f).get(0).print());
		
		createRecipe();
		
		rs.shutdown();
	}

	
	// camsona - Basic recipe creator for us to use to get recipes in easier
	public static void createRecipe() {
		// Declaring values so java doesnt get mad later
		String title = "";
		String type = "";
		List<String> Tags = new ArrayList<String>();
		String prepTime = "";
		String cookTime = "";
		double servings = 0;
		double calories = 0;
		double fat = 0;
		double carbs = 0;
		double protein = 0;
		Map<String, Double> Ingredients = new HashMap<String, Double>();
		List<String> units = new ArrayList<String>();
		List<String> Directions = new ArrayList<String>();

		Scanner sc = null;
		try {
			sc = new Scanner(System.in);

			System.out.println("Welcome to the Recipe Creator!");
			System.out.print("Step 1: What is the name of the recipe: ");
			title = sc.nextLine();

			System.out.print("\nStep 2: What type of meal the recipe is (Entree, Side, Dessert): ");
			type = sc.next();

			System.out.println(
					"\nStep 3: What are the dietary restrictions of the recipe? Up to 11 are allowed. When you are done enter S. ");
			for (int i = 1; i < 12; i++) {
				System.out.print("Tag " + i + ": ");
				String temp = sc.next();
				if (temp.equalsIgnoreCase("s")) {
					for(int j = 0; j < 12 - i; j++) {
						Tags.add("none");
					}
					break;
				}
				Tags.add(temp);
			}

			System.out.print("\nStep 4: How long it takes to prepare the ingredients for the recipe: ");
			prepTime = sc.next();

			System.out.print("\nStep 5: How long it takes to cook the recipe: ");
			cookTime = sc.next();

			System.out.print("\nStep 6: How many servings does the recipe make? ");
			servings = sc.nextDouble();

			System.out.print("\nStep 7: The Nutrient Round-Up\n\nHow many calories does the recipe have? ");
			calories = sc.nextDouble();

			System.out.print("How much fat (in grams) does the recipe have? ");
			fat = sc.nextDouble();

			System.out.print("How many carbs (in grams) does the recipe have? ");
			carbs = sc.nextDouble();

			System.out.print("How much protein (in grams) does the recipe have? ");
			protein = sc.nextDouble();

			// We should have more than 6 ingredients, especially since they're at the end
			System.out.print("\nStep 8: Ingredients, when you wish to stop please enter S ");
			//Short for continue
			boolean contin = true;
			
			for (int i = 1; i < 99; i++) {
				boolean repeat = true;
				String name = "";
				String unit = "";
				double num = 0;

				while (repeat) {
					// Lets the user retry adding an ingredient if they made a mistake
					System.out.print("\nIngredient " + i + ":\nName: ");
					name = sc.nextLine();
					name = sc.nextLine();
					if (name.equalsIgnoreCase("s")) {
						// If the user wants to stop, ends this loop and then shortly after ends the second one
						contin = false;
						break;
					}
					
					System.out.print("Units of measurement: ");
					unit = sc.next();

					System.out.print("How many " + unit + " are used in the recipe? ");
					num = sc.nextDouble();

					System.out.print("\nDoes the ingredient look right? Y / N: ");
					if (sc.next().equalsIgnoreCase("Y")) {
						repeat = false;
					}
				}
				if(!contin) {
					break;
				}
					
				Ingredients.put(name, num);
				units.add(unit);
			}

			System.out.println("\nStep 9: Enter the directions step by step. Once again when you are done enter S");
			String tem;
			for (int i = 1; i < 101; i++) {
				System.out.print("S" + i + ": ");
				tem = sc.nextLine();
				if (tem.equalsIgnoreCase("s")) {
					break;
				} else {
					Directions.add(tem);
				}
			}



			Recipe temp = new Recipe(title, type, Tags, prepTime, cookTime, servings, Ingredients, units, calories, fat,
					carbs, protein, Directions);

			System.out.println(temp);

			if (type.equals("Entree")) {
				RecipeSelector.entrees.add(temp);
			} else if (type.equals("Side")) {
				RecipeSelector.sides.add(temp);
			} else if (type.equals("Dessert")) {
				RecipeSelector.desserts.add(temp);
			}

			System.out.println("Your recipe has been created!");
			
		} catch (InputMismatchException ime) {
			ime.printStackTrace();
		}
	}
}
