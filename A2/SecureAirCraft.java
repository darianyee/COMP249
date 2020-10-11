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

package securePackage4;
import securePackage.SecurePublicTransportation;

public class SecureAirCraft extends SecurePublicTransportation{

	public enum classType{Helicopter, Airline, Glider, Balloon};
	public enum maintenanceType{Weekly, Monthly, Yearly};
	
	/**
	 * classType is the first instance variable
	 * maintenanceType is the second instance variable
	 */
	private classType cType;
	private maintenanceType mType;
	
	/**
	 * Default constructor when a SecureAirCraft object is created
	 */
	public SecureAirCraft() {
		super();
	}
	
	/**
	 * Constructor that takes in a double, an int, a classType and a maintenance type and sets it as
	 * the ticket price, number of stops, classType and maintenanceType
	 * @param ticketPrice a double is the first parameter
	 * @param numStops an int the second parameter
	 * @param cType a classType is the third parameter
	 * @param mType a maintenanceType is the fourth parameter
	 */
	public SecureAirCraft(double ticketPrice, int numStops, classType cType, maintenanceType mType) {
		super(ticketPrice, numStops);
		this.cType=cType;
		this.mType=mType;
	}
	
	/**
	 * Copy Constructor that takes in another AirCraft and copies its information
	 * @param A an SecureAirCraft object
	 */
	public SecureAirCraft(SecureAirCraft A) {
		super(A.getTicketPrice(), A.getNumStops());
	}
	
	/**
	 * Converts the SecureAirCraft's information (ticket price, number of stops, class type and maintenance type) and converts it to a String
	 */
	public String toString() {
		return "This Aircraft is a " + this.getClassType() + " and has " + this.getMaintenanceType() + " maintenance.\nIt has " 
				+ super.getNumStops() + " stops and costs $" + super.getTicketPrice() + " per ticket.";
	}
	
	/**
	 * Determines if two SecureAirCraft objects have the same information
	 * @param o an object
	 * @return boolean calculated from the two SecureAirCraft objects
	 */
	public boolean equals(Object o) {
		if(this.getClass()==o.getClass() && o!=null) {//returns false if the object points to a null pointer and prevent the program to crash
			SecureAirCraft a = (SecureAirCraft)o;
			return (this.getNumStops()==a.getNumStops() && this.getTicketPrice()==a.getTicketPrice()&&
					this.getClassType()==a.getClassType() && this.getMaintenanceType()==a.getMaintenanceType());
		}
		return false;
	}
	
	/**
	 * @return classType gets the class type
	 */
	public classType getClassType() {
		return this.cType;
	}

	/**
	 * @param cType to set as new ClassType
	 */
	public void setClassType(classType cType) {
		this.cType = cType;
	}

	/**
	 * @return maintenanceType gets the maintenance type
	 */
	public maintenanceType getMaintenanceType() {
		return this.mType;
	}

	/**
	 * @param mType to set as new maintenanceType
	 */
	public void setMaintenanceType(maintenanceType mType) {
		this.mType = mType;
	}
}
