package Menu;
/*
 * This is a subclass of the MenuItem class. It is supposed to represent all object that are defined as Salad.
 * 
 */
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Salad extends MenuItem{
	/*
	 * The static Salad List holds all items that are of type Salad. This list makes it easier to iterate and find which Class does a Menu Item belongs to. 
	 * The static saladHeader and saladImage are just items that are supposed to represent an object of this class in a container in a frame. 
	 * The static orderCount is used in the Management Panel to determine how many object of type Salad has been ordered.
	 */
	private static List<MenuItem> SaladList = new ArrayList<>();
	private static JLabel saladHeader = new JLabel();
	private static ImageIcon saladImage = new ImageIcon("salad.png");
	private static int orderCount = 0;
	/*
	 * The constructor first create an object with the given parameters using the MenuItem class' constructor. It then adds the created
	 * object to the Salad Class' Main Dish List. 
	 * 
	 * @param  name  a String that specifies that name of the MenuItem object
	 * @param  stock  an int value that specifies the quantity of the object that are in stock currently.
	 * @param  price  a double value that specifies the object's price 
	 */
	public Salad(String name, int stock, double price) {
		super(name, stock, price);
		Salad.SaladList.add(this);
	}
	/*
	 * Returns the static Salad List that contains all the objects that are of type Salad
	 * 
	 * @return  The saladList
	 */
	
	/***********************************************************
	 * Public Methods                                          *
	 ***********************************************************/
	
	public static List<MenuItem> getSaladList() {
		return SaladList;
	}
	/*
	 *  Sets up the label and the image of the Class. The label contains the name of the class, with the
	 *  font "Lato", Plain and size 20, and an image of an Salad that is to the left of the text.
	 */
	public static void setLabel() {
		saladHeader.setText("Salad");
		saladHeader.setOpaque(false);
		saladHeader.setIcon(saladImage);
		saladHeader.setFont(new Font("Lato", Font.PLAIN, 20));
		saladHeader.setHorizontalTextPosition(JLabel.RIGHT);
		saladHeader.setVerticalTextPosition(JLabel.CENTER);
	}
	/*
	 * Return the label that is associated with the class.
	 * 
	 * @return  The label saladHeader
	 */
	public static JLabel getSaladHeader() {
		return saladHeader;
	}
	/*
	 * Returns the order count of the class
	 * 
	 * @return  How many times an item of type Salad have been ordered
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
