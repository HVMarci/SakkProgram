package SakkProgram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MutatoBabu extends ImageView {
	public boolean szin;
	public MutatoBabu() throws FileNotFoundException {
		this.szin = true;
		String projRoot = System.getenv("projectRoot");
		this.setImage(new Image(new FileInputStream(projRoot + "\\ChessPieces\\WhitePawn.png")));
	}
	public static void valtoztatas(MutatoBabu e) throws FileNotFoundException {
		e.szin = e.szin ? false : true;
		Main.lepoSzin = Main.lepoSzin ? false : true;
		String projRoot = System.getenv("projectRoot");
		if (e.szin) {
			e.setImage(new Image(new FileInputStream(projRoot + "\\ChessPieces\\WhitePawn.png")));
		} else {
			e.setImage(new Image(new FileInputStream(projRoot + "\\ChessPieces\\BlackPawn.png")));
		}
	}
}
