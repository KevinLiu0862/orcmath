package bensStuff;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Graduation extends Component {

	public Graduation() {
		super(40,40,100,100);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.drawRect(0,0,getWidth(),getHeight());
	}

}
