package Menu;
/*
 * This is a subclass of the MenuItem class. It is supposed to represent all object that are defined as Non Alcoholic Drink.
 * 
 */
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class NonAlcoholicDrink extends MenuItem{
	/*
	 * The static Non Alcoholic Drink List holds all items that are of type Non Alcoholic Drink. This list makes it easier to iterate and find which Class does a Menu Item belongs to. 
	 * The static nonAlcoholicDrinkHeader and nonAlcoholicDrinkImage are just items that are supposed to represent an object of this class in a container in a frame. 
	 * The static orderCount is used in the Management Panel to determine how many object of type Non Alcoholic Drink has been ordered.
	 */
	private static List<MenuItem> NonAlcoholicDrinkList = new ArrayList<>();
	private static JLabel nonAlcoholicDrinkHeader = new JLabel();
	private static ImageIcon nonAlcoholicDrinkImage = new ImageIcon("nonalcoholicdrink.png");
	private static int orderCount = 0;
	
	/*
	 * The constructor first create an object with the given parameters using the MenuItem class' constructor. It then adds the created
	 * object to the Non Alcoholic Drink Class' Main Dish List. 
	 * 
	 * @param  name  a String that specifies that name of the MenuItem object
	 * @param  stock  an int value that specifies the quantity of the object that are in stock currently.
	 * @param  price  a double value that specifies the object's price 
	 */
	
	public NonAlcoholicDrink(String name, int stock, double price) {
		super(name, stock, price);
		
		NonAlcoholicDrink.NonAlcoholicDrinkList.add(this);
		
	}
	/*
	 * Returns the static Non Alcoholic Drink List that contains all the objects that are of type Non Alcoholic Drink
	 * 
	 * @return  The nonAlcoholicDrinkList
	 */

	/***********************************************************
	 * Public Methods                                          *
	 ***********************************************************/
	
	public static List<MenuItem> getNonAlcoholicDrinkList() {
		return NonAlcoholicDrinkList;
	}
	/*
	 *  Sets up the label and the image of the Class. The label contains the name of the class, with the
	 *  font "Lato", Plain and size 20, and an image of an Non Alcoholic Drink that is to the left of the text.
	 */
	public static void setLabel() {
		nonAlcoholicDrinkHeader.setText("Non-Alcoholic Drink");
		nonAlcoholicDrinkHeader.setOpaque(false);
		nonAlcoholicDrinkHeader.setIcon(nonAlcoholicDrinkImage);
		nonAlcoholicDrinkHeader.setFont(new Font("Lato", Font.PLAIN, 20));
		nonAlcoholicDrinkHeader.setHorizontalTextPosition(JLabel.RIGHT);
		nonAlcoholicDrinkHeader.setVerticalTextPosition(JLabel.CENTER);
	}
	/*
	 * Return the label that is associated with the class.
	 * 
	 * @return  The label nonAlcoholicDrinkHeader
	 */
	public static JLabel getNonAlcoholicDrinkHeader() {
		return nonAlcoholicDrinkHeader;
	}
	/*
	 * Returns the order count of the class
	 * 
	 * @return  How many times an item of type Non Alcoholic Drink have been ordered
	 */
	
	public static int getOrderCount() {
		return orderCount;
	}
	/*
	 * Increases the orderCount of the object with the amount that is given as parameter.
	 * Used in the Customer Panel when an item is ordered to increase the orderCount of the Class.
	 * 
	 * @param  n  An int value that specifies how much the orderCount is increased
	 */
	public static void increaseOrderCount(int n) {
		orderCount += n;
	}

}
