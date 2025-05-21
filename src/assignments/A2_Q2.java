// -------------------------------------------------------
// Assignment 2
// Written by: Karam Midani 40277218
// For COMP 248 Section R 2232 – Fall 2023
// -------------------------------------------------------

package assignments;

//import scanner
import java.util.Scanner;

public class A2_Q2 {

	public static void main(String[] args) {
	
	//assign scanner for inputs
	Scanner scanner = new Scanner(System.in);
	
	//print welcome message
	System.out.println("-------****-------****-------****-------****-----****-----\r\n"
			+ "Welcome to Grade Calculator\r\n"
			+ "-------****-------****-------****-------****-----****-----");
	
	//ask the user for input
	System.out.print("\nEnter the student's score (out of 100): ");
	double grade = scanner.nextDouble();
	
	//nested if statements to check the validity of the input, where the program gives only 2 chances for a correct input
	//we check if the grade is below 0 and print a message accordingly and ask for another input
	if (grade<0) {
		System.out.println("The score has to be zero or above. Please try again.");
		grade = scanner.nextDouble();
		//we check the validity of the second input, if it still doesn't follow our rules, we print a goodbye message and close the program
		if (grade<0 || grade>100) {
			System.out.print("It is still an invalid input. Bye!"); 
			System.exit(1); }
	}
	//we check the other case where the grade could be above 100, and ask for another input
	else if (grade>100) {
		System.out.println("The score has to be below 100. Please try again.");
		grade = scanner.nextDouble(); 
		//we check the validity of the second input, if it still doesn't follow our rules, we print a goodbye message and close the program
		if (grade>100 || grade<0) {
			System.out.print("It is still an invalid input. Bye!"); 
			System.exit(1); }
		}
	
	//assign a variable for the letter grade
	char letter_grade;
	
	//we use integer division to minimise cases that could be checked
	//we also cast grade as an int because we declared category as an int, and then we perform int division with another int (10)
	int category = (int)grade / 10;
	
	//switch statement to check the case that is according to the user's input and assign a value to the letter grade variable
	switch (category) {
		//after division, only 10 and 9 can have the same result, so we combine them by not breaking the case for 10
		case 10:
		case 9:
			letter_grade = 'A';
			break;
		case 8:
			letter_grade = 'B';
			break;
		case 7:
			letter_grade = 'C';
			break;
		case 6:
			letter_grade = 'D';
			break;
		default:
			letter_grade = 'F';
			break;
		} //close switch
	
	//print the student's letter grade
	System.out.println("The student’s grade is: " + letter_grade);
	
	//closing message
	System.out.println("\nThank you for using our program. Bye!");
	
	//close scanner
	scanner.close();
			
			
	} //closing main
	
} //closing public class


