/**
 * File Name: Employee.java
 * Author: Fatoumatta Touray
 * Student Number: C21354101
 * Description of class: This is a superclass that contains the employee number, the employee name,
 * the number of years the employee worked in the organisation and the name of the course.
 */  

package application;
import java.util.Scanner;

public class Employee {

	/**Define Employee - instance variables*/
	private String employeeNumber;
	private String name;
	private int yearsWorking;
	private String courseName;
	
	/**Constructor 1 - create blank object*/
	public Employee() {
		this.employeeNumber = "";
		this.name = "";
		this.yearsWorking = 0;
		this.courseName = "";
	}
	
	/**Constructor 2 - new employee object with data*/
	public Employee(String number, String name, int years, String course) {
		this.employeeNumber = number;
		this.name = name;
		
		/**Error Checking - only employees with over 5 years experience are allowed on training courses*/
		if (years <= 5)
		{
			 do
			 {
				 Scanner scan = new Scanner(System.in);
				 System.out.print("\nEmployee has to have over 5 years experience to join a training course");
				 System.out.print("\nPlease enter how many years experience the employee has");
				
				 years = scan.nextInt();
				 scan.nextLine();
				 
				 if (years > 5)
				 {
					 this.yearsWorking = years;
				 }
				 
			 }while (years <= 5);
		}
		else if (years > 5)
		{
			this.yearsWorking = years;
		}
		
		
		/**If the first 4 characters of the course name are not FOOD then the course name should be updated to ERROR. 
		 * Error Message should be displayed*/
		
		if( course.length() >= 4 &&  course.charAt(0) == 'F' && course.charAt(1) == 'O' 
				&& course.charAt(2) == 'O' && course.charAt(3) == 'D')
		{
			this.courseName = course;
		}
		else
		{
			this.courseName = "ERROR";
			setCourseName("ERROR");
			System.out.println("\nERROR - Course name that was inputted is invalid");
		}
		
		/**boolean correct = true;
		correct = courseNameCorrect(this.courseName);
    	if (correct == false)
    	{
    		System.out.println("\nERROR - Course name that was inputted is invalid");
    	}
		//this.courseName = course;*/
	}
	
	/**Constructor 3 - new employee object with only employee number data*/
	public Employee(String number, String course) {
		this.employeeNumber = number;
		if( course.length() >= 4 &&  course.charAt(0) == 'F' && course.charAt(1) == 'O' 
				&& course.charAt(2) == 'O' && course.charAt(3) == 'D')
		{
			this.courseName = course;
		}
		else
		{
			do
			 {
				 Scanner scan = new Scanner(System.in);
			System.out.println("\nERROR - Course name that was inputted is invalid");
			System.out.println("Enter a valid course");
			course = scan.nextLine();
			 }while ( course.length() < 4 &&  course.charAt(0) != 'F' && course.charAt(1) != 'O' 
						&& course.charAt(2) != 'O' && course.charAt(3) != 'D');
			if( course.length() >= 4 &&  course.charAt(0) == 'F' && course.charAt(1) == 'O' 
					&& course.charAt(2) == 'O' && course.charAt(3) == 'D')
			{
				this.courseName = course;
			}
		}
		
	}
	
	
/**GETTERS - returns the variable values*/
	public String getEmployeeNumber() {
		return this.employeeNumber;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getYearsWorking() {
		return this.yearsWorking;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	/**SETTERS - update the variable values*/
	public void setEmployeeNumber(String number) {
		this.employeeNumber = number;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setYearsWorking(int years) {
		this.yearsWorking = years;
	}
	
	public void setCourseName(String course) {
		this.courseName = course;
	}
	
	
	/**Comparing employee numbers of two employees for equality*/ 
	public boolean equals(Object o)
	{
		Employee e = (Employee)o; //Cast operator - take the variable o and override it
		if (this.employeeNumber.equalsIgnoreCase(e.getEmployeeNumber()))
		{
			return true; //if employee is found (i.e. employee exists) return true
		}
		else
		{
			return false; //if employee is not found (i.e. employee doesn't exist) return false
		}
	}
	
	/**If the first 4 characters of the course name are not FOOD then the course name should be updated to ERROR. 
	 * Error Message should be displayed*/
	/**Validating the course name - #1*/
	/**public boolean courseNameCorrect(String courseName) {
		boolean correct = true;
		
		if(courseName.charAt(0) != 'F' || courseName.charAt(1) != 'O' 
				|| courseName.charAt(2) != 'O' || courseName.charAt(3) != 'D')
		{
			correct = false;
			setCourseName("ERROR");
		}
		else if (courseName.charAt(0) == 'F' || courseName.charAt(1) == 'O' 
				|| courseName.charAt(2) == 'O' || courseName.charAt(3) == 'D')
		{
			correct = true;
		}
		
		return correct;
	}*/
	
	/**POLYORPHISM - OVERRIDING FROM OBJECT SUPERCLASS*/
	/**Method to display all employee details*/
	public String toString() {
		
		String result;
		//boolean correct = true;
		
		result = "\nEmployee Number: " + this.employeeNumber 
				+ "\nEmployee Name " + this.name 
				+ "\nNumber of years worked in FoodCo: " + this.yearsWorking
				+ "\nName of course: " + this.courseName;
		
		/**correct = courseNameCorrect(courseName);
    	if (correct == false)
    	{
    		result = result + "\nERROR - Course name that was inputted is invalid";
    	}*/
		
		return result;
	}
	
}
