// -------------------------------------------------------
// Assignment 4
// Written by: Karam Midani 40277218
// For COMP 248 Section R 2232 – Fall 2023
// -------------------------------------------------------
package CostLessBites;
//import scanner
import java.util.Scanner;
public class PoS {
	//create static scanner to use in static methods
	static Scanner scanner = new Scanner(System.in);
	
	//instance variable of class type Sales
	//instance variable array of class type PrePaiCard
	//private to keep them hidden
	private Sales sales;
	private PrePaiCard[] prePaiCards;
	
	//static input validation method to avoid repetition
	//returns an int that represents a number that satisfies the condition of the while loop
	public static int inputValidation() {
		//the choice of which PoS the user wants to input
		int choice = scanner.nextInt();
		//since the amount of PoSs are hardcoded, the range is from 0 to 4, this can be changed easily
		//while loop that initiates if the user doesnt enter a condition satisfying input
		while(choice < 0 || choice > 4){
			System.out.println("Sorry, but there is no PoS number " + choice);
			System.out.print("--> Try again: (Enter number 0 to 4): ");
			choice = scanner.nextInt();
		}
		return choice;
	}
	
	//static input validation method for the choice of prepaicard, same concept as first input validation
	public static int inputValidationTwo(int index, PoS[] PoSs){
		int choice = scanner.nextInt();
		while(choice < 0 || choice > (PoSs[index].getNumberOfPrePaidCards()-1)){
			System.out.println("Sorry, but pre-paid card number " + choice + " does not exist.");
			System.out.print("--> Try again: (Enter number 0 to "  + (PoSs[index].getNumberOfPrePaidCards()-1) + "): ");
			choice = scanner.nextInt();
		}
		return choice;
	}
	
	//default method that assigns null to the prepaicards array and uses default constructor on sales
	public PoS() {
		this.sales = new Sales();
		this.prePaiCards = null;
	}
	//constructor that takes 2 parameters of type Sales and array of type PrePaiCard
	//we create deep copies to avoid privacy leaks
	public PoS(Sales sales, PrePaiCard[] prePaiCards) {
		//use copy constructor from class Sales to create a deep copy
		this.sales = new Sales(sales);
		//we create a temporary array and copy the contents from our parameter,
		//then we assign the temporary array to this.array
		PrePaiCard[] temp = new PrePaiCard[prePaiCards.length];
		for(int i = 0; i<temp.length; i++) {
			temp[i] = prePaiCards[i];
		}
		this.prePaiCards = temp;
	}
	
	//method that checks if the amount of sale categories between two objects of PoS are the same
	//returns boolean representing if its equal or not (true if equal false if not)
	public boolean salesEquals(PoS pos) {
		return this.sales.equals(pos.sales);
	}
	
	//method that checks if the value in $s of the sales of two different PoSs is the same
	//returns boolean representing if its equal or not (true if equal false if not)
	public boolean valueEquals(PoS pos) {
		return (this.sales.salesTotal() == pos.sales.salesTotal());
	}
	
	//method that returns a copy (to avoid a leak) of the $ value of the sales
	public int getPoSSalesValue() {
		Sales salesCopy = new Sales(this.sales);
		return salesCopy.salesTotal();
	}
	
	//method that returns the length of the prepaicards array
	public int getNumberOfPrePaidCards() {
		if (this.prePaiCards == null)
			return 0;
		return this.prePaiCards.length;
	}
	
	//method that adds a prepaicard to the array (so adding an element to the array basically)
	//takes parameters of the information of the new prepaicard that's going to be added
	//returns an int that represent the new number of cards in the array (array length)
	public int addPrePaiCard(String type, int month, int day, String id_number) {
		//if statement checks if the array is null,
		//this if statement is specifically done for null arrays because there is nothing that can be copied and added on to them;
		//we have to create something from scratch.
		//newArray = {new card}
		//originalArray = newArray
		if(this.prePaiCards == null) {
			//it creates a new temporary array with size 1,
			PrePaiCard[] temp = new PrePaiCard[1];
			//and adds the information of the new card using the prepaicard constructor.
			temp[0] = new PrePaiCard(type, month, day, id_number);
			//then, assign the new temporary array to our original array, and return the new number of cards.
			this.prePaiCards = temp;
			return this.getNumberOfPrePaidCards();
		}
		//we create a new temporary array with the length of the original array + 1, to fit the new card
		//we also take a temporary index that we're gonna use later, we assign the length of the original array to it
		PrePaiCard[] temp = new PrePaiCard[this.prePaiCards.length + 1];
		int tempIndex = prePaiCards.length;
		//for loop that starts from index 0 until last index, and increments by 1 each iteration
		//the point of this for loop is to copy all indexes of original array to new array
		for (int i = 0; i < this.prePaiCards.length; i++){
			//copies each value of original array to new temporary array
			temp[i] = this.prePaiCards[i];
		   }
		//when for loop is finished, we assign the temporary array to the original array
		this.prePaiCards = temp;
		//using the temporary index we got earlier that has the value of the length of the old array,
		//(length of old array = last index of new array which is +1 size only)
		//we assign the new information of the prepaicard to the last index using the prepaicard constructor
		//then we return the new number of cards using the getlength method
		this.prePaiCards[tempIndex] = new PrePaiCard(type, month, day, id_number);
		return this.getNumberOfPrePaidCards();
	}
	
