package game;
import java.awt.Font;

import game.Block;
import game.exceptions.MapException;
import game.map.Tiles;
import std.StdDraw;

public class Interface {
    private double version;
    private Font font;
    private double offsetY = 0.1;

    Block map;
    Block playerInfos;
    Block gameInfos;
    Block shop;
    Block MainMenu;

    MainMap mainMap;
    
    //Setup de la fenetre
    public Interface(double ver, Font font, String mapLink){
        this.version = ver;
        this.font = font;
        this.MainMenu = new Block(0.5, 0.5, 0.3, 0.4);
        this.map = new Block(0.4, 0.45+this.offsetY, 0.5, 0.4);
        this.playerInfos = new Block(0.9, 0.825+this.offsetY, 0.024, 0.1);
        this.gameInfos = new Block(0.9,0.786+this.offsetY,0.014,0.10);
        this.shop = new Block(0.9, 0.41+this.offsetY, 0.36, 0.1);
        StdDraw.setTitle("Tower Defense VideCoq_Merrer V" + version);
        try{
            this.mainMap = new MainMap(mapLink, map);
        }
        catch(MapException e){
            //TODO when mapException is catch
            System.out.println("Map is too big !");
            }
    }
    
    //Dessine la zone Info Jeu
    public void drawGameInfos(int[] level, int[] waves){
        StdDraw.setFont(this.font);
        StdDraw.text(this.gameInfos.getCenterX()-0.07, this.gameInfos.getCenterY()-0.002, "LVL:" +level[0]+"/" + level[1]);
        StdDraw.text(this.gameInfos.getCenterX()+0.05, this.gameInfos.getCenterY()-0.002, "WAVE:" + waves[0] + "/" + waves[1]);
        
        //Dessine le contour de la zone
        StdDraw.setPenRadius(0.003);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.rectangle(this.gameInfos.getCenterX(), this.gameInfos.getCenterY(), this.gameInfos.getHalfWidth(), this.gameInfos.getHalfHeight());
    }

    //Dessine la zone Info Joueur
    public void drawPlayerInfos(int coinsValue, int lifeValue){
        
        this.drawCoinIcon();
        this.drawHeartIcon(this.playerInfos.getCenterX()+0.075,this.playerInfos.getCenterY(),this.playerInfos.getHalfHeight()-0.005);
        Font f = new Font("Arial", Font.BOLD, 20);
        StdDraw.setFont(f);
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.text(this.playerInfos.getCenterX()-0.05, this.playerInfos.getCenterY(), "" + coinsValue);
        StdDraw.setPenColor(223, 75, 95);
        StdDraw.text(this.playerInfos.getCenterX()+0.04,this.playerInfos.getCenterY()-0.002, ""+ lifeValue);
        StdDraw.setPenRadius(0.003);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.rectangle(this.playerInfos.getCenterX(), this.playerInfos.getCenterY(), this.playerInfos.getHalfWidth(), this.playerInfos.getHalfHeight());
    }

    //Dessine l'icône de pièce
    private void drawCoinIcon(){
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.setPenRadius(0.05);
        StdDraw.point(this.playerInfos.getCenterX()-0.08, this.playerInfos.getCenterY());
        StdDraw.setPenColor(StdDraw.SILVER);
        StdDraw.setPenRadius(0.04);
        StdDraw.point(this.playerInfos.getCenterX()-0.08, this.playerInfos.getCenterY());
    }

    //Dessine l'icône de coeur
    private void drawHeartIcon(double centerX, double centerY, double halfHeight){
        StdDraw.setPenColor(223, 75, 95);
        double [] listX = new double []
            {
                centerX,
                centerX - halfHeight ,
                centerX - halfHeight ,
                centerX - 0.66 * halfHeight ,
                centerX - 0.33 * halfHeight ,
                centerX,
                centerX + 0.33 * halfHeight ,
                centerX + 0.66 * halfHeight ,
                centerX + halfHeight ,
                centerX + halfHeight ,
                };
                double [] listY = new double []
                {
                centerY - halfHeight ,
                centerY,
                centerY + 0.5 * halfHeight ,
                centerY + halfHeight ,
                centerY + halfHeight ,
                centerY + 0.5 * halfHeight ,
                centerY + halfHeight ,
                centerY + halfHeight ,
                centerY + 0.5 * halfHeight ,
                centerY,
                };
                StdDraw.filledPolygon(listX , listY);
    }

