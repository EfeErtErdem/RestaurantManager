package Restaurant;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Menu.*;
/*
 * This class is an extension of the JFrame class. It is supposed the represent the 
 * frame that the management will use to register the customers and show that stats.
 * The management can register customers form this frame and see how many of each MenuItem is in stock 
 * and how many of the MenuItem types have been sold.
 */
public class Manager extends JFrame implements ActionListener{
	/*
	 * A tableList that is a list of all the tables in the restaurant
	 * A menu that holds all of the MenuItem objects of the restaurant
	 * A customerList that holds all of the customers currently registered at the restaurant
	 * A double totalSales that holds the value of the total sales of this session 
	 * A button registerButton that when clicked, registers the customers
	 * A button deleteButton that when clicked, deletes a customer 
	 * Four JTextField objects that makes it possible to take input for the registration of the customers.
	 * 			The customerName text field takes in the name of the customer
	 * 			The customerAghe text field takes in the age of the customer
	 * 			The customerCount text field takes in how many people are in the customer group
	 * 			The customerId text field that takes in the id of teh customer 
	 * Four JTextArea objects that displays information about the restaurant
	 * 			The customerListText text area shows the currently registered customers with their ages and 
	 * 					the total cost of their orders
	 * 			The tableText text area shows which table is assigned to which customer
	 * 			The stockInfoText text area displays how many of each MenuItem objects are left in stock
	 * 			The orderInfoText text area shows how many of each MenuItem types have been sold 
	 */
	private List<Table> tableList;
	private Menu menu; 
	private static List<Customer> customerList = new LinkedList<>();
	private static double totalSales = 0;
	private JButton registerButton;
	private JButton deleteButton;
	private JTextField customerName;
	private JTextField customerAge;
	private JTextField customerCount;
	private JTextField customerId;
	private JTextArea customerListText;
	private JTextArea tableText;
	private JTextArea stockInfoText;
	private JTextArea orderInfoText;
	/*
	 * The constructor takes two arguments: a menu and a table list sets the menu and 
	 * the tableList fields of the objects to these parameters, respectively. It also sets up the frame 
	 * for the management window.
	 */
	public Manager(Menu m, List<Table> tableList) {
		
		this.menu = m;
		this.tableList = tableList;
		
		// This is the icon image of the frame
		ImageIcon image = new ImageIcon("logo.jpg");
		
		//This is the main panel of the frame. All other components 
		//are placed in this panel
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(800,4500));
		mainPanel.setBackground(new Color(249,246,238));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		//This is the panel that contains the header "Management Window"
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(249,246,238));
		headerPanel.setPreferredSize(new Dimension(500,150));
		headerPanel.setMaximumSize(headerPanel.getPreferredSize());
		
		//This is the panel that holds the registration info.
		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(new Color(249,246,238));
		registerPanel.setPreferredSize(new Dimension(700,50));
		registerPanel.setMaximumSize(registerPanel.getPreferredSize());
		
		//This is the panel that contains the three input text fields for registrations
		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(new Color(249,246,238));
		inputPanel.setPreferredSize(new Dimension(500,50));
		inputPanel.setMaximumSize(inputPanel.getPreferredSize());
		
		//This is the registration button
		JPanel registerButtonPanel = new JPanel();
		registerButtonPanel.setBackground(new Color(249,246,238));
		registerButtonPanel.setPreferredSize(new Dimension(500,200));
		registerButtonPanel.setMaximumSize(registerPanel.getPreferredSize());
		
		//This is the text field that takes the name of the customer
		customerName = new JTextField();
		customerName.setPreferredSize(new Dimension(100,40));
		customerName.setMaximumSize(customerName.getPreferredSize());
		inputPanel.add(customerName);
		
		//This is the text field that takes the age of the customer
		customerAge = new JTextField();
		customerAge.setPreferredSize(new Dimension(100,40));
		customerAge.setMaximumSize(customerName.getPreferredSize());
		inputPanel.add(customerAge);
		
		//This is the text field that takes how many people are in the customer group
		customerCount = new JTextField();
		customerCount.setPreferredSize(new Dimension(100,40));
		customerCount.setMaximumSize(customerCount.getPreferredSize());
		inputPanel.add(customerCount);
		
		//This is the registration button. The button is added to the frame 
		registerButton = new JButton();
		registerButton.setText("REGISTER");
		registerButton.setPreferredSize(new Dimension(100,45));
		registerButton.setMaximumSize(registerButton.getPreferredSize());
		registerButton.addActionListener(this);
		registerButtonPanel.add(registerButton);
		
		//This is the panel that holds the deletion info.
		JPanel deletePanel = new JPanel();
		deletePanel.setBackground(new Color(249,246,238));
		deletePanel.setPreferredSize(new Dimension(700,50));
		deletePanel.setMaximumSize(deletePanel.getPreferredSize());
		
		//This is the panel that contains the customerId text field
		JPanel deleteInputPanel = new JPanel();
		deleteInputPanel.setBackground(new Color(249,246,238));
		deleteInputPanel.setPreferredSize(new Dimension(500,50));
		deleteInputPanel.setMaximumSize(deleteInputPanel.getPreferredSize());
		
		//This is the deletion button. The button is added to the panel 
		deleteButton = new JButton();
		deleteButton.setText("DELETE");
		deleteButton.setPreferredSize(new Dimension(100,45));
		deleteButton.setMaximumSize(deleteButton.getPreferredSize());
		deleteButton.addActionListener(this);
		deleteInputPanel.add(deleteButton);
		
		//This is the text field that takes the id of the customer
		customerId = new JTextField();
		customerId.setPreferredSize(new Dimension(100,40));
		customerId.setMaximumSize(customerId.getPreferredSize());
		deleteInputPanel.add(customerId);
		
		//This panel holds the text field that shows the info about the registered customers
		JPanel customerListPanel = new JPanel();
		customerListPanel.setBackground(new Color(249,246,238));
		customerListPanel.setPreferredSize(new Dimension(500,550));
		customerListPanel.setMaximumSize(customerListPanel.getPreferredSize());
		
		//This is the text area that shows the info about the customers
		customerListText = new JTextArea();
		customerListText.setPreferredSize(new Dimension(500,400));
		customerListText.setMaximumSize(customerListText.getPreferredSize());
		customerListText.setEditable(false);
		customerListText.setFont(new Font("Lato",Font.BOLD, 20));
		
		//This is the text that shows the customer info
		String customerText = "CUSTOMER LIST: \n\n";
		
		//The customer list can be sorted because the Customer class implements the Comparable generic interface
		customerList.sort(null);
		
		//Adds to the text the relevant info about customers
		for (Customer c : customerList) {
			customerText += String.format("(%d) %s --- %d --- %.2f%n",c.getNumber(), c.getName(),c.getAge(), c.getTotalPriceOfOrder());
		}
		
		//Adds the text to the customerText text area and adds the customerText to the customerListPanel
		customerListText.setText(customerText);
		customerListPanel.add(customerListText);
		
		//This panel holds the text field that shows the info about tables
		JPanel tablePanel = new JPanel();
		tablePanel.setBackground(new Color(249,246,238));
		tablePanel.setPreferredSize(new Dimension(500,550));
		tablePanel.setMaximumSize(tablePanel.getPreferredSize());
				
		//This is the text area that shows the info about tables
		tableText = new JTextArea();
		tableText.setPreferredSize(new Dimension(500,400));
		tableText.setMaximumSize(tableText.getPreferredSize());
		tableText.setEditable(false);
		tableText.setFont(new Font("Lato",Font.BOLD, 20));
				
		//This string dislays the tanle number of customers
		String tables = "TABLE INFORMATION: \n";
		for (Customer c : Manager.customerList) {
			tables += String.format("Customer id : %d ----> Table number %d%n",c.getNumber(),c.getTableNumber());
		}
				
		//Adds the text to the relevant text are and add the text area to the relevant panel
		tableText.setText(tables);
		tablePanel.add(tableText);
		
		//This is the panel that contains the elements showing info
		//about stocks
		JPanel stockInfoPanel = new JPanel();
		stockInfoPanel.setBackground(new Color(249,246,238));
		stockInfoPanel.setPreferredSize(new Dimension(500,2300));
		stockInfoPanel.setMaximumSize(stockInfoPanel.getPreferredSize());
		
		//This is the text area that contains the text that shows info
		//about stocks
		stockInfoText = new JTextArea();
		stockInfoText.setPreferredSize(new Dimension(500,2300));
		stockInfoText.setMaximumSize(customerListText.getPreferredSize());
		stockInfoText.setEditable(false);
		stockInfoText.setFont(new Font("Lato",Font.BOLD, 20));
		
		//Iterates over all of the items in the menu and adds the MenuItem name and the stock
		//info to the text
		String stockText = "STOCK INFO:  \n\n";
		for (List<MenuItem> dishType : this.menu.getDishList()) {
			for (MenuItem item : dishType) {
				stockText += String.format("%s : .... %d%n------------------------------------------------------%n",item.getName(), item.getStock());
			}
		}
		
		//Adds the text to the stockInfoText text area and adds the text area
		//to the stockInfoPanel panel
		stockInfoText.setText(stockText);
		stockInfoPanel.add(stockInfoText);
		
		//This is the panel that holds the elements showing the 
		//info about the orders of the customer
		JPanel orderInfoPanel = new JPanel();
		orderInfoPanel.setBackground(new Color(249,246,238));
		orderInfoPanel.setPreferredSize(new Dimension(500,700));
		orderInfoPanel.setMaximumSize(orderInfoPanel.getPreferredSize());
		
		//This is the text area that holds info about the 
		//orders of the customers and the total sales of the session
		orderInfoText = new JTextArea();
		orderInfoText.setPreferredSize(new Dimension(500,700));
		orderInfoText.setMaximumSize(customerListText.getPreferredSize());
		orderInfoText.setEditable(false);
		orderInfoText.setFont(new Font("Lato",Font.BOLD, 20));
		
		//This string holds the info how many times each of the MenuItem types have been ordered.
		//It looks at each one of the subclasses of the MenuItem class and uses the static orderCount field of them
		String orderText = String.format("ORDER INFO:  %n%n%s : ... %d%n------------------------------------------------------%n%s : ... %d%n------------------------------------------------------%n%s : ... %d%n------------------------------------------------------%n%s : ... %d%n------------------------------------------------------%n%s : ... %d%n------------------------------------------------------%n%s : ... %d%n------------------------------------------------------%n%s : ... %d%n------------------------------------------------------%n%s : ... %d%n------------------------------------------------------%n", "Appetizer", Appetizer.getOrderCount(), "Condiment", Condiment.getOrderCount(), "Dessert", Dessert.getOrderCount(), "Drink", Drink.getOrderCount(), "Main Dish", MainDish.getOrderCount(), "Non-Alcoholic Drink", NonAlcoholicDrink.getOrderCount(), "Salad", Salad.getOrderCount(), "Soup", Soup.getOrderCount());
		
		//This string represents the total of the sales of this session
		String totalSalesText = String.format("%n%n*************************%n* TOTAL SALES: %.2f*%n*************************", Manager.totalSales);
		
		//Adds the texts to the orderInfotext text area and adds the text area to the orderInfoPanel
		orderInfoText.setText(orderText + totalSalesText);
		orderInfoPanel.add(orderInfoText);
		
		//This is the header for the frame. The header is added to the frame
		JLabel header = new JLabel("MANAGEMENT WINDOW");
		header.setFont(new Font("Franklin Gothic",Font.BOLD, 30));
		header.setBackground(new Color(249,246,238));
		header.setOpaque(true);
		headerPanel.add(header);
		
		//This is the information on how to register customers. The info is added to the panel
		JLabel warning = new JLabel("*Use the below button to register customers. Enter the name, age and the customer count.");
		warning.setFont(new Font("Lato",Font.BOLD, 16));
		warning.setBackground(new Color(249,246,238));
		warning.setOpaque(true);
		registerPanel.add(warning);
		
		//This is the information on how to delete. The info is added to the panel
		JLabel deleteWarning = new JLabel("*Use the below button to delete customers. Enter the id of the customer");
		deleteWarning.setFont(new Font("Lato",Font.BOLD, 16));
		deleteWarning.setBackground(new Color(249,246,238));
		deleteWarning.setOpaque(true);
		deletePanel.add(deleteWarning);
		
		//Sets up the frame
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,4500);
		this.getContentPane().setBackground(new Color(249,246,238));
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Restaurant Manager");
		this.setIconImage(image.getImage());
		this.add(mainPanel);
		
		//Adds all of the panels that hold the elements to the main panel
		mainPanel.add(headerPanel);
		mainPanel.add(registerPanel);
		mainPanel.add(inputPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		mainPanel.add(registerButtonPanel);
		mainPanel.add(deletePanel);
		mainPanel.add(deleteInputPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		mainPanel.add(customerListPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		mainPanel.add(tablePanel);
		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		mainPanel.add(stockInfoPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		mainPanel.add(orderInfoPanel);
		
		//Wraps a scrollable panel around the main panel
		JScrollPane scroll = new JScrollPane(mainPanel);
		
		//Adds the main panel to the frame
		this.add(scroll);

		this.pack();
		
	}
	
	/*
	 * This is the method of the ActionListener interface that determines how each intractable element in
	 * the frame will perform. There is one button in this frame, so this method is going to determine 
	 * how this button will perform
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * If the register button is clicked, takes the values that have been entered to the three text fields and 
		 * creates a new customer object with the values as the parameters. Then adds the new customer object to the customer list.
		 * Then creates a new Customer Session window, passes the customer, menu and the table list to it and closes the management window.
		 *  If one or more of the parameters are null or 
		 * basically entered with the wrong format, displays a dialogue box that displays a warning to enter correct 
		 * values and returns to the management window.
		 */
		if (e.getSource() == registerButton) {
			try {
				Customer newCustomer = new Customer(customerName.getText(), Integer.valueOf(customerAge.getText()),Integer.valueOf(customerCount.getText()));
				dispose();
				customerList.add(newCustomer);
				new CustomerSession(newCustomer, menu, tableList);
			}
			catch(RuntimeException r) {
				JOptionPane error = new JOptionPane();
				error.showMessageDialog(null, "Please enter an integer value.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		/*
		 * If the delete button is clicked, iterates over the customer list of the session. When it finds the customer with
		 * the same id as the value entered to the customerId text area, it unoccupies the table of that customer and deletes 
		 * the customer from the customer list. Finally, it updates the customer text field and the table text field.
		 */
		else if (e.getSource() == deleteButton) {
			try {
				Iterator<Customer> it = Manager.customerList.iterator();
				while (it.hasNext()) {
					Customer c = it.next();
					if (c.getNumber() == Integer.parseInt(customerId.getText())) {
						for (Table t : tableList) {
							if (t.getNumber() == c.getTableNumber()) {
								t.unoccupyTable();
							}
						}
						it.remove();
					}
				}
				String customerText = "CUSTOMER LIST: \n\n";
				customerList.sort(null);
				for (Customer c : customerList) {
					customerText += String.format("(%d) %s --- %d --- %.2f%n",c.getNumber(), c.getName(),c.getAge(), c.getTotalPriceOfOrder());
				}
				customerListText.setText(customerText);
				String tables = "TABLE INFORMATION: \n";
				for (Customer c : Manager.customerList) {
					tables += String.format("Customer id : %d ----> Table number %d%n",c.getNumber(),c.getTableNumber());
				}
				tableText.setText(tables);
			}
			catch(RuntimeException r) {
				JOptionPane error = new JOptionPane();
				error.showMessageDialog(null, "Please enter a valid value for id.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	}
	
	/*
	 * Removes the last customer object from the customer list 
	 */
	public static void removeLastCustomer() {
		customerList.remove(customerList.size() - 1);
	}
	/*
	 * Increases the total sales by the parameter sale
	 * 
	 * @param  sale  A double that the total sales of this session is increased by
	 */
	public static void increaseTotalSales(double sale) {
		totalSales += sale;
	}
}
