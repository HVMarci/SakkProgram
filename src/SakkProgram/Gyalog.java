package SakkProgram;

public class Gyalog extends Babu {
	
	public Gyalog() {
		this.tipus = "gyalog";
	}
	public boolean lepes(double babuX, double babuY, double rectX, double rectY) {

		if (this.szin) {
			if(babuY == 240) {
				if (babuX == rectX && rectY < babuY && rectY+(3*40) > babuY) {
		//			System.out.println(true);
					return true;
				} else {
		//			System.out.println(babuX == rectX);
		//			System.out.println(rectY < babuY);
					return false;
				}
			} else {
				if (babuX == rectX && rectY < babuY && rectY+(2*40) > babuY) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			if(babuY == 40) {
				if (babuX == rectX && rectY > babuY && rectY-(3*40) < babuY) {
					return true;
				} else {
					return false;
				}
			} else {
				if (babuX == rectX && rectY > babuY && rectY-(2*40) < babuY) {
					return true;
				} else {
					return false;
				}
			}
		}
		
	}
}