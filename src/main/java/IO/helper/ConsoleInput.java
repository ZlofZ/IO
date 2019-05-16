package IO.helper;

import java.util.Scanner;

public class ConsoleInput{
	private Scanner scanner;
	
	
	/**
	 * Waits for terminal input from the user in the form of an int.
	 * @return The int inputted by the user.
	 */
	public int readInt(){
		return readInt("");
	}
	/**
	 * Waits for terminal input from the user in the form of an int.
	 * @param inputQuery a String that will be printed before asking the user for input.
	 * @return The int inputted by the user.
	 */
	public int readInt(String inputQuery){
		if(!inputQuery.isEmpty())
			System.out.println(inputQuery);
		int i = scanner.nextInt();
		scanner.nextLine();
		return i;
	}
	
	/**
	 * Waits for terminal input from the user in the form of a String.
	 * @return The String inputted by the user.
	 */
	public String readString(){
		return readString("");
	}
	
	/**
	 * Waits for terminal input from the user in the form of a String.
	 * @param inputQuery a String that will be printed before asking the user for input.
	 * @return a String that will be printed before asking the user for input.
	 */
	public String readString(String inputQuery){
		if(!inputQuery.isEmpty())
			System.out.println(inputQuery);
		return scanner.nextLine();
	}
	
	/**
	 * The constructor for the ConsoleInput Class.
	 */
	public ConsoleInput(){
		scanner = new Scanner(System.in);
	}
}
