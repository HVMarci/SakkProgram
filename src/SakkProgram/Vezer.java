package SakkProgram;

public class Vezer extends Babu {
	
	public Vezer() {
		this.tipus = "vezer";
	}
	
	public boolean lepes(double babuX, double babuY, double rectX, double rectY, boolean utes) {
		if (Math.abs(babuX - rectX) == Math.abs(babuY - rectY) || babuX == rectX || babuY == rectY) {
			return true;
		} else {
			return false;
		}
	}
}
