package Menu;
/*
 * The superclass of all the types of dishes. Defines a dish that has a name, stock value and a price.
 * 
 */
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MenuItem {
	/*
	 * String type name field holds the name of the dish
	 * int type stock holds the quantity of the dish that is in stock currently
	 * double type price holds the price of a single dish
	 * menuItemLabel is the representation of the object on a panel
	 * int type ownNum holds the number that is assigned to the object at creation. Acts as an id for the object
	 * 
	 */
	private String name;
	private int stock;
	private double price;
	private JLabel menuItemLabel;
	private int ownNum;
	
	private static int itemNumber = 1;
	
	/*
	 * The constructor takes three parameters and assigns the values of this parameters to the name, stock and value fields of the object.
	 * Also, it prepares the label for the object as a text that consists of the dishes name and its price, with font "Lato", Plain and size 16.
	 * Also, it increases the static itemNumber field so that every time an object of this class is created, the id that
	 * will be assigned to a new object is changed, so the id's are unique
	 * 
	 * @param  name  A String type parameter that determines the name of the object
	 * @param  stock  An int type parameter that determines the quantity of the dish in the stock
	 * @param  price  A double type parameter that determines the price of the dish
	 * 
	 */
	public MenuItem(String name, int stock, double price) {
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.ownNum = itemNumber;
		
		this.menuItemLabel = new JLabel(String.format("(%d) %s  .................. %.2f TL ",this.getOwnNum(), this.getName(), this.getPrice()));
		
		menuItemLabel.setFont(new Font("Lato", Font.PLAIN, 16));
		menuItemLabel.setBackground(new Color(249,246,238));
		menuItemLabel.setOpaque(true);
		
		itemNumber++;
	}
	/*
	 * An overloaded version of the constructor.
	 * The only difference is that it takes the id as a value and assigns the id
	 * the the objects's ownNum field. It also does not increment the itemNumber field
	 * 
	 * @param  name  A String type parameter that determines the name of the object
	 * @param  stock  An int type parameter that determines the quantity of the dish in the stock
	 * @param  price  A double type parameter taht determines the price of the dish
	 * @param  ownNumber  An int type that determines the dishes id.
	 * 
	 */
	public MenuItem(String name, int stock, double price, int ownNumber) {
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.ownNum = ownNumber;
		
		this.menuItemLabel = new JLabel(String.format("(%d) %s  .................. %.2f TL ",this.getOwnNum(), this.getName(), this.getPrice()));
		
		menuItemLabel.setFont(new Font("Lato", Font.PLAIN, 16));
		menuItemLabel.setBackground(new Color(249,246,238));
		menuItemLabel.setOpaque(true);
	}
	
	/***********************************************************
	 * Public Methods                                          *
	 ***********************************************************/
	
	/*
	 * Getter for the name field.
	 * 
	 * @return The name of the dish
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Getter for the stock field.
	 * 
	 * @return The stock number of the dish
	 */
	public int getStock() {
		return stock;
	}
	
	/*
	 * Getter for the ownNum field.
	 * 
	 * @return The unique id of the dish
	 */
	public int getOwnNum() {
		return ownNum;
	}
	
	/*
	 * Getter for the price field.
	 * 
	 * @return The price of the dish
	 */
	public double getPrice() {
		return price;
	}
	
	/*
	 * Decreases the stock field of the dish by the parameter
	 * 
	 * @param  n  The amount that the stock number of the dish is decreased by
	 */
	public void decreaseStock(int n) {
		this.stock = this.stock - n;
	}
	
	/*
	 * Returns the menuItemLabel field of the dish
	 * 
	 * @return The label that is associated with the dish
	 */
	public JLabel getMenuItemLabel() {
		return menuItemLabel;
	}
	
	/*
	 * Changes the color of the text of the dish's label to grey
	 * 
	 */
	public void changeColorToGrey() {
		this.menuItemLabel.setForeground(new Color(211,211,211));
	}
}
