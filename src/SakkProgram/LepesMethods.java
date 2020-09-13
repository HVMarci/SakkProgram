package SakkProgram;

import java.io.FileNotFoundException;

import javafx.scene.shape.Rectangle;

public class LepesMethods {
	
	public void utesHelyrerakas(Babu babu) {
		
		if (Main.leutesX > 7 * 40) {
			Main.leutesX = 0;
			Main.leutesY += 40;
		}
		babu.leutve = true;
		babu.setX(Main.leutesX);
		babu.setY(Main.leutesY);
		Main.leutesX += 40;
		
	}
	
	public boolean lepes(Babu babu, Rectangle rect) {
		
		if (babu == null && rect == null) {
			System.out.println("babu �s rect == null");
			return false;
		} else if (babu != null && rect != null) {
			System.out.println("babu �s rect != null");
			return false;
		}
		
		if (babu != null) {
			double x = babu.getX();
			double y = babu.getY();
			
			System.out.println("babu != null");
			
			if (babu.leutve) {
				Main.myLog.setText("Ez a b�bu le van �tve!");
				System.out.println("�t�tt b�bu");
				return false;
			}
			
			if (Main.lepoSzin != babu.szin && Main.lepoBabu == null) {
				System.out.println("rossz sz�n");
				Main.myLog.setText("Rossz sz�n!");
				return false;
			}
			
			if (babu.szin == Main.lepoSzin) {
				Main.myLog.setText("");
				Main.lepoBabu = babu;
				Main.lepoBabuJelolo1.valtoztatas(babu.getX(), babu.getY());
				System.out.println("L�p�b�bu csere");
				return true;
			}
			
			if (babu.tipus == "kiraly") {
				System.out.println("kir�lyt nem �t�nk");
				return false;
			}
			
			if (Main.lepoBabu.lepes(Main.lepoBabu.getX(), Main.lepoBabu.getY(), x, y, true)) {
				System.out.println("�t�s");
				Main.myLog.setText("");
				Main.lepoBabu.setX(x);
				Main.lepoBabu.setY(y);
				Main.lepoBabuJelolo2.valtoztatas(x, y);
				Main.lepoBabu = null;
				utesHelyrerakas(babu);
				try {
					MutatoBabu.valtoztatas(Main.mutatoBabu);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				return true;

			}
		}
		
		if(rect != null) {
			
			Babu mezonLevoBabu = null;
			Babu[] babuk = new Babu[32];
			
			// felt�lt�m a babuk t�mb�t
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
			
			// megn�zem, hogy ki �ll a mez�n
			for (int i = 0; i < babuk.length; i++) {

				if(babuk[i].getX() == rect.getX() && babuk[i].getY() == rect.getY()) {
					mezonLevoBabu = babuk[i];
					break;
					
				}
			}
			if (mezonLevoBabu != null) {
			
				if(Main.lepoSzin == mezonLevoBabu.szin) {
					Main.lepoBabu = mezonLevoBabu;
					Main.lepoBabuJelolo1.valtoztatas(rect.getX(), rect.getY());
					System.out.println("Main.lepoBabu �t�ll�tva!");
					Main.myLog.setText("");
					return true;
				} else if (Main.lepoBabu != null) {
					if (mezonLevoBabu.tipus == "kiraly") {
						System.out.println("kir�lyt nem �t�nk");
						return false;
					}
					if (Main.lepoBabu.lepes(Main.lepoBabu.getX(), Main.lepoBabu.getY(), rect.getX(), rect.getY(), true)) {
						System.out.println("�t�s");
						Main.myLog.setText("");
						Main.lepoBabu.setX(rect.getX());
						Main.lepoBabu.setY(rect.getY());
						Main.lepoBabuJelolo2.valtoztatas(rect.getX(), rect.getY());
						Main.lepoBabu = null;
						utesHelyrerakas(mezonLevoBabu);
						try {
							MutatoBabu.valtoztatas(Main.mutatoBabu);
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
						return true;
					} else {
						Main.myLog.setText("Rossz l�p�s!");
						System.out.println("Rossz l�p�s!");
						return false;
					}
				} else {
					Main.myLog.setText("Rossz sz�n!");
					System.out.println("Rossz sz�n!");
					return false;
				}
			} else {
				if(Main.lepoBabu == null) {
					System.out.println("Semmi");
					return false;
				}
				if (Main.lepoBabu.lepes(Main.lepoBabu.getX(), Main.lepoBabu.getY(), rect.getX(), rect.getY(), false)) {
					System.out.println("l�p�s");
					Main.myLog.setText("");
					Main.lepoBabu.setX(rect.getX());
					Main.lepoBabu.setY(rect.getY());
					Main.lepoBabuJelolo2.valtoztatas(rect.getX(), rect.getY());
					Main.lepoBabu = null;
					try {
						MutatoBabu.valtoztatas(Main.mutatoBabu);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					return true;
				}
			}
		}
		
		System.out.println("vmi baj van");
		return false;
		
		
	}
}
