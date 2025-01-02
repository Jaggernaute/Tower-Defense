package game;

import java.awt.Font;
import java.util.logging.Logger;
import java.util.logging.Level;

import std.StdAudioStereo;
import std.StdDraw;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] unused) {
        LOGGER.info("Starting Tower Defense game");
        Font font = new Font("Arial", Font.BOLD, 13);
        Interface map = new Interface(0.45, font, "src/main/resources/maps/10-3.mtp");
        // map carrés fonctionnelles
        // map valeur  y plus grande que la valeur x fonctionnel
        //TODO map valeur  y plus grande que la valeur x(fonctionnelle presque centré verticalement)
        int[] level = {2, 4};
        int[] waves = {1, 6};
        StdDraw.setCanvasSize(1920, 1080);

        try {
            StdAudioStereo.playInBackground("src/main/resources/sounds/rendertrucdefensedetour.wav");
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Failed to load background music file", e);
        }

        map.drawMainMenu();
        for(;;){
            if(StdDraw.isMousePressed()){
                StdDraw.clear();
                break;
            }
        }
        map.drawGameInfos(level, waves);
        map.drawPlayerInfos(50, 20);
        map.drawShop();
        System.out.println("Drawing MainMap");
        map.drawMainMap();
        try {
            StdAudioStereo.playInBackground("src/main/resources/sounds/game_launched.wav");
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Failed to play game launched sound", e);
        }
    }
}