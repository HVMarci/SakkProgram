package SakkProgram;

import java.io.FileNotFoundException;
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
		LepesMethods lepesMethods = new LepesMethods();
		lepesMethods.lepes(null, rect);

		/*Babu[] babuk = new Babu[32];
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

		
		if(Main.lepoBabu == null) {
			for (int i = 0; i < babuk.length; i++) {
				
//				System.out.println(babuk[i].getX() + " " + rect.getX());
//				System.out.println(babuk[i].getX() == rect.getX() && babuk[i].getY() == rect.getY());
				
				if(babuk[i].getX() == rect.getX() && babuk[i].getY() == rect.getY()) {
					if (babuk[i].szin == Main.lepoSzin) {
						Main.lepoBabu = babuk[i];
						Main.lepoBabuJelolo1.valtoztatas(babuk[i].getX(), babuk[i].getY());						
					} else {
						Main.myLog.setText("Rossz sz�n!");
					}
				}
				
			}
		} else {
			
			boolean mehet = true;
			boolean utes = false;
			int babukHossza;
			int babukKezdes;
			int babukKezdes2;
			int babukHossza2;
			Babu utni = null;
			
			
			if (Main.lepoBabu.szin) {
				babukKezdes = 0;
				babukHossza = 16;
				babukKezdes2 = 16;
				babukHossza2 = 32;
			} else {
				babukKezdes = 16;
				babukHossza = 32;
				babukKezdes2 = 0;
				babukHossza2 = 16;
			}
			
			for (int i = babukKezdes; i < babukHossza; i++) {
//				System.out.println(babuk[i].getX() == rect.getX() && babuk[i].getY() == rect.getY());
//				System.out.println(babuk[i].getX() + " " + rect.getX());
//				System.out.println(babuk[i].getX() == rect.getX() && babuk[i].getY() == rect.getY());
				if(babuk[i].getX() == rect.getX() && babuk[i].getY() == rect.getY()) {
					Main.lepoBabu = babuk[i];
					Main.lepoBabuJelolo1.valtoztatas(babuk[i].getX(), babuk[i].getY());
					mehet = false;
				}
			}
			
			for (int i = babukKezdes2; i < babukHossza2; i++) {
				if(babuk[i].getX() == rect.getX() && babuk[i].getY() == rect.getY()) {
					utni = babuk[i];
					utes = true;
				}
			}
			
			if(mehet) {
//				System.out.println(Main.lepoBabu);
//				System.out.println(rect);

				if (Main.lepoBabu.lepes(Main.lepoBabu.getX(), Main.lepoBabu.getY(), rect.getX(), rect.getY(), utes)) {
					if (!utes) {
						Main.lepoBabu.setX(rect.getX());
						Main.lepoBabu.setY(rect.getY());
						Main.lepoBabuJelolo2.valtoztatas(rect.getX(), rect.getY());
						Main.lepoBabu = null;
						Main.myLog.setText("");
						try {
							MutatoBabu.valtoztatas(Main.mutatoBabu);
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					} else {
						if (utni.tipus == "kiraly") {
							Main.myLog.setText("Kir�lyt nem �t�nk!");
						} else {
							utni.setX(Main.leutesX);
							utni.setY(Main.leutesY);
							Main.leutesX += 40;
							if(Main.leutesX > 7*40) {
								Main.leutesX = 0;
								Main.leutesY += 40;
							}
							Main.lepoBabu.setX(rect.getX());
							Main.lepoBabu.setY(rect.getY());
							Main.lepoBabuJelolo2.valtoztatas(rect.getX(), rect.getY());
							Main.lepoBabu = null;
							Main.myLog.setText("");
							try {
								MutatoBabu.valtoztatas(Main.mutatoBabu);
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
						}
					}
				} else {
					Main.myLog.setText("Rossz l�p�s!");
				}
			}
		}*/
	}

}
