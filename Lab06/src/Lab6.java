import java.util.Scanner;

/**
 * * 
 * This class contains the main method and menu 
 * Student Name: Mostapha A
 * Course: CST8130 - Data Structures CET-CS-Level 3
 * 
 * @author/Mostapha A
 * 
 */

/**
 * Implements an array of strings using hashing algorithms to set the key and
 * store.
 */
public class Lab6 {

	/**
	 * Main method for implementing array of strings and printing menu and processing.
	 * 
	 * @param args Default needed for main method
	 */
	public static void main(String[] args) {
		// variables
		int menu = -1; // menu validation
		Scanner scanner = new Scanner(System.in); // scanner for input
		String[] dataItems = new String[0]; // array for strings
		String input; // string for input into array
		int arraySize = 100; // array size for array initialization
		int index; // index for hashing calculation
		int i; // loop variable
		boolean printed = false; // variable for printing array

		// loop through menu
		do {
			// set menu to -1
			menu = -1;

			// print menu
			printMenu();

			// if input is an integer, store
			if (scanner.hasNextInt()) {
				menu = scanner.nextInt();
			} else {
				// clear input
				scanner.next();
			}

			// if it is out of range print error and loop again
			if (menu < 1 || menu > 3) {
				// print error and loop through again
				System.out.println("Invalid menu option\n");
			} else {
				// dynamically allocate array if less than arraySize
				if (dataItems.length < arraySize) {
					dataItems = new String[arraySize];
				}
				
				// case structure for menu options
				switch (menu) {
				case 1:
					// add a string
					System.out.print("Enter string to insert: ");
					input = scanner.next();

					// calculate index
					if (input.length() >= 2) {
						index = (input.charAt(0) + input.charAt(1)) % 100;
					} else {
						index = input.charAt(0) % 100;
					}

					// check if there is something there, increment if so
					while (index < 100 && dataItems[index] != null) {
						index++;
					}

					// if there is space in original index or a larger index add, otherwise print error
					if (index < 100 && dataItems[index] == null) {
						// try catch for exception handling
						try {
							// add at index
							dataItems[index] = input;
						} catch (Exception e) {
							// print exception if caught
							System.err.println(e);
						}
					} else {
						System.out.println("String cannot be placed");
					}

					// print table
					System.out.print("Table: {");
					// print each non null value
					printed = false;
					for (i = 99; i >= 0; i--) {
						// if the value is not null
						if (dataItems[i] != null) {
							// if there is a value before it, print comma and space
							if (printed == true) {
								System.out.print(", ");
							}
							// print index then value
							System.out.print(i + "=" + dataItems[i]);
							printed = true;
						}
					}
					// end of table
					System.out.println("}\n");

					break;
				case 2:
					// search for a string
					System.out.print("Enter string to find: ");
					input = scanner.next();

					// check first index to look in
					if (input.length() >= 2) {
						index = (input.charAt(0) + input.charAt(1)) % 100;
					} else {
						index = input.charAt(0) % 100;
					}

					// loop check index position then iterate through array until found
					while (index < 100 && dataItems[index] != null && input.compareTo(dataItems[index]) != 0
							&& index < 99) {
						index++;
					}

					// print if found or not
					if (index < 100 && dataItems[index] != null && input.compareTo(dataItems[index]) == 0) {
						System.out.printf("\"%s\" found at index: %d\n", input, index);
					} else {
						System.out.printf("\"%s\" was not found \n", input);
					}

					// print table
					System.out.print("Table: {");
					// print each non null value
					printed = false;
					for (i = 99; i >= 0; i--) {
						// if the value is not null
						if (dataItems[i] != null) {
							// if there is a value before it, print comma and space
							if (printed == true) {
								System.out.print(", ");
							}
							// print index then value
							System.out.print(i + "=" + dataItems[i]);
							printed = true;
						}
					}
					// end of table
					System.out.println("}\n");

					break;
				case 3:
					// exit
					System.out.println("Exiting...");
					break;
				}
			}
		} while (menu != 3);
		
		// close scanner
		scanner.close();
	}

	/**
	 * Prints the menu of options for the program.
	 */
	public static void printMenu() {
		// menu to be printed
		System.out.printf("1. Add a String to the array dataItems\r\n" + "2. Search for a String in the array\r\n"
				+ "3. Exit\r\n" + "> ");
	}
}
