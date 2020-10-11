//-------------------------------------------
//Assignment(#3)
//Question #1 (Part 1)
//Written by Darian Yee (40063058) and Sujan Saravanamuthu (40044870)
//-------------------------------------------

/**
* @author Darian Yee (40063058)
* @author Sujan Saravanamuthu (40044870)
* @version 1.0
*COMP 249
*Assignment #3
*Due: Thursday, March 21, 2019
*/

//Creating our own exception class
public class FileExistsException extends Exception{

	public FileExistsException() {
		super("Exception: There is already an existing file for that author. File will be renamed" +
					" as BU, and older BU files will be deleted!");
	}
	
	public FileExistsException(String s) {
		super(s);
	}
}

