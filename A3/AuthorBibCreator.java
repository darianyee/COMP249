//-------------------------------------------
//Assignment(#3)
//Question #1 (Part 2)
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

import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.Scanner;
/*
 * This program takes an authors name from a user and prints out all articles written by that author in 3 different formats in 3 different files
 * It will check all the files in a directory and determine which ones are valid or not
 * If a file does not exist it will close the program
 * If 3 reference files already exists for an author it will move the existing one to a back up file and save the new one as the original
 * 
 */
public class AuthorBibCreator {

	public static void main(String[] args) {

		/*
		 * Welcome message
		 */
		System.out.println("Welcome to BibCreator!");
		/*
		 * Searching for author
		 */
		System.out.print("Please enter the author name you are targeting: ");
		Scanner key=new Scanner(System.in);
		String name=key.next();
				
		/*
		 * Creating folder for .bib files
		 */
		File folder = new File("C:\\Users\\DY\\eclipse-workspace\\COMP 249 Assignment 3\\bibFiles");
		File[] listOfFiles = folder.listFiles();
		/*
		 *  This checks if all the files exists
		 */
	for (int i=0;i<listOfFiles.length;i++)
		if (listOfFiles[i].exists()==false) {
			{System.out.println("Could not open input file "+listOfFiles[i].getName()+" for reading");
			System.out.println("Please check if file exists! Program will terminate after closing");
			key.close();
			System.exit(0);}
			
		}
		
		System.out.println();
		processBibFile(listOfFiles, name);
			
	}

