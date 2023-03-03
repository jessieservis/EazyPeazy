import java.util.List;
import java.util.Map;
/**
 * 
 * @author sethm
 * I am going to try something out over the weekend
 * so if you are reading this then know that if this 
 * doesn't work out. we will go back to the og plan
 */
public interface Recipe {
	
	String Title(String html);
	List<String> ingredients (String html);
	List<String> Directions (String html);
	Map<String, String> ingredientsWithQuantities(String html);
	
}
