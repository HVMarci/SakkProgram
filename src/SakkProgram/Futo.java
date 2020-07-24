package SakkProgram;

public class Futo extends Babu {
	public boolean lepes(double babuX, double babuY, double rectX, double rectY) {
		if (Math.abs(babuX - rectX) == Math.abs(babuY - rectY)) {
			return true;
		} else {
			return false;
		}
	}
}
