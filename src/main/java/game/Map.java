package src.main.java.game;
import libs.StdDraw;
import java.awt.Font;

public class Map {
    double version;
    Font font;
    
    //Setup de la fenetre
    public Map(double ver, Font font){
        this.version = ver;
        this.font = font;
        StdDraw.setCanvasSize(1080,720);
        StdDraw.setTitle("Tower Defense VideCoq_Merrer V" + version);
    }

    //Dessine la zone Info Jeu
    public void drawGameInfos(int[] level, int[] waves){
        StdDraw.setFont(this.font);
        StdDraw.text(0.85, 0.985, "LVL:" +level[0]+"/" + level[1]);
        StdDraw.text(0.95, 0.985, "WAVE:" + waves[0] + "/" + waves[1]);
        
        //Dessine le contour de la zone
        StdDraw.setPenRadius(0.003);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.rectangle(0.9, 0.987, 0.10, 0.013);
    }

    //Dessine la zone Info Joueur
    public void drawPlayerInfos(int coinsValue, int lifeValue){
        
        this.drawCoinIcon();
        Font f = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(f);
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.text(0.85, 0.945, "" + coinsValue);
        StdDraw.setPenRadius(0.003);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.rectangle(0.9, 0.947, 0.1, 0.023);
    }

    private void drawCoinIcon(){
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.setPenRadius(0.05);
        StdDraw.point(0.82, 0.947);
        StdDraw.setPenColor(StdDraw.SILVER);
        StdDraw.setPenRadius(0.04);
        StdDraw.point(0.82, 0.947);
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
        StdDraw.setPenColor(11, 102, 35);
        StdDraw.filledRectangle(0.4,0.5,0.4,0.5);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.rectangle(0.4, 0.5, 0.4, 0.5);
    }

}
