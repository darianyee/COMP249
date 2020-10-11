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
package securePackage2;

public class SecureTram extends SecureCityBus{

	/**
	 * maxSpeed is the first instance variable
	 */
	private int maxSpeed;
	
	/**
	 * Default constructor when a Tram object is created
	 */
	public SecureTram() {
		super();
	}
	
	/**
	 * Constructor takes in a double, an int, a long, an int, two Strings and an int and sets it as the SecureTram's
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
	public SecureTram(double ticketPrice, int numStops, long routeNum, int OprYr, String dname, String lname, int maxSpeed) {
		super(ticketPrice, numStops, routeNum, OprYr, dname, lname);
		this.maxSpeed=maxSpeed;
	}

	/**
	 * Copy constructor that takes in another SecureTram and copies its information
	 * @param t a SecureTram object
	 */
	public SecureTram(SecureTram t) {
		super(t.getTicketPrice(), t.getNumStops(), t.getRouteNum(), t.getOprYr(), t.getDriverName(), t.getLineName());
		this.maxSpeed=t.maxSpeed;
	}
	
	/**
	 * Determines if two SecureTrams have the same information.
	 * (ticket price, number of stops, route number, operation year, driver name, line name and maximum speed)
	 * @param o an object
	 * @return boolean calculated from the two SecureTram objects
	 */
	public boolean equals(Object o) {
		if(this.getClass() == o.getClass() && o!=null) {//returns false if the object points to a null pointer and prevent the program to crash
			SecureTram t = (SecureTram)o;
			return (this.getNumStops()==t.getNumStops() && this.getTicketPrice()==t.getTicketPrice()&&
					this.getRouteNum()==t.getRouteNum() && this.getOprYr()==t.getOprYr() && this.getDriverName()==t.getDriverName()
					&&this.getLineName()==t.getLineName() && this.maxSpeed== t.maxSpeed);
		}
		return false;
	}
	
	/**
	 * Converts the SecureTram's information (ticket price, number of stops, route number, operation year, 
	 * driver name, line name and maximum speed) into a String
	 */
	public String toString() {
		return "This Tram is driven by " + this.getDriverName() + " and began its operation in the year " + this.getOprYr() 
				+ ".\nThe tram has route number " + this.getRouteNum() + ", line name " + this.getLineName() 
				+ " and has " + this.getNumStops() + " stops."+ "\nIt has a maximum speed of " 
				+ this.maxSpeed + " km/hr and each ticket costs $" + this.getTicketPrice(); 	
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
