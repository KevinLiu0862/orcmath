package kevin;

import guiPlayer.Sampler;
import guiPlayer.Sampler.SampleScreen;
import guiTeacher.GUIApplication;

public class CatalogMakerGUI extends GUIApplication {
	
	public CatalogMakerGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		CatalogMakerGUI sample = new CatalogMakerGUI(1000, 1000);
		Thread go = new Thread(sample);
		go.start();

	}
	
	public void initScreen() {
		CatalogScreen s = new CatalogScreen(getWidth(), getHeight());
		setScreen(s);
	}
	
	

}
