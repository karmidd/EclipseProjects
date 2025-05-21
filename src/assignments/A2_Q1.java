// -------------------------------------------------------
// Assignment 2
// Written by: Karam Midani 40277218
// For COMP 248 Section R 2232 – Fall 2023
// -------------------------------------------------------

package assignments;

//import scanner
import java.util.Scanner;

public class A2_Q1 {
	
	public static void main(String[] args) {
		
		//displaying welcome message and name of program
		System.out.println("-------****-------****-------****-------****-----****-----\n"
				+ "Welcome to BMI Calculator\n"
				+ "-------****-------****-------****-------****-----****-----\n");
		
		//assign a scanner for inputs
		Scanner scanner = new Scanner(System.in);
		
		//prompt the user to input their weight in kilograms
		System.out.print("Enter weight (in kilograms): ");
		double weight = scanner.nextDouble();
		
		//prompt the user to input their height in meters
		System.out.print("Enter height (in meters): ");
		double height = scanner.nextDouble();
		
		//calculate the body mass index using the inputs from the user
		double BMI = weight/(height*height);
		//format the bmi to show the next 2 numbers after the decimal point
		System.out.format("BMI: %.2f", BMI);
		
		//declaring the category of the user's bmi
		String BMI_Cat;
		
		//if, else if, and else statements that decide which bmi category the user is in based on their bmi
		if (BMI < 18.5)
			BMI_Cat = "Underweight"; 
		
		else if (18.5 < BMI && 24.9 > BMI) 
			BMI_Cat = "Normal Weight";  
			
		else if (BMI > 25 && BMI < 29.9) 
			BMI_Cat = "Overweight"; 
		
		else 
			BMI_Cat = "Obesity"; 
		
		//printing the bmi category
		System.out.println("\nCategory: " + BMI_Cat);
		
		//asking the user if they need additional tips according to their bmi
		System.out.println("Do you need some tips according to your BMI?");
		
		//declaration and assignment of the user's answer to the question
		String yes_no = scanner.next();
		
		//if, else if, and else statements that confirm if the user needs the additional tips or not
		//we utilise the use of multiple string.equals("x") to check the response of the user and the bmi category
		//if they do require the additional tips, we check which bmi category they're in, and then print out a specified tip based on the category
		//if they don't require the additional tip, we display a goodbye message
		if ( (yes_no.equals("yes") || yes_no.equals("Y") || yes_no.equals("y")) && BMI_Cat.equals("Underweight") ) 
			System.out.println("Please eat well and do more exercises."); 
		
		else if ( (yes_no.equals("yes") || yes_no.equals("Y") || yes_no.equals("y")) && BMI_Cat.equals("Normal Weight") ) 
			System.out.println("Congratulations, you are doing fairly well. Keep on going."); 
		
		else if ( (yes_no.equals("yes") || yes_no.equals("Y") || yes_no.equals("y")) && BMI_Cat.equals("Overweight") ) 
			System.out.println("Please watch out what you eat and do more exercises!"); 
		
		else if ( (yes_no.equals("yes") || yes_no.equals("Y") || yes_no.equals("y")) && BMI_Cat.equals("Obesity") ) 
			System.out.println("Please contact our experts for professional help."); 
		
		else
			System.out.println("Nice to meet you too. Bye!");
		
		//closing message
		System.out.println("\nThank you for using our program. Bye!");
		
		//closing scanner
		scanner.close();
		
	} //closing main

}//closing public class
