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

/**
 * Importing SecurePublicTransportation class
 */
import securePackage.SecurePublicTransportation;
/**
 * Importing SecureCityBus class
 */
import securePackage2.SecureCityBus;
/**
 * Importing Secure Metro class
 */
import securePackage2.SecureMetro;
/**
 * Importing SecureTram class
 */
import securePackage2.SecureTram;
/**
 * Importing SecureFerry class
 */
import securePackage3.SecureFerry;
/**
 * Importing SecureAircraft class
 */
import securePackage4.SecureAirCraft;
/**
 * Importing SecureAirCraft classType enum
 */
import securePackage4.SecureAirCraft.classType;
/**
 * Importing SecureAirCraft maintenanceType enum
 */
import securePackage4.SecureAirCraft.maintenanceType;

public class SecureDriver {

	/**
	 * Creating static method that displays the information of the cheapest and most expensive ticket price.
	 * @param array an array of SecurePublicTransportation
	 */
	public static void trace(SecurePublicTransportation[] array) {
		double min = 1000000;
		double max = 0;
		int minPosition;
		int maxPosition;
		
		/**
		 * Determining the cheapest and most expensive ticket price.
		 */
		for(int i=0; i<array.length;i++) {
			if(array[i]==null)
				continue;
			if(array[i].getTicketPrice()<min) {
				min = array[i].getTicketPrice();
			}
			if(array[i].getTicketPrice()>max) {
				max = array[i].getTicketPrice();
			}
		}
		
		/**
		 * Displaying the information of the cheapest ticket price.
		 */
		System.out.println("\nThe cheapest ticket price is $" + min + " . Here's more information about this form of transportation\n");

		for(int j=0; j<array.length;j++) {
			if(array[j]==null)
				continue;
			if(min==array[j].getTicketPrice()) {
				minPosition=j;
				System.out.println("This form of transportation is located in the index " + minPosition + " of the public transportation array");
				System.out.println(array[j].toString() + "\n");
			}
	
		}
		
		/**
		 * Displaying the information of the most expensive ticket price.
		 */
		System.out.println("The most expensive ticket price is $" + max + " . Here's more information about this form of transportation\n");

		for(int j=0; j<array.length;j++) {
			if(array[j]==null)
				continue;
			if(max==array[j].getTicketPrice()) {
				maxPosition=j;
				System.out.println("This form of transportation is located in the index " + maxPosition + " of the public transportation array");
				System.out.println(array[j].toString() + "\n");
			}
		}
		
	}
	
	/**
	 * Creates a copy of SecurePublicTransportation array passed in.
	 * @param a an array of SecurePublicTransportation
	 * 
	 * method does not work properly because polymorphism is "off". In order for polymorphism to work, we need
	 * Inheritance, function overriding and casting. However, the SecurePublicTransportation copy constructor is 
	 * never being overridden and hence, our method does not work the way we want. 
	 */
	public static void copyCityBuss(SecurePublicTransportation[] a) {
		/**
		 * Creating a new array of SecurePublicTransportion of the same length as the array passed in.
		 */
		SecurePublicTransportation[] b = new SecurePublicTransportation[a.length];
		/**
		 * "Copying" the objects in the array.
		 */
		for(int i=0; i<a.length;i++) {
			b[i]=new SecurePublicTransportation(a[i]);
		}
		
		System.out.println("Contents of the new array\n");
		
		/**
		 * Displaying the information of the "copied" array.
		 */
		for(int i=0; i<a.length;i++) {
			System.out.println("#" + (i+1));
			System.out.println(b[i].toString() + "\n");
		}
	}
	
