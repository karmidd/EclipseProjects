// -------------------------------------------------------
// Assignment 1
// Written by: Karam Midani 40277218
// For COMP 248 Section R 2232 – Fall 2023
// -------------------------------------------------------

//this program takes a distance from the user then performs the appropriate calculations 
//to display how many earth days it needs the project-s spaceship to reach this distance.

//we import Scanner to use it for user inputs
package assignments;

import java.util.Scanner;

public class A1_Q2 {
	
	public static void main(String[] args) {
		
		//assign a scanner to take inputs from the user
		Scanner keyboard = new Scanner(System.in);
		
		//welcome message and algorithm name
		System.out.println("Welcome to the Project-S Simple Travel-Time Computer:");
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		
		//Algorithm 2: Simple Travel-Time Computer
		//we ask the user to input the desired distance in km and we declare it as a double to take any amount the user wants
		System.out.print("\nPlease enter the distance (in km) between the Earth and the extraterrestrial body: ");
		double distance = keyboard.nextDouble();
		
		//declaration and assignment of constants given: the speed in mph, the conversion rate, and the speed in kmph to be used in the calculation
		final double CONVERSION_RATE_MPH_TO_KMPH = 1.61;
		final double SPEED_IN_MPH = 28000;
		final double SPEED_IN_KMPH = SPEED_IN_MPH * CONVERSION_RATE_MPH_TO_KMPH;
		
		//calculation that takes the input of the distance divided by the speed of the spaceship in kmph, divided by 24 hours to convert to earth days
		double days = (distance/SPEED_IN_KMPH)/24;
		
		//we add 0.5 to days, then cast it as an integer to round it. 
		//if decimal in original answer is .5 or above, it would be rounded, if its less than .5, it wont be rounded
		days = days+0.5;
		days = (int)days;
				
		//message that displays how many earth days needed to reach the destination in the spaceship
		System.out.println("Project-S spaceship, constantly travelling at 28000mi/h, will take approximately"
				+ "\n" + days + " 'Earth-based days' to get it's foreknown extraterrestrial destination.");
		
		//closing message
		System.out.println("\nThank you for your contribution to Project-S.");
		
		//close scanner
		keyboard.close();
		
	} //close main

} //close public class
