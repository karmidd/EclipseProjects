package assignments;

import java.util.Scanner;

public class LastLabDriver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String name = scanner.next();
		char[] stringArray = name.toCharArray();
		for(int i = 0; i<stringArray.length; i++) {
			if(i==0) {
				for(int j = stringArray.length/2; j<stringArray.length; j++) {
					System.out.print(stringArray[j] + " ");
					if(j==stringArray.length-1) {
						for(int k = 0; k<stringArray.length/2; k++) {
							if(k == (stringArray.length/2)-1) {
								System.out.print(stringArray[k] + "\n");
								break;
							}
							System.out.print(stringArray[k] + " ");
						}
					}
				}
			}
			if(i != stringArray.length-2) {
				for(int l = (stringArray.length-1)*2-i*2; l>0; l--) {
					if(l == 2) {
						System.out.print("&\n");
						break;
					}
					System.out.print(" ");
				}
			}
			if(i == stringArray.length-1) {
				for(int j = stringArray.length/2; j<stringArray.length; j++) {
					System.out.print(stringArray[j] + " ");
					if(j==stringArray.length-1) {
						for(int k = 0; k<stringArray.length/2; k++) {
							if(k == (stringArray.length/2)-1) {
								System.out.print(stringArray[k] + "\n" + "Awesome!");
								break;
							}
							System.out.print(stringArray[k] + " ");
						}
					}
				}
			}	
		}
	scanner.close();
	}

}
