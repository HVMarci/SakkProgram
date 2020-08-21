package SakkProgram;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LepoBabuJelolo extends Rectangle {
	public LepoBabuJelolo() {
		this.setFill(Color.PURPLE);
		this.setWidth(40);
		this.setHeight(40);
		this.setX(-40);
	}
	
	public void valtoztatas(double celX, double celY) {
		this.setX(celX);
		this.setY(celY);
	}
}
