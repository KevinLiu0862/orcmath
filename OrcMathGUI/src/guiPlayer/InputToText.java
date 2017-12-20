package guiPlayer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import components.Superheroes;

public class InputToText {

	private static ArrayList<InputToText> list;
	Scanner in = new Scanner(System.in);
	


	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Please enter something.");
		
		String input = in.nextLine();
	
		InputToText it = new InputToText();
		it.testSaveContent("text.txt", input);
	}

	
	
	public static String getCSVContent(){
		String data = "I";
		
		for (InputToText s : list) {
			data += s + "\n";
		}
		
		return data;
	}
	private void testSaveContent(String fileName,String input) {

		try {

			FileWriter fw = new FileWriter(fileName);
			
			for(InputToText s: list) {
			fw.write( input + "\n");
			}

			fw.close();

			System.out.println("Success! File \"" + fileName + "\" saved!");

		} catch (IOException e) {

			System.out.println(
					"An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");

		}

	}
}
