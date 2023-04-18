/**
 * File Name: LinkedListADT.java
 * Author: Fatoumatta Touray
 * Student Number: C21354101
 * Description of class: Abstract Data Type definition for a Linked List
 */  

//Abstract Data Type definition for a Linked List

//Note that this is not a full definition as we are only implementing some
//of the standard functions associated with a list.

package dataStructures;

public interface LinkedListADT <T>
	{
	   // Adds one element to the start or end of this list
	   public void add (T element);
	   
	   // Add element to sorted position in the list
	   public void add (T element, int index);
	   
	   // Returns the first element in the list
	   public T getFirst();
	   
	   // Returns the last element in the list
	   public T getLast();
	   
	   // Returns the first element in the list
	   public LinearNode<T> getFirstLinearNode();
	   
	   // Returns the last element in the list
	   public LinearNode<T> getLastLinearNode();

	   // Removes and returns the first element from this list
	   public T remove();
	   
	   // Search for an element and remove it
		public T remove(T element);
  
	   // Returns true if this list contains no elements
	   public boolean isEmpty();

	   // Returns the number of elements in this list
	   public int size();

	   // Returns a string representation of this list
	   public String toString();
	
	   // Searches and returns the 'i'th element in the linked list
	   public T get(int i);
	   
	   // Returns true if an element is duplicated in the list
	   public boolean contains(T element);
	   
	   // Return the next element in the list
	   public T getNext(T element); 

}
