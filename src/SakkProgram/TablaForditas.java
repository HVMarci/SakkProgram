package SakkProgram;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class TablaForditas implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent arg0) {
		Babu[] babuk = new Babu[32];
		for (int i = 0; i < babuk.length; i++) {
			if(i < 8) {
				babuk[i] = Main.feherTisztArray[i];
			} else if (i < 16) {
				babuk[i] = Main.feherGyalogArray[i-8];
			} else if (i < 24) {
				babuk[i] = Main.feketeTisztArray[i-16];
			} else {
				babuk[i] = Main.feketeGyalogArray[i-24];
			}
		}
		for(int i = 0; i < babuk.length; i++) {
			babuk[i].setX(280-babuk[i].getX());
			babuk[i].setY(280-babuk[i].getY());
		}
		Main.lepoBabuJelolo1.setX(280-Main.lepoBabuJelolo1.getX());
		Main.lepoBabuJelolo1.setY(280-Main.lepoBabuJelolo1.getY());
		Main.lepoBabuJelolo2.setX(280-Main.lepoBabuJelolo2.getX());
		Main.lepoBabuJelolo2.setY(280-Main.lepoBabuJelolo2.getY());
		if(Main.enPassantX != null) {
			Main.enPassantX = 280-Main.enPassantX;
			Main.enPassantY = 280-Main.enPassantY;
		}
		//System.out.println(Main.enPassantX + "" + Main.enPassantY);
		
		Main.fentVanASotet = Main.fentVanASotet ? false : true;
	}

}
