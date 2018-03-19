package com.github.DanielAxelsson4.Airline.MVVM;


import java.util.ArrayList;

import com.github.DanielAxelsson4.Airline.Exceptions.AirlineAlreadyExistsException;
import com.github.DanielAxelsson4.Airline.Exceptions.AirlineIsFullException;
import com.github.DanielAxelsson4.Airline.Exceptions.AirlineNotFoundException;
import com.github.DanielAxelsson4.Airline.Exceptions.PassengerNotFoundException;
import com.github.DanielAxelsson4.Airline.Models.Airline;
import com.github.DanielAxelsson4.Airline.Models.Passenger;



public abstract class AirlineHandler {

	protected Airline airline;
//	private ConcurrentSkipListMap<String, Airline> airlineList = new ConcurrentSkipListMap<String, Airline>(String.CASE_INSENSITIVE_ORDER);

	// collection av Airlines
	ArrayList<Airline> airlineList2 = new ArrayList<Airline>();


	protected Passenger passenger;
	private boolean exists;

	public AirlineHandler()
	{
		super();
		//this.airlineList = new ConcurrentSkipListMap<String, Airline>(String.CASE_INSENSITIVE_ORDER);
		this.airlineList2 = new ArrayList<Airline>();

	}
	/**
	 * Creates and returns an airline
	 */
	public Airline createAirline(String theAirlineName, int capacity)
	{
		airline = new Airline(theAirlineName, capacity);
		return airline;
	}

	public void addAirline(String airlineName, Airline airline) throws AirlineAlreadyExistsException
	{

		if(airlineList2.contains(airline))
		{
			throw new AirlineAlreadyExistsException();
		}else {
			airlineList2.add(airline);
			System.out.println("\n" + "Airline " + airlineName + " was added \n");

		}

		/*

		if(airlineList.containsKey(garageName))
		{
			throw new GarageAlreadyExistsException();
		}else {
			airlineList.put(garageName, garage);
			System.out.println("\n" + "Garage " + garageName + " was added \n");

		}*/
	}

	public void removeAirline(String airlineName) throws AirlineNotFoundException
	{
		for(Airline airline : this.airlineList2)
		{
			if(airline.getAirlineName().equalsIgnoreCase(airlineName))
			{
				airlineList2.remove(airline);
				System.out.println("Airline " + airlineName + " was removed");
				return;
			}
		}
	}
	public void listAirline()
	{
		for(Airline airline : this.airlineList2)
		{
			System.out.println(airline.toString() );
		}
	}

	/**
	 * Prints all passengers in the specified airline
	 */
	public void viewAirline(Airline airlineName) throws AirlineNotFoundException
	{
		airline.listPassenger(airline.getPassengerMap());

	}
	/**
	 * Searches the collection of airlines and returns the airline with the specified airlineName and returns the airline
	 */
	public Airline findAirline(String airlineName) throws AirlineNotFoundException
	{
		for(Airline airline : this.airlineList2)
		{
			if(airline.getAirlineName().equalsIgnoreCase(airlineName))
				return airline;
		}
		throw new AirlineNotFoundException();
	}
	/**
	 * Searches the collection of airlines for an airline not over capacity and with the specified airlineName and returns the airline
	 */
	public Airline findAirlineWithinSize(String airlineName) throws AirlineNotFoundException, AirlineIsFullException
	{
		for(Airline airline : this.airlineList2)
		{
			if(airline.getPassengerMap().size() <= airline.getCapacity() && airline.getAirlineName().equalsIgnoreCase(airlineName))
			{
				return airline;
			}
		}
		if (findAirline(airlineName) == null) {
			throw new AirlineNotFoundException();
		}
		else
		{
			throw new AirlineIsFullException();
		}


	}


	/**
	 * Find the airline and reserve a seat to the collection of passengers
	 */
	public void reserveSeat(Passenger passenger, String airlineName) throws AirlineNotFoundException, AirlineIsFullException
	{
		airline = findAirlineWithinSize(airlineName);
		airline.addPassenger(passenger.getID(), passenger);
	}
	/**
	 * Find the airline and remove the passenger from the collection of passengers
	 */
	public void removeVehicle(Passenger vehicle, String garageName) throws AirlineNotFoundException
	{
		Airline airline = findAirline(garageName);
		airline.removePassenger(vehicle);
	}
	/**
	 * Go inside each airline and call the listPassengers method
	 */
	public void listAllVehicles()
	{

		for(Airline airline : this.airlineList2)
		{
			airline.listPassenger(airline.getPassengerMap());
		}
	}
	/**
	 * Find specific passenger
	 */
	public Passenger findSpecificVehicle(String registerNumber) throws PassengerNotFoundException
	{
		for(Airline airline : this.airlineList2)
		{
			passenger = airline.findPassenger(registerNumber);
			return passenger;
		}
		return null;
	}
	/**
	 * Go inside each airline and see if it contains a passenger with the specified name and print it
	 */
	public void listSpecificPassenger(String ID) throws PassengerNotFoundException
	{
		exists = false;

		for(Airline airline : this.airlineList2)
		{
			if (airline.getPassengerMap().containsKey(ID))
			{
				exists = true;
				airline.listSpecificPassenger(ID);
			}
		}
		if (!exists)
		{
			throw new PassengerNotFoundException();
		}
	}
	/**
	 * Go inside each airline and see if it contains a passenger with the specified name and remove it
	 */
	public void removeSpecificVehicle(String ID) throws PassengerNotFoundException
	{
		exists = false;

		// TODO: Fix so this works with an arraylist instead of a map

		for(Airline airline : this.airlineList2)
		{
			if (airline.getPassengerMap().containsKey(ID))
			{
				exists = true;
				airline.removeSpecificPassenger(ID);
			}
		}
		if (!exists)
		{
			throw new PassengerNotFoundException();
		}

	}

	public ArrayList<Airline> getNotFullAirlineList()
	{
		return this.airlineList2;
	}


}
