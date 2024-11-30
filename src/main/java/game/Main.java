package src.main.java.game;
import java.awt.Font;

import std.StdAudioStereo;
    
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Font font = new Font("Arial", Font.BOLD, 13);
        Map map = new Map(0.0, font);
        int[] level = {2, 4};
        int[] waves = {1,6};
        map.drawGameInfos(level, waves);
        map.drawPlayerInfos(50, 20);
        map.drawStore();
        map.drawMainMap();
        StdAudioStereo.play("src/main/resources/sounds/game_launched.wav");
    }
}
