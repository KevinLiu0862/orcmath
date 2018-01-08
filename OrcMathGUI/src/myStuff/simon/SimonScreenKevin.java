package myStuff.simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenKevin extends ClickableScreen implements Runnable {

	public ProgressInterfaceKevin progressInt;
	public ButtonInterfaceKevin[] buttonInt;
	public Color[] colorArr;
	private ArrayList<MoveInterfaceKevin> sequence;
	private TextArea textBox;
	public int roundNumber; 
	private int numTracker; //for roundNumber
	
	private int sequenceIndex;
	private int lastSelected;
	private int numButton;
	private boolean acceptUser;
	private SimonScreenKevin screen;
	
	public SimonScreenKevin(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		 textBox.setText("");
		 nextRound();
	}

	private void nextRound() {
		acceptUser = false;
		roundNumber++;
		sequence.add(randomMove());
		ProgressInterfaceKevin.setRound(roundNumber);
		ProgressInterfaceKevin.setSequenceSize(sequence.size());
		changeText("Simon's turn.");
		textBox.setText("");
		playSequence();
		changeText("Your turn.");
		acceptUser = true;
		sequenceIndex = 0;
	}
	private void playSequence() {
		final ButtonInterfaceKevin b = getAButton();
		for(int i = 0; i<sequence.size(); i++)
		{
			if(b != null)
			{
				b.dim();
			}
				
			int sleepTime = roundNumber*3;
			Thread sleepT = new Thread(new Runnable(){

				public void run()
				{
					b.highlight();
					try 
					{
						Thread.sleep(sleepTime);
					} 
					catch (InterruptedException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					b.dim();
				}
						
				});
			sleepT.start();
		}
			
	}

	private void changeText(String x)
	{
		Thread text = new Thread(new Runnable(){

			public void run()
			{
				textBox.setText(x);
				try 
				{
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				
			});
		text.start();
	}
	

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(Color.black);
		textBox.setCustomTextColor(Color.white);
		addButtons();
		run();
		for(ButtonInterfaceKevin j: buttonInt)
		{ 
		    viewObjects.add(j); 
		}
		progressInt = getProgress();
		textBox = new TextArea(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceKevin>();
		//add 2 moves to start
		lastSelected = -1;
		progressInt.add(randomMove());
		progressInt.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progressInt);
		viewObjects.add(textBox);

	}

	private MoveInterfaceKevin randomMove() {
		  int index = (int)(Math.random()*buttonInt.length);
		    while(index == lastSelected){
		        index = (int)(Math.random()*buttonInt.length);
		    }
		    return getMove(index);
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private MoveInterfaceKevin getMove(int bIndex) {
		return sequence.get(bIndex);
	}
	
	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/

	/* 	
	9. Look at the next few lines of code and understand what they do: create a label, 
	initialize the ArrayList (I called mine "sequence", you will have to change yours to 
	reflect the name of your ArrayList<MoveInterfaceX> field.) and set lastSelectedButton to -1 
	(since no buttons have been selected yet.) The next line adds instances of MoveInterfaceX to
	 the ArrayList (again, change the name of sequence, if necessary) 
	 but calls a method named randomMove(). 
	Create this method now. You will write this method next.
	*/		
			
	private ProgressInterfaceKevin getProgress() {
		
		return null;
	}

	private void addButtons() {
		ButtonInterfaceKevin[] buttonInt = new ButtonInterfaceKevin[6];
		numButton = 6;
		Color[] colorArr = new Color[6];
		colorArr[1] = Color.blue;
		colorArr[2] = Color.magenta;
		colorArr[3] = Color.pink;
		colorArr[4] = Color.red;
		colorArr[5] = Color.orange;
		colorArr[6] = Color.yellow;
		for(int i =0; i<buttonInt.length; i--)
		{
			final ButtonInterfaceKevin b = getAButton();
			buttonInt[i] = b;
			b.setColor(colorArr[i]);
			b.setX(i*30);
			b.setY(i*25);
			
		
			b.setAction(new Action(){

				public void act()
				{
					if(acceptUser)
					{
						Thread blinkButton = new Thread(new Runnable(){

							public void run()
							{
								b.highlight();
								try 
								{
									Thread.sleep(800);
								} 
								catch (InterruptedException e) 
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								b.dim();
							}
								
							});
						blinkButton.start();
					}
				}

				});
			
			if (b == sequence.get(sequenceIndex).getAButton()) //change
			{
				sequenceIndex++;
				if(sequenceIndex == sequence.size()){ 
				    Thread nextRound = new Thread(SimonScreenKevin.this); 
				    nextRound.start(); 
				}
			}
			else
			{
				ProgressInterfaceKevin.gameOver();
			}
			
			
		}
		
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/

	private ButtonInterfaceKevin getAButton() {
		// TODO Auto-generated method stub
		return null;
	}
}
