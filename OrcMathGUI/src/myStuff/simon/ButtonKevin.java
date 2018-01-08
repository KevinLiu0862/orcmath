package myStuff.simon;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonKevin extends Button implements ButtonInterfaceKevin{

	public ButtonKevin(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);

		update();  
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub
		
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		
	}

}
