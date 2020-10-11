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


import java.util.NoSuchElementException;

public class CellList{

	//Instance variables
	private CellNode head;
	private int size;
	
	/**
	 * Default constructor. 
	 */
	public CellList() {
		head=null;
		size=0;
	}
	
	/**
	 * Takes a CellList as a parameter and copies it.
	 * @param cList CellList
	 */
	public CellList(CellList cList) {
		CellNode temp = cList.head;
		while(temp!=null) {
			this.addToEnd(temp.c);
			temp=temp.link;
		}
	}
	
	/**
	 * returns the size of the CellList.
	 * @return size int
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Creates a copy of the calling CellList.
	 */
	public CellList clone() {
		return new CellList(this);
	}
	
	/**
	 * Displays the contents of the LinkedList.
	 */
	public void showContents() {
		CellNode temp=head;
		String s = "";
		int count =0;
		System.out.println("The current size of the list is " + this.size + ". Here are the contents of the list");
		System.out.println("==========================================================================");
		while(temp!=null) {
			if(count%3==0) {
				System.out.println();
			}
			System.out.print(temp.c.toString());
			temp=temp.link;
			count++;
		}
	}
	
	/**
	 * Creates a CellNode and adds it to the beginning of the linked list
	 * @param cp CellPhone
	 */
	public void addToStart(CellPhone cp) {
		CellNode cNode = new CellNode(cp, head);
		head=cNode;
		size++;
	}
	
	/**
	 * Creates a CellNode and adds it to the beginning of the linked list
	 * @param cp CellPhone
	 */
	public void addToEnd(CellPhone cp) {
		CellNode cNode = new CellNode(cp,null);
		CellNode temp = head;
		if(head==null) {
			head = cNode;
			size++;
			return;
		}
		else if(head.link==null) {
			head.link = cNode;
			size++;
			return;
		}
		
		while(temp.link != null) {
			temp=temp.link;
		}
		temp.link=cNode;
		size++;
	}
	
	/**
	 * Adds a CellNode at the specified index and shifts the LinkedList accordingly.
	 * @param cp CellPhone
	 * @param index int 
	 */
	public void insertAtIndex(CellPhone cp, int index) {
		int count=0;
		if(index<0)
			return;
		if(index>size-1)
			throw new NoSuchElementException();
		else if(index==0){
			this.addToStart(cp);
			return;
		}
		else {
			CellNode temp = head;
			while(count!=index-1) {
				temp=temp.link;
				count++;
			}
			CellNode c = new CellNode(cp,temp.link);
			temp.link=c;
		}
		size++;
	}
	
	/**
	 * Deletes CellNode at the specified LinkedList at the specified index.
	 * @param index int
	 */
	public void deleteFromIndex(int index) {
		int count=0;
		if(index<0)
			return;
		if(index>size-1)
			throw new NoSuchElementException();
		else if(index==0) {
			head=head.link;
		}
		else {
			CellNode temp = head;
			while(count!=index-1) {
				temp=temp.link;
				count++;
			}
			temp.link=temp.link.link;
		}
		size--;
	}
	
	/**
	 * Deletes the first CellNode in the LinkedList
	 */
	public void deleteFromStart() {
		if(head==null)
			return;
		else if(size==1) {
			head=null;
			return;
		}
		head=head.link;
	}
	
	/**
	 * Replaces a CellNode at the specified index
	 * @param cp CellPhone
	 * @param index int
	 */
	public void replaceAtIndex(CellPhone cp, int index) {
		CellNode temp = head;
		int count=0;
		if(index<0)
			return;
		if(index>size-1)
			throw new NoSuchElementException();
		else if(index==0) {
			CellNode replace = new CellNode(cp,head.link);
			head=replace;
		}
		else {
			while(count!=index-1){
				temp=temp.link;
				count++;
			}
			CellNode replace = new CellNode(cp,temp.link.link);
			temp.link=replace;
		}
	}
	