    //Dessine la zone Boutique
    public void drawShop(){
        StdDraw.setPenRadius(0.003);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.rectangle(this.shop.getCenterX(), this.shop.getCenterY(), this.shop.getHalfWidth(), this.shop.getHalfHeight());
    }

    //Dessine la zone Carte
    public void drawMainMap(){
        StdDraw.setPenRadius(0.003);
        StdDraw.setPenColor(11, 102, 35);
        StdDraw.filledSquare(this.map.getCenterX(),this.map.getCenterY(),this.map.getHalfWidth());
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(this.map.getCenterX(),this.map.getCenterY(),this.map.getHalfWidth());
       
        Tile [][] mapTiles = this.mainMap.getMapTiles();
        
        for(Tile[] line : mapTiles){
            for(Tile tile : line){
                StdDraw.setPenRadius(0.1);
                switch(tile.getType()){
                    case ENEMY_SPAWN :
                        StdDraw.setPenColor(StdDraw.RED);
                        StdDraw.filledSquare(tile.getCenterX(), tile.getCenterY(), tile.getHalfWidth());
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.setPenRadius(0.003);
                        StdDraw.square(tile.getCenterX(), tile.getCenterY(), tile.getHalfWidth()); 
                        break;
                    
                    case PLAYER_BASE :
                        StdDraw.setPenColor(StdDraw.YELLOW);
                        StdDraw.filledSquare(tile.getCenterX(), tile.getCenterY(), tile.getHalfWidth());
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.setPenRadius(0.003);
                        StdDraw.square(tile.getCenterX(), tile.getCenterY(), tile.getHalfWidth()); 
                        break;

                    case PATH :
                        StdDraw.setPenColor(255, 231, 192);
                        StdDraw.filledSquare(tile.getCenterX(), tile.getCenterY(), tile.getHalfWidth());
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.setPenRadius(0.003);
                        StdDraw.square(tile.getCenterX(), tile.getCenterY(), tile.getHalfWidth());
                        break;

                    case BUILDABLE :
                        StdDraw.setPenColor(137, 137, 194);
                        StdDraw.filledSquare(tile.getCenterX(), tile.getCenterY(), tile.getHalfWidth());
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.setPenRadius(0.003);
                        StdDraw.square(tile.getCenterX(), tile.getCenterY(), tile.getHalfWidth()); 
                        break;
                    
                    case DECORATION :
                        StdDraw.setPenColor(11, 102, 35);
                        StdDraw.filledSquare(tile.getCenterX(), tile.getCenterY(), tile.getHalfWidth());
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.setPenRadius(0.003);
                        StdDraw.square(tile.getCenterX(), tile.getCenterY(), tile.getHalfWidth()); 
                        System.out.println("Case décor");
                        break;
                }
            }
        }
        System.out.println("Drawing complete");
    }

    public void drawMainMenu(){
        Font font = new Font("Arial", Font.BOLD, 25);
        StdDraw.setFont(font);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BLACK);
        //Bouton Start
        StdDraw.rectangle(this.MainMenu.getCenterX(), this.MainMenu.getCenterY()+ 0.105, this.MainMenu.getHalfWidth()/3, this.MainMenu.getHalfHeight()/6);
        StdDraw.text(this.MainMenu.getCenterX(), this.MainMenu.getCenterY()+ 0.105, "Start");
        //Bouton Settings
        StdDraw.rectangle(this.MainMenu.getCenterX(), this.MainMenu.getCenterY() , this.MainMenu.getHalfWidth()/3, this.MainMenu.getHalfHeight()/6);
        StdDraw.text(this.MainMenu.getCenterX(), this.MainMenu.getCenterY(), "Settings");
       //Bouton Quit
        StdDraw.rectangle(this.MainMenu.getCenterX(), this.MainMenu.getCenterY()- 0.105, this.MainMenu.getHalfWidth()/3, this.MainMenu.getHalfHeight()/6);
        StdDraw.text(this.MainMenu.getCenterX(), this.MainMenu.getCenterY()- 0.105, "Quit");  
    }

    //TODO drawPauseMenu
    public void drawPauseMenu(){
        Font font = new Font("Arial", Font.BOLD, 25);
        StdDraw.setFont(font);
    }



}
