import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecipeSelector {

	public static List<Recipe> entreeSelector(File f){
		
		List<Recipe> recipes = RecipeParser.recipeReader(f);
		List<Recipe> entrees = new ArrayList<>();
		
		for(Recipe recipe:recipes)
		{
			if (recipe.getType().equals("entree")) {
				entrees.add(recipe);
			}
		}
		
		
		return entrees;	
	}
	
	public static List<Recipe> sideSelector(File f){
		
		List<Recipe> recipes = RecipeParser.recipeReader(f);
		List<Recipe> sides = new ArrayList<>();
		
		for(Recipe recipe:recipes)
		{
			if (recipe.getType().equals("entree")) {
				sides.add(recipe);
			}
		}
		return sides;	
	}
	
	public static List<Recipe> dessertSelector(File f){
		
		List<Recipe> recipes = RecipeParser.recipeReader(f);
		List<Recipe> desserts = new ArrayList<>();
		
		for(Recipe recipe:recipes)
		{
			if (recipe.getType().equals("entree")) {
				desserts.add(recipe);
			}
		}
		return desserts;	
	}
	
	public List<Recipe> randomSelector() {
		File entree = new File("Entree.txt");
		File side = new File ("Sides.txt");
		File dessert = new File("Dessert.txt");
		List<Recipe> entrees = entreeSelector(entree);
		List<Recipe> sides = sideSelector(side);
		List<Recipe> desserts = dessertSelector(dessert);
		List<Recipe> meal = new ArrayList<>();
		if (!entrees.isEmpty()&& !sides.isEmpty() && !desserts.isEmpty()) {
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

}
