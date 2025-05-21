// -------------------------------------------------------
// Assignment 0
// Written by: Karam Midani 40277218
// For COMP 249 Section PP 2234 – Winter 2024
// -------------------------------------------------------
package assignment0;
//import scanner
import java.util.Scanner;
public class BookDriver {
//driver class (main) that contains all the syntax and all the functions of the program
//the program consists of 5 different functions that can add, edit, and view books in the database
	public static void main(String[] args) {
		//initialize scanner
		Scanner scanner = new Scanner(System.in);
		//welcome message and prompt for the user to enter the size of the inventory array
		System.out.println("Welcome to the Bookstore Inventory Program. (Made by Karam Midani)");
		System.out.print("Please input the maximum number of books the bookstore can contain: ");
		int maxBooks = scanner.nextInt();
		//while loop that validates the input before using it as an array size
		while(maxBooks <= 0) {
			System.out.print("Invalid input. Try again: ");
			maxBooks = scanner.nextInt();
		}
		//initialization of an array of type book with the size selected by the user
		Book[] inventory = new Book[maxBooks];
		//initialization of variables that are going to be used later
		int choice;
		int case2Choice2;
		//junk variable that is going to be used to help use the nextLine() method with the scanner
		@SuppressWarnings("unused")
		String junk;
		String passwordInput;
		//initialization of counter variables that count how many wrong password attempts are made by the user
		int wrongPasswordCountCase1 = 0;
		int wrongPasswordCountCase2 = 0;
		//final constant that is used as a password
		final String password = "249";
		//do loop that runs until the while condition is met
		do {
			//menu syntax that includes the functions of this program
			//and prompts the user to choose one of them
			System.out.println("\nWhat do you want to do?");
			System.out.println("\t1.\tEnter new books (password required)");
			System.out.println("\t2.\tChange information of a book (password required)");
			System.out.println("\t3.\tDisplay all books by a specific author");
			System.out.println("\t4.\tDisplay all books under a certain price");
			System.out.println("\t5.\tQuit");
			System.out.print("Please enter your choice > ");
			choice = scanner.nextInt();
			//switch that contains the 5 different functions of the program,
			//and a default case where the user might enter an invalid input
			switch(choice) {
			//the first function of the program is book addition into the inventory (which is the array of books)
			case 1:
				//since this function requires a password, we prompt the user for an attempt
				System.out.print("Enter password: ");
				passwordInput = scanner.next();
				//a while loop that prompts the user to try again in case their first attempt at the password was wrong
				while(!password.equals(passwordInput)) {
					//wrong attempts counter gets incremented on each wrong attempt
					wrongPasswordCountCase1++;
					//if statement that checks if the counter reaches 3 wrong attempts in a row
					//if yes, then the loop will be broken, and the user will have to select the function and try inputting the password again
					if(wrongPasswordCountCase1 == 3 || wrongPasswordCountCase1 == 6 || wrongPasswordCountCase1 == 9) {
						System.out.println("Too many wrong attempts.");
						break;
					}
					//if the user has had 12 wrong attempts in a row, the program will terminate because of suspicious activities
					else if(wrongPasswordCountCase1 == 12) {
						System.out.println("Program detected suspicious activities and will terminate immediately!");
						System.exit(0);
					}
					//prompt the user to try again
					System.out.println("Wrong password. Try again.");
					System.out.print("Enter password: ");
					passwordInput = scanner.next();
				}
				//if the password is correct, the program resets the wrong password counter,
				//displays syntax that shows how many spots are left in the inventory,
				//and prompts the user to enter the amount of new books they want to register in the database
				if(password.equals(passwordInput)) {
					wrongPasswordCountCase1 = 0;
					System.out.println("You have " + (inventory.length - Book.findNumberOfCreatedBooks()) +" spots remaining in the inventory.");
					System.out.print("Enter amount of books: ");
					int newBooksAmount = scanner.nextInt();
					//while loop that validates the input from the user
					while(newBooksAmount <= 0) {
						System.out.print("Invalid amount entered. Try again: ");
						newBooksAmount = scanner.nextInt();
					}
					//if the new amount of books fit in the inventory, we ask for the information of the new books
					if(newBooksAmount <= (inventory.length - Book.findNumberOfCreatedBooks())) {
						//variable that stores the amount of books before addition
						//this number can be used as the starting index in the array for the new books
						//for example:
						//books:   1   2  *3*   -    -
						//array: | 0 | 1 | 2 | *3* | 4 |
						int originalBooksAmount = Book.findNumberOfCreatedBooks();
						//for loop that iterates an amount of times equal to the amount of new books
						//requests the info from the user (title, author etc.)
						//then uses the constructor to create a new book object in the array
						for(int i=0; i<newBooksAmount; i++) {
							System.out.print("\nEnter title of book #" + (originalBooksAmount+i) + ": ");
							//junk variable that filters out unwanted entries from nextLine()
							junk = scanner.nextLine();
							String newTitle = scanner.nextLine();
							System.out.print("Enter author of book #" + (originalBooksAmount+i) + ": ");
							String newAuthor = scanner.nextLine();
							System.out.print("Enter ISBN of book #" + (originalBooksAmount+i) + ": ");
							long newISBN = scanner.nextLong();
							//while loop for input validation
							while(newISBN < 0) {
								System.out.print("Invalid ISBN. Try again: ");
								newISBN = scanner.nextLong();
							}
							System.out.print("Enter price of book #" + (originalBooksAmount+i) + ": ");
							double newPrice = scanner.nextDouble();
							//input validation
							while(newPrice < 0) {
								System.out.print("Invalid price. Try again: ");
								newPrice = scanner.nextDouble();
							}
							//constructor that uses all the variables entered by the user
							inventory[originalBooksAmount+i] = new Book(newTitle, newAuthor, newISBN, newPrice);
						}
					}
					//if the amount of new books entered by the new user doesnt fit in the inventory,
					//we display the appropriate messages and break out of the function
					else {
						System.out.println("New amount of books entered cannot fit in the inventory.");
						System.out.println("You have " + (inventory.length - Book.findNumberOfCreatedBooks()) +" spots remaining in the inventory.");
					}
				}
				break;
			//the second function of the program edits the values of any book chosen by the user	
			case 2:
				//same concept for passwords as case 1,
				//only difference is there isnt a maximum amount of attempts,
				//the function only exits after each 3rd wrong attempt in a row
				System.out.print("Enter password: ");
				passwordInput = scanner.next();
				while(!password.equals(passwordInput)) {
					wrongPasswordCountCase2++;
					if(wrongPasswordCountCase2 % 3 == 0) {
						System.out.println("Too many wrong attempts.");
						break;
					}
					System.out.println("Wrong password. Try again.");
					System.out.print("Enter password: ");
					passwordInput = scanner.next();
				}
				//if the password is correct, the function starts prompting the user for the appropriate information
				if(password.equals(passwordInput)) {
					//if the inventory doesnt have any books yet, we display the appropriate message and break out of the function
					if(Book.findNumberOfCreatedBooks() == 0) {
						System.out.println("There are currently no books in the inventory.");
						break;
					}
					//we display the numbers of books available in the inventory and prompt the user for a choice
					System.out.println("You can choose from book #0 to #" + (Book.findNumberOfCreatedBooks()-1));
					System.out.print("Enter the number of book you wish to update: ");
					int bookChoice = scanner.nextInt();
					//if the choice is invalid, we prompt the user to either try again, or quit to the main menu
					//we do this by utilizing a while loop
					while(bookChoice < 0 || bookChoice > Book.findNumberOfCreatedBooks()-1){
						System.out.print("Invalid input. If you wish to try again, type 1.\nIf you wish to go back to the main menu, type anything else.\n> ");
						String case2Choice1 = scanner.next();
						if(case2Choice1.equals("1")){
							System.out.print("Try Again: ");
							bookChoice = scanner.nextInt();
						}
						else
							break;
					}
					//if the choice is valid, we ask the user which information they want to change
					//by displaying a different menu that contains all the options available and the current data of the book chosen
					if(bookChoice >= 0 && bookChoice <= Book.findNumberOfCreatedBooks()-1){
						do {
							System.out.println("\n" + inventory[bookChoice] + "\n");
							System.out.println("Which information would you like to change?");
							System.out.println("\t1.\tTitle");
							System.out.println("\t2.\tAuthor");
							System.out.println("\t3.\tISBN");
							System.out.println("\t4.\tPrice");
							System.out.println("\t5.\tQuit");
							System.out.print("Enter your choice: ");
							case2Choice2 = scanner.nextInt();
							//input validation
							while(case2Choice2 < 1 || case2Choice2 > 5) {
								System.out.print("Invalid input. Try again: ");
								case2Choice2 = scanner.nextInt();
								}
							//switch that operates the different choices of the function
							switch(case2Choice2) {
								case 1:
									System.out.print("Enter the new title: ");
									junk = scanner.nextLine();
									String newTitle = scanner.nextLine();
									inventory[bookChoice].setTitle(newTitle);
									break;
								case 2:
									System.out.print("Enter the new author: ");
									junk = scanner.nextLine();
									String newAuthor = scanner.nextLine();
									inventory[bookChoice].setAuthor(newAuthor);
									break;
								case 3:
									System.out.print("Enter the new ISBN: ");
									long newISBN = scanner.nextLong();
									inventory[bookChoice].setISBN(newISBN);
									break;
								case 4:
									System.out.print("Enter the new title: ");
									double newPrice = scanner.nextDouble();
									inventory[bookChoice].setPrice(newPrice);
									break;
								default:
									break;
								}
							}while(case2Choice2 != 5);//if the user chooses to quit, the do while loop will exit
						}
					}
					break;
			//the third function of the program displays all books by the same author
			case 3:
				//if there arent any books yet, we display a message and go back to the main menu
				if(Book.findNumberOfCreatedBooks() == 0) {
					System.out.println("There are currently no books in the inventory.");
					break;
				}
				//prompt the user for the author's name
				System.out.print("Enter the author's name: ");
				junk = scanner.nextLine();
				String authorOfChoice = scanner.nextLine();
				//for loop that goes through all books in the inventory array
				//and checks if they have the same author name as the name entered, regardless of capitalization
				for(int i=0; i<Book.findNumberOfCreatedBooks(); i++) {
					//variable that keeps track of how many books of the same author we have
					int sameAuthorBooksAmount = 0;
					//if the author is found, their book is printed, and the counter gets incremented
					if(inventory[i].getAuthor().equalsIgnoreCase(authorOfChoice)) {
						System.out.println("\n" + inventory[i] + "\n");
						sameAuthorBooksAmount++;
					}
					//if the author doesnt have any books and it is the last iteration,
					//an appropriate message is displayed
					else if(sameAuthorBooksAmount == 0 && i == Book.findNumberOfCreatedBooks()-1) {
						System.out.println("Sorry, the author doesn't exist in the database.");
					}
				}
				break;
			//the fourth function displays all books under a certain price point	
			case 4:
				//we check if there are books in the inventory first
				if(Book.findNumberOfCreatedBooks() == 0) {
					System.out.println("There are currently no books in the inventory.");
					break;
				}
				//we prompt the user to enter the price they
				System.out.print("Enter the desired price: ");
				double priceOfChoice = scanner.nextDouble();
				//input validation
				while(priceOfChoice < 0) {
					System.out.print("Invalid price. Try again: ");
					priceOfChoice = scanner.nextDouble();
				}
				//for loop that checks every book in the inventory array and compares it's price with the price entered
				for(int i=0; i<Book.findNumberOfCreatedBooks(); i++) {
					//counter to keep track of amount of books that are cheaper
					int underPriceBooksAmount = 0;
					//if a book is cheaper, they're displayed, and the counter is incremented
					if(inventory[i].getPrice() < priceOfChoice) {
						System.out.println("\n" + inventory[i] + "\n");
						underPriceBooksAmount++;
					}
					//if no books are found, a message is displayed
					else if(underPriceBooksAmount == 0 && i == Book.findNumberOfCreatedBooks()-1) {
						System.out.println("Sorry, there aren't any books that cost less in the database.");
					}
				}
				break;
			//the fifth function is when the user wants to quit the program
			case 5:
				break;
			//default case for when the user inputs something invalid, it would redirect them to the main menu
			default:
				System.out.println("Invalid input. Try again.");
				break;
			}
		}while(choice != 5);//if the condition is satisfied, the do while loop be exited
		//display closing message
		System.out.println("Thank you for using the program. Goodbye.");
		//close scanner
		scanner.close();
	}//close main
}//close class
