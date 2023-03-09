import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File f = new File("Recipe.txt");
		List<Recipe> recipe = RecipeParser.recipeReader(f);
		
		RecipeSelector rs = new RecipeSelector();
		
		System.out.println(rs.desserts);

		System.out.println(recipe.toString());
	}



}
