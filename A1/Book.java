//-------------------------------------------
//Assignment(#0)
//Question #1 (Part 1)
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
 * The Book class implements methods to input, edit and view a book's information.
 */
public class Book {

	/**
	 * title is the first instance variable
	 * author is second instance variable
	 * ISBN is the third instance variable
	 * price is the fourth instance variable
	 * count is the fifth instance variable
	 */
	private String title;
	private String author;
	private long ISBN;
	private double price;
	private static int count;
	
	/**
	 * Default constructor when a Book object is created and counts the number books created.
	 */
	public Book() {
		count++;
		this.title = "No Title";
		this.author = "No author";
		this.ISBN = 0;
		this.price = 0.0;
	}
	
	/**
	 * Constructor that takes two String values, a long and a double and sets it as the Book's title, author, ISBN and price.
	 * 
	 * @param title a String is the first parameter
	 * @param author a String is the second parameter
	 * @param ISBN a long is the third parameter
	 * @param price a double is the fourth parameter
	 */
	public Book(String title, String author, long ISBN, double price) {
		count++;
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.price = price;
	}
	
	//static method that prints out the number of books created
	/**
	 * Calculates the total number of books created
	 */
	public static void findNumberOfCreatedBooks(){
		System.out.println(count);
	}
	
	/**
	 * @return String gets the title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * @return String gets the author
	 */
	public String getAuthor() {
		return this.author;
	}
	
	/**
	 * @return long gets the ISBN
	 */
	public long getISBN() {
		return this.ISBN;
	}
	
	/**
	 * @return double gets the price
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * @param newTitle to set as the title
	 */	
	public void setTitle(String newTitle) {
		this.title = newTitle;
	}
	
	/**
	 * @param newAuthor to set as the author
	 */	
	public void setAuthor(String newAuthor) {
		this.author = newAuthor;
	}
	
	/**
	 * @param newISBN to set as the ISBN
	 */	
	public void setISBN(long newISBN) {
		this.ISBN = newISBN;
	}
	
	/**
	 * @param newPrice to set as the price
	 */	
	public void setPrice(Double newPrice) {
		this.price = newPrice;
	}
	
	/**
	 * Converts the books' information (title, author, ISBN and price) into a String
	 * 
	 * @return a String of the books information
	 */
	public String toString() {
		return "Author: " + author + "\n" +
				"Title: " + title + "\n" + 
				"ISBN: " + ISBN + "\n" + 
				"Price: " + price;
	}

	/**
	 * Determines if two books have the same ISBN and price
	 * 
	 * @param book1 a Book object
	 * @return boolean calculated from the two book objects
	 */
	public boolean equals(Book book1) {
		return (this.ISBN == book1.ISBN && this.price == book1.price);
	}
	
}
