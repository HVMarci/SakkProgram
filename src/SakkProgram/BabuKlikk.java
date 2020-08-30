package SakkProgram;

import java.awt.event.MouseListener;
import java.io.FileNotFoundException;

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
		//if (Main.lepoBabu == null || Main.lepoBabu.szin == Main.lepoSzin) {
			if (babu.leutve) {
				Main.myLog.setText("Ez a bábu le van ütve!");
			} else if (Main.lepoBabu == null || Main.lepoBabu.szin == babu.szin) {
				if (babu.szin == Main.lepoSzin) {
					babu.akarLepni = true;
					Main.lepoBabu = babu;
					Main.lepoBabuJelolo1.valtoztatas(babu.getX(), babu.getY());
				} else {
					Main.myLog.setText("Rossz szín!");
				}
			} else if (Main.lepoBabu.lepes(Main.lepoBabu.getX(), Main.lepoBabu.getY(), babu.getX(), babu.getY(), true)) {
				// ütés
				if (babu.tipus == "kiraly") {
					Main.myLog.setText("Királyt nem ütünk!");
				} else {
					Main.lepoBabu.setX(x);
					Main.lepoBabu.setY(y);
					Main.lepoBabuJelolo2.valtoztatas(x, y);
					Main.lepoBabu = null;
					if (Main.leutesX > 7 * 40) {
						Main.leutesX = 0;
						Main.leutesY += 40;
					}
					babu.setX(Main.leutesX);
					babu.setY(Main.leutesY);
					babu.leutve = true;
					Main.leutesX += 40;
					Main.myLog.setText("");
					try {
						MutatoBabu.valtoztatas(Main.mutatoBabu);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			} else {
				Main.myLog.setText("Rossz lépés!");
			}
			/*
			 * if(e.getButton() == MouseButton.PRIMARY) { babu.setX(x+40); }
			 * 
			 * if(e.getButton() == MouseButton.SECONDARY) { babu.setY(y+40); }
			 * 
			 * if(e.getButton() == MouseButton.MIDDLE) { babu.setX(x-40); babu.setY(y-40); }
			 */
		//}
	}
}
