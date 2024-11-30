package src.main.java.game;
import java.awt.Font;
    
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Map map = new Map(0.0);
        int[] level = {0, 0};
        int[] waves = {0,0};
        map.drawGameInfos(level, waves);
        map.drawPlayerInfo();
        map.drawStore();
        map.drawMainMap();
    }
}
