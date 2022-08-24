package Menu;
/*
 * This is a subclass of the MenuItem class. It is supposed to represent all object that are defined as Dessert.
 * 
 */
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dessert extends MenuItem{
	/*
	 * The static Dessert List holds all items that are of type Dessert. This list makes it easier to iterate and find which Class does a Menu Item belongs to. 
	 * The static dessertHeader and dessertImage are just items that are supposed to represent an object of this class in a container in a frame. 
	 * The static orderCount is used in the Management Panel to determine how many object of type Dessert has been ordered.
	 */
	private static List<MenuItem> DessertList = new ArrayList<>();
	private static JLabel dessertHeader = new JLabel();
	private static ImageIcon dessertImage = new ImageIcon("dessert.png");
	private static int orderCount = 0;
	
	/*
	 * The constructor first create an object with the given parameters using the MenuItem class' constructor. It then adds the created
	 * object to the Dessert Class' Dessert List. 
	 * 
	 * @param  name  a String that specifies that name of the MenuItem object
	 * @param  stock  an int value that speicifies the quantity of the object that are in stock currently.
	 * @param  price  a double value that speicifies the object's price 
	 */
	
	public Dessert(String name, int stock, double price) {
		super(name, stock, price);
		Dessert.DessertList.add(this);
	}
	
	/***********************************************************
	 * Public Methods                                          *
	 ***********************************************************/
	
	/*
	 * Returns the static Dessert List that contains all the objects that are of type Dessert
	 * 
	 * @return  The DessertList
	 */
	
	public static void setLabel() {
		dessertHeader.setText("Dessert");
		dessertHeader.setOpaque(false);
		dessertHeader.setIcon(dessertImage);
		dessertHeader.setFont(new Font("Lato", Font.PLAIN, 20));
		dessertHeader.setHorizontalTextPosition(JLabel.RIGHT);
		dessertHeader.setVerticalTextPosition(JLabel.CENTER);
	}
	
	/*
	 *  Sets up the label and the image of the Class. The label contains the name of the class, with the
	 *  font "Lato", Plain and size 20, and an image of an Dessert that is to the left of the text.
	 */
	
	public static JLabel getDessertHeader() {
		return dessertHeader;
	}
	
	/*
	 * Return the label that is associated with the class.
	 * 
	 * @return  The label dessertHeader
	 */

	public static List<MenuItem> getDessertList() {
		return DessertList;
	}
	
	/*
	 * Returns the order count of the class
	 * 
	 * @return  How many times an item of type Dessert have been ordered
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
