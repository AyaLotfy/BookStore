package button;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class RegisterButton extends button {

	@Override
	public void setName() {
		File file = new File("");
		Image img = new Image(file.toURI().toString());
		image = new ImageView(img);
		b.setText("Sign In");
	}

	@Override
	public void setAction() {
		b.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				
				System.out.println("Register button clicked\n");
			}
		});
	}
}
