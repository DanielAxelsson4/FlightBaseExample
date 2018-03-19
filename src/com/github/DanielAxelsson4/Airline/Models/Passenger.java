package com.github.DanielAxelsson4.Airline.Models;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class description: Vehicle class
 * @author Daniel Axelsson and Sohrab Azami
 *
 *
 */

public class Passenger {

	private static AtomicInteger uniqueId=new AtomicInteger();
    protected String seat;
	protected String name;
	protected String email;
	protected String adress;
	protected String reservedAirline;
	protected String currentClass;

	public Passenger(String name, String email, String adress, String currentClass) {
		this.currentClass = currentClass;
		this.name = name;
		this.email = email;
		this.adress = adress;
		this.seat = setSeat(currentClass);
	}

	public String getID() {
		return seat;
	}

	protected String getName() {
		return name;
	}

	protected String getEmail() {
		return email;
	}

	protected String getAdress() {
		return adress;
	}

	protected String getReservedAirline() {
		return reservedAirline;
	}

	protected String getSeat() {
		return seat;
	}

	protected String setSeat(String currentClass) {

		if (currentClass.equals("Business")) {
			// mellan 1-5


			seat = String.valueOf(uniqueId.incrementAndGet());
		}
		else if (currentClass.equals("Economy")) {
			// mellan 6-10


			seat = String.valueOf(uniqueId.incrementAndGet());
		}




		return seat;
	}

	protected String getCurrentClass() {
		return currentClass;
	}

	protected void setCurrentClass(String currentClass) {
		this.currentClass = currentClass;
	}

	@Override
	public String toString() {
		return "Seat = " + seat + " \n" + "Name = " + name + " \n" + "Email = " + email + " \n" + "Adress = " + adress;
	}

































}
