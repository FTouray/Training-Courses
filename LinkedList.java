/**
 * File Name: LinkedList.java
 * Author: Fatoumatta Touray
 * Student Number: C21354101
 * Description of class: This class implements the ADT definition of a linked list using the same signatures.
 */

package dataStructures;

//This class implements the ADT definition of a linked list using the same signatures. Note that we can add extra methods
//here once all of the methods listed in the ADT interface are included.

public class LinkedList<T> implements LinkedListADT<T> {

	private int count; // the current number of elements in the list
	private LinearNode<T> list; // pointer to the first element
	private LinearNode<T> last; // pointer to the last element

	// -----------------------------------------------------------------
	// Creates an empty list.
	// -----------------------------------------------------------------
	public LinkedList() {
		this.count = 0;
		this.last = null;
		this.list = null;
	}


	/**
	 * 1. Adds a generic object to the end of a list if only the object doesn't
	 * exist already in the list. The object should be input as a parameter
	 */
	public void add(T element) {

		LinearNode<T> node = new LinearNode<T>(element);

		if (size() == 0) {
			this.last = node; // This is the last and the
			this.list = node; // first node
			this.count++;
		} // end if
		else if (!(contains(element))) {
			last.setNext(node); // add node to the end of the list
			last = node; // now make this the new last node.
			this.count++;
		} // end else

	}

	/**
	 * 2. Add a generic object in the correct sorted position in the list. Allow
	 * method to take 2 parameters. The first parameter is the object that is being
	 * inserted into the list and the second parameter is an integer value which
	 * indicates where in the list the object should be inserted. So this value is
	 * 1, the object should be added to the start of the list. If the value is 2,
	 * the object should be inserted as the second object in the list
	 */	
	public void add(T element, int index) {
		LinearNode<T> node = new LinearNode<T>(element);
		if (index < 0) {
			//display message
			System.out.print("Index out of bounds");
		}
		
		if (list == null) { //If the list empty add the element to the start of the list instead of index.
			//node.setNext(list);
			//list = node;
			this.last = node; // This is the last and the
			this.list = node; // first node
			this.count++;
		}
		else
			if (index == 0) { //If the index is 0 add the element as the first element in the list
			node.setNext(list);
			list = node;
			this.count++;
		} 
			else if (index > size()){ //If the index is greater than the size of the list add the element to the end list
				last.setNext(node); // add node to the end of the list
				//last = node; // now make this the new last node.
				//this.count++;
				this.last = node; // This is the last and the
				this.count++;
			}
		else if (index <= size()) //Else if the index is smaller than the size or equal equal add the element to that position
		{
			LinearNode<T> previous = list;
			int count = 1;
			
			while (count < index) {
				previous = previous.getNext(); //previous moves the the next node as the loop continues
				count++;
			}
			
			LinearNode<T> current = previous.getNext(); //current is now the node next to the previous node
			previous.setNext(node); //the new node is now next to the previous node
			node.setNext(current); //the current is inserted next to the new node
			this.count++;
			
		}
	}
	
	
	public T remove() {
		 LinearNode<T> temp = null;
		   T result = null;
			if (isEmpty()) {
				System.out.println("There are no nodes in the list");
			}//end if
			else {
				
				result = this.list.getElement();
				temp = list;
				this.list = this.list.getNext();
				temp.setNext(null); //dereference the original first element
				//count--;
			}//end else
			return result;
	}
	
