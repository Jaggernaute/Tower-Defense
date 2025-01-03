package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;

/***
 * LevelLoader
 * <p>
 * This object parse a level file and gives waves with a streamable.
 * It also give the map to load.
 * <p>
 * @since 0.42
 */
public class LevelLoader {
    
    private String levelLink;
    private LinkedList<String> waitingWaves;
    private String mapLink;

    public LevelLoader(String levelLink){
        this.levelLink = levelLink;
        ArrayList<String> temp = ReadLvlFile();
        this.waitingWaves = new LinkedList<String>();
        System.out.println(temp.toString());
        for(int i = 1; i < temp.size(); i++ ){
            this.waitingWaves.add(temp.get(i));
        }
        this.mapLink = setMapLink(temp.get(0));
    }

    private ArrayList<String> ReadLvlFile(){
         ArrayList<String> tab = new ArrayList<>();
        try{FileReader fileReader = new FileReader(this.levelLink);
            BufferedReader buffReader = new BufferedReader(fileReader);
            //If file is not empty
            while(buffReader.ready()){
               String line = buffReader.readLine();
                tab.add(line);
            }
            
        }
        catch(IOException ioe){
            System.out.println("Failed to load File");
        }
        return tab;
    }

    public String getNextWave(){
        String temp = this.waitingWaves.pollFirst();
        return temp;
    }

    private String setMapLink(String name){
        return "src/main/resources/maps/" + name + ".mtp";
    }

    public String getMapLink() {
        return mapLink;
    }

    public static void main(String[] args) {
        LevelLoader test1 = new LevelLoader("src/main/resources/levels/level1.lvl");
        System.out.println(test1.getNextWave());
        System.out.println(test1.getMapLink());
    }
}
