package SakkProgram;

public class Gyalog extends Babu {

	public Gyalog() {
		this.tipus = "gyalog";
	}

	public boolean lepes(double babuX, double babuY, double rectX, double rectY, boolean utes) {
		if (!utes) {
			if (Main.enPassantX != null) {
				if (this.szin) {
					if (((babuX + 40 == rectX) || (babuX - 40 == rectX)) && (babuY - 40 == rectY)
							&& (Main.enPassantX == rectX && Main.enPassantY - 40 == rectY)) {
						Main.enPassantX = null;
						Main.enPassantY = null;
						Main.enPassantBabu.setX(Main.leutesX);
						Main.enPassantBabu.setY(Main.leutesY);
						Main.leutesX += 40;
						if(Main.leutesX > 7*40) {
							Main.leutesX = 0;
							Main.leutesY += 40;
						}
						Main.enPassantBabu.leutve = true;
						return true;
					}
				} else {
					if (((babuX + 40 == rectX) || (babuX - 40 == rectX)) && (babuY + 40 == rectY)
							&& (Main.enPassantX == rectX && Main.enPassantY + 40 == rectY)) {
						Main.enPassantX = null;
						Main.enPassantY = null;
						Main.enPassantBabu.setX(Main.leutesX);
						Main.enPassantBabu.setY(Main.leutesY);
						Main.leutesX += 40;
						if(Main.leutesX > 7*40) {
							Main.leutesX = 0;
							Main.leutesY += 40;
						}
						Main.enPassantBabu.leutve = true;
						return true;
					}
				}
			}
			if (this.szin) {
				if (babuY == 240) {
					if (babuX == rectX && rectY < babuY && rectY + (3 * 40) > babuY) {
						// System.out.println(true);
						Main.enPassantX = rectX;
						Main.enPassantY = rectY;
						Main.enPassantBabu = this;
						return true;
					} else {
						// System.out.println(babuX == rectX);
						// System.out.println(rectY < babuY);
						return false;
					}
				} else {
					if (babuX == rectX && rectY < babuY && rectY + (2 * 40) > babuY) {
						Main.enPassantX = null;
						Main.enPassantY = null;
						return true;
					} else {
						return false;
					}
				}
			} else {
				if (babuY == 40) {
					if (babuX == rectX && rectY > babuY && rectY - (3 * 40) < babuY) {
						Main.enPassantX = rectX;
						Main.enPassantY = rectY;
						Main.enPassantBabu = this;
						return true;
					} else {
						return false;
					}
				} else {
					if (babuX == rectX && rectY > babuY && rectY - (2 * 40) < babuY) {
						Main.enPassantX = null;
						Main.enPassantY = null;
						return true;
					} else {
						return false;
					}
				}
			}
		} else {
			if (this.szin) {
				if (((babuX + 40 == rectX) || (babuX - 40 == rectX)) && (babuY - 40 == rectY)) {
					Main.enPassantX = null;
					Main.enPassantY = null;
					return true;
				} else {
					return false;
				}
			} else {
				if (((babuX + 40 == rectX) || (babuX - 40 == rectX)) && (babuY + 40 == rectY)) {
					Main.enPassantX = null;
					Main.enPassantY = null;
					return true;
				} else {
					return false;
				}
			}
		}
	}
}
