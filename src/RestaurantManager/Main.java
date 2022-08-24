/* *********** Pledge of Honor ***************************************************************************
* I hereby certify that I have completed this programming project on my own
* without any help from anyone else. The effort in the project thus belongs
* completely to me. I did not search for a solution, or I did not consult to any program
* written by other students or did not copy any program from other sources. I read and
* followed the guidelines provided in the project description.
*
* READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
* SIGNATURE: <Efe Erdem, 76578>
*
************************************************************************************************************/

package RestaurantManager;

import java.util.LinkedList;
import java.util.List;

import Menu.Appetizer;
import Menu.Condiment;
import Menu.Dessert;
import Menu.Drink;
import Menu.MainDish;
import Menu.Menu;
import Menu.NonAlcoholicDrink;
import Menu.Salad;
import Menu.Soup;
import Restaurant.Customer;
import Restaurant.CustomerSession;
import Restaurant.Manager;
import Restaurant.Table;


public class Main {
	
	public static void main(String[] args) {
		
		//The table list that stores all the table objects
		List<Table> tableList = new LinkedList<Table>();
		
		//Table objects are created
		Table table21 = new Table(1,2);
		tableList.add(table21);
		Table table22 = new Table(2,2);
		tableList.add(table22);
		Table table23 = new Table(3,2);
		tableList.add(table23);
		Table table24 = new Table(4,2);
		tableList.add(table24);
		Table table45 = new Table(5,4);
		tableList.add(table45);
		Table table46 = new Table(6,4);
		tableList.add(table46);
		Table table47 = new Table(7,4);
		tableList.add(table47);
		Table table48 = new Table(8,4);
		tableList.add(table48);
		Table table69 = new Table(9,6);
		tableList.add(table69);
		Table table610 = new Table(10,6);
		tableList.add(table610);
		
		//The menu object is created
		Menu menu = new Menu();
		
		//The Menu Item objects are created
		Soup tarhanaSoup = new Soup("Tarhana Soup", 0, 40);
		Soup wontonSoup = new Soup("Wonton Soup", 10, 45);
		Soup phoSoup = new Soup("Pho Soup", 10, 55);
		Soup caldoVerde = new Soup("Caldo Verde", 10, 60);
		Soup borscht = new Soup("Borscht", 10, 60);
		
		Appetizer chickenWings = new Appetizer("Chicken Wings", 10, 35);
		Appetizer hormelChiliDip = new Appetizer("Hormel Chili Dip", 10, 40);
		Appetizer mozarellaSticks = new Appetizer("Mozarella Sticks", 10, 30);
		Appetizer totchos = new Appetizer("Totchos", 10, 40);
		Appetizer cowboyCrackDip = new Appetizer("Cowboy Crack Dip", 10, 20);
		
		Salad saladCaprese = new Salad("Salad Caprese", 10, 30);
		Salad cobbSalad = new Salad("Cobb Salad", 10, 35);
		Salad caesarSalad = new Salad("Caesar Salad", 10, 25);
		Salad greekSalad = new Salad("Greek Salad", 10, 25);
		Salad larbSalad = new Salad("Larb Salad", 10, 25);
		
		Condiment mayonnaise = new Condiment("Mayonaisse", 10, 5);
		Condiment ketchup = new Condiment("Ketchup", 10, 5);
		Condiment mustard = new Condiment("Mustard", 10, 5);
		Condiment tabasco = new Condiment("Tabasco", 10, 5);
		Condiment soySauce = new Condiment("Soy Sauce", 10, 8);
		
		Dessert tiramisu =  new Dessert("Tiramisu", 10, 30);
		Dessert churros =  new Dessert("Churros", 10, 35);
		Dessert baklava =  new Dessert("Baklava", 10, 25);
		Dessert rumCake =  new Dessert("Rum Cake", 10, 25);
		Dessert ricePudding =  new Dessert("Rice Pudding", 10, 20);
		
		Drink longIslandIcedTea = new Drink("Long Island Iced Tea", 10, 50);
		Drink cosmopolitan = new Drink("Cosmopolitan", 10, 50);
		Drink vodkaMartini = new Drink("Vodka Martini", 10, 50);
		Drink irishCoffee = new Drink("Irish Coffee", 10, 50);
		Drink mojito = new Drink("Mojito", 10, 50);
		
		NonAlcoholicDrink pepsi = new NonAlcoholicDrink("Pepsi", 10, 25);
		NonAlcoholicDrink sprite = new NonAlcoholicDrink("Sprite", 10, 25);
		NonAlcoholicDrink cocaCola = new NonAlcoholicDrink("Coca Cola", 10, 25);
		NonAlcoholicDrink mineralWater = new NonAlcoholicDrink("Mineral Water", 10, 25);
		NonAlcoholicDrink water = new NonAlcoholicDrink("Water", 10, 25);
		
		MainDish sauerkraut = new MainDish("Sauerkraut", 10, 85);
		MainDish coconutShrimp = new MainDish("Coconut Shrimp", 10, 90);
		MainDish crabCakes = new MainDish("Crab Cakes", 10, 90);
		MainDish meatLoaf = new MainDish("Meat Loaf", 10, 85);
		MainDish fritoPie = new MainDish("Frito Pie", 10, 80);
		MainDish bbqRibs = new MainDish("BBQ Ribs", 10, 95);
		MainDish doner = new MainDish("Doner", 10, 90);
		
		//All the MenuItem objects are added to the menu
		menu.addMenuItemList(Soup.getSoupList());
		menu.addMenuItemList(Appetizer.getAppetizerList());
		menu.addMenuItemList(Salad.getSaladList());
		menu.addMenuItemList(Condiment.getCondimentList());
		menu.addMenuItemList(Dessert.getDessertList());
		menu.addMenuItemList(Drink.getDrinkList());
		menu.addMenuItemList(NonAlcoholicDrink.getNonAlcoholicDrinkList());
		menu.addMenuItemList(MainDish.getMainDishList());
		
		//A Manager object is created and the UI starts
		Manager manager = new Manager(menu,tableList);
		
	}

}
