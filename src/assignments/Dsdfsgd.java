package assignments;
import java.util.Scanner;
public class Dsdfsgd {

	public static void main(String[] args) {
		
		final int PER_LINE = 5;
		
		int value, limit, mult, count = 0;
		
		@SuppressWarnings("resource")
		Scanner nuno = new Scanner(System.in);
		
		System.out.print("Enter a positive value: ");
		value = nuno.nextInt();
		
		System.out.print("Enter an upper limit: ");
		limit = nuno.nextInt();
		
		System.out.println("Multiples of "+value+" between "+ value + " & " + limit);
		
		for (mult = value ; mult <= limit; mult+=value) {
			System.out.print(mult + "\t");
			
			// Print a specific number of values per line of output
			count++;
			if (count % PER_LINE == 0)
				System.out.print("\n");
			}

		nuno.close();
		
		
		
	}

}
