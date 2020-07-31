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
		
		if (Main.lepoBabu == null || Main.lepoBabu.szin == babu.szin) {
			babu.akarLepni = true;
			Main.lepoBabu = babu;
		} else if(Main.lepoBabu.lepes(Main.lepoBabu.getX(), Main.lepoBabu.getY(), babu.getX(), babu.getY())) {
			// ütés
			Main.lepoBabu.setX(x);
			Main.lepoBabu.setY(y);
			Main.lepoBabu = null;
			if(Main.leutesX > 7*40) {
				Main.leutesX = 0;
				Main.leutesY += 40;
			}
			babu.setX(Main.leutesX);
			babu.setY(Main.leutesY);
			Main.leutesX += 40;
		} else {
			Main.myLog.setText("Rossz lépés!");
		}
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
