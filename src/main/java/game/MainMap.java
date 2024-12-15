package game;

import game.exceptions.MapException;

public class MainMap {
    Case[][] mapCases;
    int offsetX;
    int offsetY;
    
    public MainMap(String mapLink) throws MapException{
        //lecture de la map et assignation des tailles sizeY et sizeX
        int sizeX = 0;
        int sizeY = 0;
        if(sizeX <= 10 && sizeY <= 10){
            this.mapCases =  new Case[sizeY][sizeX];
            this. offsetX = (10 - sizeX)/2;
            this. offsetY = (10 - sizeY)/2;
        }
        else{
            throw new MapException("Map too big", "" , mapLink);
        }
    }
    
}
