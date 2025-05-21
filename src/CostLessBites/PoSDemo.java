// -------------------------------------------------------
// Assignment 4
// Written by: Karam Midani 40277218
// For COMP 248 Section R 2232 – Fall 2023
// -------------------------------------------------------
package CostLessBites;
//import scanner
import java.util.Scanner;
public class PoSDemo {//driver class
	public static void main(String[] args) {//main method
		//create array of multiple PoSs
		PoS[] allPoS = new PoS[5];
		//for loop that uses the default constructor on each PoS in the array
		for(int i = 0; i < allPoS.length; i++) {
			allPoS[i] = new PoS();
		}
		//we use the methods of adding sales and cards to hardcode information to our PoSs to test the program
		allPoS[0].addPoSSales(2, 1, 0, 4, 1);
		allPoS[0].addPrePaiCard("Vegetarian", 12, 25, "40825164");
		allPoS[0].addPrePaiCard("Carnivore", 12, 3, "21703195");
		
		allPoS[1].addPoSSales(2, 1, 0, 4, 1);
		allPoS[1].addPrePaiCard("Vegan", 12, 7, "40825164");
		allPoS[1].addPrePaiCard("Vegetarian", 8, 24, "21596387");
		
		allPoS[2].addPoSSales(0, 1, 5, 2, 0);
		allPoS[2].addPrePaiCard("Pescatarian", 6, 1, "12345678");
		allPoS[2].addPrePaiCard("Halal", 12, 18, "42087913");
		allPoS[2].addPrePaiCard("Kosher", 4, 5, "40735421");
		
		allPoS[3].addPoSSales(3, 2, 4, 1, 2);
		
		allPoS[4].addPoSSales(3, 2, 4, 1, 2);
				
		//assign scanner
		Scanner scanner = new Scanner(System.in);
		//welcome message
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("|   Welcome to Concordia CostLessBites Catering Sales Counter Application       |");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		//int variable that represents the choice of the user in the menu
		int choice;
		//do while loop that stops only when choice = 0
		do {
			//menu syntax
			System.out.println("| What would you like to do?                                                    |");
			System.out.println("| 1 >> See the content of all PoSs                                              |\r\n"
					+ "| 2 >> See the content of one PoS                                               |\r\n"
					+ "| 3 >> List PoSs with same $ amount of sales                                    |\r\n"
					+ "| 4 >> List PoSs with same number of Sales categories                           |\r\n"
					+ "| 5 >> List PoSs with same $ amount of Sales and same number of prepaid cards   |\r\n"
					+ "| 6 >> Add a PrePaiCard to an existing PoS                                      |\r\n"
					+ "| 7 >> Remove an existing prepaid card from a PoS                               |\r\n"
					+ "| 8 >> Update the expiry date of an existing Prepaid card                       |\r\n"
					+ "| 9 >> Add Sales to a PoS                                                       |\r\n"
					+ "| 0 >> To quit                                                                  |\r\n"
					+ "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
			System.out.print("Please enter your choice and press <Enter>: ");
			//choice input from user
			choice = scanner.nextInt();
			//switch that contains a case for each option available
			switch(choice) {
				//case 0 does nothing in the switch except breaking,
				case 0:
					break;
				//case 1 prints out each PoS
				case 1:
					System.out.println("Content of each PoS:");
					System.out.println("---------------------");
					//for loop that prints out all elements of the PoS array
					for(int i = 0; i < allPoS.length; i++) {
						System.out.println("PoS #" + i +":");
						System.out.println(allPoS[i].toString());
					}
					break;
				//case 2 prints the contents of a specific PoS chosen by the user
				case 2:
					//prompt the user for which PoS they want to view
					System.out.print("Which PoS you want to see the content of? (Enter number 0 to 4): ");
					//user's choice that is validated before use by using the static input validation method
					int choice2 = PoS.inputValidation();
					//prints the contents of the chosen PoS
					System.out.println(allPoS[choice2].toString());
					break;
				//case 3 prints the PoSs in the array with the same amount of $ value	
				case 3:
					System.out.println("List of PoSs with the same total $ Sales: \n");
					//nested for loops that compare the $values of each PoS in the array
					//first for loop indicates the index of the element we want to compare everything else with
					for(int i = 0; i < allPoS.length; i++) {
						//second for loop goes through all other elements that come after the element that the first for loop indicated
						for(int j = i+1; j < allPoS.length; j++) {
							//boolean value that comes from using the $ equals method
							boolean equal = allPoS[i].valueEquals(allPoS[j]);
							//if two values from two different PoSs are the same, it will print out a message accordingly
							if(equal) {
								System.out.println("\t" + "PoSs " + i + " and " + j + " both have "+ allPoS[i].getPoSSalesValue());
							}
						}
					}
					System.out.print("\n");
					break;
				//case 4 prints the PoSs in the array with the same amount of sales categories	
				case 4:
					System.out.println("List of PoSs with the same Sales categories: \n");
					//same concept and algorithm as case 3, this time we're checking the sales categories
					for(int i = 0; i < allPoS.length; i++) {
						for(int j = i+1; j < allPoS.length; j++) {
							boolean equal = allPoS[i].salesEquals(allPoS[j]);
							if(equal) {
								System.out.println("\t" + "PoSs " + i + " and " + j + " both have "+ allPoS[i].salesOfPoS());
							}
						}
					}
					System.out.print("\n");
					break;
				//case 5 print the PoSs with the same $ values and same amount of prepaid cards
				case 5:
					System.out.println("List of PoSs with same $ amount of sales and same number of pre-paid cards :\n");
					//same concept and algorithm as cases 3&4, this checks the equality of $ values and number of prepaicards
					for(int i = 0; i < allPoS.length; i++) {
						for(int j = i+1; j < allPoS.length; j++) {
							boolean equal = allPoS[i].equals(allPoS[j]);
							if(equal) {
								System.out.println("\t" + "PoSs " + i + " and " + j);
							}
						}
					}
					System.out.print("\n");
					break;
				//case 6 adds a prepaicard to a PoS	
				case 6:
					System.out.print("Which PoS do you want to add a pre-paid card to? (Enter number 0 to 4): ");
					//choice that goes through the input validation method
					int choice6 = PoS.inputValidation();
					//prompts user to input the desired information
					System.out.print("Please enter the following information so that we may complete the PrePaiCard-\r\n"
							+ "--> Type of pre-paid card (Carnivore, Halal, Kosher, Pescatarian, Vegetarian, Vegan): ");
					String type = scanner.next();
					System.out.print("--> ID of the pre-paid card owner: ");
					String id_number = scanner.next();
					System.out.print("--> Expiry day number and month (seperate by a space): ");
					int day = scanner.nextInt();
					int month = scanner.nextInt();
					//we use the addprepaicard method to add our new card,
					//then we assign our new number of cards into a variable, then print a message
					int numOfPrePaiCards = allPoS[choice6].addPrePaiCard(type, month, day, id_number);
					System.out.println("You now have " + numOfPrePaiCards + " pre-paid card(s).\n");
					break;
				//case 7 removes a prepaicard from a PoS
				case 7:
					System.out.print("Which PoS you want to remove a pre-paid card from? (Enter number 0 to 4): ");
					//input validation of choice
					int choice7 = PoS.inputValidation();
					//if the chosen PoS doesnt have cards, we display a message and exit the case
					if(allPoS[choice7].getNumberOfPrePaidCards() == 0) {
						System.out.println("Sorry that PoS has no pre-paid cards.\n");
						break;
					}
					//prompts the user to choose the desired card
					System.out.print("(Enter number 0 to " + (allPoS[choice7].getNumberOfPrePaidCards()-1) + "): ");
					//we use the second input validation method that validates the choice of prepaicard
					int choiceTwo7 = PoS.inputValidationTwo(choice7, allPoS);
					//boolean value that runs the removeprepaicard method, and then returns true to signify that the
					//process was a success, then exits the case
					boolean successOrNot = allPoS[choice7].removePrePaiCard(choiceTwo7);
					if(successOrNot) {
						System.out.println("Pre-paid card was removed successfully.\n");
						break;
					}
				//case 8 updates the day and month of a card in a PoS
				case 8:
					System.out.print("Which PoS do you want to update a pre-paid card from? (Enter number 0 to 4): ");
					//input validation
					int choice8 = PoS.inputValidation();
					//we check if prepaicards exist in this PoS
					if(allPoS[choice8].getNumberOfPrePaidCards() == 0) {
						System.out.println("Sorry that PoS has no pre-paid cards.\n");
						break;
					}
					System.out.print("Which pre-paid card do you want to update? (Enter number 0 to " + (allPoS[choice8].getNumberOfPrePaidCards()-1) + "): ");
					//we prompt the user to choose a card and we validate it
					int choiceTwo8 = PoS.inputValidationTwo(choice8, allPoS);
					//we prompt the user for new day and month
					System.out.print("--> Enter new expiry day number and month (seperate by a space): ");
					int newDay = scanner.nextInt();
					int newMonth = scanner.nextInt();
					//we use the method and use our variables as parameters to set the new date
					allPoS[choice8].setDate(choiceTwo8, newDay, newMonth);
					System.out.println("Expiry Date updated.\n");
					break;
				//case 9 adds an amount of category sales to a PoS	
				case 9:
					System.out.print("Which PoS do you want to add sales to? (Enter number 0 to 4) ");
					//input validation
					int choice9 = PoS.inputValidation();
					//we prompt the user to input the desired numbers of sales they want to add
					System.out.print("How many junior, teen, medium, big and family meals do you want to add?\r\n"
							+ "Enter 5 numbers seperated by a space): ");
					int juniorMeals = scanner.nextInt();
					int teenMeals = scanner.nextInt();
					int mediumMeals = scanner.nextInt();
					int bigMeals = scanner.nextInt();
					int familyMeals = scanner.nextInt();
					//we use the variables given by the user as parameters for our addpossales method
					allPoS[choice9].addPoSSales(juniorMeals, teenMeals, mediumMeals, bigMeals, familyMeals);
					//print new sales
					System.out.println("You now have $" + allPoS[choice9].getPoSSalesValue());
					break;
				//default case for when the user doesnt input something from 0-9
				default:
					System.out.println("Sorry that is not a valid choice. Try again.");
			}//close switch
		}//close do while loop
		while(choice != 0);
		//display goodbye message
		System.out.println("Thank you for using Concordia CostLessBites Catering Sales Counter Application!");
		//close scanner
		scanner.close();
	}//close driver
}//close class