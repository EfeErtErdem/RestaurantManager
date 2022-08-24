package Restaurant;
/*
 * A class that is supposed to represent a Table. It has a unique ID number, a capacity
 * that determines how many persons can sit on the table, a value that determines if it is occupied or
 * not, and a label that determines how it will be represented on the frame. 
 */
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Table {
	/*
	 * An int capacity that determines the how many people can sit on the table
	 * An int number that determines the id of the table
	 * A boolean occupied that determines if the table is occupied or not
	 * A label and an image that represents how a Table object will be represented 
	 * in a frame.
	 */
	private int capacity;
	private int number;
	private boolean occupied;
	private JLabel tableLabel;
	private static ImageIcon tableImage = new ImageIcon("table1.png");
	/*
	 * The constructor takes two arguments ands assigns them to the id and the 
	 * capacity fields of the Table objects, respectively. It sets the object's
	 * occupied value to false. It also sets up the label of the object so that it
	 * shows an image of a table and the id of that table to the bottom right of that 
	 * image
	 * 
	 *  @param  number  An int value that determines the id of the table
	 *  @param  capacity  An int value that determines how many people
	 *  					can sit on the table
	 */
	public Table(int number, int capacity) {
		this.capacity = capacity;
		this.number = number;
		
		occupied = false;
		
		tableLabel = new JLabel(String.format("%d",this.number, this.capacity));
		tableLabel.setOpaque(true);
		tableLabel.setFont(new Font("Lato", Font.PLAIN, 16));
		tableLabel.setHorizontalTextPosition(JLabel.RIGHT);
		tableLabel.setVerticalTextPosition(JLabel.BOTTOM);
		tableLabel.setBackground(new Color(249,246,238));
		tableLabel.setIcon(tableImage);
		
	}
	
	/***********************************************************
	 * Public Methods                                          *
	 ***********************************************************/
	
	/*
	 * A getter for the capacity of the table
	 * 
	 * @return  The capacity of the table
	 */
	public int getCapacity() {
		return capacity;
	}
	/*
	 * A getter for the occupied value of the table
	 * 
	 * @return  True if the table is occupied, otherwise false
	 */
	public boolean isOccupied() {
		return this.occupied;
	}
	/*
	 * Sets the occupied value of the table to true
	 */
	public void occupyTable() {
		this.occupied = true;
	}
	/*
	 * Sets the occupied value of the table to false
	 */
	public void unoccupyTable() {
		this.occupied = false;
	}
	/*
	 * A getter for the representation of the table object in a frame
	 * 
	 * @return  The representation of the object in a frame
	 */
	public JLabel getTableLabel() {
		return tableLabel;
	}
	/*
	 * It sets the foreground color of the label of the Table object to red.
	 * Used when showing the table is occupied in the frame
	 */
	public void setTableGrey() {
		this.tableLabel.setForeground(new Color(220,11,11));
	}
	/*
	 * Sets the foreground color of the label of the Table object to black
	 * Used when showing the table is available in the frame
	 * 
	 */
	public void setTableNormal() {
		this.tableLabel.setForeground(new Color(0,0,0));
	}
	/*
	 * A getter for the id of the Table object
	 * 
	 * @return  The unique id of the Table object
	 */
	public int getNumber() {
		return number;
	}
	/*
	 * A setter for the id of the Table object
	 * 
	 * @param  number  An int value that the id of the table is set to
	 */
	public void setNumber(int number) {
		this.number = number;
	}
}
