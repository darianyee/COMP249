//-------------------------------------------
//Assignment(#2)
//Question #1 (Part 2)
//Written by Darian Yee (40063058)
//-------------------------------------------

/**
 * @author Darian Yee (40063058)
 * @version 1.0
 *COMP 249
 *Assignment #2
 *Due: Friday, February 20, 2019
 */

package securePackage3;
import securePackage.SecurePublicTransportation;

public class SecureFerry extends SecurePublicTransportation{

	/**
	 * buildYr is the first instance variable
	 * shipName is the second instance variable
	 */
	private int buildYr;
	private String shipName;
	
	/**
	 * Default Constructor when a SecureFerry is created
	 */
	public SecureFerry() {
		super();
	}
	
	/**
	 * Constructor takes in a double, two int and a String and sets it as the ticket price, number of stops, build year and ship name
	 * @param ticketPrice a double
	 * @param numStops an int
	 * @param buildYr an int
	 * @param shipname a String
	 */
	public SecureFerry(double ticketPrice, int numStops, int buildYr, String shipname) {
		super(ticketPrice, numStops);
		this.buildYr = buildYr;
		this.shipName=shipname;
	}
	
	/**
	 * Copy Constructor that takes in another SecureFerry and copies its information
	 * @param f a Ferry object
	 */
	public SecureFerry(SecureFerry f) {
		super(f.getTicketPrice(), f.getNumStops());
		this.buildYr=f.buildYr;
		this.shipName=f.shipName;
	}
	
	/**
	 * Converts the SecureFerry's information (ticket price, number of stops, build year and ship name) into a String
	 */
	public String toString() {
		return "This Ferry is called " + this.shipName + " and was built in the year " + this.buildYr + ".\nIt has " 
				+ super.getNumStops() + " stops and costs $" + super.getTicketPrice() + " per ticket.";
	}
	
	/**
	 * Determines if two SecureFerrys' have the same information
	 * @param o an Object
	 * @return boolean calculated from the two Ferry objects
	 */
	public boolean equals(Object o) {
		if(this.getClass()==o.getClass() && o!=null) {//returns false if the object points to a null pointer and prevent the program to crash
			SecureFerry f = (SecureFerry)o;
			return (this.getNumStops()==f.getNumStops() && this.getTicketPrice()==f.getTicketPrice()&&
					this.buildYr==f.buildYr && this.shipName==f.shipName);
		}
		return false;
	}
	
	/**
	 * @return int gets the build year
	 */
	public int getBuildYr() {
		return buildYr;
	}
	
	/**
	 * @param buildYr to set as new build year
	 */
	public void setBuildYr(int buildYr) {
		this.buildYr = buildYr;
	}
	
	/**
	 * @return String gets the ship name
	 */
	public String getShipName() {
		return shipName;
	}
	
	/**
	 * @param shipName to set as the new ship name
	 */
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	
}
