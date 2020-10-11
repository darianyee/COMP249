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

public class Metro extends CityBus{

	/**
	 * numVehicles is the first instance variable
	 * city is the second instance variable
	 */
	private int numVehicles;
	private String city;
	
	/**
	 * Default constructor when a Metro object is created
	 */
	public Metro() {
		super();
	}
	
	/**
	 * Constructor takes in a double, an int, a long, an int and three Strings and sets it as the Metro's
	 * ticket price, number of stops, route number, operation year, driver's name, line name, number of vehicles and the city
	 * 
	 * @param ticketPrice a double is the first parameter
	 * @param numStops an int is the second parameter
	 * @param routeNum a long is the third parameter
	 * @param OprYr an int is the fourth parameter
	 * @param dname a String is the fifth parameter
	 * @param lname a String is the sixth parameter
	 * @param numVehicles an int is the seventh parameter
	 * @param city a String is the eighth parameter
	 */
	public Metro(double ticketPrice, int numStops, long routeNum, int OprYr, String dname, String lname, int numVehicles, String city) {
		super(ticketPrice, numStops, routeNum, OprYr, dname, lname);
		this.numVehicles=numVehicles;
		this.city=city;
	}
	
	/**
	 * Copy constructor that takes in another Metro and copies its information
	 * @param m a Metro object
	 */
	public Metro(Metro m) {
		super(m.ticketPrice, m.numStops, m.routeNum, m.oprYr, m.driverName, m.lineName);
		this.numVehicles=m.numVehicles;
		this.city=m.city;
	}
	
	/**
	 * Determines if two Metros' have the same information.
	 * (ticket price, number of stops, route number, operation year, driver name, line name,number of vehicles and city)
	 * @param o an object
	 * @return boolean calculated from the two Metro objects
	 */
	public boolean equals(Object o) {
		if(this.getClass()==o.getClass() && o!=null) {
			Metro m = (Metro)o;
			return (this.getNumStops()==m.getNumStops() && this.getTicketPrice()==m.getTicketPrice()&&
					this.routeNum==m.routeNum && this.oprYr==m.oprYr && this.driverName==m.driverName
					&&this.lineName==m.lineName && this.numVehicles==m.numVehicles && this.city==m.city);
		}
		return false;
	}
	
	/**
	 * Converts the Metro's information (ticket price, number of stops, route number, operation year, driver name, 
	 * line name, number of vehicles and city)
	 * into a String
	 */
	public String toString() {
		return "This Metro is driven by " + this.driverName + " and began its operation in the year " + this.oprYr 
				+ ".\nThe metro has route number " + this.routeNum + " and line name \"" + this.lineName + 
				"\".\nIt also has " + this.numStops + " stops and a total of " + this.numVehicles + " vehicles. "
				+ "\nEach ticket costs $" + this.ticketPrice + " and will take you around the city of " + this.city + ".";
	}
		
	/**
	 * @return int gets number of vehicles
	 */
	public int getNumVehicles() {
		return numVehicles;
	}

	/**
	 * @param numVehicles to set as new number of vehicles
	 */
	public void setNumVehicles(int numVehicles) {
		this.numVehicles = numVehicles;
	}

	/**
	 * @return String gets the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city to set as new city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
}
