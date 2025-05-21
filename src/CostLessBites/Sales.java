// -------------------------------------------------------
// Assignment 4
// Written by: Karam Midani 40277218
// For COMP 248 Section R 2232 – Fall 2023
// -------------------------------------------------------
package CostLessBites;
//class type Sales
public class Sales {
	//everything is private to hide it from other classes
	//final static values that represent the price of each meal type
	private static final int JUNIOR_PRICE = 5;
	private static final int TEEN_PRICE = 10;
	private static final int MEDIUM_PRICE = 12;
	private static final int  BIG_PRICE = 15;
	private static final int  FAMILY_PRICE = 20;
	//instance variables that represent the quantity of sales from each type
	private int juniorSales;
	private int teenSales;
	private int mediumSales;
	private int bigSales;
	private int familySales;
	
	//default constructor that initiates all instance variables to 0
	public Sales() {
		this.juniorSales = 0;
		this.teenSales = 0;
		this.mediumSales = 0;
		this.bigSales = 0;
		this.familySales = 0;
	}
	//constructor that takes 5 int formal parameters and assigns them to their correspondant instance variable
	public Sales(int juniorSales, int teenSales, int mediumSales, int bigSales, int familySales) {
		this.juniorSales = juniorSales;
		this.teenSales = teenSales;
		this.mediumSales = mediumSales;
		this.bigSales = bigSales;
		this.familySales = familySales;
	}
	//copy constructor that takes 1 parameter of type Sales and copies all values of
	//another object of class type Sales
	public Sales(Sales original) {
		this.juniorSales = original.juniorSales;
		this.teenSales = original.teenSales;
		this.mediumSales = original.mediumSales;
		this.bigSales = original.bigSales;
		this.familySales = original.familySales;
	}
	//getter methods
	public int getJuniorSales() {
		return this.juniorSales;
		}
	public int getTeenSales() {
		return this.teenSales;
		}
	public int getMediumSales() {
		return this.mediumSales;
		}
	public int getBigSales() {
		return this.bigSales;
		}
	public int getFamilySales() {
		return this.familySales;
		}
	//setters that take a parameter that gets assigned to the instance variable
	public void setJuniorSales(int sales) {
		this.juniorSales = sales;
		}
	public void setTeenSales(int sales) {
		this.teenSales = sales;
		}
	public void setMediumSales(int sales) {
		this.mediumSales = sales;
		}
	public void setBigSales(int sales) {
		this.bigSales = sales;
		}
	public void setFamilySales(int sales) {
		this.familySales = sales;
		}
	//method that takes 5 int parameters and adds them to the correspondant instance variables
	public void addSales(int juniorInc, int teenInc, int mediumInc, int bigInc, int familyInc) {
		this.juniorSales += juniorInc;
		this.teenSales += teenInc;
		this.mediumSales += mediumInc;
		this.bigSales += bigInc;
		this.familySales += familyInc;
		}
	//method that calculates the total by doing (price*sales) + (price2*sales2) and so on
	//we also utilise out getter methods here
	//returns total as an int
	public int salesTotal() {
		int total = (JUNIOR_PRICE*this.getJuniorSales()) + (TEEN_PRICE*this.getTeenSales()) + (MEDIUM_PRICE*this.getMediumSales()) + (BIG_PRICE*this.getBigSales()) + (FAMILY_PRICE*this.getFamilySales());
		return total;
		}
	//toString method that returns a string that concludes the sales
	// saleNumber x $price + saleNumber2 x $price2 and so on
	public String toString() {
		return this.getJuniorSales() + " x $" + JUNIOR_PRICE + " + " +  this.getTeenSales() + " x $" + TEEN_PRICE + " + " +  this.getMediumSales() + " x $" + MEDIUM_PRICE + " + " +  this.getBigSales() + " x $" + BIG_PRICE + " + " +  this.getFamilySales() + " x $" + FAMILY_PRICE;
		}
	//equals method that takes one parameter of type Sales and checks if both objects have the same amount of sales
	//returns boolean
	//if sales1 = 10 & sales2 = 10,
	//sales1 == sales2 --> true
	//we utilise the getter methods here as well
	public boolean equals(Sales sales) {
		return (this.getJuniorSales() == sales.getJuniorSales() && this.getTeenSales() == sales.getTeenSales() && this.getMediumSales() == sales.getMediumSales() && this.getBigSales() == sales.getBigSales() && this.getFamilySales() == sales.getFamilySales());		 	
		}

}//close class
