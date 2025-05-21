// -------------------------------------------------------
// Assignment 0
// Written by: Karam Midani 40277218
// For COMP 249 Section PP 2234 – Winter 2024
// -------------------------------------------------------
package assignment0;
//Book class, contains variables, constructors, getters, setters, and other methods
public class Book {
	//instance variables that represent the data of each book
	//private to hide it from other classes and restrict access
	private String title;
	private String author;
	private long ISBN;
	private double price;
	//static variable that represents the amount of objects of type book created
	private static int BookCount = 0;
	
	//parameterized constructor that takes 4 parameters and assigns them to the instance variables of the object
	public Book(String title, String author, long ISBN, double price) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.price = price;
		//the constructor increments the static counter variable to indicate an increase in book objects created
		BookCount++;
	}
	//copy constructor that takes another book type object 
	//and assigns the values of it's variables to the variables of the new object
	//this is done by using the custom constructor and using the the variables of our parameter as parameters
	public Book(Book otherBook) {
		this(otherBook.title, otherBook.author, otherBook.ISBN, otherBook.price);
	}
	//default constructor that utilises the custom constructor and takes default values
	public Book() {
		this("N/A", "N/A", 0, 0);
	}
	//getters
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public long getISBN() {
		return ISBN;
	}
	public double getPrice() {
		return price;
	}
	//setters
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setISBN(long ISBN) {
		this.ISBN = ISBN;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	//static method that returns the static counter variable
	public static int findNumberOfCreatedBooks() {
		return BookCount;
	}
	//equals method that takes another object of type book as a parameter
	//compares if both ISBNs are the same and if both have the same price, and returns a boolean value accordingly
	public boolean equals(Book otherBook) {
		return (this.ISBN == otherBook.ISBN && this.price == otherBook.price);
	}
	//tostring method that returns a custommade string, overrides print method for book objects
	@Override
	public String toString() {
		return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + ISBN + "\nPrice: $" + price;
	}
	
}//close class
