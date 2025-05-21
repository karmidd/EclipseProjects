package assignments;

import java.util.Scanner;

public class AvgMarks {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double[][] marks = new double[10][4];
		for (int i = 0; i < marks.length; i++ ) {
			System.out.println("Please enter the marks for student number " + (i+1));
			for (int s = 0; s < marks[i].length; s++) {
				System.out.println("Please enter mark number "+ (s+1));
				marks[i][s] = scanner.nextDouble();
			}
			
		}
		
		for (int i = 0; i < marks.length; i++) {
			for (int s = 0; s < marks[i].length ; s++)
					System.out.println(marks[i][s]);
		scanner.close();
				

		}
	}
}
