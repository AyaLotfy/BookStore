package button;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public abstract class button {
	protected Button b;
	protected ImageView image;

	public button() {
		createButton();
		setName();
		setAction();
		setStyle();
	}

	public Button getButton() {
		return b;
	}

	private void createButton() {
		b = new Button();
	}

	protected void setStyle() {
		image.setFitHeight(75);
		image.setFitWidth(200);
		b.getStyleClass().add("button");
	}

	public abstract void setName();

	public abstract void setAction();
}
