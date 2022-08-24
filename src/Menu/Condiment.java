package Menu;
/*
 * This is a subclass of the MenuItem class. It is supposed to represent all object that are defined as Condiments.
 * 
 */
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Condiment extends MenuItem{
	/*
	 * The static Condiment List holds all items that are of type Condiment. This list makes it easier to iterate and find which Class does a Menu Item belongs to. 
	 * The static condimentHeader and condimentImage are just items that are supposed to represent an object of this class in a container in a frame. 
	 * The static orderCount is used in the Management Panel to determine how many object of type Condiment has been ordered.
	 */
	private static List<MenuItem> CondimentList = new ArrayList<>();
	private static JLabel condimentHeader = new JLabel();
	private static ImageIcon condimentImage = new ImageIcon("condiment.png");
	private static int orderCount = 0;
	
	/*
	 * The constructor first create an object with the given parameters using the MenuItem class' constructor. It then adds the created
	 * object to the Condiment Class' Condiment List. 
	 * 
	 * @param  name  a String that specifies that name of the MenuItem object
	 * @param  stock  an int value that speicifies the quantity of the object that are in stock currently.
	 * @param  price  a double value that speicifies the object's price 
	 */
	
	public Condiment(String name, int stock, double price) {
		super(name, stock, price);
		Condiment.CondimentList.add(this);
	}
	
	/*
	 * Returns the static Condiment List that contains all the objects that are of type Condiment
	 * 
	 * @return  The CondimentList
	 */

	/***********************************************************
	 * Public Methods                                          *
	 ***********************************************************/

	public static List<MenuItem> getCondimentList() {
		return CondimentList;
	}
	
	/*
	 *  Sets up the label and the image of the Class. The label contains the name of the class, with the
	 *  font "Lato", Plain and size 20, and an image of an Condiment that is to the left of the text.
	 */
	
	public static void setLabel() {
		condimentHeader.setText("Condiment");
		condimentHeader.setOpaque(false);
		condimentHeader.setIcon(condimentImage);
		condimentHeader.setFont(new Font("Lato", Font.PLAIN, 20));
		condimentHeader.setHorizontalTextPosition(JLabel.RIGHT);
		condimentHeader.setVerticalTextPosition(JLabel.CENTER);
	}
	
	/*
	 * Return the label that is associated with the class.
	 * 
	 * @return  The label condimentHeader
	 */

	public static JLabel getCondimentHeader() {
		return condimentHeader;
	}
	
	/*
	 * Returns the order count of the class
	 * 
	 * @return  How many times an item of type Condiment have been ordered
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
