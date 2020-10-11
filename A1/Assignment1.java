//-------------------------------------------
//Assignment(#0)
//Question #1 (Part 2)
//Written by Darian Yee (40063058)
//-------------------------------------------

/**
 * @author Darian Yee (40063058)
 * @version 1.0
 *COMP 249
 *Assignment #1
 *Due: Friday, February 1, 2019
 */

/**
 * The program creates an array of books for the user and gives them 5 options to pick from. The user can enter new
 * information about a book, edit information about a book, find out which books are written by a specific author,
 * find out if there are any books cheaper than a specified price or exit the program.
 */

import java.util.Scanner;

public class Assignment1 {

	public static void main(String[] args) {
		/**
		 * Initializing the Scanner
		 */
		Scanner KeyIn = new Scanner (System.in);
		
		/**
		 * Diaplsying a welcome message.
		 */
		System.out.println("|------****------****------****------****|");
		System.out.println("\tWelcome to Darian's Bookstore!!");
		System.out.println("|------****------****------****------****|\n");
		
		/**
		 * Initializing and declaring variables.
		 */
		int maxBooks, choice, option, bookSelected;
		final String psw = "password";
		int count1=0, count2=0, totalAttempts=0;
		String attempt, removeSpace;
		boolean valid = true; 
		String exitOrDisplay="y";
		int ftry=1, i = 0;
		int booknum=0,  rBooks=0, temp =0;
		boolean noBooks=false;
		double price;
		
		/**
		 * Asks the user the amount of Books they would like to store in their inventory until its a positive number.
		 */
		do {
		System.out.println("What is the maximum number of books your bookstore can contain?");
		maxBooks = KeyIn.nextInt();
		if(maxBooks<=0)
			System.out.println("Please pick a number greater than 0\n");
		
		}while (maxBooks<=0);
		
		/**
		 * Creating and initializing the array of Books.
		 */
		Book[] inventory = new Book[maxBooks];
		for(int k=0; k<maxBooks; k++) {
			inventory[k] = new Book();
		}
		rBooks = inventory.length;

		/**
		 * Asks the user to select an option from the main menu until option 5 is selected.
		 */
		do {
		printDisplay();
		choice = KeyIn.nextInt();
		
		/**
		 * Displays a message if the number is not between 1 and 5.
		 */
		if(choice>5||choice<1)
			System.out.println("Please pick a number from 1-5\n");
		
		/**
		 * Initializing switch statement
		 */
		switch(choice) {
		
		/**
		 * User can input books into the inventory
		 */
		case 1: {

			/**
			 * Prompts the user to input the password.
			 * If the user incorrectly guesses the password for 3 consecutive times,it brings them back to the main menu.
			 * If the user incorrectly guesses the password 12 times, then an exit message is displayed and the program ends.
			 * If the password is correct, then the counter is reset to 0.
			 */
			do {
				removeSpace = KeyIn.nextLine();
				System.out.println("Please enter your password");
				attempt = KeyIn.next();
				
				if(attempt.equals(psw)) {
					valid=false;
					count1=0;
				}

				else {
					count1++;
					totalAttempts++;
				}

				if(totalAttempts==12) {
					System.out.println("Program has detected suspicious activities and will terminate immediately!");
					break;
				}

				if(count1==3||count1==6||count1==9) {
					break;
				}

			}while(count1<12 && valid);
			
			valid=true;
			
			/**
			 * If the password is correct, the user is asked how many books they would like to fill in their inventory.
			 */
			if(attempt.equals(psw)) {
				int bookNum;
				
				System.out.println("How many books would you like to enter?");
				bookNum = KeyIn.nextInt();
				
				do {
					
					/**
					 * Displays a message if the inventory is already full.
					 */
					if(rBooks == 0) {
						System.out.println("Your inventory of books is full. You cannot add anymore books.");
						break;
					}
					
					/**
					 * Displays a message if the user wishes to enter a negative number of books or a number greater than the number of books available.
					 * Continuously prompts the user until a number between 0 and the maximum number of books in the inventory is entered.
					 */
					if((bookNum<0 || bookNum>inventory.length)&& ftry==1)
						do {
							System.out.println("Sorry, that is an invalid number. Please enter a number between 0 "
									+ "and " + inventory.length + "\nHow many books would you like to enter?");
							bookNum = KeyIn.nextInt();
						}while(booknum<0 || bookNum>inventory.length);
					
					/**
					 * Displays a message if the user wishes to enter a negative number of books or a number greater than the remaining amount in the inventory.
					 * Continuously prompts the user until a number between 0 and the remaining number of books in the inventory is entered.
					 */
					else if(ftry==2 &&(bookNum<0 | bookNum>rBooks)) {
						do {
							System.out.println("Sorry, that is an invalid number. Please enter a number between 0 and " + rBooks);
							System.out.println("How many books would you like to enter?");
							bookNum = KeyIn.nextInt();
						}while(bookNum<0 || bookNum>rBooks);
					}
					
					/**
					 * Leaves to the main menu if the user decides to enter 0 new books.
					 */
					else if(bookNum==0)
						break;
					
					/**
					 * Displays a message letting the user know how many empty books are remaining in the inventory.
					 */
					if(bookNum > rBooks) {
						System.out.println("You only have " + rBooks + " remaining books in your inventory");
						break;
					}
				}while(bookNum<0 || bookNum>inventory.length);
				
				/**
				 *  Leaves to the main menu if there are 0 remaining books in the inventory.
				 */
				if(rBooks == 0) {
					break;
				}
				else if(bookNum > rBooks) {
					continue;
				}
				
				if(ftry==1) {
					temp=bookNum;
					ftry=2;
				}
				/**
				 * Displays the amount of books remaining in your inventory.
				 */
				else {
					temp = i + bookNum;
					if(bookNum==0) {
						System.out.println("You have " + (inventory.length-temp) + " empty books remaining in your inventory");
						break;
					}
					if(rBooks==0)
						bookNum+=temp;
				}
				
				/**
				 * Sets the information for the books.
				 */
				for(int j = i; j<temp;j++) {
					inventory[j] = new Book();
					removeSpace = KeyIn.nextLine();
					
					System.out.println("Please enter the title of book #" + (j+1));
					String newTitle=KeyIn.nextLine();
					inventory[j].setTitle(newTitle);
				
					System.out.println("Please enter the author of book #" + (j+1));
					String newAuthor=KeyIn.nextLine();
					inventory[j].setAuthor(newAuthor);
				
					System.out.println("Please enter the ISBN of book #" + (j+1));
					long newISBN=KeyIn.nextLong();
					inventory[j].setISBN(newISBN);
				
					System.out.println("Please enter the price of book #" + (j+1));
					double newPrice=KeyIn.nextDouble();
					inventory[j].setPrice(newPrice);
					
					rBooks--;
					i = j+1;
				}
				
				/**
				 * Displays the amount of books remaining in your inventory
				 */
				System.out.println("You have " + (inventory.length-temp) + " empty books remaining in your inventory");
				if(temp==0) {
					if(inventory.length-temp==inventory.length)
						noBooks=false;
					else
						noBooks=true;
				}	
			}

			break;
		}
		
		/**
		 * The user can update information of books already in the inventory
		 */
		case 2:{
			
			/**
			 * Asks the user to input the password.
			 * If the password is correct, the user decides which information of the book they would like to update.
			 * If the user incorrectly guesses the password 3 consecutive times, program exits to the main menu.
			 */
			do {
				removeSpace = KeyIn.nextLine();
				System.out.println("Please enter your password");
				attempt = KeyIn.next();
				
				if(attempt.equals(psw)) {
					valid=false;
					count2=0;
				}
				else
					count2++;
				if(count2==3) 
					break;
				
				}while(count2<3 && valid);
						
			valid=true;
			
			if(count2==3) {
				count2=0;
				break;
			}
			
			/**
			 * If the user would like to update a book that is not in the inventory, a message is displayed.
			 * The user is asked if they would like to update another book or go back to the main menu.
			 */
			do {
				System.out.println("Which book number would you like to update? (min number is 0 and max number is " + (maxBooks-1) + ")");
				bookSelected = KeyIn.nextInt();
				
					if(bookSelected>=maxBooks || bookSelected<0) {
						System.out.println("Sorry, there is no book in the location you requested.\n\n" + 
										"Would you like to re-enter another book or quit and go back to the main menu?" +
										"(Press Y to enter another book or anything else to go back to the display screen)");
						exitOrDisplay = KeyIn.next();
						
					if(exitOrDisplay.equalsIgnoreCase("Y"))
						continue;
					else 
						break;
					}
					else if(inventory[bookSelected].getTitle().equals("No Title") && inventory[bookSelected].getAuthor().equals("No author")
						&& inventory[bookSelected].getISBN()==0 && inventory[bookSelected].getPrice()== 0.0) {
					System.out.println("Sorry there are no books in that spot for you to update.");
					break;
				}
			
				if(bookSelected>=0 && bookSelected<maxBooks) {
					int ftime=0;
					
					/**
					 * Asks the user what information they would like to change.
					 */
					do {
						if(ftime==0) {
							System.out.println("Book #" + (bookSelected+1));
							System.out.println(inventory[bookSelected].toString() + "\n");
							System.out.println("What information would you like to change?");
							System.out.println("\t1. author");
							System.out.println("\t2. title");
							System.out.println("\t3. ISBN");
							System.out.println("\t4. price");
							System.out.println("\t5. Quit (to main menu)");
							System.out.println("Enter your choice>");
						}
						
						if(ftime==1) {
							System.out.println("\nIs there any additional information you would like to change?");
							System.out.println("\t1. author");
							System.out.println("\t2. title");
							System.out.println("\t3. ISBN");
							System.out.println("\t4. price");
							System.out.println("\t5. Quit (to main menu)");
							System.out.println("Enter your choice>");
						}
						
						if(ftime==2)
							System.out.println("Please pick a number from 1-5");
						
						option = KeyIn.nextInt();
						removeSpace = KeyIn.nextLine();
					
						switch(option) {
					
						/**
						 * Asks the new user to set the new author and displays the updated information.
						 */
						case 1: {
							ftime=1;
							System.out.println("What would you like to set the author's name to?");
							String newAuthor = KeyIn.nextLine();
							inventory[bookSelected].setAuthor(newAuthor);
							System.out.println("Here is the updated version of the book");
							System.out.println(inventory[bookSelected].toString());
							break;
						}
					
						/**
						 * Asks the user to set the new title and displays the updated information
						 */
						case 2: {
							ftime=1;
							System.out.println("What would you like to update the book's title to?");
							String newTitle = KeyIn.nextLine();
							inventory[bookSelected].setTitle(newTitle);
							System.out.println("Here is the updated version of the book");
							System.out.println(inventory[bookSelected].toString());
							break;
						}
					
						/**
						 * Asks the user to set the new ISBN and displays the updated information
						 */
						case 3: {
							ftime=1;
							System.out.println("What would you like to update the new ISBN to?");
							Long newISBN = KeyIn.nextLong();
							inventory[bookSelected].setISBN(newISBN);
							System.out.println("Here is the updated version of the book");
							System.out.println(inventory[bookSelected].toString());
							break;
						}
					
						/**
						 * Asks the user to set the new price and displays the updated information.
						 */
						case 4: {
							ftime=1;
							System.out.println("What would you like to update the new price to?");
							Double newPrice = KeyIn.nextDouble();
							inventory[bookSelected].setPrice(newPrice);
							System.out.println("Here is the updated version of the book");
							System.out.println(inventory[bookSelected].toString());
							break;
						}
					
						/**
						 * Exits back to the main menu.
						 */
						case 5:{
							break;
						}
						
						default:{
							ftime=2;
							break;
						}
						
						}
					
					}while(option!=5);
					
					break;
				}
								
				}while(exitOrDisplay.equalsIgnoreCase("y"));
			
			break;
		}
		
		/**
		 * Checks the inventory and displays all the books written by the specified author
		 */
		case 3:{
			removeSpace = KeyIn.nextLine();
			System.out.println("Please enter an author name");
			String name = KeyIn.nextLine();
			findBooksBy(inventory, name);
			break;
		}
	
		/**
		 * Displays all the books that are cheaper than the specified price
		 */
		case 4:{
			/**
			 * 
			 */
			do {
			System.out.println("Please enter a price greater than $0.00");
			price = KeyIn.nextDouble();
			}while (price<=0);
			findCheaperThan(inventory, price);
			//Exits switch statement
			break;
		}
		
		/**
		 * Program ends and displays an exit message when option 5 is selected from the main menu
		 */
		case 5:{
			System.out.println("Thank you for visiting!! Hope to see you soon");
			break;
		}
		
		}
		
		/**
		 * Program ends if the user guesses the incorrect password 12 consecutive times
		 */
		if(totalAttempts==12)
			break;
		
		}while(choice!=5);
		
		/**
		 * Closes Scanner
		 */
		KeyIn.close();
	}

