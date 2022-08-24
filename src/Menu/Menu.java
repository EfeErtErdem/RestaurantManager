package Menu;
/*
 * This class acts as a container that holds all of the Menu Item type
 * objects. Because a single menu object is created at the main, this 
 * class also acts as sort of a recording device that holds all the stock 
 * and the price information.
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	/*
	 * The list that all of the Menu Item objects are stored as a list of lists that are type MenuItem.
	 * The only reason is that in the main method, it is easier to add the static List
	 * of the Classes that store all the objects of that Class to the list of the menu
	 * 
	 */
	
	private List<List<MenuItem>> menuDishList = new ArrayList<>();
	
	/*
	 * The default constructor of the Object Class is being used because the 
	 * menu object does not need to be initialized with any parameters
	 * 
	 */
	
	/*
	 * Returns the List that the MenuItem objects are stored.
	 * 
	 * @return The list menuDishList that the Menu Item objects are 
	 * 			stored.
	 */
	
	/***********************************************************
	 * Public Methods                                          *
	 ***********************************************************/
	
	public List<List<MenuItem>> getDishList() {
		return menuDishList;
	}
	
	/*
	 * Adds a list of menu items to the internal list of the menu object
	 * Used when adding the lists containing the objects of the subclasses of the Menu Item Class
	 * to the internal list of menu object
	 * 
	 * @param  dishList  a list that contains objects of Menu Item type
	 * 
	 */
	
	public void addMenuItemList(List<MenuItem> dishList) {
		this.menuDishList.add(dishList);
	}
	
	/*
	 * Returns the total price of all the objects that 
	 * are stored in the menu
	 * 
	 * @return  The total price of all items in the menu
	 * 
	 */
	
	public double returnTotalPrice() {
		
		double total = 0;
		
		for (List<MenuItem> subMenu : this.menuDishList) {
			for (MenuItem m : subMenu) {
				total += m.getPrice();
			}
		}
		return total;
	}
}
