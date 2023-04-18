package application;

import java.util.Scanner;
import java.util.Random;
import dataStructures.*;
/**
 * File Name: TrainingCourse.java
 * Author: Fatoumatta Touray
 * Student Number: C21354101
 * Description of class: Driver class that uses the Employee class with a LinkedList
 */  

public class TrainingCourses {
	
	LinkedList<Employee>info; //Global variable
	int numberOfEmployees = 0; 
	
	/**Constructor to call the methods*/
	public TrainingCourses() {
		info = new LinkedList<Employee>(); //blank LinkedList
		
		Scanner scan = new Scanner(System.in);
		String ans; //answer to add in sorted list 
		
		System.out.print("\t\tWELCOME TO FOODCO\n");
		
		/**0. Ask the user how many employees the wish to input*/
		numberOfEmployees = getNumber();
		
		do {
		/**Ask employee */
		System.out.print("\nDo you wish to enter employees in a sorted list or not? (yes/no) ");
		ans = scan.nextLine();
		
		if (ans.equalsIgnoreCase("no")) 
		{
		/**1. Allow user to input employees*/
		System.out.println("\n------------------------------ADDING EMPLOYEES------------------------------");
		inputEmployees();
		}
		else if (ans.equalsIgnoreCase("yes"))
		{
		System.out.println("\n------------------------------ADDING EMPLOYEES TO SORTED POSITION------------------------------");
		inputEmployeesSorted();
		}
		else 
		{
			System.out.println("Invalid input");
		}
		}
		while (!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no"));
		
		/**2. Display all employee details*/
		System.out.println("\n------------------------------DISPLAYING EMPLOYEES------------------------------");
		displayEmployees();
		
		
		/**3. Remove employee from training course*/
		System.out.println("\n------------------------------REMOVING AN EMPLOYEE FROM TRAINING COURSE------------------------------");
		removeFromTrainingCourse();
		
		/**4. Display all details of employees on training course*/
		System.out.println("\n------------------------------DISPLAYING EMPLOYEES ON TRAINING COURSE------------------------------");
		displayEmployees();
		
		/**5. Delete all employees from specified course*/
		System.out.println("\n------------------------------DELETE ALL EMPLOYEES FROM SPECIFIED COURSE------------------------------");
		deleteEmployeesFromCourse(); //
		
		/**6. Display remaining employees*/
		System.out.println("\n------------------------------DISPLAYING REMAINING EMPLOYEES------------------------------");
		displayEmployees();
		
		/**7. Personal -- Display the grade of an employee */
		System.out.println("\n------------------------------DISPLAYING GRADE OF AN EMPLOYEE------------------------------");
		displayGrade();
		
		/**4. Display the number of employees in the list*/
		System.out.println("\n------------------------------NO. EMPLOYEE------------------------------");
		listSize();
		
		/**Display employee at an index*/
		System.out.println("\n------------------------------FIND WHERE AN EMPLOYEE IS IN THE LIST------------------------------");
		findEmployee(); //
		
		
		
		
	}
	
	/**0. Ask the user how many employees the wish to input*/
	public int getNumber() {
		 Scanner scan = new Scanner(System.in);
		 int numberOfEmployees; //Variable of the amount of employees user wishes to input
		 /**Ask user the amount of employees they wish to input maximum 10.*/
		 do {
	            System.out.print("\nHow many employees do you wish to enroll in a training course: ");
	            numberOfEmployees = scan.nextInt();
	            scan.nextLine();

	            if (numberOfEmployees > 10)
	            {
	            	//If amount > 10 - display error maximum is 10
	                System.out.println("Error – maximum of 10 employees can be enrolled");
	            }
	            else if (numberOfEmployees < 1)
	            {
	            	//If amount < 1 - display error minimum of 1
	                System.out.println("Error – mininum of 1 employees can be enrolled");
	            }
	           
	            //keep them trapped in a loop if 
	        }while (numberOfEmployees > 10 || numberOfEmployees < 1); 
		 //if amount =< 10 for loop goes around amount times - user will be trapped in a loop until number of employees is made 
		 
         System.out.println("Details for " + numberOfEmployees + " employees will now be inputted");
         return numberOfEmployees;
	}
	

	
	/**1. Allow user to input employees*/
	public void inputEmployees() {
		Scanner scan = new Scanner(System.in);

		String employeeNumber; //employees number
		String name; //name of employee
		int yearsWorking; //number of years the employee has worked in the company
		String courseName; //the name of the course they are doing/wish to do

		Employee employee; //Store employee in Employee.java class

		for (int count = 1; count <= numberOfEmployees; count++)
		{
			do {
				/** 1. Ask user to input employee details */

				System.out.print("\nEnter the number of employee " + count + ": ");
				employeeNumber = scan.nextLine();

				System.out.print("Enter the name of employee " + count + ": ");
				name = scan.nextLine();

				System.out.print("How many years has employee " + count + " been working for FoodCo: ");
				yearsWorking = scan.nextInt(); scan.nextLine();

				System.out.print("Enter the name of the course you wish to enroll employee " + count + " in: ");
				courseName = scan.nextLine();

				employee = new Employee(employeeNumber, name, yearsWorking, courseName);

				/**validates employee - checks for duplications in the LinkedList*/
				if (info.contains(employee)) { //contains method from LinkedList
					System.out.println("\nEmployee has already been entered. Please enter a different employee");
				}

			}while (info.contains(employee)); //Keeps user trapped in a loop if LinkedList contains employee already

			/**Add employee to list if not already added*/
			info.add(employee);

		}
	} //end inputEmployees()
	
	
	/**2. Display all employee details*/
	 public void displayEmployees() {
		 	
		  System.out.println(info.toString()); //Display employees in the list
  	   
		} //end display
	 
	 /**3. Remove employee from training course as specified by their employee number*/
	 public void removeFromTrainingCourse() {
		 Scanner scan = new Scanner(System.in);

		 Employee em; //Store employee details
		 
		 String employeeNumber;
		 
		 System.out.print("\nEnter the employee number of the employee you wish to remove: ");
		 employeeNumber = scan.nextLine(); //Ask user  to input employee number of employee they wish to delete

		 em = new Employee(employeeNumber, "FOOD");//create a new employee to compare
	
		 //Remove the employee if found
		 Employee x = info.remove(em);	 
		 
	 }
	 
	 
	 
	 /**5. Delete all employees from specified course*/
	 public void deleteEmployeesFromCourse() {
		 Scanner scan = new Scanner(System.in);
		 Employee em;
		 String course; //used to compare the course name in Employee class with
		 
		 
		 
		 System.out.print("\nEnter the name of the course you wish to delete all employees from: ");
		 course = scan.nextLine(); //Ask user to input the name of the course wish to delete employees from
		
		 em = new Employee("", course);
		 
		
		for( int i = 0; i < info.size(); i++) {
		 Employee e = info.get(i);
		 if (info.get(i).getCourseName().equals(course)) {
			 //Display message saying which employees are being removed
			 System.out.println("Employee " + info.get(i).getEmployeeNumber() + " whose name is " + info.get(i).getName() + " is being deleted from course " + info.get(i).getCourseName());
		 Employee x1 = info.remove(e);
		 //i++;
	 }
	}	

	 }
	 
 /**7. Personal -- Ask to input employee number and give random grade*/
	 
	 /**Function that uses random number generator to return an int between 1 and 100
	  * to represent the employee grade*/
	 public int grade() {
		 Random g = new Random(); //calling random 
		 int grade = g.nextInt(100) + 1; //setting range to 100 and 1 so that it doesn't return 0
		 
		 //return the grade so it can be called
		 return grade;
	 }
	 
	 public void displayGrade() {
		 Scanner scan = new Scanner(System.in);

		 Employee e; //store employee
		 String employeeNumber; //number of employee they wish to get the grade of
		 String courseName; //the name of the course the employee is in
		 int result = grade(); //result is calling the function of grade and will store the value
		 
		 
		 System.out.print("\nEnter the details of the employee you wish to see the grade of below");

		 System.out.print("\nEnter the number of employee: ");
			employeeNumber = scan.nextLine();


			System.out.print("Enter the name of the course the employee is enrolled in: ");
			courseName = scan.nextLine();

			e = new Employee(employeeNumber, courseName); //create a new employee to compare contents to 
			
			 if (info.contains(e))
			 {
				 System.out.println("\nDisplay grade for employee with the employee number " + e.getEmployeeNumber() + " on the course " + e.getCourseName());
				 System.out.println("\n" + e.getEmployeeNumber() + " currently has a grade of " + result + "%"); 
				 
				 if (result < 40) {
					 System.out.println(e.getEmployeeNumber() + " has a failing grade of " + result + "% and will need to get 40% "
					 		+ "in order to pass the course and be awarded with a certificate");  
				 }
				 else if (result == 40) {
					 System.out.println(e.getEmployeeNumber() + " has a passing grade of " + result + "% and is on track"
						 		+ "to being awarded with a pass certificate");  
				 }
				 else if (result > 40 && result < 50) {
					 System.out.println(e.getEmployeeNumber() + " has a passing grade of " + result + "% and is doing well "
						 		+ "they will awarded with a merit certificate if grade remains consistant");  
				 }
				 else if (result > 50 && result < 70) {
					 System.out.println(e.getEmployeeNumber() + " has a passing grade of " + result + "% and is doing well "
						 		+ "they will awarded with a higher merit certificate if grade remains consistant");  
				 }
				 else if (result >= 70 ) {
					 System.out.println(e.getEmployeeNumber() + " has an exceptional grade of " + result + "% "
						 		+ "and will awarded with the highest level of certificate that can be received a distinction");  
				 }
			 }
			 else 
			 {
				 System.out.println("Employee not found");
			 }
		
	 }
	 
	 
	 
	 /**------------------------------------------EXTRAS-----------------------------------------------------*/
	 
	 /**Add employee to a specific position in the LinkedList class*/
		public void inputEmployeesSorted() {
			Scanner scan = new Scanner(System.in);

			String employeeNumber; //employees number
			String name; //name of employee
			int yearsWorking; //number of years the employee has worked in the company
			String courseName; //the name of the course they are doing/wish to do
			
			int pos;
			

			Employee employ; //store employee in Employee.java class

			
					/** Ask user to input employee details */
			//only if the numbers of employees they inputted is less than 10
			 for (int count = 1; count <= numberOfEmployees; count++) {
					do {
					System.out.print("\nEnter the number of employee " + count + ": ");
					employeeNumber = scan.nextLine();

					System.out.print("Enter the name of employee " + count + ": ");
					name = scan.nextLine();

					System.out.print("How many years has employee " + count + " been working for FoodCo: ");
					yearsWorking = scan.nextInt(); scan.nextLine();

					System.out.print("Enter the name of the course you wish to enroll employee " + count + " in: ");
					courseName = scan.nextLine();

					employ = new Employee(employeeNumber, name, yearsWorking, courseName);

					/**validates employee - checks for duplications*/
					 if (info.contains(employ)) { //contains method from LinkedList
					System.out.println("\nEmployee has already been entered. Please enter a different employee");
					}
					 
					
					System.out.print("\nWhat position in the list do you wish to add the employee to? ");
					pos = scan.nextInt(); scan.nextLine();
					
					if (info.size() == 0 && pos > info.size()) {
						System.out.println("There is no employee in the list, so this employee will be added to the beginning of the list");
					}
					else if (pos > info.size()+1) {
						System.out.println("The size of the list is not that big. \nThe employee will be added to the end of the list");
					}
					
								
					
				//Add employee to list if not already added
			}while (info.contains(employ));
					//pos-1 --> If user inputs 1 element will be inputted as the first element in the list which is in index 0.
					info.add(employ, pos-1); //passing index and employee as parameters to LinkedList class
					
			 }
				
		} //end inputEmployeesSorted()
		
		/**Method to find the size of the list*/
		public void listSize() {
			System.out.println("\nThere is " + info.size() + " Employees enrolled in a course");
			
	    }
		
		/**Method to find which position an employee is in*/
		public void findEmployee() {
	    	Scanner scan = new Scanner(System.in);
	    	int pos; //position of employee user want
			

			System.out.print("Input index of required Employee: ");
			pos = scan.nextInt(); scan.nextLine();
						
			
			Employee aEmployee = info.get(pos); //get employee at that position
			if (aEmployee != null) { //if the employee is not null, display the details
				System.out.println("Employee details are:" + info.get(pos) + "\n");
			}
			else
			{
			System.out.println("There is no Employee at position " + pos);
			}
	    }
	 
	/**Call the constructor*/
	public static void main(String[] args)
    {
        new TrainingCourses();
    }

}
