import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecipeSelector {
	// Dont like declaring them with files in there already because of exceptions but just for testing
	static List<Recipe> entrees = entreeSelector(new File("Entrees.txt"));
	static List<Recipe> sides = sideSelector(new File("Sides.txt"));
	static List<Recipe> desserts = dessertSelector(new File("Desserts.txt"));

// One big setup method called once vs 3 smaller methods all called once in file

//	public static void setup(File entrees, File sides, File desserts) {
//		File[] fileArr = { entrees, sides, desserts };
//		for (int i = 1; i < 3; i++) {
//			List<Recipe> recipes = RecipeParser.recipeReader(fileArr[i]);
//
//			for (Recipe recipe : recipes) {
//				if (recipe.getType().equals("entree")) {
//					RecipeSelector.entrees.add(recipe);
//				} else if (recipe.getType().equals("side")) {
//					RecipeSelector.sides.add(recipe);
//				} else if (recipe.getType().equals("dessert")) {
//					RecipeSelector.desserts.add(recipe);
//				}
//			}
//
//		}
//	}

	public static List<Recipe> entreeSelector(File f) {

		List<Recipe> recipes = RecipeParser.recipeReader(f);
		List<Recipe> entrees = new ArrayList<>();

		for (Recipe recipe : recipes) {
			if (recipe.getType().equals("Entree")) {
				entrees.add(recipe);
			}
		}

		return entrees;
	}

	public static List<Recipe> sideSelector(File f) {

		List<Recipe> recipes = RecipeParser.recipeReader(f);
		List<Recipe> sides = new ArrayList<>();

		for (Recipe recipe : recipes) {
			if (recipe.getType().equals("Side")) {
				sides.add(recipe);
			}
		}
		return sides;
	}

	public static List<Recipe> dessertSelector(File f) {

		List<Recipe> recipes = RecipeParser.recipeReader(f);
		List<Recipe> desserts = new ArrayList<>();

		for (Recipe recipe : recipes) {
			if (recipe.getType().equals("Dessert")) {
				desserts.add(recipe);
			}
		}
		return desserts;
	}

	public List<Recipe> randomSelector() {
		List<Recipe> meal = new ArrayList<>();
		if (!entrees.isEmpty() && !sides.isEmpty() && !desserts.isEmpty()) {
			Random rand = new Random();

			Recipe randomEntree = entrees.get(rand.nextInt(entrees.size()));
			Recipe randomSide = sides.get(rand.nextInt(sides.size()));
			Recipe randomDessert = desserts.get(rand.nextInt(desserts.size()));

			meal.add(randomEntree);
			meal.add(randomSide);
			meal.add(randomDessert);
		}

		return meal;

	}
	/**
	* @author camsona_url - Desc: Takes entrees, sides, and dessert lists and prints them to their respective files
	*/
	public static void shutdown() {
		PrintWriter pw = null;

		File f = new File("Entrees.txt");
		try {
			pw = new PrintWriter(f);

			pw.println(
					"title	type	Prep_time	Cook_time	Servings	Calories	Fat	Carbs	Protein	tag1	tag2	tag3	"
							+ "tag4	tag5	tag6	tag7	tag8	tag9	tag10	tag11	steps	"
							+ "ingredient1	amount1	unit1	ingredient2	amount2	unit2	ingredient3	amount3	unit3	ingredient4	amount4	unit4	ingredient5	amount5	unit5	ingredient6	amount6");

			for (int i = 0; i < RecipeSelector.entrees.size(); i++) {
				pw.println(RecipeSelector.entrees.get(i).print());
			}

			f = new File("Sides.txt");
			pw = new PrintWriter(f);

			pw.println(
					"title	type	Prep_time	Cook_time	Servings	Calories	Fat	Carbs	Protein	tag1	tag2	tag3	"
							+ "tag4	tag5	tag6	tag7	tag8	tag9	tag10	tag11	steps	"
							+ "ingredient1	amount1	unit1	ingredient2	amount2	unit2	ingredient3	amount3	unit3	ingredient4	amount4	unit4	ingredient5	amount5	unit5	ingredient6	amount6");

			for (int i = 0; i < RecipeSelector.sides.size(); i++) {
				pw.println(RecipeSelector.sides.get(i).print());
			}

			f = new File("Desserts.txt");
			pw = new PrintWriter(f);

			pw.println(
					"title	type	Prep_time	Cook_time	Servings	Calories	Fat	Carbs	Protein	tag1	tag2	tag3	"
							+ "tag4	tag5	tag6	tag7	tag8	tag9	tag10	tag11	steps	"
							+ "ingredient1	amount1	unit1	ingredient2	amount2	unit2	ingredient3	amount3	unit3	ingredient4	amount4	unit4	ingredient5	amount5	unit5	ingredient6	amount6");

			for (int i = 0; i < RecipeSelector.desserts.size(); i++) {
				pw.println(RecipeSelector.desserts.get(i).print());
			}

		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} finally {
			pw.close();
		}

	}

}