	/**
	 * Returns a pointer to the specified CellNode
	 * @param snum long
 	 * @return CellNode pointer to the location of the CellNode in the LinkedList
	 */
	//Privacy leak because the user can store the location of the CellNode s a variable and can change it.
	//The user can also delete the entire CellList if they set the head to null;
	public CellNode find(long snum) {
		int count=0;
		CellNode temp = head;
		while(count<size) {
			if(temp.c.getSerialNum()==snum)
				return temp;
			temp=temp.link;
			count++;
		}
		return null;
	}
	
	/**
	 *  * This Method returns a string that shows the pointer node and the number of iterations
	 * @param snum long the serial number
	 * @return String the location of the CellNode
	 */
	public String finds(long snum) {
		int count=1;
		CellNode temp = head;
		while(count<size) {
			if(temp.c.getSerialNum()==snum)
				return ("The CellPhone is located in " + temp+"\nand it went through "+count+" iterations\n");
			temp=temp.link;
			count++;
		}
		return null;
	}
	/**
	 * Returns a boolean value depending if the serial number is in the LinkedList
	 * @param snum long
	 * @return boolean
	 */
	public boolean contains(long snum) {
		
		int count=0;
		CellNode temp = head;
		if(size==1) {
			return(temp.c.getSerialNum()==snum);
		}
		while(count<size-1) {
			if(temp.c.getSerialNum()==snum)
				return true;
			temp=temp.link;
			count++;
		}
		return false;
	}
	
	/**
	 * Returns boolean value depending if the two LinkedLists contain the same CellPhones
	 * @param list CellList
	 * @return boolean
	 */
	public boolean equals(CellList list) {
		if(this.size!=list.size)
			return false;
		CellNode temp=head;
		CellNode t=list.head;
		while(temp!=null) {
			if(!temp.c.equals(t.c))
				return false;
			temp=temp.link;
			t=t.link;
		}
		return true;
	}
	
	/**
	 * Returns boolean value depending if the two LinkedLists contain the same CellPhones
	 */
	public boolean equals(Object o) {
		if(o==null || this.getClass()!=o.getClass())
			return false;
		CellList list = (CellList)o;
		if(this.size!=list.size)
			return false;
		CellNode temp=head;
		CellNode t=list.head;
		while(temp!=null) {
			if(!temp.c.equals(t.c))
				return false;
			temp=temp.link;
			t=t.link;
		}
		return true;
	}
	
	/**
	 *Inner class
	 */
	private class CellNode {
		/**
		 * Instance variables
		 */
		private CellPhone c;
		private CellNode link;
		
		/**
		 * Default Constructor
		 */
		public CellNode() {
			this.c=null;
			this.link=null;
		}
		
		/**
		 * Parameterized Constructor that takes in a CellPhone and a CellNode
		 * @param cp CellPhone
		 * @param link CellNode
		 */
		public CellNode(CellPhone cp, CellNode link) {
			this.c= cp;
			this.link=link;
		}
		
		/**
		 * Copy constructor
		 * @param c CellNode
		 */
		public CellNode(CellNode c) {
			this.c=c.c;
			this.link=c.link;
		}
		
		/**
		 * gets the CellPhone
		 * @return CellPhone
		 */
		public CellPhone getC() {
			return c;
		}

		/**
		 * sets the CellPhone to c
		 * @param c CellPhone
		 */
		public void setC(CellPhone c) {
			this.c = c;
		}

		/**
		 * gets the CellNode
		 * @return link CellNode
		 */
		public CellNode getLink() {
			return link;
		}

		/**
		 * sets the CellNode
		 * @param link CellNode
		 */
		public void setLink(CellNode link) {
			this.link = link;
		}
		
		/**
		 * Clones the CellNode
		 */
		public CellNode clone() {
			CellNode cp = new CellNode();
			cp.c=this.c;
			cp.link=this.link;
			return cp;
		}

		
	}
	
}