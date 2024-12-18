package game;

import game.map.Tiles;

public class Tile extends Block{
    Tiles type;

    public Tile(Tiles type, double centerX, double centerY, double halfHeight, double halfWidth){
        super(centerX, centerY, halfHeight, halfWidth);
        this.type = type;
    }

    public Tiles getType(){
        return this.type;
    }
}
