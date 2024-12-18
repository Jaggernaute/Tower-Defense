package game;

import java.io.*;
import game.exceptions.MapException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class MainMap {
    Case[][] mapCases;
    int offsetX;
    int offsetY;
    
    public MainMap(String mapLink) throws MapException{
        //lecture de la map et assignation des tailles sizeY et sizeX
        String[] lines = fileRead(mapLink);
        if(matches(lines[0], "Error %s")){
            
        }
        int sizeX = lines[0].length();
        int sizeY = 0;
        for(String x : lines){
            if(x != ""){
                sizeY ++;
            }
        }
        
        if(sizeX <= 10 && sizeY <= 10){
            this.mapCases =  new Case[sizeY][sizeX];
            this. offsetX = (10 - sizeX)/2;
            this. offsetY = (10 - sizeY)/2;
        }
        else{
            throw new MapException("Map too big", "" , mapLink);
        }
    }

    private String[] fileRead(String mapLink){
        String[] lines = new String[10];
        int i = 0;
        try{FileReader fileReader = new FileReader(mapLink);
            BufferedReader buffReader = new BufferedReader(fileReader);
            while(buffReader.ready() && i <= 9){
                lines[i] = buffReader.readLine();
                i++;
            }
            if(10 <= i && buffReader.ready()){
                lines[0] = "Error : too many lines in the file";
                return lines;
            }
        }   
        catch(Exception e){Main.LOGGER.log(Level.WARNING, "Failed to read the file : " + mapLink );
        lines[0] = "Error : Failed to read file : " + mapLink;
        return lines;
    }
        return lines;
    }
    
}
