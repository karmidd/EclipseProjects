// -------------------------------------------------------
// Assignment 1
// Written by: Karam Midani 40277218
// For COMP 248 Section R 2232 – Fall 2023
// -------------------------------------------------------

//this program performs specific arithmetic equations to values of x and y in respect to the special operator "@" to compute the values of variables z.
//in other words, this program calculates x @ y = z
package assignments;

public class A1_Q1 {

	public static void main(String[] args) {
		
		//printing the welcome message and the challenge name
		System.out.println("Welcome to the Authentication Challenge Program.");	
		System.out.println("Project-S Access System: 6-Piece Authentication Challenge: ");	
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//Algorithm 1: Simple Cipher Program
		//declaration and assignment of x and y values and declaration of z:	
		int x1 = 7, x2 = 8, x3 = 4, x4 = 20, x5 = 9, x6 = 45;
		int y1 = 5, y2 = 3, y3 = 2, y4 = 14, y5 = 3, y6 = 20;
		int z1, z2, z3, z4, z5, z6;
		
		//we use the arithmetic operations of division, addition, and remainder, to find z:
		//z equals the quotient of x/y plus the remainder of x/y
		//@ = (a/b) + (a%b)
		z1 = (x1/y1) + x1%y1;
		z2 = (x2/y2) + x2%y2;
		z3 = (x3/y3) + x3%y3;
		z4 = (x4/y4) + x4%y4;
		z5 = (x5/y5) + x5%y5;
		z6 = (x6/y6) + x6%y6;
		 
		//printing the display of the six puzzle pieces with all the variables
		System.out.println(x1+" @ "+y1+"  "+x2+" @ "+y2+"  "+x3+" @ "+y3+"  "+x4+" @ "+y4+"  "+x5+" @ "+y5+"  "+x6+" @ "+y6);
		System.out.println("  |      |      |       |       |       |");
		System.out.println("  "+z1+"      "+z2+"      "+z3+"       "+z4+"       "+z5+"       "+z6+"  ");
		
		//printing closing message
		System.out.println("At Project-S, we employ multi-factor authentication because one password is never enough.");
		
	} //close main
	
} //close public class
