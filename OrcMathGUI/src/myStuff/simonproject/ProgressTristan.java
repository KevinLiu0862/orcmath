package myStuff.simonproject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class ProgressTristan implements ProgressInterfaceTristan {

	public ProgressTristan() {
		// TODO Auto-generated constructor stub
	}

	public void update(Graphics2D g, boolean hover){
		g.setColor(Color.black);//
		g.drawString("String1" , 150, 200);
		g.drawString("String2" , 250, 200);
	}
	
	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setX(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setY(int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getAlpha() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAlpha(float f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unhoverAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hoverAction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRound(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSequenceSize(int x) {
		// TODO Auto-generated method stub

	}

}
