package coding_challenge_1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class coding_challenge_1 {
	
	// Gather input from the user
	// The prompt is used as the first message
	public static void input_handler(String prompt) {
		boolean is_valid = false;
		boolean is_valid_name = false;
		boolean is_valid_age = false;
		boolean is_valid_id = false;
		String name = "";
		String age = "";
		String id = "";
		String output_type = "cmd";
		
		
		while(is_valid == false) {
			System.out.println(prompt);
			
			// Get the name
			name = get_input("What is your name? ");
			is_valid_name = error_checker(name,"name");
			// Get the age
			age = get_input("What is your age? ");
			is_valid_age = error_checker(age,"age");
			// Get the Youtube id
			id = get_input("What is your Youtube id? ");
			is_valid_id = error_checker(id,"id");
			
			is_valid = is_valid_name & is_valid_age & is_valid_id;
		}
		
		String output = formatter(name,age,id);
		
		// File or command line?
		String answer = get_input("Do you want to write to a file (y or n)? ");
		if(answer.equals("y")) {
			output_type = "file";
		}
		
		output_handler(output,output_type);
		
	}
	
	// Check if there is any errors in the item given its type
	public static boolean error_checker(String item,String type) {
		boolean is_valid = true;
		
		switch(type) {
			case "name":
				is_valid = !is_number(item);
				break;
			case "age":
				is_valid = is_number(item);
				break;
			case "id":
				is_valid = !is_number(item);
				break;
		}
		
		return is_valid;
	}
	
	// Format the input from the user into a 
	public static String formatter(String name,String age,String id) {
		String formatted_output = "";
		formatted_output = "Your name is " + name + ", you are " + age +" years old and your username is " + id + "."; 
		return formatted_output;
	}
	
	// Write the output either to the command line or to a file depending on type
	public static void output_handler(String output,String type) {
		
		switch(type) {
			case "file":
				// Get the file name
				String file_name = get_input("Enter file name: ");
				file_name = file_name + ".txt";
				write_to_file(file_name,output);
				break;
			case "cmd":
				System.out.println(output);
				break;
		}
	}
	
	// Helper functions
	// Write the output to the given file_name, if already exist will overwrite
	public static void write_to_file(String file_name,String output) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file_name, "UTF-8");
			writer.write(output);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		writer.close();
	}
	
	// Get an input from the user
	public static String get_input(String prompt) {
		String input = "";
		//Set up the scanner
		Scanner reader = new Scanner(System.in);
		//Prompt the user
		System.out.println(prompt);
		//Get the data (here it is always a string)
		input = reader.nextLine(); 
		return input;
	}
	
	//Check if the string is a number or not
	public static boolean is_number(String number) {
		try {
				double d = Double.parseDouble(number);
			} 
		catch (NumberFormatException | NullPointerException nfe) {
				return false;
			}
		return true;
	}
	
	// Boot function
	public static void main(String args[]) {
		String prompt = "Hi, please enter the following: ";
		input_handler(prompt);
	}
}
