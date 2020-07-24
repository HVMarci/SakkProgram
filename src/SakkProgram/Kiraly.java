package SakkProgram;

public class Kiraly extends Babu{
	public boolean lepes(double babuX, double babuY, double rectX, double rectY) {
		
		if (babuX - 40 <= rectX && babuX + 40 >= rectX && babuY - 40 <= rectY && babuY + 40 >= rectY) {
			return true;
		} else {
			return false;
		}

	}
}
