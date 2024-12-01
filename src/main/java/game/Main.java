package src.main.java.game;
import java.awt.Font;

import std.*;
    
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Font font = new Font("Arial", Font.BOLD, 13);
        Interface map = new Interface(0.0, font);
        int[] level = {2, 4};
        int[] waves = {1,6};
        StdAudioStereo.playInBackground("src/main/resources/sounds/lego-building.wav");
        map.drawGameInfos(level, waves);
        map.drawPlayerInfos(50, 20);
        map.drawStore();
        map.drawMainMap();
        StdAudioStereo.play("src/main/resources/sounds/game_launched.wav");
        for (;;){
            if(StdDraw.isMousePressed()){
                StdAudioStereo.play("src/main/resources/sounds/splash.wav");
            }
        }
    }
}