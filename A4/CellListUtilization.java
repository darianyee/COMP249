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


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CellListUtilization {

	public static void main(String[] args) {

	System.out.println("Welcome to our CellList!\n\n");
		
	//Initializing Scanner
	Scanner sc = null;
	Scanner keyIn = new Scanner (System.in);
	//Creating CellList object
	CellList list1 = new CellList();
	CellList list2 = new CellList();
	
	//Reading file in from Scanner
	try {
		sc = new Scanner(new FileInputStream("C:\\Users\\DY\\eclipse-workspace\\COMP 249 Assignment 4\\A4 Files Part 2\\Cell_Info.txt"));
		while(sc.hasNext()) {
			long snum=sc.nextLong();
			String brand=sc.next();
			double price=sc.nextDouble();
			int year = sc.nextInt();
			
			//Storing each CellPhone and adding it to the LinkedList if it does not exist
			CellPhone c = new CellPhone(snum, brand, year, price);
			if(list1.contains(c.getSerialNum()))
				continue;
			list1.addToEnd(c);
			
		}
		/*
		 * Display the CellList
		 */
		System.out.println("The contents of the initialized list");
		list1.showContents();
		System.out.println(" X\n");
		int count=0;
		long snum=1;
		/*
		 * Will prompt user to enter serial number, will check for serial number and shows the pointer to that node 
		 * and how many iterations it took to find this device
		 */
		while(snum>=0) {
			System.out.println("Please enter a serial number you wish to search for(Enter a negative number to stop)");
			snum=keyIn.nextLong();
			if(snum>=0 && list1.find(snum)!=null)
				
				System.out.println(list1.finds(snum));
			else if(snum>=0 && list1.find(snum)==null)
				System.out.println("The CellPhone could not be found in the CellList\n");
			
		}
		/*
		 * Testing all our methods
		 */
		
		//Creating CellPhone Objects
		//Testing parameterized constructor
		CellPhone a= new CellPhone(1,"Apple",2019,799.99);
		CellPhone a1= new CellPhone(2,"Apple",2018,699.99);
		CellPhone a2= new CellPhone(3,"Apple",2017,599.99);
		CellPhone a3= new CellPhone(4,"Samsung",2019,499.99);
		CellPhone a4= new CellPhone(5,"Samsung",2018,999.99);
		CellPhone a5= new CellPhone(6,"Samsung",2017,899.99);
		CellPhone a6= new CellPhone(7,"Apple",2019,799.99);
		CellPhone a7= new CellPhone(8,"HTC",2019,499.99);
		//Testing copy constructor
		CellPhone a8= new CellPhone(a,9);
		//Testing clone method
		CellPhone a9=a.clone();
		
		//Testing equals method
		System.out.println("Demonstrating Equals Method");
		System.out.println(a.equals(a6));
		System.out.println(a.equals(a8));
		System.out.println(a.equals(a9));
		System.out.println(a.equals(a1));
		System.out.println();
		System.out.println();
		System.out.println("This is tostring method");
		System.out.println(a.toString());
		System.out.println();
		System.out.println();
		System.out.println("Created new celllist and added 3 cellphones to the end");
		CellList c1=new CellList();
		
		//Testing addToEnd method
		c1.addToEnd(a);
		c1.addToEnd(a1);
		c1.addToEnd(a2);
		c1.showContents();
		System.out.println();
		System.out.println();
		System.out.println("the following display shows the addToStart method ");
		System.out.println();
		
		//Testing addToStart method
		c1.addToStart(a3);
		c1.showContents();
		System.out.println();
		System.out.println();
		System.out.println("Inserting a cellphone at index 2");
		System.out.println();
		
		//Testing insertAtIndex method
		c1.insertAtIndex(a4,2);
		c1.showContents();
		System.out.println();
		System.out.println();
		System.out.println("Deleting what is in index 2");
		System.out.println();
		
		//Testing deleteFromIndex method
		c1.deleteFromIndex(2);
		c1.showContents();
		System.out.println();
		System.out.println();
		System.out.println("Deleting Something from the start");
		System.out.println();
		
		//Testing deleteFromStart method
		c1.deleteFromStart();
		c1.showContents();
		System.out.println();
		System.out.println();
		System.out.println("Replacing what is in index 2");
		System.out.println();
		
		//Testing replaceAtIndex method
		c1.replaceAtIndex(a6,2);
		c1.showContents();
		System.out.println();
		System.out.println();
		
		//Testing contains method
		System.out.println("Showing contains and Equals method");
		System.out.println(c1.contains(1));
		
		System.out.println(list1.equals(c1));
		System.out.println();
		System.out.println();
		System.out.println("Creating two lists,second one from copy constructor, third one form clone method");
		CellList c2=new CellList(c1);
		
		//Testing clone method
		CellList c3=c1.clone();
		System.out.println();
		System.out.println();
		c1.showContents();
		System.out.println();
		System.out.println();
		c2.showContents();
		System.out.println();
		System.out.println();
		c3.showContents();
		System.out.println();
		System.out.println("Showing the size of first list");
		System.out.println(c1.getSize());
	}
	
	/*
	 * Catches if the file cannot be read
	 */
	catch(FileNotFoundException e) {
		System.out.println(e.getMessage());
		System.out.println("Program will now terminate");
		System.exit(0);
	}
	/*
	 * Catches if Node can't be found
	 */
	catch(NoSuchElementException e) {
		System.out.println(e.getMessage());
		System.out.println("Program will now terminate");
		System.exit(0);
	}
	/*
	 * Closes scanner
	 */
	finally {
		sc.close();
		keyIn.close();
		System.out.println("\nThank you for visiting!");
	}
	
}

}
