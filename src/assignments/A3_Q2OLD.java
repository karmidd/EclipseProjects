// -------------------------------------------------------
// Assignment 3
// Written by: Karam Midani 40277218
// For COMP 248 Section R 2232 – Fall 2023
// -------------------------------------------------------
package assignments;
//import Scanner
import java.util.Scanner;

public class A3_Q2OLD {

	public static void main(String[] args) {
		
		//create scanner
		Scanner scanner = new Scanner(System.in);
		
		//display welcome message and explanation of the usage of the program
		System.out.println("Welcome to Mont-Halloween Skiing Contest Ranker.");
		System.out.println("Whenever a skier makes it to the finish line, enter their name and skiing time.");
		
		//declaration of arrays with the size of 20 for 20 skiers only
		String[] skiers = new String[20];
		double[] times = new double[20];
		
		//declaration and assignment of a boolean to control the repetition of the do while loop
		//and other variables that will be used in the loops: selection sort loop and do while loop.
		boolean repeat = true;
		int min, count = 0; 
		double temp;
		String tempString;
		
		//do while loop that runs the program until the user wants to stop
		do {
			//prompt the user to input the skier's name and their time
			System.out.print("Please input the skier's name: ");
			skiers[count] = scanner.next(); 
			System.out.print("Please input the skier's time: ");
			times[count] = scanner.nextDouble();
			//algorithm that goes through all indexes of the array to check if there is a duplicate
			//if a duplicate exists, a do while loop initiates and stops only when a non duplicate time is entered
			for(int k = count-1; k >= 0; k--) {
				if (times[count] == times[k]) {
					do{
						System.out.print("Time already exists, therefore invalid, please try again: ");
						times[count] = scanner.nextDouble();
					  }
					while(times[count] == times[k]);
											  }
											  }
		
			//selection sort loop that goes through the first index of the array until the second to last index
			//sorts from smallest to biggest
			//we sort the time values first since they're numbers, and after we do the same with the names so it matches the skiers to their times
			for(int i = 0; i < times.length-1; i++) {
				min = i;
				for (int scan = i+1; scan < times.length; scan++) {
					if (times[scan] == 0)
						continue;
					if (times[scan] < times[min])
						min = scan;
					
					temp = times[min];
					times[min] = times[i];
					times[i] = temp;
					
					tempString = skiers[min];
					skiers[min] = skiers[i];
					skiers[i] = tempString;
																  }
													}
					
				//switch that prints the amount of podiums occupied at the moment and prints the order made by the selection sort loop
				switch (count) {
					case 0:
						System.out.println("First podium goes to " + skiers[0] + " who made it in " + times[0] + "second(s)");
						break;
					case 1:
						System.out.println("First podium goes to " + skiers[0] + " who made it in " + times[0] + "second(s)");
						System.out.println("Second podium goes to " + skiers[1] + " who made it in " + times[1] + "second(s)");
						break;
					default:
						System.out.println("First podium goes to " + skiers[0] + " who made it in " + times[0] + "second(s)");
						System.out.println("Second podium goes to " + skiers[1] + " who made it in " + times[1] + "second(s)");
						System.out.println("Third podium goes to " + skiers[2] + " who made it in " + times[2] + "second(s)");
						break;
						
							   }	
				//increment count to go to the next index of the arrays
				count++;
				
				//if statement that works only when the maximum amount of skiers has been entered
				//when iterated, displays congratulating message to the top 3, 
				//a goodbye message with letting the user know that max input has been reached,
				//and then terminates the program
				if (count == 20) {
					System.out.println("Congratulations to the top 3 skiers!: ");
					System.out.println("First podium goes to " + skiers[0] + " who made it in " + times[0] + "second(s)");
					System.out.println("Second podium goes to " + skiers[1] + " who made it in " + times[1] + "second(s)");
					System.out.println("Third podium goes to " + skiers[2] + " who made it in " + times[2] + "second(s)");
					System.out.println("Maximum number of skiers has been input, thanks for using the program!");
					System.out.println("Goodbye!");
					System.exit(1);
				}
				//we ask the user if they want to perform another operation and prompt them for an answer
				System.out.print("Do you want to perform another operation? y/yes: ");
				String choice = scanner.next();
					
				//if the answer is not one that the program recognises as an approval, it will display a goodbye message and terminate
				//by making the boolean false and stopping the initial while loop
				//it will also display a congratulating message to the top 3
				if (choice.toUpperCase().compareTo("Y") != 0 && choice.compareTo("Yes") != 0) {
					System.out.println("Congratulations to the top 3 skiers!: ");
					System.out.println("First podium goes to " + skiers[0] + " who made it in " + times[0] + "second(s)");
					System.out.println("Second podium goes to " + skiers[1] + " who made it in " + times[1] + "second(s)");
					System.out.println("Third podium goes to " + skiers[2] + " who made it in " + times[2] + "second(s)");
					System.out.println("Goodbye!");
					repeat = !repeat;}
					}				
		while(repeat);
		
					
		scanner.close();
		}
	}				
				
			
		
	


