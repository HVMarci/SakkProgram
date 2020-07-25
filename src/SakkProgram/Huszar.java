package SakkProgram;

public class Huszar extends Babu {
	
	public Huszar() {
		this.tipus = "huszar";
	}
	
	public boolean lepes(double babuX, double babuY, double rectX, double rectY) {
		if (((babuX + 40 == rectX || babuX - 40 == rectX) && (babuY + 80 == rectY || babuY - 80 == rectY)) || ((babuX + 80 == rectX || babuX - 80 == rectX) && (babuY + 40 == rectY || babuY - 40 == rectY))) {
			return true;
		} else {
			return false;
		}
	}
}
