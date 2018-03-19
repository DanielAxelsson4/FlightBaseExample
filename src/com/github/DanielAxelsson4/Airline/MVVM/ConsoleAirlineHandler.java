package com.github.DanielAxelsson4.Airline.MVVM;


import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.github.DanielAxelsson4.Airline.Exceptions.AirlineAlreadyExistsException;
import com.github.DanielAxelsson4.Airline.Exceptions.AirlineIsFullException;
import com.github.DanielAxelsson4.Airline.Exceptions.AirlineNotFoundException;
import com.github.DanielAxelsson4.Airline.Exceptions.PassengerNotFoundException;
import com.github.DanielAxelsson4.Airline.Models.Airline;
import com.github.DanielAxelsson4.Airline.Models.Passenger;
import com.github.DanielAxelsson4.Airline.UI.Main;



public class ConsoleAirlineHandler extends AirlineHandler {

	protected String registrationNumber = null;
	protected int capacity = 0;

	protected String name = null;
	protected String email = null;
	protected String adress = null;


	protected Integer power = null;
	protected String airlineName = null;
	protected String theAirlineName = null;
	protected String garageType = null;
	protected Passenger passenger = null;
	protected Airline airline = null;
	protected Main menu = new Main();

	public ConsoleAirlineHandler() {
	}

	/**
	 * Prompts the user for inputs and adds an airline
	 */

	public void addAirline()
	{
		try
		{
			theAirlineName = JOptionPane.showInputDialog("What's the name of the airline?");
			capacity = 10 - 1;
			if (theAirlineName == null || capacity < 0) {
				throw new NumberFormatException();
			}
			Airline airline = super.createAirline(theAirlineName, capacity);
			super.addAirline(theAirlineName, airline);

		}
		catch(AirlineAlreadyExistsException e)
		{
			System.out.println("airline already exists");
		}
		catch(NumberFormatException e)
		{
			System.out.println("Please input a correct value");
			return;
		}
	}
	/**
	 * Prompts the user for inputs and removes an airline
	 */
	public void removeAirline()
	{
		try
		{
			theAirlineName = JOptionPane.showInputDialog("What's the name of the airline you want to remove?");
			if (theAirlineName == null || capacity < 0) {
				throw new NumberFormatException();
			}
			super.removeAirline(theAirlineName);
		}
		catch(AirlineNotFoundException e)
		{
			System.out.println("\n" +  "The airline was not found \n");
			return;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Please input a correct value");
			return;
		}
	}
	/**
	 * Lists all airlines
	 */
	@Override
	public void listAirline()
	{
		System.out.println("\n" +  "Now viewing all airlines: \n ");
		super.listAirline();
	}
	/**
	 * Prompts the user for inputs and lists all passengers in specified airline
	 */
	public void listPassengers()
	{
		try {
			theAirlineName = JOptionPane.showInputDialog("\n" + "What is the name of the airline you would you like to view?");
			airline = super.findAirline(theAirlineName);
			System.out.println("\n" + "Now viewing airline: "  + theAirlineName + "\n");
			super.viewAirline(airline);
		}
		catch (AirlineNotFoundException e) {
			System.out.println("\n" +  "The airline was not found \n");
			return;
		}

	}
	/**
	 * Lists all passengers in all airlines
	 */
	@Override
	public void listAllVehicles()
	{
		System.out.println("\n" + "Now viewing all passengers: \n");
		super.listAllVehicles();
	}
	/**
	 * Prompts the user for inputs and lists the passenger with specified name
	 */
	public void listSpecificPassenger()
	{
		try
		{
			registrationNumber = JOptionPane.showInputDialog("What's the name of the passenger you would like to find?");
			super.listSpecificPassenger(registrationNumber);
		}
		catch(PassengerNotFoundException e)
		{
			System.out.println("\n" + "Passenger not found! \n");
			return;
		}
	}
	/**
	 * Prompts the user for inputs and removes the passenger with the specified name
	 */
	public void removeSpecificPassenger()
	{
		try
		{
			registrationNumber = JOptionPane.showInputDialog("What's the name of the passenger you would like to remove?");
			super.removeSpecificVehicle(registrationNumber);
		}
		catch(PassengerNotFoundException e)
		{
			System.out.println("\n" + "Passenger is not booked \n");
			return;
		}
	}

	/**
	 * Prompts the user for inputs and creates reserves a seat
	 */
	public void reserveSeat()
	{
		try {

			JTextField name = new JTextField();
			JTextField email = new JTextField();
			JTextField adress = new JTextField();
			JTextField theAirlineName = new JTextField();
			JTextField seat = new JTextField();
			String[] currentClass={"Business","Economy"};
		    JComboBox jcd = new JComboBox(currentClass);




			Object[] message = {
				    "Name:", name,
				    "Email:", email,
				    "Adress:", adress,
				    "Airline:", theAirlineName,
				    "Seat:", seat,
				    "Class", jcd
				};
			if(name.getText() == null || email.getText() == null || adress.getText() == null)
			{
				throw new NullPointerException();
			}
		//	int option = new JOptionPane().showConfirmDialog(null, message, "Seat", JOptionPane.OK_CANCEL_OPTION);
			int option = JOptionPane.showConfirmDialog(null, message, "Reserve seat", JOptionPane.OK_CANCEL_OPTION);
			passenger = new Passenger(name.getText(), email.getText(), adress.getText(), jcd.getSelectedItem().toString());

			super.reserveSeat(passenger, theAirlineName.getText());
		}
		catch(NumberFormatException e)
		{
			System.out.println("\n" + "Please input a correct value \n");
			return;
		}
		catch (AirlineIsFullException e)
		{
			System.out.println("\n" +  "The garage is full \n ");
			return;
		}
		catch (NullPointerException e)
		{
			System.out.println("\n" + "Please input a correct value \n");
			return;
		}
		catch (AirlineNotFoundException e)
		{
			System.out.println("\n" + "Airline was not found \n");
			return;
		}
	}

	public void addFood() {
		JTextField username = new JTextField();
		JTextField password = new JTextField();
		Object[] message = {
		    "Username:", username,
		    "Password:", password
		};

		int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
		    if (username.getText().equals("h") && password.getText().equals("h")) {
		        System.out.println("Login successful");
		    } else {
		        System.out.println("login failed");
		    }
		} else {
		    System.out.println("Login canceled");
		}

	}

























}
