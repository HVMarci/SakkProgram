package SakkProgram;

import java.util.concurrent.TimeUnit;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class TablaKlikk implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent e) {
		
		Rectangle rect = (Rectangle) e.getSource();
		Babu[] babuk = new Babu[16];
		for (int i = 0; i < babuk.length; i++) {
			if(i < 8) {
				babuk[i] = Main.feherTisztArray[i];
			} else {
				babuk[i] = Main.feherGyalogArray[i-8];
			}

		}

		
		if(Main.lepoBabu == null) {
			for (int i = 0; i < babuk.length; i++) {
				
//				System.out.println(babuk[i].getX() + " " + rect.getX());
//				System.out.println(babuk[i].getX() == rect.getX() && babuk[i].getY() == rect.getY());
				
				if(babuk[i].getX() == rect.getX() && babuk[i].getY() == rect.getY()) {
					Main.lepoBabu = babuk[i];
				}
				
			}
		} else {
			boolean mehet = true;
			for (int i = 0; i < babuk.length; i++) {
//				System.out.println(babuk[i].getX() == rect.getX() && babuk[i].getY() == rect.getY());
//				System.out.println(babuk[i].getX() + " " + rect.getX());
//				System.out.println(babuk[i].getX() == rect.getX() && babuk[i].getY() == rect.getY());
				if(babuk[i].getX() == rect.getX() && babuk[i].getY() == rect.getY()) {
					Main.lepoBabu = babuk[i];
					mehet = false;
				}
			}
			if(mehet) {
//				System.out.println(Main.lepoBabu);
//				System.out.println(rect);
				if (Main.lepoBabu.lepes(Main.lepoBabu.getX(), Main.lepoBabu.getY(), rect.getX(), rect.getY())) {
					Main.lepoBabu.setX(rect.getX());
					Main.lepoBabu.setY(rect.getY());
					Main.lepoBabu = null;
					Main.myLog.setText("");
				} /*else if(Main.lepoBabu.tipus == "gyalog" && Gyalog.lepes(Main.lepoBabu.getX(), Main.lepoBabu.getY(), rect.getX(), rect.getY())) {
					Main.lepoBabu.setX(rect.getX());
					Main.lepoBabu.setY(rect.getY());
					Main.lepoBabu = null;
					Main.myLog.setText("");
				} else if(Main.lepoBabu.tipus == "bastya" && Bastya.lepes(Main.lepoBabu.getX(), Main.lepoBabu.getY(), rect.getX(), rect.getY())) {
					Main.lepoBabu.setX(rect.getX());
					Main.lepoBabu.setY(rect.getY());
					Main.lepoBabu = null;
					Main.myLog.setText("");
				} else if(Main.lepoBabu.tipus == "futo" && Futo.lepes(Main.lepoBabu.getX(), Main.lepoBabu.getY(), rect.getX(), rect.getY())) {
					Main.lepoBabu.setX(rect.getX());
					Main.lepoBabu.setY(rect.getY());
					Main.lepoBabu = null;
					Main.myLog.setText("");
				} else if(Main.lepoBabu.tipus == "vezer" && Vezer.lepes(Main.lepoBabu.getX(), Main.lepoBabu.getY(), rect.getX(), rect.getY())) {
					Main.lepoBabu.setX(rect.getX());
					Main.lepoBabu.setY(rect.getY());
					Main.lepoBabu = null;
					Main.myLog.setText("");
				} else if(Main.lepoBabu.tipus != "kiraly" && Main.lepoBabu.tipus != "gyalog" && Main.lepoBabu.tipus != "bastya" && Main.lepoBabu.tipus != "futo" && Main.lepoBabu.tipus != "vezer") {
					Main.lepoBabu.setX(rect.getX());
					Main.lepoBabu.setY(rect.getY());
					Main.lepoBabu = null;
					Main.myLog.setText("");
				} */else {
					Main.myLog.setText("Rossz lépés!");
				}
			}
		}
	}

}
