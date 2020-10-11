//-------------------------------------------
//Assignment(#4)
//Question #1 (Part 2)
//Written by Darian Yee (40063058) and Sujan Saravanamuthu (40044870)
//-------------------------------------------

/**
* @author Darian Yee (40063058)
* @author Sujan Saravanamuthu (40044870)
* @version 1.0
*COMP 249
*Assignment #4
*Due: Monday, April 8th, 2019
*/


import java.util.Scanner;
public class CellPhone {

	//Instance variables
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	/**
	 * Default Constructor
	 */
	public CellPhone() {
		this(0,"",0,0);
	}
	
	/**
	 * Parameterized constructor that takes in a long, String, int and double.
	 * @param snum long the serial number of the CellPhone
	 * @param brand String the brand of the CellPhone
	 * @param year int the year of the CellPhone
	 * @param price double price of the CellPhone
	 */
	public CellPhone(long snum, String brand, int year, double price) {
		this.serialNum=snum;
		this.brand=brand;
		this.year=year;
		this.price=price;
	}

	/**
	 * Constructor takes a CellPhone and a long as its parameter. It copies the brand, year and price of the CellPhone
	 * passed in the parameter and sets the serial number to the long value of the second parameter.
	 * @param c CellPhone to be copied
	 * @param snum long serial number of the new CellPhone
	 */
	public CellPhone(CellPhone c, long snum) {
		this(snum, c.brand,c.year, c.price);
	}
	
	/**
	 * Clones the CellPhone object calling the method and asks the user for a new serial number.
	 */
	public CellPhone clone() {
		Scanner keyIn = new Scanner(System.in);
		System.out.println("Please enter a serial number");
		serialNum = keyIn.nextLong();
		CellPhone c = new CellPhone(serialNum, this.brand, this.year, this.price);
		keyIn.close();
		return c;
	}
	
	/**
	 * Gets the serial number
	 * @return long serial number
	 */
	public long getSerialNum() {
		return serialNum;
	}

	/**
	 * Takes in a long value as its parameter and sets it as the serial number.
	 * @param long serial number
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	/**
	 * Gets the brand
	 * @return String brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Takes in a String value and sets it to the brand.
	 * @param String brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Gets the year
	 * @return int year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Takes in an int value and sets it to the year
	 * @param int year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Gets the price
	 * @return double price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Takes in a double and sets it to the price
	 * @param double price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Returns the information of the CellPhone.
	 */
	public String toString() {
		return "[" + this.serialNum + ": " + this.brand + " " + this.price + "$ " + this.year + " ] ---->";
	}
	
	/**
	 * Determines if the CellPhones have the same brand, price and year. 
	 */
	public boolean equals(Object o) {
		if(o!=null && this.getClass()==o.getClass()) {
			CellPhone c = (CellPhone)o;
			return (this.brand==c.brand && this.price==c.price && this.year==c.year);
		}
		return false;
	}
	
}
