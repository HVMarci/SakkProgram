//package SakkProgram;
//
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.InputStream;
//
//import org.apache.batik.transcoder.TranscoderInput;
//import org.apache.batik.transcoder.TranscoderOutput;
//import org.apache.batik.transcoder.TranscodingHints;
//import org.apache.batik.transcoder.image.ImageTranscoder;
//
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.shape.SVGPath;
//
//
//    class ChessPieceDeclarations extends ImageTranscoder {
//        private BufferedImage image = null;
//        public BufferedImage createImage(int w, int h) {
//            image = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//            return image;
//        }
//        public void writeImage(BufferedImage img, TranscoderOutput out) {
//        }
//        public BufferedImage getImage() {
//            return image;
//        }
//        String url = "/SakkProgram/ChessPieces/WhiteKing.svg";
//        
//        ChessPieceDeclarations transcoder = new ChessPieceDeclarations();
//        TranscodingHints hints = new TranscodingHints();
//        hints.put(ImageTranscoder.KEY_WIDTH, 20f); //your image width	
//        hints.put(ImageTranscoder.KEY_HEIGHT, 20f); //your image height
//        hints.put(ImageTranscoder.KEY_DOM_IMPLEMENTATION, SVGDOMImplementation.getDOMImplementation());
//        hints.put(ImageTranscoder.KEY_DOCUMENT_ELEMENT_NAMESPACE_URI, SVGConstants.SVG_NAMESPACE_URI);
//        hints.put(ImageTranscoder.KEY_DOCUMENT_ELEMENT, SVGConstants.SVG_SVG_TAG);
//        hints.put(ImageTranscoder.KEY_XML_PARSER_VALIDATING, false);
//
//        transcoder.setTranscodingHints(hints);
//        TranscoderInput input = new TranscoderInput(url);
//        transcoder.transcode(input, null);
//        BufferedImage bufferedImage = transcoder.getImage();
//        
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//        JPEGImageEncoder imageEncoder = JPEGCodec.createJPEGEncoder(outputStream);
//        imageEncoder.encode(bufferedImage);
//
//        byte[] bytes = outputStream.toByteArray();
//        InputStream inputStream = new ByteArrayInputStream(bytes);
//        
//      //javafx.scene.image.Image
//        Image image1 = new Image(inputStream);
//        //javafx.scene.image.ImageView
//        ImageView imageView = new ImageView();
//        imageView.setImage(image1);
//
//    }
//    
//
////	static String whiteKingPath1 = "M 22.5,11.63 L 22.5,6";
////	static String whiteKingPath2 = "M 20,8 L 25,8";
////	static String whiteKingPath3 = "M 22.5,25 C 22.5,25 27,17.5 25.5,14.5 C 25.5,14.5 24.5,12 22.5,12 C 20.5,12 19.5,14.5 19.5,14.5 C 18,17.5 22.5,25 22.5,25";
////	static String whiteKingPath4 = "M 11.5,37 C 17,40.5 27,40.5 32.5,37 L 32.5,30 C 32.5,30 41.5,25.5 38.5,19.5 C 34.5,13 25,16 22.5,23.5 L 22.5,27 L 22.5,23.5 C 19,16 9.5,13 6.5,19.5 C 3.5,25.5 11.5,29.5 11.5,29.5 L 11.5,37 z ";
////	static String whiteKingPath5 = "M 11.5,30 C 17,27 27,27 32.5,30";
////	static String whiteKingPath6 = "M 11.5,33.5 C 17,30.5 27,30.5 32.5,33.5";
////	static String whiteKingPath7 = "M 11.5,37 C 17,34 27,34 32.5,37";
////	!!WRONG!!static String[] whiteKingPath = {whiteKingPath1,whiteKingPath2,whiteKingPath3,whiteKingPath4,whiteKingPath5,whiteKingPath6,whiteKingPath7};
//

package SakkProgram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

