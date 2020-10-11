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

package Package3;
import Package.PublicTransportation;

public class Ferry extends PublicTransportation{
	/**
	 * buildYr is the first instance variable
	 * shipName is the second instance variable
	 */
	private int buildYr;
	private String shipName;
	
	/**
	 * Default Constructor when a Ferry is created
	 */
	public Ferry() {
		super();
	}
	
	/**
	 * Constructor takes in a double, two int and a String and sets it as the ticket price, number of stops, build year and ship name
	 * @param ticketPrice a double
	 * @param numStops an int
	 * @param buildYr an int
	 * @param shipname a String
	 */
	public Ferry(double ticketPrice, int numStops,int buildYr, String shipname) {
		super(ticketPrice, numStops);
		this.buildYr = buildYr;
		this.shipName=shipname;
	}
	
	/**
	 * Copy Constructor that takes in another Ferry and copies its information
	 * @param f a Ferry object
	 */
	public Ferry(Ferry f) {
		super(f.ticketPrice, f.numStops);
		this.buildYr=f.buildYr;
		this.shipName=f.shipName;
	}
	
	/**
	 * Converts the Ferry's information (ticket price, number of stops, build year and ship name) into a String
	 */
	public String toString() {
		return "This Ferry is called " + this.shipName + " and was built in the year " + this.buildYr + ".\nIt has " 
				+ this.numStops + " stops and costs $" + this.ticketPrice + " per ticket.";
	}
	
	/**
	 * Determines if two Ferrys' have the same information
	 * @param o an Object
	 * @return boolean calculated from the two Ferry objects
	 */
	public boolean equals(Object o) {
		if(this.getClass()==o.getClass() && o!=null) {
			Ferry f = (Ferry)o;
			return (this.getNumStops()==f.getNumStops() && this.getTicketPrice()==f.getTicketPrice()&&
					this.buildYr==f.getBuildYr() && this.shipName==f.getShipName());
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
