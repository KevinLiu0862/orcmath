package myStuff.simonproject;

import guiTeacher.GUIApplication;

public class SimonGameTristan extends GUIApplication {

	public static SimonGameTristan game;
	public static SimonScreenTristan screen;
	
	
	public SimonGameTristan(int width, int height) {
		super(width, height);
		setVisible(true);
	}
	@Override
	public void initScreen() {
		screen = new SimonScreenTristan(getWidth(), getHeight());
		setScreen(screen);
//
	}
	public static void main(String[] args)
	{
		game = new SimonGameTristan(800,800);
		Thread runner = new Thread(game);
		runner.start();
	}


}//
