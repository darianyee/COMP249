//-------------------------------------------
//Assignment(#2)
//Question #1 (Part 1)
//Written by Darian Yee (40063058)
//-------------------------------------------

/**
 * @author Darian Yee (40063058)
 * @version 1.0
 *COMP 249
 *Assignment #2
 *Due: Friday, February 20, 2019
 */

package securePackage;

public class SecurePublicTransportation {

	/**
	 * ticketPrice is the first instance variable
	 * numStops is the second instance variable
	 */
	//Attributes are now private so the children can only access them by using the get/set of the parent class
	//Instead of calling it directly
	private double ticketPrice;
	private int numStops;
	
	/**
	 * Default Constructor when a SecurePublicTransportation object is created 
	 */
	public SecurePublicTransportation() {
		this(0.0, 0);
	}
	
	/**
	 * Constructor takes a double and an int and sets it as the secure public Transportations' ticket price and number of stops
	 * 
	 * @param ticketPrice a double is the first parameter
	 * @param numStops an int is the second parameter
	 */
	public SecurePublicTransportation(double ticketPrice, int numStops) {
		this.ticketPrice=ticketPrice;
		this.numStops = numStops;
	}
	
	/**
	 * Copy Constructor takes another SecurePublicTransportation object and copies it
	 * @param pt a publicTransportation object
	 */
	public SecurePublicTransportation(SecurePublicTransportation pt) {
		this.ticketPrice=pt.ticketPrice;
		this.numStops=pt.numStops;
	}
	
	/**
	 * Determines if two SecurePublicTransportation objects have the same ticket price and number of stops
	 * 
	 * @param o an Object
	 * @return boolean calculated from the two publicTransportation objects
	 */
	public boolean equals(Object o) {
		if(this.getClass()==o.getClass() && o!=null) { //returns false if the object points to a null pointer and prevent the program to crash
			SecurePublicTransportation pt = (SecurePublicTransportation)o;
			return(this.numStops==pt.getNumStops() && this.ticketPrice==pt.getTicketPrice());
		}
		return false;
	}
	
	/**
	 * Converts the secure public Transportation's information (ticket price and number of stops) into a String
	 * @return a String of the public Transportation's information
	 */
	public String toString() {
		return "This public Transportation has " + this.numStops + " stops and costs $" + this.ticketPrice + " per ticket";
	}
	
	/**
	 * @return double gets the ticket price
	 */
	public double getTicketPrice() {
		return ticketPrice;
	}
	
	/**
	 * @param ticketPrice a double to set as the new ticket price
	 */
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	/**
	 * @return int gets the number of stops
	 */
	public int getNumStops() {
		return numStops;
	}
	
	/**
	 * @param numStops an int to set as the new number of stops
	 */
	public void setNumStops(int numStops) {
		this.numStops = numStops;
	}
}
