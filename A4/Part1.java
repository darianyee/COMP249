//-------------------------------------------
//Assignment(#4)
//Question #1 (Part 1)
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


import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
public class Part1 {

	public static void main(String[] args) {
		
	/*
	 * Initialized Scanner,PrintWriter and asked user the name of the file they wish to open
	 */
		
	// C:\Users\DY\eclipse-workspace\COMP 249 Assignment 4\A4 Files Part 1\PersonOfTheCentury.txt
		
	Scanner key=new Scanner(System.in);
	System.out.println("Welcome To Sub Dictionary Creator");
	System.out.println("Please enter the name of the input file");
	String f=key.nextLine();
	PrintWriter out = null;
	/*
	 * Opened a file called SubDictionary
	 * created a String ArrayList which uses the methods defined below to create the dictionary 
	 */
	try {
		out = new PrintWriter(new FileOutputStream("SubDictionary.txt"));
		ArrayList<String> a=sort(shorten(Dictionary(f)));
		/*
		 * the first index in the Arraylist is a blank therefore it needs to be removed
		 */
		a.remove(0);
		int count=a.size();
		out.println("The document produced this sub-dictionary, which includes " + count + " entries.\r\n");
		/*
		 * Created a new Character ArrayList
		 * This loop goes through the sorted definition list,it'll see if the helper list as the first letter of a word,
		 * and if it doesn't it'll add that letter with the equal sign
		 * This way it'll only add each letter once, and it will be the first instance of that letter
		 */
		ArrayList <Character>helper=new ArrayList<Character>();
		//printing the characters
		for (int i=0;i<a.size();i++) {
			if (!helper.contains(a.get(i).charAt(0))) {
				helper.add(a.get(i).charAt(0));
				out.println("\n"+a.get(i).charAt(0)+"\n==");
			}
			//printing the words from the file
			out.println(a.get(i));
			
		}
	}
	/*
	 * If the file cannot be found this exception will be thrown
	 */
	catch(FileNotFoundException e) {
		System.out.println(e.getMessage());
		System.out.println("System will now exit");
		System.exit(0);
	}
	/*
	 * Close Scanner 
	 */
	finally {
		out.close();
		System.out.println("The file has been read and a sub dictionary has been created.");
	}
	
	}
	
	/**
	 * This Method creates an unsorted list of words from a file
	 * 
	 * @param input String
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> Dictionary(String input){
		String words;
		ArrayList<String> A1=new ArrayList<String>();
			try {
				Scanner sc=new Scanner(new FileInputStream(input));
				/*
				 * This delimeter removes all special characters and whitespace
				 */
				sc.useDelimiter("[.=,:;?!\\s]");
				/*
				 * Changes all the words to upper case and removes all 'M and 'S
				 */
				while (sc.hasNext()) {
					words=sc.next().toUpperCase();
					words=words.replaceAll("’M", "");
					words=words.replaceAll("’S", "");
					
					/*
					 * If there is a digit, it will not put that word in the dictionary 
					 */
					if (words.matches(".*\\d.*"))
						continue;
					/*
					 * If a word is only 1 letter and is not A or I, it won't add that word
					 */
					if(words.length()==1 && words.indexOf("A")==-1 && words.indexOf("I")==-1)
						continue;
					A1.add(words);
				}
			}catch (FileNotFoundException e) {
				System.out.println("No File with that name found, Program will now terminate");
				System.exit(0);
			}
			return A1;
	}


	/**
	 * Gets rid of the duplicates in the ArrayList<String>
	 * 
	 * @param StrArr Takes an ArrayList of String and removes the duplicates
	 * @return ArrayList of String
	 */
	public static ArrayList<String> shorten(ArrayList<String> StrArr) {
		//Trimming Array
		StrArr.trimToSize();
		
		// Storing the size of the ArrayList
		int size = StrArr.size();
		ArrayList<String> a = new ArrayList<String>();
		
		// Getting rid of duplicates in the array
		for(int i=0; i<size;i++) {
			if(a.contains(StrArr.get(i)))
				continue;
			a.add(StrArr.get(i));
		}
		return a;
	}
	
	/**
	 * sorts the ArrayList in lexicographic order
	 * 
	 * @param StrArr ArrayList of String and sorts it in lexicographic order
	 * @return
	 */
	public static ArrayList<String> sort(ArrayList<String> StrArr) {
		StrArr.trimToSize();
		int size = StrArr.size();
		String temp="";
		int count=0;
		
		if (StrArr.size()>1) {
			// check if the number of orders is larger than 1
            for (int i=0; i<size; i++) {
            	// bubble sort outer loop
                for (int j=0; j < size-1; j++) {
                    if (StrArr.get(j).compareTo(StrArr.get(j+1)) > 0){
                        temp = StrArr.get(j);
                        StrArr.set(j,StrArr.get(j+1) );
                        StrArr.set(j+1, temp);
                    }
                }
            }
        }
		return StrArr;
	}
}


