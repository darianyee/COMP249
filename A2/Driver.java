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

/**
 * importing Scanner to get user input
 */

import Package.PublicTransportation;
/**
 * importing cityBus class
 */
import Package2.CityBus;
/**
 * importing Metro class
 */
import Package2.Metro;
/**
 * importing Tram class
 */
import Package2.Tram;
/**
 * importing Ferry class
 */
import Package3.Ferry;
/**
 * importing Aircraft class
 */
import Package4.AirCraft;
/**
 * importing classType enum from Aircraft class
 */
import Package4.AirCraft.classType;
/**
 * importing maintenanceType enum from Aircraft class
 */
import Package4.AirCraft.maintenanceType;

public class Driver {
	
	public static void main(String[] args) {
				
		/**
		 * Creating an array of publicTransportation objects.
		 */
		PublicTransportation[] array = new PublicTransportation[15];
		
		/**
		 * Creating two PublicTransportation objects and storing them in the array.
		 */
		PublicTransportation pt = new PublicTransportation(12.75, 10);
		PublicTransportation pt1 = new PublicTransportation();
		pt1.setTicketPrice(1.50);
		pt1.setNumStops(30);
		array[0]=pt;
		array[1]=pt1;

		/**
		 * Determining if the two PublicTransportation objects have the same information.
		 */
		System.out.println(pt.equals(pt1));
		
		/**
		 * Displaying the information of the second PublicTransportation object.
		 */
		System.out.println(array[1].toString() + "\n");
		
		/**
		 * Creating three CityBus objects and storing them into the array of PublicTransportation.
		 */
		CityBus cb = new CityBus(12.75, 10, 411, 2010, "Jeremy Lin", "Deux Montagnes");
		CityBus cb1 = new CityBus(cb);
		CityBus cb2 = new CityBus();
		cb2.setTicketPrice(14.25);
		cb2.setNumStops(18);
		cb2.setRouteNum(203);
		cb2.setOprYr(2016);
		cb2.setDriverName("Sean");
		cb2.setLineName("Beaconsfield");
		array[2]=cb;
		array[3]=cb1;
		array[4]=cb2;
		
		/**
		 * Determining if the first two CityBus objects contain the same information.
		 */
		System.out.println(cb.equals(cb1));
		
		/**
		 * Determining if a CityBus object is equal to a PublicTransportation object with the same information.
		 */
		System.out.println(cb.equals(pt));
		
		/**
		 * Displaying the information of the first CityBus object created.
		 */
		System.out.println(array[2].toString() + "\n");
		
		/**
		 * Creating two Metro objects and storing them into the PublicTransportation array.
		 */
		Metro m = new Metro();
		Metro m1 = new Metro(3.9, 11, 72, 2008, "Kobe Bryant", "Downtown", 18, "Toronto");
		m.setTicketPrice(7.25);
		m.setNumStops(15);
		m.setRouteNum(211);
		m.setOprYr(2000);
		m.setDriverName("Lebron James");
		m.setLineName("Des Sources");
		m.setNumVehicles(10);
		m.setCity("Montreal");
		array[5]=m;
		array[6]=m1;
		
		/**
		 * Determining if the two Metro objects contain the same information.
		 */
		System.out.println(m.equals(m1));
		
		/**
		 * Displaying the information of the first Metro object.
		 */
		System.out.println(array[5].toString() + "\n");
		
		/**
		 * Creating three Tram objects and storing them into the PublicTransportation array.
		 */
		Tram t = new Tram(5.99, 12, 470, 2003, "Jimmy O Yang", "Chinatown", 100);
		Tram t1 = new Tram(t);
		Tram t2 = new Tram();
		t1.setDriverName("Jack Frost");
		t1.setMaxSpeed(85);
		t1.setTicketPrice(2.99);
		t1.setOprYr(2001);
		array[7]=t;
		array[8]=t1;
		array[9]=t2;
		
		/**
		 * Determining if the first and second Tram objects contain the same information.
		 */
		System.out.println(t.equals(t1));
		/**
		 * Displaying the information of the first Tram object.
		 */
		System.out.println(array[7].toString() + "\n");
		
		/**
		 * Creating three Ferry objects and storing them into the publicTransportation array.
		 */
		Ferry f = new Ferry(12.50, 1, 1990, "Titanic");
		Ferry f1 = new Ferry(f);
		Ferry f2 = new Ferry();
		f2.setBuildYr(1997);
		f2.setNumStops(5);
		f2.setShipName("Big Ship");
		f2.setTicketPrice(14.25);
		array[10]=f;
		array[11]=f1;
		array[12]=f2;
		
		/**
		 * Determining if the two Ferry objects contain the same information.
		 */
		System.out.println(f.equals(f1));
		/**
		 * Displaying the information of the first Ferry object.
		 */
		System.out.println(array[10].toString() + "\n");
		
		/**
		 * Creating two AirCraft objects and storing them into the publicTransportation array.
		 */
		classType cT = classType.Airline;
		maintenanceType mT = maintenanceType.Weekly;
		AirCraft a = new AirCraft(200,2,cT, mT);
		AirCraft a1 = new AirCraft(200,2,cT,mT);
		array[13]=a;
		array[14]=a1;
		
		/**
		 * Determining if the two AirCraft objects contain the same information.
		 */
		System.out.println(a.equals(a1));
		/**
		 * Displaying the information of the first AirCraft object created.
		 */
		System.out.println(a.toString() + "\n");
		
		System.out.println("CHECKING THE CHEAPEST AND MOST EXPENSIVE TICKET PRICES");
		/**
		 * Determining which for of transportation has the cheapest ticket price, and displaying its information.
		 */
		trace(array);
		
	}

	/**
	 * Displays the information of the cheapest and most expensive ticket price.
	 * @param array and array of PublicTransportation
	 */
	public static void trace(PublicTransportation[] array) {
		double min = 1000000;
		double max = 0;
		int minPosition;
		int maxPosition;
		
		/**
		 * Determining the cheapest and most expensive ticket price.
		 */
		for(int i=0; i<array.length;i++) {
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
	
}
