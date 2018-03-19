
package com.github.DanielAxelsson4.Airline.Models;

import java.util.concurrent.ConcurrentSkipListMap;

import com.github.DanielAxelsson4.Airline.Exceptions.PassengerNotFoundException;



public class Airline {

	protected String airlineName;
	private ConcurrentSkipListMap<String, Passenger> passengerMap;
	//private ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
	protected int capacity;
	public boolean exists;




	public Airline(String airlineName, int capacity)
	{
		this.airlineName = airlineName;
		this.capacity = capacity;
		passengerMap = new ConcurrentSkipListMap<String, Passenger>(String.CASE_INSENSITIVE_ORDER);
		//passengerList = new ArrayList<Passenger>();
	}

	public void addPassenger(String registragtionNumber, Passenger newPassenger )
	{
	//	passengerList.add(newPassenger);
	//	passengerList.set(Integer.parseInt(registragtionNumber), newPassenger);



		passengerMap.put(newPassenger.getID(), newPassenger);
		System.out.println("\n" + "Passenger has a reserved seat! \n ");
	}


	public void removePassenger(Passenger newPassenger )
	{
		/*if (passengerList.contains(newPassenger)) {
			passengerList.remove(newPassenger);
		}*/


		if (passengerMap.containsKey(newPassenger.getID())){
			passengerMap.remove(newPassenger.getID());
		}
	}

	public void listPassenger(ConcurrentSkipListMap<String,Passenger> concurrentSkipListMap)
	{


		for (Passenger nextPassenger : concurrentSkipListMap.values() ) {
			System.out.println(nextPassenger.toString() );
		}
	}
	/**
	 * See if a passenger with the specified ID exists in the collection and call it's toString method
	 */
	public void listSpecificPassenger(String seat)
	{
		if(passengerMap.containsKey(seat)) {
			for (Passenger nextPassenger : passengerMap.values() ) {
				if(nextPassenger.getID().equals(seat))
				{
					exists = true;
					System.out.println("\n" + "Passenger Found! \n");
					System.out.println(nextPassenger.toString() );
				}
			}
		}
		else {
			exists = false;
		}
	}
	/**
	 * See if a vehicle with the specified registerNumber exists in the collection and remove it from the collection
	 */
	public void removeSpecificPassenger(String ID)
	{
		for (Passenger nextPassenger : passengerMap.values() ) {
			if(nextPassenger.getID().equals(ID))
			{
				passengerMap.remove(ID);
				System.out.println("\n" + "Passenger removed! \n");
			}
		}
	}
	/**
	 * Go inside the collection and returns the vehicle with the specified registerNumber
	 */
	public Passenger findPassenger(String ID) throws PassengerNotFoundException
	{
		for(Passenger passenger : passengerMap.values())
		{
			if(passenger.getID().equalsIgnoreCase(ID))
			{
				return passenger;
			}
			else
				throw new PassengerNotFoundException();
		}
		return null;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("-------- " + "Airline" + " ---------\n");
		sb.append("Name: ");
		sb.append(this.airlineName);
		sb.append("\n");
		sb.append("Amount of Passengers: ");
		sb.append(this.getPassengerMap().size());
		sb.append("\n");
		sb.append("Capacity: ");
		sb.append(capacity + 1);
		return sb.toString();
	}

	public String getAirlineName()
	{
		return airlineName;
	}

	public int getCapacity()
	{
		return capacity;
	}

	public ConcurrentSkipListMap<String,Passenger> getPassengerMap()
	{
		return passengerMap;
	}

	protected int getNumberOfVehicles() {
		return passengerMap.size();
	}












}


