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
import Package.PublicTransportation;

public class CityBus extends PublicTransportation {
	
	/**
	 * routeNum is the first instance variable
	 * oprYr is the second instance variable
	 * lineName is the third instance variable
	 * driverName is the fourth instance variable
	 */
	protected long routeNum;
	protected int oprYr;
	protected String lineName;
	protected String driverName;
	
	/**
	 * Default constructor when a CityBus object is created.
	 */
	public CityBus() {
		super();
	}
	
	/**
	 * Constructor takes in a double, an int, a long, an int and two Strings and sets it as the CityBus'
	 * ticket price, number of stops, route number, operation year, line name and driver name.
	 * 
	 * @param ticketPrice a double is the first parameter
	 * @param numStops an int is the second parameter
	 * @param routeNum a long is the third parameter
	 * @param OprYr an int is the fourth parameter
	 * @param driverName a String is the fifth parameter
	 * @param lineName a String is the sixth parameter
	 */
	public CityBus(double ticketPrice, int numStops, long routeNum, int OprYr, String driverName, String lineName) {
		super(ticketPrice,numStops);
		this.routeNum=routeNum;
		this.oprYr=OprYr;
		this.driverName=driverName;
		this.lineName=lineName;
	}
	
	/**
	 * Copy Constructor that takes in another CityBus and copies its information
	 * @param cb a CityBus object
	 */
	public CityBus(CityBus cb) {
		super(cb.ticketPrice, cb.numStops);
		this.routeNum=cb.routeNum;
		this.oprYr=cb.oprYr;
		this.driverName=cb.driverName;
		this.lineName=cb.lineName;
	}
	
	/**
	 * Converts the CityBus' information(ticket price, number of stops, route number, operation year, driver name and line name) into a String
	 */
	public String toString() {
		return "This City bus is driven by " + this.driverName + " and began its operation in the year " + this.oprYr 
				+ ".\nThe bus has route number " + this.routeNum + ", line name \"" + this.lineName + "\" and has " + this.numStops + " stops."
				+ "\nEach ticket costs $" + this.ticketPrice + ".";
	}
	
	/**
	 * Determines if two CityBus' have the same information
	 * (ticket price, number of stops, route number, operation year, driver name and line name)
	 *
	 *@param o an Object
	 *@return boolean calculated from the two City bus objects
	 */
	public boolean equals(Object o) {
		if(this.getClass()==o.getClass() && o!=null) {
			CityBus cb = (CityBus)o;
			return(super.getNumStops()==cb.getNumStops() && super.getTicketPrice()==cb.getTicketPrice()&&
					this.routeNum==cb.routeNum && this.oprYr==cb.oprYr && this.driverName==cb.driverName
					&&this.lineName==cb.lineName);
		}
		return false;
	}
	
	/**
	 * @return long gets the route number
	 */
	public long getRouteNum() {
		return routeNum;
	}
	
	/**
	 * @param routeNum to set as new route number
	 */
	public void setRouteNum(long routeNum) {
		this.routeNum = routeNum;
	}
	
	/**
	 * @return int gets the operation year
	 */
	public int getOprYr() {
		return oprYr;
	}
	
	/**
	 * @param OprYr to set as the new operation year
	 */
	public void setOprYr(int OprYr) {
		oprYr = OprYr;
	}
	
	/**
	 * @return String gets line name
	 */
	public String getLineName() {
		return lineName;
	}
	
	/**
	 * @param lname to set as new line name
	 */
	public void setLineName(String lname) {
		this.lineName = lname;
	}
	
	/**
	 * @return String gets driver name
	 */
	public String getDriverName() {
		return driverName;
	}
	
	/**
	 * @param dname to set as new driver name
	 */
	public void setDriverName(String dname) {
		this.driverName = dname;
	}
	
}
