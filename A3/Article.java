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
import java.util.Scanner;
/*
 * This class was created to help format the articles
 */
public class Article {

	/*
	 * declaring instance variables
	 */
	private String[] author;
	private String journal;
	private String title;
	private String year;
	private String volume;
	private String number;
	private String pages;
	private String keywords;
	private String doi;
	private String ISSN;
	private String month;
	public static int numOfArticles=0;
	
	/**
	 * Receives an article and stores its information accordingly( title, author, etc...)
	 * 
	 * @param bibFile receives an article
	 * @throws FileExistsException throws an exception if any of the variables are null
	 */
	public Article(String bibFile) throws FileExistsException{
		//increments each time a new Article is created
		numOfArticles++;
		//Splits the file into an array of Strings (based on what is in between the character '{' or '}'
		String[] s = bibFile.split("[{]|[}]");
		
		//if any of the sections in the array is empty, throw an exception
		for(int i=0; i<s.length;i++) {
			if(s[i].isEmpty()) {
				throw new FileExistsException();
			}
		}
		
		//storing the variables accordingly based on the variable name
		author = s[2].split(" and ");
		journal = s[4];
		title = s[6]; 
		year = s[8]; 
		volume = s[10]; 
		number = s[12]; 
		pages = s[14]; 
		keywords = s[16]; 
		doi = s[18];
		ISSN = s[20]; 
		month = s[22]; 
	}

	/**
	 * sorts the authors in IEEE format
	 * 
	 * @return String of authors in IEEE format
	 */
	public String IEEEauthor() {
		String temp="";
		for(int i=0;i<author.length-1;i++) {
			temp+=author[i] + ", ";
		}
		temp=temp+author[author.length-1]+ ". ";
		return temp;
	}
	
	/**
	 * 
	 * @return String bibliography in IEEE format
	 */
	public String IEEEformat() {
		return this.IEEEauthor() + "\"" + this.title + "\", " + this.journal + ", vol. "+ this.volume + 
				" no." + this.number + " p. " + this.pages + ", " + this.month + " " + this.year + "."; 
	}
	
	/**
	 * sorts authors in ACM format
	 * @return String of authors in ACM format
	 */
	public String ACMauthor() {
		return author[0] + " et al. ";
	}
	
	/**
	 * 
	 * @return String bibliography in ACMformat 
	 */
	public String ACMformat() {
		return this.ACMauthor() + this.year + ". " + this.title + ". " + this.journal + ". " + this.volume + ", " + this.number +
				" (" + this.year + "), " + this.pages + ". DOI:https://doi.org/" + this.doi + ".";
	}
	
	/**
	 * 
	 * @return String of authors in NJ format
	 */
	public String NJauthor() {
		String temp="";
		for(int i=0;i<author.length-1;i++) {
			temp+=author[i] + " & ";
		}
		temp=temp+author[author.length-1]+ ". ";
		return temp;
	}
	
	/**
	 * 
	 * @return String bibliography in NJ format
	 */
	public String NJformat() {
		return this.NJauthor() + this.title + ". " + this.journal + ". " + this.volume + ", " + this.pages + "(" + this.year + ")";
	}
	
}
