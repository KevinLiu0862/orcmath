package components;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class Apple extends Component {

	public Apple() {
		
		super(40, 40, 100, 100);
		update();
	}

	@Override
	public void update(Graphics2D g) {
		
		g.setColor(Color.pink);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

}
