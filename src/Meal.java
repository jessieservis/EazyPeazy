import java.util.ArrayList;

/*EzeayPeazy Meal
 * DEV @ Seth Glover 
 * DESCRIPTION 
 * DATE
 */
public class Meal implements Comparable <Meal> {
	private String name; 
	private double calories;
	private static ArrayList<Float> nutritionValue = new ArrayList<Float>();
	private ArrayList<String> labels = new ArrayList<String>();
	
	/**
	 * 
	 */
	public Meal(String name, double calories) {
		this.name = name; 
		this.calories = calories; 
		
	}
	
	public double getCalories(int count) {
		
		double totalCalories = 0;
		//iterate through meal to count calories
		for (int i = 0; i< count; i++) {
			
		}
		
		return totalCalories;
	}
	/*
	 * compares meals based on calores. 
	 */
	public int compareTo(Meal other) {
		return Double.compare(this.calories, other.calories);
	}

}
