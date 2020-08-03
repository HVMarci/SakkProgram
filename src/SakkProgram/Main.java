package SakkProgram;

import javafx.application.Application;
import SakkProgram.BabuKlikk;
import static javafx.application.Application.launch;

import java.io.FileNotFoundException;
import java.util.Map;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	
	static Rectangle[] rect;
	static Map pieces;
	static Babu[] feherTisztArray;
	static Babu[] feherGyalogArray;
	static Babu[] feketeTisztArray;
	static Babu[] feketeGyalogArray;
	static Babu lepoBabu;
	static Text myLog;
	static Group root;
	static double leutesX = 0;
	static double leutesY = 8*40;
	static Double enPassantX;
	static Double enPassantY;
	static Babu enPassantBabu;
	
	@Override
	public void start(Stage stage) throws FileNotFoundException {

		rect = new Rectangle[64];
		boolean szin = false;
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				int pos = x * 8 + y;
				rect[pos] = new Rectangle();
				rect[pos].setX(x * 40);
				rect[pos].setY(y * 40);
				rect[pos].setWidth(40);
				rect[pos].setHeight(40);
				if (szin) {
					rect[pos].setFill(Color.BROWN);
					szin = false;
				} else {
					rect[pos].setFill(Color.ALICEBLUE);
					szin = true;
				}
				rect[pos].setOnMouseClicked(new TablaKlikk());
			}
			szin = szin ? false : true;
		}
		
		myLog = new Text();
		myLog.setFill(Color.BLACK);
		myLog.setCursor(Cursor.CROSSHAIR);
		myLog.setX(10);
		myLog.setY(360);
		myLog.setFont(new Font(40));
		
		pieces = ChessPieceDeclarations.getChessPieces();
		Babu[] feherTisztek = (Babu[]) pieces.get("feherTisztek");
		Babu[] feherGyalogok = (Babu[]) pieces.get("feherGyalogok");
		Babu[] feketeTisztek = (Babu[]) pieces.get("feketeTisztek");
		Babu[] feketeGyalogok = (Babu[]) pieces.get("feketeGyalogok");

		//System.out.println(feherTisztek.length);
		
		feherTisztArray = new Babu[feherTisztek.length];
		for (int i = 0; i < feherTisztArray.length; i++) {
			feherTisztArray[i] = feherTisztek[i];
			//System.out.println(imageViewArray[i]);
			//babuArray[i].setImage(feherTisztek[i]);
			feherTisztArray[i].setX(40 * i);
			feherTisztArray[i].setY(7*40);
			feherTisztArray[i].setOnMouseClicked(new BabuKlikk());
			feherTisztArray[i].setFitHeight(40);
			feherTisztArray[i].setFitWidth(40);
		}
		
		feherGyalogArray = new Babu[feherGyalogok.length];
		for (int i = 0; i < feherGyalogArray.length; i++) {
			feherGyalogArray[i] = feherGyalogok[i];
			//System.out.println(feherGyalogArray[i].getImage());
			//babuArray[i].setImage(feherTisztek[i]);
			feherGyalogArray[i].setX(40 * i);
			feherGyalogArray[i].setY(6*40);
			feherGyalogArray[i].setOnMouseClicked(new BabuKlikk());
			feherGyalogArray[i].setFitHeight(40);
			feherGyalogArray[i].setFitWidth(40);
		}
		
		feketeTisztArray = new Babu[feketeTisztek.length];
		for (int i = 0; i < feketeTisztArray.length; i++) {
			feketeTisztArray[i] = feketeTisztek[i];
			//System.out.println(imageViewArray[i]);
			//babuArray[i].setImage(feherTisztek[i]);
			feketeTisztArray[i].setX(40 * i);
			feketeTisztArray[i].setY(0*40);
			feketeTisztArray[i].setOnMouseClicked(new BabuKlikk());
			feketeTisztArray[i].setFitHeight(40);
			feketeTisztArray[i].setFitWidth(40);
		}
		
		feketeGyalogArray = new Babu[feketeGyalogok.length];
		for (int i = 0; i < feketeGyalogArray.length; i++) {
			feketeGyalogArray[i] = feketeGyalogok[i];
			//System.out.println(feketeGyalogArray[i].getImage());
			//babuArray[i].setImage(feherTisztek[i]);
			feketeGyalogArray[i].setX(40 * i);
			feketeGyalogArray[i].setY(1*40);
			feketeGyalogArray[i].setOnMouseClicked(new BabuKlikk());
			feketeGyalogArray[i].setFitHeight(40);
			feketeGyalogArray[i].setFitWidth(40);
		}

		// Ha nincs kikommentelve és rákattintunk, akkor hibára fut, mert nem tudja a
		// Rectangle-t ImageView-vá castolni
		//rect[9].addEventFilter(MouseEvent.MOUSE_CLICKED, MyEventHandler.babuKlikk);

		root = new Group();

		root.getChildren().addAll(rect);
		root.getChildren().addAll(feherTisztArray);
		root.getChildren().addAll(feherGyalogArray);
		root.getChildren().addAll(feketeTisztArray);
		root.getChildren().addAll(feketeGyalogArray);
		root.getChildren().add(myLog);
		Scene scene = new Scene(root, 400, 400);

		//scene.setFill(Color.LAVENDER);

		stage.setTitle("Sakktábla");

		stage.setScene(scene);

		stage.show();
	}

	public static void main(String args[]) {
		launch(args);

		// command generator
//	  String[] betuk = {"a", "b", "c", "d", "e", "f", "g", "h"};
//	  for (int i = 0; i < 9; i++) {
//		  for (int j = 8; j>0; j--) {
//		  	System.out.println(betuk[i] +j);
//		  }
//	  }
	}
}