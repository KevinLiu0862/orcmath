package guiPlayer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import components.Superheroes;

public class CatalogMaker {

	private static ArrayList<Superheroes> list;
	private static String name;
	private static String gender;
	private static String color;
	private static String power;
	
	public CatalogMaker() {
		
		list = new ArrayList<Superheroes>();
		list.add(new Superheroes("Superman", "Male", "Blue", "Flyyyyyyyyyyyy"));
		list.add(new Superheroes("Flash", "Male", "Red", "Faaaaaaaaast"));
		list.add(new Superheroes("Ant Man", "Male", "Black", "Shriiiiiiiiiiiiink"));
		list.add(new Superheroes("Wonderwoman", "Female", "Blue", "Stroooooooong"));
		list.add(new Superheroes("Iron Man", "Male", "Red", "Smaaaaaaaaaaart"));
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		CatalogMaker cm = new CatalogMaker();
		System.out.println(cm.getCSVContent());
		
		System.out.println("Enter the name of your superhero");
		 name = in.nextLine();
		System.out.println("Enter the gender of your superhero");
		 gender = in.nextLine();
		System.out.println("Enter the color of your superhero");
		 color = in.nextLine();
		System.out.println("Enter the power of your superhero");
		 power = in.nextLine();
		
		cm.addNewHero(name, gender, color, power);
		cm.testSaveContent("superheroes.csv");
	}

	public String getCSVContent(){
		String data = "Name,Gender,Color,Power \n";
		
		for (Superheroes s : list) {
			data += s + "\n";
		}
		
		return data;
	}
	
	public void addNewHero(String name, String gender, String color, String power) {
		list.add(new Superheroes(name, gender, color, power));
		
		System.out.println("Superhero created successfully.");
	}
	
	
	private void testSaveContent(String fileName) {

		try {

			FileWriter fw = new FileWriter(fileName);
			
			for(Superheroes s: list) {
			fw.write(getCSVContent() + "\n");
			}

			fw.close();

			System.out.println("Success! File \"" + fileName + "\" saved!");

		} catch (IOException e) {

			System.out.println(
					"An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");

		}

	}
}
