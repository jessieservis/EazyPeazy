import java.util.ArrayList;

/*EzeayPeazy Meal
 * DEV @ Seth Glover 
 * DESCRIPTION This might not be needed but I am leaving this here for now. 
 * DATE
 */
public class Meal implements Comparable <Meal> {
	double calories; 
	
	public Meal (double calories) {
		this.calories = calories; 
	}

	public int compareTo(Meal other) {
		return Double.compare(this.calories, other.calories);
	}

}
