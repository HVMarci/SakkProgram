package SakkProgram;

import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class BabuKlikk implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent e) {
		Babu babu = (Babu) e.getSource();
		double x = babu.getX();
		double y = babu.getY();
		babu.akarLepni = true;
		Main.lepoBabu = babu;
		/*if(e.getButton() == MouseButton.PRIMARY) {
			babu.setX(x+40);
		}
		
		if(e.getButton() == MouseButton.SECONDARY) {
			babu.setY(y+40);
		}
		
		if(e.getButton() == MouseButton.MIDDLE) {
			babu.setX(x-40);
			babu.setY(y-40);
		}*/
	}
}
