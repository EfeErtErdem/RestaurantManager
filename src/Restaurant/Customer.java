package Restaurant;
/*
 * A class that is supossed to represent a customer at the restaurant. Has the attributes
 * name, age, how many people are in the customer group and the order.
 * 
 */
import java.util.ArrayList;
import java.util.List;
import Menu.MenuItem;

public class Customer implements Comparable<Customer>{
	/*
	 * String name holds the name of the customer
	 * int numberOfCustomer holds the number of customers in the group
	 * orderList is an ArrayList of MenuItem objects that holds the orders of the customer group
	 * int tableNumber holds the number of the table that is assigned to the customer
	 * int age is the age of the customer
	 * int number is the id of the customer
	 * static int id is the id value that will be assigned to a customer once they are created
	 */
	private String name;
	private int numberOfCustomer;
	private List<MenuItem> orderList = new ArrayList<>();;
	private int tableNumber;
	private int age;
	private int number;
	private static int id = 1;
	/*
	 * The constructor creates a Customer objects that has a name, age 
	 * and has a number that represents the number of people in its group
	 * Also assigns the static id value to the customer's number field and 
	 * increments the id by 1
	 * 
	 * @param  name  A String that represents the customer name
	 * @param  age  An int that represents the age of the customer
	 * @param  numberOfCustomer  An int that represents the number of people in the 
	 *                           customer group
	 * 
	 */
	public Customer(String name, int age, int numberOfCustomer) {
		this.name = name;
		this.numberOfCustomer = numberOfCustomer;
		this.age = age;
		
		this.number = id;
		id++;
	}
	
	/***********************************************************
	 * Public Methods                                          *
	 ***********************************************************/
	
	/*
	 * A getter for the table number of the customer
	 * 
	 * @return  The table number of the customer
	 */
	public int getTableNumber() {
		return tableNumber;
	}
	/*
	 * A setter for the table number of the customer.
	 * 
	 * @param  tableNumber  An int that represents the table number
	 */
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	/*
	 * A getter for the name of the customer
	 * 
	 * @return  The name of the customer
	 */
	public String getName() {
		return name;
	}
	/*
	 * A getter for the number of customers in the group
	 * 
	 * @return  The number of customers in the group
	 */
	public int getNumberOfCustomer() {
		return numberOfCustomer;
	}
	/*
	 * A getter for the list of the orders of the customer
	 * 
	 * @return  The list of the orders of the customer
	 */
	public List<MenuItem> getOrderList() {
		return orderList;
	}
	/*
	 * A setter for the list of orders of the customer.
	 * 
	 * @param  m  A list of MenuItem objects that the order
	 * 				list of the customer will be set to.
	 */
	public void setOrderList(List<MenuItem> m) {
		this.orderList = m;
	}
	/*
	 * Adds an order of type MenuItem into the order list of 
	 * the customer
	 * 
	 * @param  m  A MenuItem object that is going to be added 
	 * 				to the order list of the customer
	 * 
	 */
	public void addOrder(MenuItem m) {
		this.orderList.add(m);
	}
	/*
	 * Removes all of the orders from the customers order list
	 * 
	 */
	public void removeOrders() {
		this.orderList.clear();
	}
	/*
	 * Calculates the total price of the orders of the customer.
	 * Iterates over the order list and finds the price of a dish 
	 * by multiplying its order quantity and the price of a single 
	 * dish
	 */
	public double getTotalPriceOfOrder() {
		double totalPrice = 0;
		for (MenuItem m : this.orderList) {
			totalPrice += m.getPrice() * m.getStock();
		}
		return totalPrice;
	}
	/*
	 * A getter for the age of the customer
	 * 
	 * @return  The age of the customer
	 */
	public int getAge() {
		return age;
	}
	/*
	 * A setter for the age of the customer.
	 * 
	 * @param  age  An integer that the age of the customer
	 * 				is going to be set to
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/*
	 * A getter for the id of the customer
	 * 
	 * @return  The id of the customer
	 */
	public int getNumber() {
		return number;
	}
	/*
	 * Determines how Customer objects are compared to each other.
	 * Takes a Customer object c as argument. Firstly it compares the 
	 * age of the current object and c. If they are not equal, it makes 
	 * them sortable by their age values in descending order. Else, it makes
	 * them sortable by the total cost of their orders in descending order
	 * 
	 *  @param  c	A customer object that the current object is being compared
	 *  			to
	 *  
	 *  @return     It returns -1 if the compared value of the current object
	 *  			is smaller than the object it is compared to. Returns 1 if 
	 *  			the compared value of the current object is bigger then the 
	 *  			object it is compared to. Returns 0 if the compared values 
	 *  			of both objects are the same.
	 * 
	 */
	@Override
	public int compareTo(Customer c) {
		if (this.age != c.age) {
			if (this.age < c.age) {
				return -1;
			}
			else if (this.age > c.age) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else {
			if (this.getTotalPriceOfOrder() < c.getTotalPriceOfOrder()) {
				return 1;
			}
			else if (this.getTotalPriceOfOrder() > c.getTotalPriceOfOrder()) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}
}
