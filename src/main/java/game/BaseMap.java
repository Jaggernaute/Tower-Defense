package game;
import libs.StdDraw;
public class BaseMap {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(1080,720);
        StdDraw.setPenRadius(0.005);

        //Dessine la zone Info Jeu
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.rectangle(0.9, 0.987, 0.10, 0.013);
        //Dessine la zone Info Joueur
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.rectangle(0.9, 0.947, 0.1, 0.023);
        //Dessine la zone Boutique
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.rectangle(0.9, 0.46, 0.1, 0.46);
        //Dessine la zone Carte
        StdDraw.setPenColor(StdDraw.PURPLE);
        StdDraw.rectangle(0.4, 0.5, 0.4, 0.5);
    }
}
