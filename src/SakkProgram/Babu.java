package SakkProgram;

import javafx.scene.image.ImageView;

public abstract class Babu extends ImageView implements Lepo {
	public boolean akarLepni = false;
	
	// false = fekete; true = fehér
	public boolean szin;
	
	public String tipus;
	public boolean leutve = false;

//	public abstract boolean lepes(double babuX, double babuY, double rectX, double rectY);
}
