package Menu;
/*
 * This is a subclass of the MenuItem class. It is supposed to represent all object that are defined as Main Dish.
 * 
 */
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MainDish extends MenuItem{
	/*
	 * The static Main Dish List holds all items that are of type Main Dish. This list makes it easier to iterate and find which Class does a Menu Item belongs to. 
	 * The static mainDishHeader and mainDishImage are just items that are supposed to represent an object of this class in a container in a frame. 
	 * The static orderCount is used in the Management Panel to determine how many object of type Main Dish has been ordered.
	 */
	private static List<MenuItem> mainDishList = new ArrayList<>();
	private static JLabel mainDishHeader = new JLabel();
	private static ImageIcon mainDishImage = new ImageIcon("maindish.png");
	private static int orderCount = 0;
	
	/*
	 * The constructor first create an object with the given parameters using the MenuItem class' constructor. It then adds the created
	 * object to the Main Dish Class' Main Dish List. 
	 * 
	 * @param  name  a String that specifies that name of the MenuItem object
	 * @param  stock  an int value that specifies the quantity of the object that are in stock currently.
	 * @param  price  a double value that specifies the object's price 
	 */
	
	public MainDish(String name, int stock, double price) {
		super(name, stock, price);
		MainDish.mainDishList.add(this);
	}
	
	/*
	 * Returns the static Drink List that contains all the objects that are of type Main Dish
	 * 
	 * @return  The mainDishList
	 */

	/***********************************************************
	 * Public Methods                                          *
	 ***********************************************************/
	
	public static List<MenuItem> getMainDishList() {
		return mainDishList;
	}
	
	/*
	 *  Sets up the label and the image of the Class. The label contains the name of the class, with the
	 *  font "Lato", Plain and size 20, and an image of an Main Dish that is to the left of the text.
	 */
	
	public static void setLabel() {
		mainDishHeader.setText("Main Dish");
		mainDishHeader.setOpaque(false);
		mainDishHeader.setIcon(mainDishImage);
		mainDishHeader.setFont(new Font("Lato", Font.PLAIN, 20));
		mainDishHeader.setHorizontalTextPosition(JLabel.RIGHT);
		mainDishHeader.setVerticalTextPosition(JLabel.CENTER);
	}
	
	/*
	 * Return the label that is associated with the class.
	 * 
	 * @return  The label mainDishHeader
	 */

	public static JLabel getMainDishHeader() {
		return mainDishHeader;
	}
	
	/*
	 * Returns the order count of the class
	 * 
	 * @return  How many times an item of type Main Dish have been ordered
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
