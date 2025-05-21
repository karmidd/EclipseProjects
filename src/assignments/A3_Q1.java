// -------------------------------------------------------
// Assignment 3
// Written by: Karam Midani 40277218
// For COMP 248 Section R 2232 – Fall 2023
// -------------------------------------------------------
package assignments;

import java.util.Scanner;

public class A3_Q1 {

	public static void main(String[] args) {
				
				//create scanner and boolean for the loop of the program
				Scanner scanner = new Scanner(System.in);
				boolean repeat = true;
				//welcome message
				System.out.println("Welcome to this calculator, offering Addition and Subtraction.");
				//while loop that keeps on repeating until the user chooses to not do any more operations
				while(repeat) {
					//message that asks the user for one of two operations available on this program
					System.out.print("Please select 1 for Addition or 2 for Subtraction: ");
					//user's choice of operation, we use string so the user can input anything
					String typeOfOperation = scanner.next();
					
					//while loop in case the user doesn't input a correct value for the choice of operations
					while (typeOfOperation.compareTo("1") != 0 && typeOfOperation.compareTo("2") != 0) {
						System.out.println("Operation not supported.");
						typeOfOperation = scanner.next(); }
	
					//declaration of variables outside of loops that will be used for the whole scope of the program
					int count; 
					//assignment of the value 0 to variable sum for the beginning of the operation
					double sum = 0, num;
					
					//switch that checks the user's choice of operation
					switch (typeOfOperation) {
							
						//if it the choice was 1, the program will run code for addition operations
						case "1":
							//message that prompts the user to input the desired numbers
							System.out.print("Please input your numbers: ");
							//first number that the user will input will be read as the amount of numbers the calculator will use for the operation
							count = scanner.nextInt();
							//we use a for loop to use the specific amount of numbers decided by count in our operation
							for (int i = 0; i < count; i++ ) {
								num = scanner.nextDouble();
								sum += num;	
								}
							//we round the sum to 2 decimal digits and display it, then we break to end the operation of this case and leave the switch
							System.out.format("The result of your addition is: %.2f", sum);
							break;
							
						//if it the choice was 2, the program will run code for subtraction operations
						case "2":
							//message that prompts the user to input the desired numbers
							System.out.print("Please input your numbers: ");
							//first number that the user will input will be read as the amount of numbers the calculator will use for the operation
							count = scanner.nextInt();
							//we use a for loop to use the specific amount of numbers decided by count in our operation
							for (int i = 0; i < count; i++ ) {
								num = scanner.nextDouble();
								//an if else statement that uses the first iteration where there are no operations yet to be done
								//to assign the sum to the first number input and not subtract the number from 0
								if (i==0)
									sum = num;
								else
									sum -= num;	
								}
								//we round the sum to 2 decimal digits and display it, then we break to end the operation of this case and leave the switch
								System.out.format("The result of your subtraction is: %.2f", sum);
								break;
							}
					//we ask the user if they want to perform another operation and prompt them for an answer
					System.out.print("\nDo you want to perform another operation? y/yes: ");
					String choice = scanner.next();
						
					//if the answer is not one that the program recognises as an approval, it will display a goodbye message and terminate
					//by making the boolean false and stopping the initial while loop
					if (choice.toUpperCase().compareTo("Y") != 0 && choice.compareTo("Yes") != 0) {
						System.out.println("Goodbye!");
						repeat = !repeat;}
						
				}//close the first while loop
							
						
					//close scanner
					scanner.close();
						
		}//close main
					
}//close public class
			

	


