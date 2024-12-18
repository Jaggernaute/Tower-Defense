package game;

import java.io.*;
import game.exceptions.MapException;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

public class MainMap {
    private static final Logger LOGGER = Logger.getLogger(MainMap.class.getName());
    Case[][] mapCases;
    int sizeX;
    int sizeY;
    Block map;
    
    public MainMap(String mapLink, Block map) throws MapException{
        //lecture de la map et assignation des tailles sizeY et sizeX
        ArrayList<ArrayList<String>> tab = fileRead(mapLink);
        int sizeX = tab.get(0).size();
        int sizeY = 0;
        this.map = map;
        for(ArrayList<String> x : tab){
            if(x.size() != 0){
                sizeY ++;
            }
        }
        
        if(sizeX <= 10 && sizeY <= 10){
            this.mapCases =  new Case[sizeY][sizeX];
            this.sizeX = sizeX;
            this.sizeY = sizeY; 
        }
        else{
            LOGGER.log(Level.WARNING, "Map " + mapLink + " is too big !");
            throw new MapException("Map too big", "" , mapLink);
        }
    }

    public void drawMainMap(ArrayList<ArrayList<String>> parsedFile){
        double caseHalfWidth = map.getHalfWidth() / this.sizeX;
        double caseHalfHeight = map.getHalfHeight() / this.sizeY;
        double offsetX = 0;
        double offsetY = 0;
        this.mapCases = new Case[this.sizeY][this.sizeX];
        int i = 0;
        int j;
        while(i <= this.sizeY){
            j = 0;
            ArrayList<String> line = parsedFile.get(i);
            for(String c : line){
                switch
            }
        }

    }

    private ArrayList<ArrayList<String>> fileRead(String mapLink){
        ArrayList<ArrayList<String>> tab = new ArrayList<>();
        try{FileReader fileReader = new FileReader(mapLink);
            BufferedReader buffReader = new BufferedReader(fileReader);
            //If file is not empty
            while(buffReader.ready()){
                ArrayList<String> lines = new ArrayList<>(Arrays.asList(buffReader.readLine().split("")));
            }
        }
        catch(Exception e){
            LOGGER.log(Level.WARNING, "Failed to load file : " + mapLink);
        }
        return tab;
    }
    
}
