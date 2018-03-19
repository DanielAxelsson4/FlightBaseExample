
package com.github.DanielAxelsson4.Airline.UI;

import javax.swing.JOptionPane;

import com.github.DanielAxelsson4.Airline.MVVM.ConsoleAirlineHandler;



public class Main {

	static ConsoleAirlineHandler conAirHandler = new ConsoleAirlineHandler();
	static int response = 0;
	static String[] options = null;
	boolean choice = true;


	/**
	 * Main method that instantiate menu and calls the main menu.
	 * @param args
	 */

	public static void main(String[] args)
	{
		Main menu = new Main();
		menu.callMainMenu();
	}

	/**
	 * Main menu method
	 */
	public void callMainMenu()
	{
		String[] options = new String[] {"Airline menu", "Reservation menu", "Food menu", "Close"};
		while(choice = true) {

			response = JOptionPane.showOptionDialog(null, "What would menu would you like to enter", "Main menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, options, options[0]);

			switch (response) {
			// Open airline menu
			case 0: callAirlineMenu();
			break;
			// Open reservation menu
			case 1: callReservationMenu();
			break;
			// Exit application
			case 2: callFoodMenu();
			break;
			case 3: return;
			}
		}


	}


	public void callFoodMenu() {
		conAirHandler.addFood();

	}

	/**
	 * Airline menu method
	 */
	public void callAirlineMenu()
	{
		options = new String[] {"Add airline", "Remove airline", "List airline", "Go to main menu"};
		while(choice = true) {

			response = JOptionPane.showOptionDialog(null, "What would you like to do", "Airline menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, options, options[0]);

			switch (response) {
			// Add airline
			case 0: conAirHandler.addAirline();
			break;
			// Remove airline
			case 1: conAirHandler.removeAirline();
			break;
			// List airline
			case 2: conAirHandler.listAirline();
			break;
			// Back to main menu
			case 3:	return;

			}
		}
	}

	/**
	 * Reservation menu method
	 */
	public void callReservationMenu()
	{
		options = new String[] {"Reserve seat", "Remove seat", "List all seated passengers", "List reserved passanger in specific airline", "List passenger with ID", "Go back"};

		while(choice = true) {


			response = JOptionPane.showOptionDialog(null, "What would you like to do?", "Vehicle menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, options, options[0]);

			switch (response) {
			// Calls the reserve method
			case 0: conAirHandler.reserveSeat();
			break;
			// Remove specific passenger
			case 1: conAirHandler.removeSpecificPassenger();
			break;
			// Lists all passengers
			case 2: conAirHandler.listAllVehicles();
			break;
			// Lists passenger in specified airline
			case 3:	conAirHandler.listPassengers();
			break;
			// List specific passenger
			case 4:	conAirHandler.listSpecificPassenger();
			break;
			// Back to main menu
			case 5:	return;
			}
		}
	}




















	}



