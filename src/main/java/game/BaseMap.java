package game;
import libs.StdDraw;

public class BaseMap {
    double version;
    public BaseMap(double ver){
        this.version = ver;
        StdDraw.setCanvasSize(1080,720);
        StdDraw.setTitle("Tower Defense VideCoq_Merrer V" + version);
    }

    public void drawGameInfos(int[] level, int[] wave){
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.rectangle(0.9, 0.987, 0.10, 0.013);
    }
    
    public static void main(String[] args) {
        //Setup de la fenetre
        double version = 0;
        StdDraw.setCanvasSize(1080,720);
        StdDraw.setTitle("Tower Defense VideCoq_Merrer V" + version);
        
        //Setup du crayon
        StdDraw.setPenRadius(0.003);

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
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledRectangle(0.4,0.5,0.4,0.5);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.rectangle(0.4, 0.5, 0.4, 0.5);
    }
}
