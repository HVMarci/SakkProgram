package SakkProgram;

public class Kiraly extends Babu{
	
	public Kiraly() {
		this.tipus = "kiraly";
	}
	public boolean lepes(double babuX, double babuY, double rectX, double rectY, boolean utes) {
		
		if (babuX - 40 <= rectX && babuX + 40 >= rectX && babuY - 40 <= rectY && babuY + 40 >= rectY) {
			Main.enPassantX = null;
			Main.enPassantY = null;
			return true;
		} else {
			return false;
		}

	}
}