	/**
	 * Displays the main menu
	 */
	public static void printDisplay() {
		System.out.println("\n--------------MAIN MENU--------------\n");
		System.out.println("What do you want to do?");
		System.out.println("\t 1. Enter new books (password required)");
		System.out.println("\t 2. Change information of a book (password required)");
		System.out.println("\t 3. Display all books by a specific author");
		System.out.println("\t 4. Display all books under a certin price");
		System.out.println("\t 5. Quit");
		System.out.println("Please enter your choice>");
	}
	
	/**
	 * Displays all the books that are written by a specific author
	 * 
	 * @param inventory an array of books
	 * @param author a String
	 */
	public static void findBooksBy(Book[] inventory, String author) {
		int count=0;
		for(int i=0; i<inventory.length; i++) {
			if(inventory[i].getAuthor().equals("No author"))
				continue;
	
			if(inventory[i].getAuthor().equals(author)) {
				count++;
				System.out.println("Book #" + (i+1));
				System.out.println(inventory[i].toString() + "\n");
			}
		}
		if (count==0)
			System.out.println("Sorry there are no books written by: " + author + "\n");
	}
	
	/**
	 * Looks through the inventory of books and checks if there is a book cheaper than a specific price
	 * 
	 * @param inventory an array of Books
	 * @param price a double greater than 0
	 */
	public static void findCheaperThan(Book[] inventory, Double price) {
		int count=0;
		for(int i=0; i<inventory.length; i++) {
			if(inventory[i].getPrice()==0.0)
				continue;
			else if (inventory[i].getPrice()<price) {
				count++;
				System.out.println("Book #" + (i+1));
				System.out.println(inventory[i].toString() + "\n");
			}
		}
		if (count==0)
			System.out.println("Sorry there are no books that are $" + price + " or cheaper\n");
	}
	

}
