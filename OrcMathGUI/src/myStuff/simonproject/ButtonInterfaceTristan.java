package myStuff.simonproject;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.interfaces.Clickable;

public interface ButtonInterfaceTristan extends Clickable {
	void setColor(Color blue);
	void setAction(Action action);
	void highlight();
	void dim();
}//