	/**
	 * This Method takes in a directory and an author names and prints out 3 reference files
	 * 
	 * @param f An array of File objects to be searched
	 * @param name a String variable that is to searched for in the array of Files
	 */
	public static void processBibFile(File[] f, String name) {
		
		String str1 = "", str2 = "", str3 = "";
		PrintWriter fa=null;
		PrintWriter fb=null;
		PrintWriter fc=null;
		File f1=null;
		File f2=null;
		File f3=null;
		File f4=null;
		File f5=null;
		File f6=null;
		String s1=name+"-IEEE.json";
		String s2=name+"-NJ.json";
		String s3=name+"-ACM.json";
		String s4=name+"-IEEE-BU.json";
		String s5=name+"-ACM-BU.json";
		String s6=name+"-NJ-BU.json";
		int count=0;
		
		
		/*
		 * getting the number of files being read
		 */
		int numOfScanner = f.length;
		/*
		 * declaring an array of Scanners to read in each file
		 */
		Scanner[] scArr = new Scanner[numOfScanner];
		/*declaring a String array of String to convert each file into a String variable
		 * 
		 */
		String[] fileArr = new String[numOfScanner];
		for(int i=0;i<numOfScanner;i++) {
			fileArr[i]="";
		}
		
		try {
			/*
			 * searching through each file in the array
			 */
			for(int i=0; i<numOfScanner;i++) {
				/*
				 * setting a scanner to read a specific file
				 */
				scArr[i]=new Scanner(f[i]);
				/*
				 * converting the file to a String and storing it into an array
				 */
				while(scArr[i].hasNextLine()) {
					fileArr[i] = fileArr[i].concat(scArr[i].nextLine()+"\n");
				}
			
								
				/*
				 * getting the number of @ARTICES in the file
				 */
				int articleNum = numOfArticle(fileArr[i]);
				
	
				
				String[] ArticleArr = fileArr[i].split("@ARTICLE");
			
				/*
				 * If an article contains an authors name, it will create an article object 
				 */
				try {
					Article[] ArtArr = new Article[articleNum];
					for(int x=0; x<articleNum;x++) {
						if(ArticleArr[x].contains(name)) {
							ArtArr[x] = new Article("@ARTICLE " + ArticleArr[x]);
						}
						else
							ArtArr[x]=null;
					}
					
					/*
					 * This will string together each article by the author in the given format, each reference on a new line
					 */
					for(int x=0; x<articleNum; x++)
						if(ArtArr[x]!=null) {
							str1=str1.concat("\n")  + ArtArr[x].IEEEformat() + "\n";
							str2=str2.concat("\n") + ArtArr[x].NJformat() + "\n";
							count++;
							str3=str3.concat("\n") + "[" + count + "]\t" + ArtArr[x].ACMformat() + "\n";
						}
				}
				catch(Exception e) {
					System.out.println("Something went wrong");
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.print(e.getMessage());
		}
		
		/*
		 * If there are no articles by the author given, no files will be created
		 */
		if(str1.equals("") || str2.equals("") || str3.equals("")) {
			System.out.println("No records were found for the author(s) with the name: " + name +
					"\nNo files have been created!");
	     	System.out.println("\nGoodbye! Hope you have enjoyed creating the needed files using AuthorBibCreator.");
			System.exit(0);
		}

		
	/*
	 * This try block will try to open up 3 files one for each format
	 * If it already exists it will move the existing one to a backup and save the current on as an original
	 * if a backup already exists it will delete it
	 * 
	 */
		try{
			
			f1=new File(s1);
			f2=new File(s2);
			f3=new File(s3);
				if (f1.exists()||f2.exists()||f2.exists())
					throw new FileExistsException("File Already Exists");
				try{
					fa=new PrintWriter(new FileOutputStream(s1));
					fb=new PrintWriter(new FileOutputStream(s2));
					fc=new PrintWriter(new FileOutputStream(s3));
					fa.print(str1);
					fb.print(str2);
					fc.print(str3);
				}
				/*
				 * If a filenotfoundexception is thrown, the program will close all files and delete the directory
				 */
				catch (FileNotFoundException e) {
			
					System.out.println("Error Occured, Program Will Close All Files and Delete Directory");
					fa.close();
					fb.close();
					fc.close();
					new File(s1).delete();
					new File(s2).delete();
					new File(s3).delete();	
				}
		}catch (FileExistsException e) {
			System.out.println("A file already exists with the name: "+s1);
			System.out.println("File will be renamed as: "+s4+" and any old BUs will be deleted");
			System.out.println(" ");
			System.out.println("A file already exists with the name: "+s2);
			System.out.println("File will be renamed as: "+s5+" and any old BUs will be deleted");
			System.out.println(" ");
			System.out.println("A file already exists with the name: "+s3);
			System.out.println("File will be renamed as: "+s6+" and any old BUs will be deleted");
			System.out.println(" ");
			f4=new File(s4);
			f5=new File(s5);
			f6=new File(s6);
			if (f4.exists())
				f4.delete();
			if (f5.exists())
				f5.delete();
			if (f6.exists())
				f6.delete();
			f1.renameTo(f4);
			f2.renameTo(f5);
			f3.renameTo(f6);
			try {
				fa=new PrintWriter(new FileOutputStream(s1));
				fb=new PrintWriter(new FileOutputStream(s2));
				fc=new PrintWriter(new FileOutputStream(s3));
			}
			catch(FileNotFoundException e1) {
				System.out.println(e1.getMessage());
			}
			fa.println(str1);
			fb.println(str2);
			fc.println(str3);
		}
		finally {
	     	
	     	if(fa!=null)
	     		fa.close();
	     	if(fb!=null)
	     		fb.close();
	     	if(fc!=null)
	     		fc.close();
	     	
	     	System.out.println("A total of " + Article.numOfArticles + " records were found for author(s) with name: " + name);
	     	System.out.println("Files " + s1 + ", " + s2 + " and " + s3 + " have been created!");
	     	System.out.println("\n\nGoodbye! Hope you have enjoyed creating the needed files using AuthorBibCreator.");
	 }
}
		
		
		
	
		
	
	
	

	
	/**
	 * 
	 * @param s String of the contents in the file
	 * @return	int the number of Articles in the file
	 */
	public static int numOfArticle(String s) {
		int count=0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='A'&&s.charAt(i+1)=='R' && s.charAt(i+2)=='T' && s.charAt(i+3)=='I' && s.charAt(i+4)=='C'
					&& s.charAt(i+5)=='L'&& s.charAt(i+6)=='E' )
				count++;
		}
		return count;
	}
	

}

