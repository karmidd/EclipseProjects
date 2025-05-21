// -------------------------------------------------------
// Assignment 4
// Written by: Karam Midani 40277218
// For COMP 248 Section R 2232 – Fall 2023
// -------------------------------------------------------
package CostLessBites;

public class PrePaiCard {
	//instance variables indicating information on the card
	//private to keep them hidden
	private String type;
	private int month;
	private int day;
	private String id_number;
	
	//default constructor that gives the instance variables values of 0 or empty strings
	public PrePaiCard() {
		this.type = "";
		this.month = 0;
		this.day = 0;
		this.id_number = "";
	}
	//constructor that takes 4 parameters that get assigned to the correspondant instance variables
	//we use if statements on day and month, if parameters are an illogical number,
	//we assign 0 to day and month instance variables
	public PrePaiCard(String type, int month, int day, String id_number) {
		this.type = type;
		this.id_number = id_number;
		if (month >= 1 && month <= 12)
			this.month = month;
		else
			this.month = 0;
		if (day >= 1 && day <= 31)
			this.day = day;
		else
			this.day = 0;
		this.id_number = id_number;
	}
	//copy constructor that takes a parameter of class type PrePaiCard
	//and copies all the variables
	public PrePaiCard(PrePaiCard original) {
		this.type = original.type;
		this.month = original.month;
		this.day = original.day;
		this.id_number = original.id_number;
	}
	//getter methods
	public String getType() {
		return this.type;
	}
	public int getMonth() {
		return this.month;
	}
	public int getDay() {
		return this.day;
	}
	public String getIdNumber() {
		return this.id_number;
	}
	//setter methods that assign the parameters to the instance variables
	public void setType(String type) {
		this.type = type;
	}
	public void setMonth(int month) {
		if (month >= 1 && month <= 12)
			this.month = month;
		else
			this.month = 0;
	}
	public void setDay(int day) {
		if (day >= 1 && day <= 31)
			this.day = day;
		else
			this.day = 0;
	}
	public void setIdNumber(String id_number) {
		this.id_number = id_number;
	}
	//toString method that returns a concatenation of 4 strings which are:
	//a string that represents the day, includes 0 if the day is a 1 digit number
	//a string that represents the month, includes 0 if the month is a 1 digit number
	//the type string, that we can access using getter method
	//the id number string, that we can access using getter method
	public String toString() {
		String dayString;
		String monthString;
		if (this.getDay() < 10)
			dayString = "0" + this.getDay();
		else
			dayString = this.getDay() + "";
		if (this.getMonth() < 10)
			monthString = "0" + this.getMonth();
		else
			monthString = this.getMonth() + "";
		
		return this.getType() + " - " + this.getIdNumber() + " - " + dayString + "/" + monthString + ".";
	}
	//equals method that takes a parameter of class type PrePaiCard
	//we check if each variable from one PrePaiCard is equals to the one on another PrePaiCard
	//we use the appropriate ways of comparisons ( == for numbers, .equals() for strings)
	public boolean equals(PrePaiCard prepaicard) {
		return (this.getMonth() == prepaicard.getMonth() && this.getDay() == prepaicard.getDay() && this.getType().equals(prepaicard.getType()) && this.getIdNumber().equals(prepaicard.getIdNumber()));		
	}
}//close class
