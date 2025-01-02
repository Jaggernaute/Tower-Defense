package game;

import game.map.Tiles;

/***
 * Object Tile, a tile on the main Game map
 * <p>
 * This object represent an area to display wich is part of the Game area where entities interact on.
 * <p>
 * @since 0.2
 */
public class Tile extends Block{
    private Tiles type;

    public Tile(Tiles type, double centerX, double centerY, double halfHeight, double halfWidth){
        super(centerX, centerY, halfHeight, halfWidth);
        this.type = type;
    }

    public Tiles getType(){
        return this.type;
    }
}
