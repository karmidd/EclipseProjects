package assignments;

//import scanner
import java.util.Scanner;

public class A3_Q1OLD {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//welcome message
		System.out.println("Welcome to this calculator, offering Addition and Subtraction.");
		//message that asks the user for one of two operations available on this program
		System.out.print("Please select 1 for Addition or 2 for Subtraction: ");
		//user's choice of operation
		int typeOfOperation = scanner.nextInt();
		
		//while loop that keeps repeating in case the user doesn't input a correct value for the choice of operation
		while (typeOfOperation != 1 && typeOfOperation != 2) {
			
			System.out.println("Operation not supported.");
			typeOfOperation = scanner.nextInt(); }
		
		//declaration of variables outside of loops that will be used for the whole scope of the program
		int count; 
		//assignment of the value 0 to variable sum for the beginning
		double sum = 0, num;
		
			//switch that checks the user's choice of operation
			switch (typeOfOperation) {
				
				//if it the choice was 1, the program will run code for addition operations
				case 1:
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
				case 2:
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
			
			//if the answer is not one that the program recognizes as an approval, it will display a goodbye message and terminate
			if (choice.toUpperCase().compareTo("Y") != 0 && choice.compareTo("yes") != 0) {
				System.out.println("Goodbye!");
				System.exit(1);}
			//if the answer is an approval to continue, a while loop while start where the same program runs again, 
			//until the user doesn't want it to
			else {		
				while(choice.toUpperCase().equals("Y") || choice.equals("yes")) {
					//assign the value 0 to sum to reset the result
					sum = 0;
					System.out.print("Please select 1 for Addition or 2 for Subtraction: ");
					typeOfOperation = scanner.nextInt();
					
					while (typeOfOperation != 1 && typeOfOperation != 2) {
						
						System.out.println("Operation not supported.");
						typeOfOperation = scanner.nextInt(); }
					
						switch (typeOfOperation) {
							
							case 1:
								System.out.print("Please input your numbers: ");
								count = scanner.nextInt();
								for (int i = 0; i < count; i++ ) {
									num = scanner.nextDouble();
									sum += num;	
								}
								System.out.format("The result of your addition is: %.2f", sum);
								break;
							
							case 2:
								System.out.print("Please input your numbers: ");
								count = scanner.nextInt();
								for (int i = 0; i < count; i++ ) {
									num = scanner.nextDouble();
									if (i==0)
										sum = num;
									else
										sum -= num;	
								}
								System.out.format("The result of your subtraction is: %.2f", sum);
								break;
						
						
							}
						System.out.print("\nDo you want to perform another operation? y/yes: ");
						choice = scanner.next();
						
						if (choice.toUpperCase().compareTo("Y") != 0 && choice.compareTo("yes") != 0) {
							System.out.println("Goodbye!");
							System.exit(1);}
				}
					
				}
			
				//close scanner
				scanner.close();
				
			}//close main
			
		}//close public class
		
		
	


