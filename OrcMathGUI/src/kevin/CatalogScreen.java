package kevin;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {
	
	private TextField titleField;
	private Button addButton;

	public CatalogScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		titleField = new TextField(40, 40, 200, 30, "Text goes here", "Title");
		viewObjects.add(titleField);
		
		addButton = new Button(100, 100, 100, 100, "Add", new Action() {
			
			@Override
			public void act() {
				titleField.setText("You clicked the button");
			}
		});
	}

	
}
