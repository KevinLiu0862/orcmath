package kevin;

import java.awt.Color;
import java.util.List;

import components.Superheroes;
import guiPlayer.CatalogMaker;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField nameField;
	private TextField genderField;
	private TextField colorField;
	private TextField powerField;
	private Button addButton;
	private CatalogMaker catalog;
	private TextArea textArea;

	public CatalogScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		catalog = new CatalogMaker();
		
		nameField = new TextField(40, 40, 200, 30, "Text goes here", "Title");
		viewObjects.add(nameField);
		
		genderField = new TextField(40, 140, 200, 30, "Text goes here", "Title");
		viewObjects.add(genderField);
		
		colorField = new TextField(40, 240, 200, 30, "Text goes here", "Title");
		viewObjects.add(colorField);
		
		powerField = new TextField(40, 340, 200, 30, "Text goes here", "Title");
		viewObjects.add(powerField);
		
		addButton = new Button(50, 440, 50, 50, "Add", new Action() {
			
			@Override
			public void act() {
				addButtonClicked();
			}
		});
		viewObjects.add(addButton);
		
		textArea = new TextArea(500, 40, 300, 300, "Text Area");
		viewObjects.add(textArea);
	}

	protected void addButtonClicked() {
		
		Superheroes sh = new Superheroes(nameField.getText(), genderField.getText(), colorField.getText(), powerField.getText());
		String s = textArea.getText() + sh + "\n";
		catalog.addNewHero(nameField.getText(), genderField.getText(), colorField.getText(), powerField.getText());
		
		nameField.setText(" ");
		genderField.setText(" ");
		colorField.setText(" ");
		powerField.setText(" ");
		
		// nameField.setInputType(TextField.INPUT_TYPE_NUMERIC);
			// This makes only numeric entries available
	}

}
