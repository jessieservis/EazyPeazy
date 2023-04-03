import java.io.File;
import java.util.*;

public class DietDecorator extends RecipeSelector {
	public static List<Recipe> recipes = new ArrayList<>();
	public static List<Recipe> dietRecipes = new ArrayList<>();
	public static List<String> tags = new ArrayList<>();

	public static List<Recipe> flagFinder(String tagflag) {
		for (int i = 0; i < recipes.size(); i++) {
			tags = recipes.get(i).getTags();
			for (String tag : tags) {
				if (tag.equals(tagflag))
					dietRecipes.add(recipes.get(i));
				break;
			}
		}
		return dietRecipes;
	}

	public static List<Recipe> entreeSelector(File f, String tagflag) {
		recipes = RecipeSelector.entreeSelector(f);
		return flagFinder(tagflag);
	}

	public static List<Recipe> sideSelector(File f, String tagflag) {
		recipes = RecipeSelector.sideSelector(f);
		return flagFinder(tagflag);

	}

	public static List<Recipe> dessertSelector(File f, String tagflag) {
		recipes = RecipeSelector.dessertSelector(f);
		return flagFinder(tagflag);
	}
}

class VeganDecorator extends DietDecorator{
	public static List<Recipe> VeganEntree(File f) {
		return DietDecorator.entreeSelector(f, "vegan");
	}
	public static List<Recipe> VeganSideSelector(File f) {
		return DietDecorator.sideSelector(f, "vegan");
	}
	public static List<Recipe> VeganDessertSelector(File f) {
		return DietDecorator.dessertSelector(f, "vegan");
	}
}