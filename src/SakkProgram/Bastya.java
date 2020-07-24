package SakkProgram;

public class Bastya extends Babu {
	
	public boolean lepes(double babuX, double babuY, double rectX, double rectY) {
		if (babuX == rectX || babuY == rectY) {
			return true;
		} else {
			return false;
		}
	}
}
