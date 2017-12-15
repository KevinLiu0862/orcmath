package components;

import java.awt.Color;
import java.awt.Graphics2D;

//import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Superheroes extends Component {

	
	private String name;
	private String gender;
	private String color;
	private String power;
	
	public Superheroes(String name, String gender, String color, String power) {
		super(40, 40, 300, 300);
		
		this.name = name;
		this.gender = gender;
		this.color = color;
		this.power = power;
		
		//addSequence("resources/spritesheet.png" , 150, 0, 0, 256, 225, 3);
		//Thread animation = new Thread(this);
		//animation.start();
		
		update();
	}

	@Override
	public void update(Graphics2D g) {
		
		//g.setColor(Color.pink);
		//g.fillRect(0, 0, getWidth(), getHeight());
		//super.update(g);
	}

	public String toString() {
		return name + "," + gender + "," + color + "," + power;
	}
}
