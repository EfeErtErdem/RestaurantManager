package Restaurant;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Menu.Appetizer;
import Menu.Condiment;
import Menu.Dessert;
import Menu.Drink;
import Menu.MainDish;
import Menu.Menu;
import Menu.MenuItem;
import Menu.NonAlcoholicDrink;
import Menu.Salad;
import Menu.Soup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
 * This class is an extension of the JFrame class. It is supposed to represent
 * the frame that the customers will use to choose their table and make their
 * order. It displays a warning message if there are no available tables and closes the window.
 * If there are available tables, after the customer makes their choice, takes them to
 * the Menu Session and lets them choose their orders.
 */
public class CustomerSession extends JFrame implements ActionListener{
	/*
	 *** A list of tables tableList that contains all of the tables in the restaurant
	 * 
	 *** A list of tables availableTableList that contains all of the available tables to the customers
	 * 
	 *** A menu that holds all the MenuItem objects in the restaurant
	 *
	 *** A customer will choose their table and place their orders
	 * 
	 *** A combo box tableChoice that shows the customer the available tables
	 * 
	 *** A button chooseButton that lets the customer claim the table they have chosen
	 * 
	 *** A combo box chooseOrder that lists the available dishes and lets the customer choose from the available dishes
	 * 
	 *** A text field orderQuantity that lets the customer enter how many portions of the chosen dish they want to order
	 * 
	 ***A list of MenuItem objects that hold the orders of the customer before they are added to the customers order list
	 * 
	 *** A button addButton that lets the users add the dish with the portions they have specified to their pre-order list
	 *
	 *** A button deleteButton that lets the user delete the last dish they have added to their pre-order list
	 * 
	 *** A text area orderText that displays the dishes in the customers pre-order list with their portions
	 * 
	 *** A button orderButton that lets the customer order the dishes they have chosen
	 *  
	 *** A panel mainPanel that holds all the elements of the Menu Session
	 * 
	 *** A panel tableMainPanel that holds all the elements of the Table Session
	 */
	private List<Table> tableList;
	private List<Table> availableTableList;
	private Menu menu;
	private Customer customer;
	private JComboBox tableChoise;
	private JButton chooseButton;
	private JComboBox chooseOrder;
	private JTextField orderQuantity;
	private List<MenuItem> preOrderList;
	private JButton addButton;
	private JButton deleteButton;
	private JTextArea orderText;
	private JButton orderButton;
	private JPanel mainPanel;
	private JPanel tableMainPanel;
	/*
	 * The constructor takes three parameters and sets the customer, menu and tableList fields
	 * of the current object to these parameters, respectively. It also sets up the frame. The code here is
	 * divided into two main parts: the table session and the menu session. The table session is where the
	 * customer chooses their table and the menu session where they place their orders.
	 * 
	 *  @param  customer  A Customer object that determines the customer of this frame
	 *  @param  menu  A Menu object that determines the menu that the orders will be placed from
	 *  @param  tableList  A List of Table objects that contains the tables that the customer will 
	 *  						choose from
	 */
	public CustomerSession(Customer customer, Menu menu, List<Table> tableList) {
		this.customer = customer;
		this.menu = menu;
		this.tableList = tableList;
		this.availableTableList = new LinkedList<>();
		
		//The image icon of the frame
		ImageIcon image = new ImageIcon("logo.jpg");
		
		
		/**************************************************************************************
		 **************************************************************************************
		 *******                     Beginning of the Table Session                       *****
		 **************************************************************************************
		 **************************************************************************************/
		
		
		//This is the list that contain the panels that are going to be added to the main panel.
		//Makes it easier to iterate over the panels.
		ArrayList<JPanel> tablePanelList = new ArrayList<>();
		
		/*
		 * This part determines the available tables to the current customer. It checks how many 
		 * people are in the customer group, and checks if the capacity of the table is appropriate.
		 * Then it checks if the table is occupied. If the conditions are satisfied, it adds the table 
		 * to the available table list. If not, sets the foreground of the label of the table to red to 
		 * show that it is unavailable. Also, if the conditions are met, sets the foreground color of the
		 * label to black in the case that it may have been set to red before.
		 */
		for (Table t : tableList) {
			if (customer.getNumberOfCustomer() > 0 && customer.getNumberOfCustomer() <= 2) {
				if (t.getCapacity() != 2 || t.isOccupied()) {
					t.setTableGrey();
				}
				else {
					t.setTableNormal();
					availableTableList.add(t);
				}
			}
			else if (customer.getNumberOfCustomer() > 2 && customer.getNumberOfCustomer() <= 4) {
				if (t.getCapacity() != 4 || t.isOccupied()) {
					t.setTableGrey();
				}
				else {
					t.setTableNormal();
					availableTableList.add(t);
				}
			}
			else if (customer.getNumberOfCustomer() > 4 && customer.getNumberOfCustomer() <= 6) {
				if (t.getCapacity() != 6 || t.isOccupied()) {
					t.setTableGrey();
				}
				else {
					t.setTableNormal();
					availableTableList.add(t);
				}
			}
		}
		
		/*
		 * These are all the sub panels of the table main panel that the elements will be
		 * placed in. They are added to the panel list because it makes it easier to iterate 
		 * over them.
		 */
		tableMainPanel = new JPanel();
		JPanel tableWarningPanel = new JPanel();
		tablePanelList .add(tableWarningPanel);
		JPanel tableHeaderPanel = new JPanel();
		tablePanelList .add(tableHeaderPanel);
		JPanel twoTablePanel = new JPanel();
		tablePanelList .add(twoTablePanel);
		JPanel fourTablePanel = new JPanel();
		tablePanelList .add(fourTablePanel);
		JPanel sixTablePanel = new JPanel();
		tablePanelList .add(sixTablePanel);
		
		//This panel holds the combo box tableChoice and the button chooseButton
		JPanel tableMidPanel = new JPanel();
		tablePanelList .add(tableMidPanel);
		
		/*
		 * The layout manager for the main panel is set to be Box Layout. Box Layout treats 
		 * the elements as a sort of box and stacks them according to the parameters that are entered.
		 * In this case, it stacks the elements on top of each other.
		 */
		tableMainPanel.setLayout(new BoxLayout(tableMainPanel, BoxLayout.Y_AXIS));
		
		//This is the header for the table session. Added to the respective panel
		JLabel tableHeader = new JLabel("TABLE LIST");
		tableHeader.setFont(new Font("Lato",Font.BOLD, 30));
		tableHeader.setBackground(new Color(249,246,238));
		tableHeader.setOpaque(true);
		tableHeaderPanel.add(tableHeader);
		
		//This is a message that informs the users that unavailable tables will be shown in red
		//Added to the respective panel
		JLabel tableWarning = new JLabel("*Warning. Unavailable tables will be shown in red.");
		tableWarning.setFont(new Font("Lato",Font.BOLD, 15));
		tableWarning.setBackground(new Color(249,246,238));
		tableWarning.setOpaque(true);
		tableWarningPanel.add(tableWarning);
		
		/*
		 * Adds the labels of the Table objects to their respective panels by iterating 
		 * over the table list
		 */
		for (Table t : this.tableList) {
			if (t.getCapacity() == 2) {
				twoTablePanel.add(t.getTableLabel());
			}
			else if (t.getCapacity() == 4) {
				fourTablePanel.add(t.getTableLabel());
			}
			else if (t.getCapacity() == 6) {
				sixTablePanel.add(t.getTableLabel());
			}
		}
		
		/*
		 * This part prepares the String array that will be given 
		 * to the combo box tableChoice as an argument. A new String array
		 * that will contain the numbers of the available tables is created, then
		 * the list of available tables are iterated over and their numbers are placen 
		 * to the array 
		 */
		int i = 0;
		String[] availableTableNumbers = new String[availableTableList.size()];
		for (Table t : availableTableList) {
			availableTableNumbers[i] = String.valueOf(t.getNumber());
			i++;
		}
 		
		
		//The combo box for choosing the available tables
		tableChoise = new JComboBox(availableTableNumbers);
		tableChoise.setPreferredSize(new Dimension(100,40));
		tableChoise.setMaximumSize(tableChoise.getPreferredSize());
		
		//The button for choosing an available table
		chooseButton = new JButton();
		chooseButton.setText("Choose Table");
		chooseButton.setPreferredSize(new Dimension(150,40));
		chooseButton.setMaximumSize(chooseButton.getPreferredSize());
		chooseButton.addActionListener(this);
		
		//Just some panel adjustments
		tableMainPanel.setPreferredSize(new Dimension(550,3000));
		tableMainPanel.setMaximumSize(tableMainPanel.getPreferredSize());;
		tableMainPanel.setBackground(new Color(249,246,238));
		for (JPanel p : tablePanelList) {
			p.setPreferredSize(new Dimension(550,200));
			p.setMaximumSize(p.getPreferredSize());
			p.setBackground(new Color(249,246,238));
		}
		tableWarningPanel.setPreferredSize(new Dimension(550,50));
		tableHeaderPanel.setPreferredSize(new Dimension(550,80));
		
		//Adds the combo box for choosing the tables and the choosing button to
		//the midPanel
		tableMidPanel.add(tableChoise);
		tableMidPanel.add(chooseButton);
		
		//Adds all the sub panels to the main panel
		for (JPanel p : tablePanelList) {
			tableMainPanel.add(p);
		}
		
		
		/**************************************************************************************
		 **************************************************************************************
		 *******                          End of the Table Session                        *****
		 **************************************************************************************
		 **************************************************************************************/
		
		/*
		 *----------------------------------------------------------------------------------------- 
		 */
		
		/**************************************************************************************
		 **************************************************************************************
		 *******                     Beginning of the Menu Session                       *****
		 **************************************************************************************
		 **************************************************************************************/
		
		//The pre order list that is used for storing a customers orders before adding them 
		//to the order list of the customer
		preOrderList = new LinkedList<MenuItem>();
		
		//An image used in the header (A table, actually. Same one used in table images)
		ImageIcon image2 = new ImageIcon("table1.png");
		
		/*
		 *  The main panel contains all the other panels, top panel has the warning message, header panel has the menu title 
		 *  and the others are self-explanatory: the panels that start with the sub classes of MenuItem contains the subclass' 
		 *  label, and the ones that start with sub contain the dishes' labels.
		 */
		mainPanel = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel headerPanel = new JPanel();
		JPanel soupPanel = new JPanel();
		JPanel subSoupPanel = new JPanel();
		JPanel saladPanel = new JPanel();
		JPanel subSaladPanel = new JPanel();
		JPanel nonAlcoholicDrinkPanel = new JPanel();
		JPanel subNonAlcoholicDrinkPanel = new JPanel();
		JPanel mainDishPanel = new JPanel();
		JPanel subMainDishPanel = new JPanel();
		JPanel drinkPanel = new JPanel();
		JPanel subDrinkPanel = new JPanel();
		JPanel dessertPanel = new JPanel();
		JPanel subDessertPanel = new JPanel();
		JPanel condimentPanel = new JPanel();
		JPanel subCondimentPanel = new JPanel();
		JPanel appetizerPanel = new JPanel();
		JPanel subAppetizerPanel = new JPanel();
		
		//these panels hold the elements that let the customer order
		JPanel instructionPanel = new JPanel();
		JPanel chooseOrderPanel = new JPanel();
		JPanel instructionPanel2 = new JPanel();
		JPanel orderQuantityPanel = new JPanel();
		JPanel addDeletePanel = new JPanel();
		JPanel textPanel = new JPanel();
		JPanel orderPanel = new JPanel();
		
		//A list of panels makes it easier to iterate when doing the same operations on the panels.
		ArrayList<JPanel> panelList = new ArrayList<>();
		panelList.add(topPanel);
		panelList.add(headerPanel);
		panelList.add(soupPanel);
		panelList.add(subSoupPanel);
		panelList.add(appetizerPanel);
		panelList.add(subAppetizerPanel);
		panelList.add(saladPanel);
		panelList.add(subSaladPanel);
		panelList.add(condimentPanel);
		panelList.add(subCondimentPanel);
		panelList.add(dessertPanel);
		panelList.add(subDessertPanel);
		panelList.add(drinkPanel);
		panelList.add(subDrinkPanel);
		panelList.add(nonAlcoholicDrinkPanel);
		panelList.add(subNonAlcoholicDrinkPanel);
		panelList.add(mainDishPanel);
		panelList.add(subMainDishPanel);
		panelList.add(instructionPanel);
		panelList.add(chooseOrderPanel);
		panelList.add(instructionPanel2);
		panelList.add(orderQuantityPanel);
		panelList.add(addDeletePanel);
		panelList.add(textPanel);
		panelList.add(orderPanel);
		
		//A box layout with Y-axis orientation is used, because the panels should stack on top of each other like boxes.
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		//The sub-panels use the flow layout manager because the items should be visible even if the menu is resized.
		subSaladPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
		subSoupPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
		subNonAlcoholicDrinkPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
		subMainDishPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
		subDrinkPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
		subDessertPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
		subCondimentPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));
		subAppetizerPanel.setLayout(new FlowLayout(FlowLayout.CENTER,5,0));

		//Size adjustments for the panels
		mainPanel.setPreferredSize(new Dimension(450,3100));
		mainPanel.setMaximumSize(mainPanel.getPreferredSize());
		topPanel.setPreferredSize(new Dimension(500,30));
		headerPanel.setPreferredSize(new Dimension(500,150));
		soupPanel.setPreferredSize(new Dimension(500,100));
		subSoupPanel.setPreferredSize(new Dimension(500,150));
		saladPanel.setPreferredSize(new Dimension(500,100));
		subSaladPanel.setPreferredSize(new Dimension(500,150));
		nonAlcoholicDrinkPanel.setPreferredSize(new Dimension(500,100));
		subNonAlcoholicDrinkPanel.setPreferredSize(new Dimension(500,150));
		drinkPanel.setPreferredSize(new Dimension(500,100));
		subDrinkPanel.setPreferredSize(new Dimension(500,150));
		dessertPanel.setPreferredSize(new Dimension(500,100));
		subDessertPanel.setPreferredSize(new Dimension(500,150));
		condimentPanel.setPreferredSize(new Dimension(500,100));
		subCondimentPanel.setPreferredSize(new Dimension(500,150));
		mainDishPanel.setPreferredSize(new Dimension(500,100));
		subMainDishPanel.setPreferredSize(new Dimension(500,150));
		appetizerPanel.setPreferredSize(new Dimension(500,100));
		subAppetizerPanel.setPreferredSize(new Dimension(500,150));
		instructionPanel.setPreferredSize(new Dimension(500,25));
		chooseOrderPanel.setPreferredSize(new Dimension(500,50));
		instructionPanel2.setPreferredSize(new Dimension(500,25));
		orderQuantityPanel.setPreferredSize(new Dimension(500,50));
		addDeletePanel.setPreferredSize(new Dimension(500,50));
		textPanel.setPreferredSize(new Dimension(500,200));
		orderPanel.setPreferredSize(new Dimension(500,50));

		//All have the same color.
		mainPanel.setBackground(new Color(249,246,238));
		for (JPanel p : panelList) {
			p.setBackground(new Color(249,246,238));
			mainPanel.add(p);
		}

		//Adds the warning label to the top panel
		JLabel warningLabel = new JLabel();
		warningLabel.setText("*Warning! Items that are not in the stock will be displayed in grey.");
		warningLabel.setOpaque(false);
		warningLabel.setVerticalAlignment(JLabel.TOP);
		warningLabel.setHorizontalAlignment(JLabel.LEFT);
		warningLabel.setBackground(new Color(249,246,238));
		topPanel.add(warningLabel, BorderLayout.NORTH);

		//Adds the header to the header panel
		JLabel header = new JLabel();
		header.setText("Menu");
		header.setIcon(image2);
		header.setFont(new Font("Lato",Font.BOLD, 30));
		header.setHorizontalTextPosition(JLabel.CENTER);
		header.setVerticalTextPosition(JLabel.TOP);
		header.setBackground(new Color(249,246,238));
		header.setOpaque(true);
		headerPanel.add(header, BorderLayout.NORTH);

		//Prepares the class labels.
		Soup.setLabel();
		Salad.setLabel();
		NonAlcoholicDrink.setLabel();
		Drink.setLabel();
		MainDish.setLabel();
		Dessert.setLabel();
		Condiment.setLabel();
		Appetizer.setLabel();

		//Adds the labels of MenuItem's subclasses (the header + the image of the class) to their respective panels.
		soupPanel.add(Soup.getSoupHeader(), BorderLayout.NORTH);
		saladPanel.add(Salad.getSaladHeader(), BorderLayout.NORTH);
		nonAlcoholicDrinkPanel.add(NonAlcoholicDrink.getNonAlcoholicDrinkHeader(), BorderLayout.NORTH);
		drinkPanel.add(Drink.getDrinkHeader(), BorderLayout.NORTH);
		mainDishPanel.add(MainDish.getMainDishHeader(), BorderLayout.NORTH);
		dessertPanel.add(Dessert.getDessertHeader(), BorderLayout.NORTH);
		condimentPanel.add(Condiment.getCondimentHeader(), BorderLayout.NORTH);
		appetizerPanel.add(Appetizer.getAppetizerHeader(), BorderLayout.NORTH);

		//Iterates over all the MenuItem objects in the menu and set the 
		//foreground color to grey if there are none in the stock
		for (List<MenuItem> dishList : menu.getDishList()) {
			for (MenuItem m : dishList) {
				if (m.getStock() == 0) {
					m.changeColorToGrey();
				}
			}
		}

		//Adds the MenuItem objects' labels to their respective sub panels
		for (MenuItem m : Soup.getSoupList()) {
			subSoupPanel.add(m.getMenuItemLabel(), BorderLayout.SOUTH);
		}
		for (MenuItem m : Salad.getSaladList()) {
			subSaladPanel.add(m.getMenuItemLabel(), BorderLayout.SOUTH);
		}
		for (MenuItem m : NonAlcoholicDrink.getNonAlcoholicDrinkList()) {
			subNonAlcoholicDrinkPanel.add(m.getMenuItemLabel(), BorderLayout.SOUTH);
		}
		for (MenuItem m : Drink.getDrinkList()) {
			subDrinkPanel.add(m.getMenuItemLabel(), BorderLayout.SOUTH);
		}
		for (MenuItem m : MainDish.getMainDishList()) {
			subMainDishPanel.add(m.getMenuItemLabel(), BorderLayout.SOUTH);
		}
		for (MenuItem m : Dessert.getDessertList()) {
			subDessertPanel.add(m.getMenuItemLabel(), BorderLayout.SOUTH);
		}
		for (MenuItem m : Appetizer.getAppetizerList()) {
			subAppetizerPanel.add(m.getMenuItemLabel(), BorderLayout.SOUTH);
		}
		for (MenuItem m : Condiment.getCondimentList()) {
			subCondimentPanel.add(m.getMenuItemLabel(), BorderLayout.SOUTH);
		}
		
		/*
		 * An instruction on top of the combo box that tells the purpose of the combo box.
		 * Then added to the instruction panel
		 */
		JLabel instruction = new JLabel("Please select the number of the dish you want to order");
		instruction.setOpaque(false);
		instruction.setBackground(new Color(249,246,238));
		instructionPanel.add(instruction);
		
		/*
		 * This part prepares the String array that will be given 
		 * to the combo box chooseOrder as an argument. A new String array
		 * that will contain the numbers of the available dishes is created, then
		 * the list of all dishes are iterated over and their numbers are placed 
		 * to the array if they are available. 
		 */
		
		//The list is used to store the numbers of the available dishes
		List<String> availableDishes = new LinkedList<>();
		
		//Iterated over the menu to find the available dishes and add their number to the
		//list
		for (List<MenuItem> item : this.menu.getDishList()) {
			for (MenuItem m : item) {
				if (m.getStock() > 0) {
					availableDishes.add(String.valueOf(m.getOwnNum()));
				}
			}
		}
		
		//The list is converted to an array
		String[] chooseNumber = new String[availableDishes.size()];
		availableDishes.toArray(chooseNumber);
		
		//The combo box for choosing the dish, created with the parameter as the array
		//that contains the number of the available dishes. Added to the choose order panel
		chooseOrder = new JComboBox(chooseNumber);
		chooseOrder.setPreferredSize(new Dimension(140,40));
		chooseOrder.setMaximumSize(chooseOrder.getPreferredSize());
		chooseOrderPanel.add(chooseOrder);
		
		//Instruction for the customer to enter the amount of portions to the below text field
		//Added to the instruction panel 2
		JLabel instruction2 = new JLabel("Please enter the number of portions");
		instruction2.setOpaque(false);
		instruction2.setBackground(new Color(249,246,238));
		instructionPanel2.add(instruction2);
		
		//A text field that gets the number of portions from the customer
		//Added to the order quantity panel
		orderQuantity = new JTextField();
		orderQuantity.setPreferredSize(new Dimension(100,40));
		orderQuantity.setMaximumSize(orderQuantity.getPreferredSize());
		orderQuantityPanel.add(orderQuantity);

		//A button that adds the order to the pre order list for the customer
		//Added to the add delete panel
		addButton = new JButton();
		addButton.setText("ADD");
		addButton.setPreferredSize(new Dimension(65,45));
		addButton.setMaximumSize(addButton.getPreferredSize());
		addButton.addActionListener(this);
		addDeletePanel.add(addButton);
		
		//A button that lets the user delete the last order they have added to the pre order list
		//Added to the add delete panel
		deleteButton = new JButton();
		deleteButton.setText("DELETE");
		deleteButton.setPreferredSize(new Dimension(80,45));
		deleteButton.setMaximumSize(deleteButton.getPreferredSize());
		deleteButton.addActionListener(this);
		addDeletePanel.add(deleteButton);

		//A text are that displays the orders in the pre order list
		//Added to the text panel
		orderText = new JTextArea();
		orderText.setPreferredSize(new Dimension(200,250));
		orderText.setMaximumSize(orderText.getPreferredSize());
		orderText.setEditable(false);
		textPanel.add(orderText);

		//A button that adds the items in the pre order list
		//to the customers order list. Added to the order panel
		orderButton = new JButton();
		orderButton.setText("ORDER");
		orderButton.setPreferredSize(new Dimension(100,45));
		orderButton.setMaximumSize(orderButton.getPreferredSize());
		orderButton.addActionListener(this);
		orderPanel.add(orderButton);
		
		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		
		
		/**************************************************************************************
		 **************************************************************************************
		 *******                         End of the Menu Session                          *****
		 **************************************************************************************
		 **************************************************************************************/
		
		//The main panel that is going to be used for both panels
		JPanel customerSessionPanel = new JPanel();
		customerSessionPanel.setLayout(new BoxLayout(customerSessionPanel, BoxLayout.Y_AXIS));
		customerSessionPanel.setPreferredSize(new Dimension(750,3100));
		customerSessionPanel.setBackground(new Color(249,246,238));
		
		//Sets up the frame
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(750,3100);
		this.getContentPane().setBackground(new Color(249,246,238));
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Restaurant Manager");
		this.setIconImage(image.getImage());
		
		//Adds the main panels of the Table session and the Menu 
		//session to the main panel of the frame with a gap
		customerSessionPanel.add(tableMainPanel);
		customerSessionPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		customerSessionPanel.add(mainPanel);
		
		//the panel for Menu session is not visible at first because 
		//the customer has to choose a table before they choose dishes
		mainPanel.setVisible(false);
		
		/*
		 * Checks if there are available tables. If there are no available tables, shows
		 * an error message informing the user that there are no available tables, 
		 * removes the customer from the Manager class' customer list and opens a manager window
		 * with the parameters menu and the tableList.
		 */
		if (this.availableTableList.size() == 0) {
			JOptionPane close = new JOptionPane();
			close.showMessageDialog(null, "There are no available tables!");
			Manager.removeLastCustomer();
			new Manager(menu,tableList);
			dispose();
		}
		
		//Wraps a JScrollPane around the main panel of the frame
		JScrollPane scroll = new JScrollPane(customerSessionPanel);
		
		//adds the main panel of the rame to the frame
		this.add(scroll);
	}
	
	/*
	 * This is the method of the ActionListener interface that determines how each intractable element in
	 * the frame will perform. There are three buttons in this frame, so this method is going to determine 
	 * how each of these three buttons will perform
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*
		 * When the chooseButton is pressed, it informs the customer that they have
		 * selected their table and sets the table occupied so that the next customer 
		 * can not select the table. It sets the table number of the customer to the selected table's number
		 * The Table Session panel is set invisible, and the Menu session panel
		 * is set visible so that the customer can place their order
		 */
		if (e.getSource() == chooseButton) {
			JOptionPane info = new JOptionPane();
			info.showMessageDialog(null, "You have chosen Table " + tableChoise.getSelectedItem() + ". Please scroll down to select dishes.");
			customer.setTableNumber(Integer.parseInt((String) tableChoise.getSelectedItem()));
			for (Table t : availableTableList) {
				if (t.getNumber() == Integer.parseInt((String) tableChoise.getSelectedItem())) {
					customer.setTableNumber(t.getNumber());
					t.occupyTable();
				}
			}
			tableMainPanel.setVisible(false);
			mainPanel.setVisible(true);
		}
		
		/*
		 * When the addButton is pressed, the dish that has the same id as the value selected
		 * in the combo box is found. The value that has been entered to the orderQuantity text area is used 
		 * as a stock value. A new MenuItem object that has the same name,stock value, price and id is 
		 * created and added to the pre order list.If the stock value that has been entered to the text area 
		 * is more than the stock value of the object in the menu, a disclaimer pops up that informs the user the 
		 * maximum number of portions that they can order. The customer then chooses add the order or not. If the customer
		 * chooses to order, the MenuItem object in the menu that the order corresponds to is found and its stock value is decreased
		 * by the portion value of the order. 
		 * If no value has been entered to the text area, an error message pops up to inform the user to enter a value to the text area.
		 * Also, the name of the order and the portions gets added as text to the text field that shows the orders. 
		 */
		else if(e.getSource() == addButton) {
			try {
				for (List<MenuItem> dishList : menu.getDishList()) {
					for (MenuItem m : dishList) {
						if (m.getOwnNum() == Integer.parseInt((String) chooseOrder.getSelectedItem())) {
							if (Integer.parseInt(orderQuantity.getText()) > m.getStock()) {
								JOptionPane info = new JOptionPane();
								int answer = info.showConfirmDialog(null, "There are only " + m.getStock() + " items left in stock. Would you like to add that much to your order?", "Order Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
								if (answer == 0) {
									MenuItem newMenuItem = new MenuItem(m.getName(), m.getStock(), m.getPrice(), m.getOwnNum());
									preOrderList.add(newMenuItem);
									m.decreaseStock(m.getStock());
								}
								else {
									return;
								}
							}
							else {
								MenuItem newMenuItem = new MenuItem(m.getName(),Integer.parseInt(orderQuantity.getText()),m.getPrice(), m.getOwnNum());
								preOrderList.add(newMenuItem);
								m.decreaseStock(newMenuItem.getStock());
							}
						}
					}
				}
			}
			catch(RuntimeException r) {
				JOptionPane error = new JOptionPane();
				error.showMessageDialog(null, "Please enter an integer value.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String orders = "";
			for (MenuItem m: preOrderList) {
				orders += String.format("%s  %s%n", m.getName(), m.getStock());
			}
			orderText.setText(orders);
		}
		
		/*
		 * When the delete button is pressed, the most recent MenuItem in the pre-order list is deleted. It is first
		 * iterated over the menu and the MenuItem object that has the same id as the most recent object is found. Then, the 
		 * stock of the object in the menu is increased by the portion value of the most recent item, and the most recent item is
		 * removed from the pre order list. Finally, the text that shows the order of the customer is updated to show 
		 * the current pre order list.
		 */
		else if (e.getSource() == deleteButton) {
			try {
				boolean foundFlag = false;
				for (List<MenuItem> dishList : menu.getDishList()) {
					for (MenuItem m: dishList) {
						if (m.getOwnNum() == preOrderList.get(preOrderList.size() - 1).getOwnNum()) {
							m.decreaseStock(-(preOrderList.get(preOrderList.size() - 1).getStock()));
							preOrderList.remove(preOrderList.size() - 1);
							foundFlag = true;
							break;
						}
					}
					if(foundFlag) {
						break;
					}
				}
				String orders = "";
				for (MenuItem m: preOrderList) {
					orders += String.format("%s  %s%n", m.getName(), m.getStock());
				}
				orderText.setText(orders);
			}
			catch(RuntimeException r) {
				JOptionPane error = new JOptionPane();
				error.showMessageDialog(null, "Please order first.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		/*
		 * When the orderButton is pressed, the total price of the objects in the pre order list is calculated.
		 * The customer is shown the total price, and asked whether or not they approve of the order. If the answer is no
		 * then returns to the Menu Session. If the answer is yes. The objects in the pre order list is added to the order list 
		 * of the customer. Then, it is iterated over the order list, decided which subclass of the MenuItem class the object belongs to
		 * and then the order count of that class is increased by the number of portions of the order. Finally, a new Manager window with the parameters
		 * menu and table list is created so that the restaurant can register new customers.  
		 */
		else if (e.getSource() == orderButton) {		
			JOptionPane info = new JOptionPane();
			int totalPrice = 0;
			for (MenuItem m : preOrderList) {
				totalPrice += m.getPrice() * m.getStock(); 
			}
			int answer = info.showConfirmDialog(null, "Are you sure of the order? Total price: " + totalPrice, "Order Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
			if (answer == 0) {
				customer.setOrderList(preOrderList);
				for (MenuItem order : customer.getOrderList()) {
					if (10 < order.getOwnNum() && order.getOwnNum() <= 15) {
						Salad.increaseOrderCount(order.getStock());
					}
					else if (0 < order.getOwnNum() && order.getOwnNum() <= 5) {
						Soup.increaseOrderCount(order.getStock());
					}
					else if (30 < order.getOwnNum() && order.getOwnNum() <= 35) {
						NonAlcoholicDrink.increaseOrderCount(order.getStock());
					}
					else if (35 < order.getOwnNum() && order.getOwnNum() <= 42) {
						MainDish.increaseOrderCount(order.getStock());
					}
					else if (25 < order.getOwnNum() && order.getOwnNum() <= 30) {
						Drink.increaseOrderCount(order.getStock());
					}
					else if (20 < order.getOwnNum() && order.getOwnNum() <= 25) {
						Dessert.increaseOrderCount(order.getStock());
					}
					else if (15 < order.getOwnNum() && order.getOwnNum() <= 20) {
						Condiment.increaseOrderCount(order.getStock());
					}
					else if (5 < order.getOwnNum() && order.getOwnNum() <= 10) {
						Appetizer.increaseOrderCount(order.getStock());
					}
					Manager.increaseTotalSales(order.getPrice()*order.getStock());
				}
				new Manager(menu,tableList);
				dispose();
			}
			else if (answer == 1 || answer == 2) {
				return;
			}
		}
	}
}