	/**
	 * 3. Delete any object from the list where the object is passed in a 
	 * parameter
	 */	
	public T remove(T element) {
		 LinearNode<T> current = this.list;
		 LinearNode<T> previous = this.list;
		 
		 //If list is empty
		 if (isEmpty()) {
				System.out.println("There are no nodes in the list");
			}
		
					if (current == null) {
						return null; 
					}
		 
		//Element to be deleted is at the start of the list
		 if (current != null && current.getElement().equals(element)) {
		//list = current.getNext(); //set the first node to the element next the current element that equals the element inputted
			 //this.list = this.list.getNext();
		//current.setNext(current.getNext());
		//current.setNext(null);
		//count--;
			 current = list;
			this.list = this.list.getNext();
			current.setNext(null);
			this.count--;
			 //remove();
	}else { ////////////
		
	
		 //Element is anywhere in the list
		/**while current is not null and the element of current does not equal element inputted iterate to the list and move to the next element 
		 * until the element of current equals the element inputted*/
		 while (current != null && !current.getElement().equals(element)) {
				previous = current; //points to current before current goes to the next element to store it as the previous element
				current = current.getNext();
			}
		 previous.setNext(current.getNext());
		 this.count--;
	}
//		//Element is not in the list so return null
//			if (current == null) {
//				return null; 
//			}
		 
		//Points to the node after current bypassing the current node
	///////////previous.setNext(current.getNext());
	//Size of the list is smaller
	/////////this.count--;
	
	return current.getElement();
}

	
	/** 4. Display all object data in the list */
	// Returns a string representation of this list
	public String toString() {
		LinearNode<T> current = null;
		String fullList = "";

		for (current = this.list; current != null; current = current.getNext()) {
			fullList = fullList + "\n" + current.getElement().toString();
		} // end for

		return fullList;
	}

	/** 5. Return the first linear node in the list */
	public LinearNode<T> getFirstLinearNode() {
		return this.list;
	}

	/** 6. Return the last linear node in the list */
	public LinearNode<T> getLastLinearNode() {

		return this.last;
	}

	/** 7. Return the first element in the list */
	public T getFirst() {

		if (list == null) { // if list is empty
			System.out.println("There is no elements in the list");
		}

		// Returns the first element
		return list.getElement();
	}

	/** 8. Return the last linear element in the list */
	public T getLast() {
		if (last == null) {
			System.out.println("There is no elements in the list");
		}

		LinearNode<T> temp = last;
		// The while loop takes us to the end of the LinkedList
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		// Returns the last element
		return temp.getElement();
	}

	/**
	 * 9. Return the next element in the list (where the current element is input into
	 * the method as a parameter
	 */
	public T getNext(T element) {
		// Stores element that is entered as a parameter
		LinearNode<T> current = this.list;
		// Store the element next to the element that was entered as a parameter
		LinearNode<T> next = list;

		if (current == last) {
			System.out.print("This is the last element in the list." + "\nThere is no element next to it");
		}

		if (isEmpty()) {
			// The node is empty
			System.out.println("There are no nodes in the list");
			return null;
		}
		
		for (current = this.list; current != null; current = current.getNext()) {
			// If current equals to the element entered as a parameter
			if (current.getElement() == element) // (current.getElement().equals(element))
			{
				// Set next to the element next to the element that was inputted as a parameter
				next = current.getNext();

			}

		} // end for
			
			// return the element next to the one inputted
		return next.getElement();

	}

	/** 10. Check to see if list is empty */
	// Returns true if this list contains no elements
	public boolean isEmpty() {
		if (this.list == null)
			return true; 
		else
			return false;
	}

	/**
	 * 11. Check to see if the list already contains a generic object as an input as
	 * a parameter and returns a boolean
	 */
	public boolean contains(T element) {
		
		LinearNode<T> current = list;
		while (current != null) { //loop while current is not null
			if(current.getElement().equals(element)) { //if the current element equals the element inputted as a parameter
				return true; //return true
			}
				current = current.getNext(); //if it is not keep looping through the list - move to the next element and check if it equals
			
		}
		return false; //if it does not return false
	}
	
	
		
	
	/**12. Include another function into this linked list class that you will call in your driver class*/
	/**----------------------------EXTRAS----------------------------------------------------*/

	// Returns the 'i'th element in the linked list
	public T get(int i) {
		
			//LinearNode<T> current = list;
			LinearNode<T> current = this.list;

			if ( i < 0 || i > size()) //if the index is smaller than 0 or greater than the size of the list
			{
				return null;
			}
			else
			{
				
			//Iterate through the list 
				for (int c = 1; c < i; i++) {
					while(current.getNext() != null) {  //if current does not equal null keep iterating / if current equals null means you are at the end of the list
					current = current.getNext(); //current moves to the next element 
					
				}
					
				}
			
			
				return current.getElement(); //return the element of current
			}

			
	}
	
	
	// Returns the number of elements in this list
	public int size() {
		return this.count;
	}

	

}
