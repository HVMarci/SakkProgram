package SakkProgram;

public class Futo extends Babu {
	
	public Futo() {
		this.tipus = "futo";
	}
	
	public boolean lepes(double babuX, double babuY, double rectX, double rectY, boolean utes) {
		if (Math.abs(babuX - rectX) == Math.abs(babuY - rectY)) {
			Main.enPassantX = null;
			Main.enPassantY = null;
			return true;
		} else {
			return false;
		}
	}
}
