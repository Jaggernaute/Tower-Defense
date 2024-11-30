package src.main.java.game;
import libs.StdDraw;
import java.awt.Font;

public class Map {
    double version;
    
    //Setup de la fenetre
    public Map(double ver){
        this.version = ver;
        StdDraw.setCanvasSize(1080,720);
        StdDraw.setTitle("Tower Defense VideCoq_Merrer V" + version);
    }

    //Dessine la zone Info Jeu
    public void drawGameInfos(int[] level, int[] waves){
        Font font = new Font("Arial", Font.BOLD, 13);
        StdDraw.setFont(font);
        StdDraw.text(0.85, 0.985, "LVL:" +level[0]+"/" + level[1]);
        StdDraw.text(0.95, 0.985, "WAVE:" + waves[0] + "/" + waves[1]);
        
        //Dessine le contour de la zone
        StdDraw.setPenRadius(0.003);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.rectangle(0.9, 0.987, 0.10, 0.013);
    }

    //Dessine la zone Info Joueur
    public void drawPlayerInfo(){
        
        StdDraw.setPenRadius(0.003);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.rectangle(0.9, 0.947, 0.1, 0.023);
    }

    //Dessine la zone Boutique
    public void drawStore(){
        StdDraw.setPenRadius(0.003);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.rectangle(0.9, 0.46, 0.1, 0.46);
    }

    //Dessine la zone Carte
    public void drawMainMap(){
        StdDraw.setPenRadius(0.003);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledRectangle(0.4,0.5,0.4,0.5);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.rectangle(0.4, 0.5, 0.4, 0.5);
    }

}