public class ChessPieceDeclarations {
	public static Map getChessPieces() throws FileNotFoundException {
		String projRoot = System.getenv("projectRoot");
		System.out.println(projRoot);
		Image whiteKingImg = new Image(new FileInputStream(projRoot + "\\ChessPieces\\WhiteKing.png"));
		Image whiteQueenImg = new Image(new FileInputStream(projRoot + "\\ChessPieces\\WhiteQueen.png"));
		Image whiteRookImg = new Image(new FileInputStream(projRoot + "\\ChessPieces\\WhiteRook.png"));
		Image whitePawnImg = new Image(new FileInputStream(projRoot + "\\ChessPieces\\WhitePawn.png"));
		Image whiteHorseImg = new Image(new FileInputStream(projRoot + "\\ChessPieces\\WhiteHorse.png"));
		Image whiteBishopImg = new Image(new FileInputStream(projRoot + "\\ChessPieces\\WhiteBishop.png"));
		Image blackKingImg = new Image(new FileInputStream(projRoot + "\\ChessPieces\\BlackKing.png"));
		Image blackRookImg = new Image(new FileInputStream(projRoot + "\\ChessPieces\\BlackRook.png"));
		Image blackBishopImg = new Image(new FileInputStream(projRoot + "\\ChessPieces\\BlackBishop.png"));
		Image blackHorseImg = new Image(new FileInputStream(projRoot + "\\ChessPieces\\BlackHorse.png"));
		Image blackQueenImg = new Image(new FileInputStream(projRoot + "\\ChessPieces\\BlackQueen.png"));
		Image blackPawnImg = new Image(new FileInputStream(projRoot + "\\ChessPieces\\BlackPawn.png"));

		Kiraly whiteKing = new Kiraly();
		whiteKing.setImage(whiteKingImg);
		whiteKing.szin = true;

		Vezer whiteQueen = new Vezer();
		whiteQueen.setImage(whiteQueenImg);
		whiteQueen.szin = true;

		Bastya whiteRook1 = new Bastya();
		whiteRook1.setImage(whiteRookImg);
		whiteRook1.szin = true;

		Bastya whiteRook2 = new Bastya();
		whiteRook2.setImage(whiteRookImg);
		whiteRook2.szin = true;

		Huszar whiteHorse1 = new Huszar();
		whiteHorse1.setImage(whiteHorseImg);
		whiteHorse1.szin = true;

		Huszar whiteHorse2 = new Huszar();
		whiteHorse2.setImage(whiteHorseImg);
		whiteHorse2.szin = true;

		Futo whiteBishop1 = new Futo();
		whiteBishop1.setImage(whiteBishopImg);
		whiteBishop1.szin = true;

		Futo whiteBishop2 = new Futo();
		whiteBishop2.setImage(whiteBishopImg);
		whiteBishop2.szin = true;

		Babu[] feherTisztek = { whiteRook1, whiteHorse1, whiteBishop1, whiteQueen, whiteKing, whiteBishop2, whiteHorse2,
				whiteRook2 };

		Gyalog whitePawn1 = new Gyalog();
		whitePawn1.setImage(whitePawnImg);
		whitePawn1.szin = true;

		Gyalog whitePawn2 = new Gyalog();
		whitePawn2.setImage(whitePawnImg);
		whitePawn2.szin = true;

		Gyalog whitePawn3 = new Gyalog();
		whitePawn3.setImage(whitePawnImg);
		whitePawn3.szin = true;

		Gyalog whitePawn4 = new Gyalog();
		whitePawn4.setImage(whitePawnImg);
		whitePawn4.szin = true;

		Gyalog whitePawn5 = new Gyalog();
		whitePawn5.setImage(whitePawnImg);
		whitePawn5.szin = true;

		Gyalog whitePawn6 = new Gyalog();
		whitePawn6.setImage(whitePawnImg);
		whitePawn6.szin = true;

		Gyalog whitePawn7 = new Gyalog();
		whitePawn7.setImage(whitePawnImg);
		whitePawn7.szin = true;

		Gyalog whitePawn8 = new Gyalog();
		whitePawn8.setImage(whitePawnImg);
		whitePawn8.szin = true;

		Babu[] feherGyalogok = { whitePawn1, whitePawn2, whitePawn3, whitePawn4, whitePawn5, whitePawn6, whitePawn7,
				whitePawn8 };

		Kiraly blackKing = new Kiraly();
		blackKing.setImage(blackKingImg);
		blackKing.szin = false;

		Vezer blackQueen = new Vezer();
		blackQueen.setImage(blackQueenImg);
		blackQueen.szin = false;

		Bastya blackRook1 = new Bastya();
		blackRook1.setImage(blackRookImg);
		blackRook1.szin = false;

		Bastya blackRook2 = new Bastya();
		blackRook2.setImage(blackRookImg);
		blackRook2.szin = false;

		Huszar blackHorse1 = new Huszar();
		blackHorse1.setImage(blackHorseImg);
		blackHorse1.szin = false;

		Huszar blackHorse2 = new Huszar();
		blackHorse2.setImage(blackHorseImg);
		blackHorse2.szin = false;

		Futo blackBishop1 = new Futo();
		blackBishop1.setImage(blackBishopImg);
		blackBishop1.szin = false;

		Futo blackBishop2 = new Futo();
		blackBishop2.setImage(blackBishopImg);
		blackBishop2.szin = false;

		Babu[] feketeTisztek = { blackRook1, blackHorse1, blackBishop1, blackQueen, blackKing, blackBishop2,
				blackHorse2, blackRook2 };

		Gyalog blackPawn1 = new Gyalog();
		blackPawn1.setImage(blackPawnImg);
		blackPawn1.szin = false;

		Gyalog blackPawn2 = new Gyalog();
		blackPawn2.setImage(blackPawnImg);
		blackPawn2.szin = false;

		Gyalog blackPawn3 = new Gyalog();
		blackPawn3.setImage(blackPawnImg);
		blackPawn3.szin = false;

		Gyalog blackPawn4 = new Gyalog();
		blackPawn4.setImage(blackPawnImg);
		blackPawn4.szin = false;

		Gyalog blackPawn5 = new Gyalog();
		blackPawn5.setImage(blackPawnImg);
		blackPawn5.szin = false;

		Gyalog blackPawn6 = new Gyalog();
		blackPawn6.setImage(blackPawnImg);
		blackPawn6.szin = false;

		Gyalog blackPawn7 = new Gyalog();
		blackPawn7.setImage(blackPawnImg);
		blackPawn7.szin = false;

		Gyalog blackPawn8 = new Gyalog();
		blackPawn8.setImage(blackPawnImg);
		blackPawn8.szin = false;

		Babu[] feketeGyalogok = { blackPawn1, blackPawn2, blackPawn3, blackPawn4, blackPawn5, blackPawn6, blackPawn7,
				blackPawn8 };

		Map<String, Babu[]> pieces = new HashMap<String, Babu[]>();
		pieces.put("feherTisztek", feherTisztek);
		pieces.put("feherGyalogok", feherGyalogok);
		pieces.put("feketeTisztek", feketeTisztek);
		pieces.put("feketeGyalogok", feketeGyalogok);

		return pieces;
	}
}
