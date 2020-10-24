package SakkProgram;

public class Gyalog extends Babu {

	public Gyalog() {
		this.tipus = "gyalog";
	}

	public boolean lepes(double babuX, double babuY, double rectX, double rectY, boolean utes) {
		double negyven = 20;
		double feherKettoNegyven;
		double sotetKettoNegyven;
		if(Main.fentVanASotet) {
			negyven = 40;
			feherKettoNegyven = 240;
			sotetKettoNegyven = 40;
		} else {
			negyven = -40;
			feherKettoNegyven = 40;
			sotetKettoNegyven = 240;
		}
		if (!utes) {
			if (Main.enPassantX != null) {
				if (this.szin) {
					if (((babuX + 40 == rectX) || (babuX - 40 == rectX)) && (babuY - negyven == rectY)
							&& (Main.enPassantX == rectX && Main.enPassantY - negyven == rectY)) {
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
					if (((babuX + 40 == rectX) || (babuX - 40 == rectX)) && (babuY + negyven == rectY)
							&& (Main.enPassantX == rectX && Main.enPassantY + negyven == rectY)) {
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
				if (babuY == feherKettoNegyven) {
					System.out.println(rectY - (2 * negyven) +""+babuY);
					if ((babuX == rectX && rectY + (2 * negyven) == babuY) || (babuX == rectX && rectY + (1 * negyven) == babuY)) {
						Main.enPassantX = rectX;
						Main.enPassantY = rectY;
						Main.enPassantBabu = this;
						return true;
					} else {
						return false;
					}
				} else {
					if (babuX == rectX && rectY + (1 * negyven) == babuY) {
						Main.enPassantX = null;
						Main.enPassantY = null;
						return true;
					} else {
						return false;
					}
				}
			} else {
				if (babuY == sotetKettoNegyven) {
					System.out.println(rectY - (2 * negyven) +""+babuY);
					if ((babuX == rectX && rectY - (1 * negyven) == babuY) || (babuX == rectX && rectY - (2 * negyven) == babuY)) {
						Main.enPassantX = rectX;
						Main.enPassantY = rectY;
						Main.enPassantBabu = this;
						return true;
					} else {
						return false;
					}
				} else {
					if (babuX == rectX && rectY - (1 * negyven) == babuY) {
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
				if (((babuX + 40 == rectX) || (babuX - 40 == rectX)) && (babuY - negyven == rectY)) {
					Main.enPassantX = null;
					Main.enPassantY = null;
					return true;
				} else {
					return false;
				}
			} else {
				if (((babuX + 40 == rectX) || (babuX - 40 == rectX)) && (babuY + negyven == rectY)) {
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
