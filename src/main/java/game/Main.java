package game;

import java.awt.Font;
import java.util.logging.Logger;
import java.util.logging.Level;

import std.StdAudioStereo;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] unused) {
        LOGGER.info("Starting Tower Defense game");
        Font font = new Font("Arial", Font.BOLD, 13);
        Interface map = new Interface(0.0, font, "src/main/resources/maps/5-8.mtp");
        int[] level = {2, 4};
        int[] waves = {1, 6};

        try {
            StdAudioStereo.playInBackground("src/main/resources/sounds/rendertrucdefensedetour.wav");
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Failed to load background music file", e);
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