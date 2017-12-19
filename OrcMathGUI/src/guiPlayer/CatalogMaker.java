<<<<<<< HEAD
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

	public static String getCSVContent(){
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
=======
package guiPlayer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CatalogMaker {

	public static Scanner in;

	private ArrayList<Book> catalog;

	public CatalogMaker() {
		//instantiate the catalog
		catalog = new ArrayList<Book>();
	}

	public static void main(String[] args){
		CatalogMaker maker = new CatalogMaker();
		in = new Scanner(System.in);
		maker.menu();
	}

	private static void displayMessage(String message){
		System.out.println(message);
	}

	private void menu() {
		displayMessage("Would you like to \"load\" a save file or \"create\" a new list? ");
		String[] allowedEntry = {"load","create"};
		String input = getEntry(allowedEntry);
		if(input.equals("load")){
			load();
		}else{
			create();
		}
	}

	private void create() {
		
		boolean running = true;
		while(running){
			showCatalog();
			displayMessage("Would you like to \"add\", \"save\", or \"quit\"?");
			String[] allowedEntry = {"add","save","quit"};
			String selection = getEntry(allowedEntry);
			if(selection.equals("add")){
				add();
			}else if(selection.equals("save")){
				save();
			}else{
				running = false;
			}
		}
	}

	private void add() {
		String title = null;
		String author = null;
		int pages = 0;
		displayMessage("Please enter a title");
		title = getStringInput();
		displayMessage("Please enter an author");
		author = getStringInput();
		displayMessage("Please enter the number of pages.");
		pages = getIntegerInput();
		addBook(new Book(title, author, pages));
	}

	private int getIntegerInput() {
		String text = in.nextLine();
		int value = 0;
		boolean valid = false;
		while(!valid){
			try{
				value = Integer.parseInt(text);
				valid = true;
			}catch(NumberFormatException nfe){
				displayMessage("You must enter an integer.");
			}
		}
		return value;
	}

	private static String getStringInput(){
		String text = in.nextLine();
		while(text.isEmpty()){
			displayMessage("You must enter a non-empty String.");
			text = in.nextLine();
		}
		return text;
	}


	private void addBook(Book b){
		catalog.add(b);
	}

	private void save() {
		try{    
			FileWriter fw=new FileWriter("BookCatalog.csv");
			for(Book b: catalog){
				fw.write(b+"\n");    	
			}

			fw.close();    
			System.out.println("Success! File \"BookCatalog.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}

	private static String getEntry(String[] allowedEntry) {
		String input = in.nextLine();
		while(!matchesEntry(input, allowedEntry)){
			displayMessage("You must enter one of these words: ");
			for(String s: allowedEntry){
				System.out.print(s+" ");
			}
			displayMessage("\n");
			input = in.nextLine();
		}
		return input;
	}

	private static boolean matchesEntry(String text, String[] list){
		for(String l: list){
			if(l.equals(text))return true;
		}
		return false;
	}

	private  void showCatalog() {
		displayMessage("The catalog contains these Books:\n");
		for(Book b: catalog){
			displayMessage("   "+b.toString()+"\n");
		}
	}

	private void load() {
		String fileName = "";
		//empty the catalog to prepare for a new load
		catalog = new ArrayList<Book>();
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened){
			try {
				System.out.println("Enter a file to open");
				fileName = in.nextLine();
				FileReader fileReader = new FileReader(new File(fileName));
				String line = "";
				//a BufferedReader enables us to read teh file one line at a time
				BufferedReader br = new BufferedReader(fileReader);
				while ((line = br.readLine()) != null) {

					String[] param = line.split(",");
					//add a new Book for each line in the save file
					catalog.add(new Book(param[0],param[1],Integer.parseInt(param[2])));



				}
				br.close();
				opened = true;
			}catch (IOException e) {
				System.out.println("The file name you specified does not exist.");
			}
		}
		create();

	}
}
>>>>>>> branch 'master' of https://github.com/KevinLiu0862/orcmath.git
