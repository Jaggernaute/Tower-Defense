package game;

import java.io.*;
import game.exceptions.MapException;
import game.map.Tiles;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

public class MainMap {
    private static final Logger LOGGER = Logger.getLogger(MainMap.class.getName());
    Tile[][] mapTiles;
    int sizeX;
    int sizeY;
    Block map;
    
    public MainMap(String mapLink, Block map) throws MapException{
        //lecture de la map et assignation des tailles sizeY et sizeX
        ArrayList<ArrayList<String>> tab = fileRead(mapLink);
        int sizeX = tab.get(0).size();
        int sizeY = tab.size();
        this.map = map;
        
        if(sizeX <= 10 && sizeY <= 10){
            this.mapTiles =  new Tile[sizeY][sizeX];
            this.sizeX = sizeX;
            this.sizeY = sizeY; 
        }
        else{
            LOGGER.log(Level.WARNING, "Map " + mapLink + " is too big !");
            System.out.println("Map too big");
            throw new MapException("Map too big", "" , mapLink);
        }
        System.out.println(tab.toString());
        prepareMainMap(tab);
    }

    private void prepareMainMap(ArrayList<ArrayList<String>> parsedFile){
        double caseHalfWidth = (map.getHalfWidth() / this.sizeX);
        double caseHalfHeight = (map.getHalfHeight() / this.sizeY);
        System.out.println(map.getCorners()[0].getY());
        double centerX = map.getCorners()[0].getX() + caseHalfWidth;
        double centerY = map.getCorners()[0].getY() + caseHalfHeight-0.2;
        double offsetX = 0;
        double offsetY = 0;
        this.mapTiles = new Tile[parsedFile.size()][parsedFile.get(0).size()];
        int i = 0;
        int j;
        System.out.println(this.sizeY);
        while(i < this.sizeY){
            j = 0;
            ArrayList<String> line = parsedFile.get(i);
            for(String st : line){
                switch (st) {
                    case "S":
                        this.mapTiles[i][j] = new Tile(Tiles.ENEMY_SPAWN,centerX + offsetX, centerY + offsetY, caseHalfHeight, caseHalfWidth);
                        break;
                    case "B":
                        this.mapTiles[i][j] = new Tile(Tiles.PLAYER_BASE,centerX + offsetX, centerY + offsetY, caseHalfHeight, caseHalfWidth);
                        break;
                    case "R":
                        this.mapTiles[i][j] = new Tile(Tiles.PATH,centerX + offsetX, centerY + offsetY, caseHalfHeight, caseHalfWidth);
                        break;
                    case "C":
                        this.mapTiles[i][j] = new Tile(Tiles.BUILDABLE,centerX + offsetX, centerY + offsetY, caseHalfHeight, caseHalfWidth);
                        break;
                    case "X":
                        this.mapTiles[i][j] = new Tile(Tiles.DECORATION,centerX + offsetX, centerY + offsetY, caseHalfHeight, caseHalfWidth);
                        break;
                    default:
                    //TODO
                        //throw mapExeption ("Unknow tile")
                }
            offsetX += 2*caseHalfWidth;
            j ++;
            }
            offsetX = 0;
            i++;
            offsetY -= 2*caseHalfHeight;
        }
    }

    private ArrayList<ArrayList<String>> fileRead(String mapLink){
        ArrayList<ArrayList<String>> tab = new ArrayList<>();
        try{FileReader fileReader = new FileReader(mapLink);
            BufferedReader buffReader = new BufferedReader(fileReader);
            //If file is not empty
            while(buffReader.ready()){
                ArrayList<String> lines = new ArrayList<>(Arrays.asList(buffReader.readLine().split("")));
                tab.add(lines);
                System.out.println(lines.toString());
            }
            
        }
        catch(IOException ioe){
            System.out.println("Failed to load File");
            LOGGER.log(Level.WARNING, "Failed to load file : " + mapLink);
        }
        return tab;
    }
    
    public Tile[][] getMapTiles(){
        return this.mapTiles;
    }
}