	//method that removes one specific element from the array
	//the specified element is chosen by the parameter which is an integer that will represent the index of array
	public boolean removePrePaiCard(int index) {
		//we create a new temporary array that has the length of the original array minus one
		PrePaiCard[] temp = new PrePaiCard[this.getNumberOfPrePaidCards()-1];
			//for loop that starts at index 0, stops at the last index of the new temporary array, and increments by 1 each iteration
		//contains copying algorithm that copies each element from the original array
		for (int i = 0; i < temp.length; i++){
			//if statement that only initiates if we reach the desired index we want deleted
			if(i == index) {
				//for loop that continues (or begins) the copying algorithm,
				//it continues starting from the index we dont want,
				//it assigns the values of the current index of the new temporary array the next index of the original array
				//basically it stops copying 1 to 1, and starts copying 1 to 1+1
				//for example:
				//0 1 2 3 4 (selected index = 2)
				//| | X/ /
				//0 1 2 3 
				for(; i < temp.length; i++) {
					temp[i] = this.prePaiCards[i+1];
				}
				//breaks to exit the loop
				break;
			}
			//1 to 1 copying pre-arrival to chosen index
			temp[i] = this.prePaiCards[i];
		   }
		//we assign the temporary array to the original array, then return boolean value true to signify success
		this.prePaiCards = temp;
		return true;
	}
	//date setter, requires 3 parameters, the index of the chosen card that is wanted to be updated,
	//the new day and new month
	//we access the setters in PrePaiCard by calling them using an object from the same class
	public void setDate(int index, int day, int month){
		this.prePaiCards[index].setMonth(month);
		this.prePaiCards[index].setDay(day);
	}
	
	//method that adds sale categories
	//this works by accessing the addSales method by calling it from an object of the same class (Sales)
	public void addPoSSales(int juniorSales, int teenSales, int mediumSales, int bigSales, int familySales) {
		this.sales.addSales(juniorSales, teenSales, mediumSales, bigSales, familySales);
	}
	
	//equals method that checks if the $ values of 2 PoSs is the same
	//and if the amount of prepaicards of both PoSs is the same
	public boolean equals(PoS pos) {
		return (this.valueEquals(pos)) && (this.getNumberOfPrePaidCards() == pos.getNumberOfPrePaidCards());
	}
	
	//toString method that returns a concatenation of 2 strings, which are:
	//1st string is the sales breakdown (toString method of class Sales) and a new line
	//2nd string is one of 2:
	//if the PoS has no prepaicards, the 2nd string will be a message indicating that there are no prepaicards
	//if the PoS does have prepaicards,
	public String toString() {
		//1st string is the sales breakdown (toString method of class Sales) and a new line
		String salesString = this.sales.toString() + "\n";
		//2nd string is one of 2:
		String prePaiCardsString = "";
		//if the PoS has no prepaicards, the 2nd string will be a message indicating that there are no prepaicards
		if(this.getNumberOfPrePaidCards() == 0) {
			return salesString + "No pre-paid cards.\n";
		}
		//if the PoS does have prepaicards, we intiate a for loop,
		//starts from index 0 until last index, we can get the length of the array using our previous method in this class,
		//we increment by 1 each iteration
		//the for loop is for combing each description of prepaicards into 1 string object
		for(int i = 0; i < this.getNumberOfPrePaidCards(); i++) {
			//addition of every description of cards into 1 string object, adding a new line at the end to keep the syntax tidy
			//(toString method of class type PrePaiCard)
			prePaiCardsString += prePaiCards[i].toString() + "\n";
		}
		return salesString + prePaiCardsString;
	}
	//method that returns a string of the sales (toString method of class type Sales)
	public String salesOfPoS(){
		return this.sales.toString();
	}
}//close class