package SakkProgram;

public class Bastya extends Babu {
	
	public Bastya() {
		this.tipus = "bastya";
	}
	public boolean lepes(double babuX, double babuY, double rectX, double rectY, boolean utes) {
		if (babuX == rectX || babuY == rectY) {
			Main.enPassantX = null;
			Main.enPassantY = null;
			return true;
		} else {
			return false;
		}
	}
}
