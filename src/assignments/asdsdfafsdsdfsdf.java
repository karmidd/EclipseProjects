package assignments;
import java.util.Scanner;
public class asdsdfafsdsdfsdf {

	public static void main(String[] args) {
		System.out.println("Welcome to Mont-Halloween Skiing contest Ranker.");

		System.out.println("Whenever a skier makes it to the finish line, enter their "

		+ "name and skiing time.");


		Scanner scanner = new Scanner(System.in);

		String[] names = new String[20];

		double[] times = new double[20];


		int count = 0;

		int firstPodiumIndex = 0;

		int secondPodiumIndex = 0;

		int thirdPodiumIndex = 0;

		while (count < 20) {


		System.out.println("Please input the skier's name: ");

		String name = scanner.nextLine();


		System.out.println("Please input the skier's time: ");

		double time = Double.parseDouble(scanner.nextLine());



		// Check if the time is unique

		boolean UniqueTime = true;

		for (int i = 0; i < count; i++) {

		if (times[i] == time) {

		UniqueTime = false;

		break;

		}

		}



		if (UniqueTime) {


		names[count] = name;

		times[count] = time;




		if (times[count] < times[firstPodiumIndex]) {

		thirdPodiumIndex = secondPodiumIndex;

		secondPodiumIndex = firstPodiumIndex;

		firstPodiumIndex = count ;

		} else if (times[count] > times[firstPodiumIndex]&&

		times[count] < times[secondPodiumIndex]) {

		thirdPodiumIndex = secondPodiumIndex;

		secondPodiumIndex = count ;

		} else if (times[count] > times[secondPodiumIndex]&&

		times[count] < times[thirdPodiumIndex]) {

		thirdPodiumIndex = count ;

		}


		count++;


		System.out.println("First podium goes to " + names[firstPodiumIndex] +

		" who made it in " + times[firstPodiumIndex] );




		if (count >= 2) {

		System.out.println("Second podium goes to " + names[secondPodiumIndex] +

		" who made it in " + times[secondPodiumIndex] );

		}

		if (count >= 3) {

		System.out.println("Third podium goes to " + names[thirdPodiumIndex] +

		" who made it in " + times[thirdPodiumIndex] );

		}



		System.out.print("Do you want to add another skier (yes/no)? ");

		String choice = scanner.nextLine();

		if (!choice.equalsIgnoreCase("y")) {

		break;

		}

		} else {

		System.out.println("Skiing time must be unique. Please enter a different time.");

		}

		}




		System.out.println("Goodbye!");

		scanner.close();

	}

}
