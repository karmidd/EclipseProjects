// -------------------------------------------------------
// Assignment 3
// Written by: Karam Midani 40277218
// For COMP 248 Section R 2232 – Fall 2023
// -------------------------------------------------------
package assignments;
//import Scanner
import java.util.Scanner;

public class A3_Q2 {

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
		int count = 0;
		int firstPodiumIndex = 0, secondPodiumIndex = 0, thirdPodiumIndex = 0;
		
		//do while loop that runs the program until the user wants to stop
		do {
			//prompt the user to input the skier's name and their time
			System.out.print("Please input the skier's name: ");
			skiers[count] = scanner.next(); 
			System.out.print("Please input the skier's time: ");
			times[count] = scanner.nextDouble();
			
			//algorithm that ensures the validity of the first ever input, 
			//if invalid, do while loop will initiate and terminate until validity is achieved
			if (count == 0 && times[count] < 0) {
				do{
					System.out.print("Invalid input, please try again: ");
					times[count] = scanner.nextDouble();
				  }
				while(times[count] < 0);
			}
			
			//algorithm that goes through all indexes of the array to check if there is a duplicate and if the number is valid
			//if a duplicate exists, a do while loop initiates and stops only when a non duplicate and valid time is entered
			//note, this algorithm only starts when count is bigger than 0
			for(int k = count-1; k >= 0; k--) {
				if (times[count] == times[k] || times[count] < 0) {
					do{
						System.out.print("Time already exists, or invalid, please try again: ");
						times[count] = scanner.nextDouble();
					  }
					while(times[count] == times[k] || times[count] < 0);
											  }
											  }
		
			//switch that includes: giving the values of podium indexes when theyre empty,
			//comparing podium values and switching them if needed dependent on time value
			//and also includes printing the podium output
			switch(count) {
				case 0:
					firstPodiumIndex = count;
					System.out.println("First podium goes to " + skiers[firstPodiumIndex] + " who made it in " + times[firstPodiumIndex] + " second(s)");
					break;
				case 1:
					if (times[count] < times[firstPodiumIndex]) {
						secondPodiumIndex = firstPodiumIndex;
						firstPodiumIndex = count; }
					else if (times[count] > times[firstPodiumIndex])
						secondPodiumIndex = count;
					System.out.println("First podium goes to " + skiers[firstPodiumIndex] + " who made it in " + times[firstPodiumIndex] + " second(s)");
					System.out.println("Second podium goes to " + skiers[secondPodiumIndex] + " who made it in " + times[secondPodiumIndex] + " second(s)");
					break;
				case 2:
					if (times[count] < times[firstPodiumIndex]) {
						thirdPodiumIndex = secondPodiumIndex;
						secondPodiumIndex = firstPodiumIndex;
						firstPodiumIndex = count; } 
					else if (times[count] > times[firstPodiumIndex] && times[count] < times[secondPodiumIndex] ) {
						thirdPodiumIndex = secondPodiumIndex;
						secondPodiumIndex = count; }
					else if (times[count] > times[secondPodiumIndex])
						thirdPodiumIndex = count;
					System.out.println("First podium goes to " + skiers[firstPodiumIndex] + " who made it in " + times[firstPodiumIndex] + " second(s)");
					System.out.println("Second podium goes to " + skiers[secondPodiumIndex] + " who made it in " + times[secondPodiumIndex] + " second(s)");
					System.out.println("Third podium goes to " + skiers[thirdPodiumIndex] + " who made it in " + times[thirdPodiumIndex] + " second(s)");
					break;
				default:
					if (times[count] < times[firstPodiumIndex]) {
						thirdPodiumIndex = secondPodiumIndex;
						secondPodiumIndex = firstPodiumIndex;
						firstPodiumIndex = count; } 
					else if (times[count] > times[firstPodiumIndex] && times[count] < times[secondPodiumIndex] ) {
						thirdPodiumIndex = secondPodiumIndex;
						secondPodiumIndex = count; }
					else if (times[count] > times[secondPodiumIndex] && times[count] < times[thirdPodiumIndex]) 
						thirdPodiumIndex = count; 
					System.out.println("First podium goes to " + skiers[firstPodiumIndex] + " who made it in " + times[firstPodiumIndex] + " second(s)");
					System.out.println("Second podium goes to " + skiers[secondPodiumIndex] + " who made it in " + times[secondPodiumIndex] + " second(s)");
					System.out.println("Third podium goes to " + skiers[thirdPodiumIndex] + " who made it in " + times[thirdPodiumIndex] + " second(s)");
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
				System.out.println("First podium goes to " + skiers[firstPodiumIndex] + " who made it in " + times[firstPodiumIndex] + " second(s)");
				System.out.println("Second podium goes to " + skiers[secondPodiumIndex] + " who made it in " + times[secondPodiumIndex] + " second(s)");
				System.out.println("Third podium goes to " + skiers[thirdPodiumIndex] + " who made it in " + times[thirdPodiumIndex] + " second(s)");
				System.out.println("Maximum number of skiers has been input, thanks for using the program!");
				System.out.println("Goodbye!");
				System.exit(1);
				}
			//we ask the user if they want to perform another operation and prompt them for an answer
			System.out.print("Do you want to perform another operation? y/yes: ");
			String choice = scanner.next();
					
			//if the answer is not one that the program recognises as an approval, it will display a goodbye message and terminate
			//by making the boolean false and stopping the initial while loop
			//it will also display a congratulating message to the top 3 dependent on how many skiers are on the podium
			if (choice.toUpperCase().compareTo("Y") != 0 && choice.compareTo("yes") != 0) {
				System.out.println("Congratulations to the winners!");
				switch(count) {
					case 1:
						System.out.println("First podium goes to " + skiers[firstPodiumIndex] + " who made it in " + times[firstPodiumIndex] + " second(s)");
						break;
					case 2:
						System.out.println("First podium goes to " + skiers[firstPodiumIndex] + " who made it in " + times[firstPodiumIndex] + " second(s)");
						System.out.println("Second podium goes to " + skiers[secondPodiumIndex] + " who made it in " + times[secondPodiumIndex] + " second(s)");
						break;
					default:
						System.out.println("First podium goes to " + skiers[firstPodiumIndex] + " who made it in " + times[firstPodiumIndex] + " second(s)");
						System.out.println("Second podium goes to " + skiers[secondPodiumIndex] + " who made it in " + times[secondPodiumIndex] + " second(s)");
						System.out.println("Third podium goes to " + skiers[thirdPodiumIndex] + " who made it in " + times[thirdPodiumIndex] + " second(s)");
						break;
				}
				System.out.println("Goodbye!");
				repeat = !repeat;
				}
				
					}				
		while(repeat);
		
		//close scanner
		scanner.close();
		
		}//close main
	
	}// close public class				
