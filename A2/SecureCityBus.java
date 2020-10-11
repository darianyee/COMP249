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
import securePackage.SecurePublicTransportation;

public class SecureCityBus extends SecurePublicTransportation{

	/**
	 * routeNum is the first instance variable
	 * oprYr is the second instance variable
	 * lineName is the third instance variable
	 * driverName is the fourth instance variable
	 */
	//Attributes are now private so the children can only access them by using the get/set of the parent class
	//Instead of calling it directly
	private long routeNum;
	private int OprYr;
	private String lineName;
	private String driverName;
	
	/**
	 * Default constructor when a SecureCityBus object is created.
	 */
	public SecureCityBus() {
		super();
	}
	
	/**
	 * Constructor takes in a double, an int, a long, an int and two Strings and sets it as the SecureCityBus'
	 * ticket price, number of stops, route number, operation year, line name and driver name.
	 * 
	 * @param ticketPrice a double is the first parameter
	 * @param numStops an int is the second parameter
	 * @param routeNum a long is the third parameter
	 * @param OprYr an int is the fourth parameter
	 * @param driverName a String is the fifth parameter
	 * @param lineName a String is the sixth parameter
	 */
	public SecureCityBus(double ticketPrice, int numStops, long routeNum, int OprYr, String driverName, String lineName) {
		super(ticketPrice,numStops);
		this.routeNum=routeNum;
		this.OprYr=OprYr;
		this.lineName=lineName;
		this.driverName=driverName;
	}
	
	/**
	 * Copy Constructor that takes in another SecureCityBus and copies its information
	 * @param cb a SecureCityBus object
	 */
	public SecureCityBus(SecureCityBus cb) {
		super(cb.getTicketPrice(), cb.getNumStops());
		this.routeNum=cb.routeNum;
		this.OprYr=cb.OprYr;
		this.driverName=cb.driverName;
		this.lineName=cb.lineName;
	}
	
	/**
	 * Converts the SecureCityBus' information(ticket price, number of stops, route number, operation year, driver name and line name) into a String
	 */
	public String toString() {
		return "This City bus is driven by " + this.driverName + " and began its operation in the year " + this.OprYr 
				+ ".\nThe bus has route number " + this.routeNum + ", line name " + this.lineName + " and has " + this.getNumStops() + " stops."
				+ " Each ticket costs $" + this.getTicketPrice();
	}
	
	/**
	 * Determines if two SecureCityBus' have the same information
	 * (ticket price, number of stops, route number, operation year, driver name and line name)
	 *
	 *@param o an Object
	 *@return boolean calculated from the two Secure City bus objects
	 */
	public boolean equals(Object o) {
		if(this.getClass()==o.getClass() && o!=null) {//returns false if the object points to a null pointer and prevent the program to crash
			SecureCityBus cb = (SecureCityBus)o;
			return(super.getNumStops()==cb.getNumStops() && super.getTicketPrice()==cb.getTicketPrice()&&
					this.routeNum==cb.routeNum && this.OprYr==cb.OprYr && this.driverName==cb.driverName
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
		return OprYr;
	}
	
	/**
	 * @param oprYr to set as the new operation year
	 */
	public void setOprYr(int oprYr) {
		OprYr = oprYr;
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