	public static void main(String[] args) {
		
		/**
		 * Creating an array of SecurePublicTransportation. 
		 */
		SecurePublicTransportation[] array = new SecurePublicTransportation[12];
		
		/**
		 * Creating two new SecurePublicTransportation objects and storing them into the array of SecurePublicTransportation.
		 */
		SecurePublicTransportation pt = new SecurePublicTransportation(12.75, 10);
		SecurePublicTransportation pt1 = new SecurePublicTransportation();
		pt1.setTicketPrice(1.50);
		pt1.setNumStops(30);
		array[0]=pt;
		array[1]=pt1;

		/**
		 * Determining if the two SecurePublicTransportation objects have the same information. 
		 */
		System.out.println(pt.equals(pt1));
		
		/**
		 * Displaying the information of the second SecurePublicTransportation object created.
		 */
		System.out.println(array[1].toString() + "\n");
		
		/**
		 * Creating two SecureCityBus objects and storing them into the SecurePublicTransportation array.
		 */
		SecureCityBus cb = new SecureCityBus(12.75, 10, 411, 2010, "Jeremy Lin", "Deux Montagnes");
		SecureCityBus cb1 = new SecureCityBus(cb);
		array[2]=cb;
		array[3]=cb1;
		
		/**
		 * Determining if the two SecureCityBus objects contain the same information.
		 */
		System.out.println(cb.equals(cb1));
		/**
		 * Determining if a SecureCityBus and a SecurePublicTransportation object with the same information are equal. 
		 */
		System.out.println(cb.equals(pt));
		
		/**
		 * Displaying the information of the first SecureCityBus created. 
		 */
		System.out.println(array[2].toString()+"\n");
		
		/**
		 * Creating two new SecureMetro objects and storing them into the SecurePublicTransportation array.
		 */
		SecureMetro m = new SecureMetro();
		SecureMetro m1 = new SecureMetro(3.9, 11, 72, 2008, "Kobe Bryant", "Downtown", 18, "Toronto");
		m.setTicketPrice(7.25);
		m.setNumStops(15);
		m.setRouteNum(211);
		m.setOprYr(2000);
		m.setDriverName("Lebron James");
		m.setLineName("Des Sources");
		m.setNumVehicles(10);
		m.setCity("Montreal");
		array[4]=m;
		array[5]=m1;
		
		/**
		 * Determining if the two SecureMetro objects are equal.
		 */
		System.out.println(m.equals(m1));
		/**
		 * Displaying the information of the second SecureMetro object created. 
		 */
		System.out.println(array[5].toString() + "\n");
		
		/**
		 * Creating two SecureTram objects and storing them into the SecurePublicTransportation array.
		 */
		SecureTram t = new SecureTram(5.99, 12, 470, 2003, "Jimmy O Yang", "Chinatown", 100);
		SecureTram t1 = new SecureTram(t);
		t1.setDriverName("Jack Frost");
		t1.setMaxSpeed(85);
		t1.setTicketPrice(2.99);
		t1.setOprYr(2001);
		array[6]=t;
		array[7]=t1;
		
		/**
		 * Determining if the two SecureTram objects are equal.
		 */
		System.out.println(t.equals(t1));
		/**
		 * Displaying the information of the second SecureTram object created.
		 */
		System.out.println(array[7].toString() + "\n");
		
		/**
		 * Creating two SecureFerry objects and storing them into the SecurePublicTransportation array.
		 */
		SecureFerry f = new SecureFerry(12.50, 1, 1990, "Titanic");
		SecureFerry f1 = new SecureFerry();
		f1.setBuildYr(1997);
		f1.setNumStops(5);
		f1.setShipName("Big Ship");
		f1.setTicketPrice(14.25);
		array[8]=f;
		array[9]=f1;
		
		/**
		 * Determining if the two SecureFerry objects are equal.
		 */
		System.out.println(f.equals(f1));
		/**
		 * Displaying the information of the second SecureFerry object created.
		 */
		System.out.println(array[9].toString() + "\n");
		
		/**
		 * Creating two SecureAirCraft objects and storing them into the SecurePublicTransportation object
		 */
		classType cT = classType.Balloon;
		maintenanceType mT = maintenanceType.Yearly;
		SecureAirCraft a = new SecureAirCraft(200.0,2,cT, mT);
		SecureAirCraft a1 = new SecureAirCraft(500,1,cT,mT);
		array[10]=a;
		array[11]=a1;
		
		/**
		 * Determining if the two SecureAirCraft objects are equal.
		 */
		System.out.println(a.equals(a1));
		/**
		 * Displaying the information of the first SecureAirCraft object.
		 */
		System.out.println(a.toString() + "\n");
		
		/**
		 * Testing to see if the copyCityBuss method correctly copied the array of ScurePublicTranportation
		 */
		System.out.println("---------------------------------------------");
		System.out.println("Testing the copyCityBuss method");
		
		copyCityBuss(array);
		
		/**
		 * Calling the trace method to determine the cheapest and most ex
		 */
		System.out.println("CHECKING THE CHEAPEST AND MOST EXPENSIVE TICKET PRICES");
		trace(array);
		
	}

}
