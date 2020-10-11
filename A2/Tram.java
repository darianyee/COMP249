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

package Package2;

public class Tram extends CityBus{

	/**
	 * maxSpeed is the first instance variable
	 */
	private int maxSpeed;
	
	/**
	 * Default constructor when a Tram object is created
	 */
	public Tram() {
		super();
	}
	
	/**
	 * Constructor takes in a double, an int, a long, an int, two Strings and an int and sets it as the Tram's
	 * ticket price, number of stops, route number, operation year, driver's name, line name and the maximum speed
	 * 
	 * @param ticketPrice a double is the first parameter
	 * @param numStops an int is the second parameter
	 * @param routeNum a long is the third parameter
	 * @param OprYr an int is the fourth parameter
	 * @param dname a String is the fifth parameter
	 * @param lname a String is the sixth parameter
	 * @param maxSpeed an int is the seventh parameter
	 */
	public Tram(double ticketPrice, int numStops, long routeNum, int OprYr, String dname, String lname, int maxSpeed) {
		super(ticketPrice, numStops, routeNum, OprYr, dname, lname);
		this.maxSpeed=maxSpeed;
	}

	/**
	 * Copy constructor that takes in another Tram and copies its information
	 * @param t a Tram object
	 */
	public Tram(Tram t) {
		super(t.ticketPrice, t.numStops, t.routeNum, t.oprYr, t.driverName, t.lineName);
		this.maxSpeed=t.maxSpeed;
	}
	
	/**
	 * Determines if two Trams have the same information.
	 * (ticket price, number of stops, route number, operation year, driver name, line name and maximum speed)
	 * @param o an object
	 * @return boolean calculated from the two Tram objects
	 */
	public boolean equals(Object o) {
		if(this.getClass() == o.getClass() && o!=null) {
			Tram t = (Tram)o;
			return (this.getNumStops()==t.getNumStops() && this.getTicketPrice()==t.getTicketPrice()&&
					this.routeNum==t.routeNum && this.oprYr==t.oprYr && this.driverName==t.driverName
					&&this.lineName==t.lineName && this.maxSpeed== t.maxSpeed);
		}
		return false;
	}
	
	/**
	 * Converts the Tram's information (ticket price, number of stops, route number, operation year, driver name, line name and maximum speed)
	 * into a String
	 */
	public String toString() {
		return "This Tram is driven by " + this.driverName + " and began its operation in the year " + this.oprYr 
				+ ".\nThe tram has route number " + this.routeNum + ", line name \"" + this.lineName + "\" and has " + this.numStops + " stops."
				+ "\nIt has a maximum speed of " + this.maxSpeed + " km/hr and each ticket costs $" + this.ticketPrice + "."; 	
	}

	/**
	 * @return int gets the maximum speed
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * @param maxSpeed to set as new route number
	 */
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	
}
