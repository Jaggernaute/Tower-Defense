package game;

import java.io.IOException;
import java.util.logging.Level;

import game.exceptions.MapException;
import std.StdAudioStereo;
import std.StdDraw;

public class MainMenu{

    Block mainMenu;
    Interface map;
    public MainMenu(Interface map, Block mainMenu){
        this.mainMenu = mainMenu;
        this.map = map;
        double x;
        double y;
        boolean start;
        boolean settings;
        boolean quit;
        for(;;){
            try{
                Thread.sleep(10);
            }
            catch(Exception e){}
            
            x = StdDraw.mouseX();
            y = StdDraw.mouseY();
            start = onStart(x, y);
            settings = onSettings(x,y);
            quit = onQuit(x,y);

            if(start){
                StdDraw.clear();
                StdDraw.setPenColor(171, 171, 171);
                StdDraw.filledRectangle(this.mainMenu.getCenterX(), this.mainMenu.getCenterY()+ 0.105, this.mainMenu.getHalfWidth()/3, this.mainMenu.getHalfHeight()/6);
                if(StdDraw.isMousePressed()){
                    StdDraw.clear();
                    break;
                }
                map.drawMainMenu();
            }
            else if(settings){
                StdDraw.clear();
                StdDraw.setPenColor(171, 171, 171);
                StdDraw.filledRectangle(this.mainMenu.getCenterX(), this.mainMenu.getCenterY(), this.mainMenu.getHalfWidth()/3, this.mainMenu.getHalfHeight()/6);
                if(StdDraw.isMousePressed()){
                    //TODO Launch Settings
                 }
                map.drawMainMenu();
            }
            else if(quit){
                StdDraw.clear();
                StdDraw.setPenColor(171, 171, 171);
                StdDraw.filledRectangle(this.mainMenu.getCenterX(), this.mainMenu.getCenterY()- 0.105, this.mainMenu.getHalfWidth()/3, this.mainMenu.getHalfHeight()/6);
                if(StdDraw.isMousePressed()){
                    //Quit
                    StdDraw.close();
                    throw new InternalError();
                 }
                map.drawMainMenu();
            }
            else{
                StdDraw.clear();
                map.drawMainMenu();
            }
        }
        
    }
    private boolean onStart(double x, double y){
        return (x >= this.mainMenu.getCenterX()-this.mainMenu.getHalfWidth()/3 && x <= this.mainMenu.getCenterX()+this.mainMenu.getHalfWidth()/3)
        &&  (y >= this.mainMenu.getCenterY()+ 0.105 - this.mainMenu.getHalfHeight()/6 && y<= this.mainMenu.getCenterY()+ 0.105 + this.mainMenu.getHalfHeight()/6);
    }

    private boolean onSettings(double x, double y){
        return (x >= this.mainMenu.getCenterX()-this.mainMenu.getHalfWidth()/3 && x <= this.mainMenu.getCenterX()+this.mainMenu.getHalfWidth()/3)
        &&  (y >= this.mainMenu.getCenterY() - this.mainMenu.getHalfHeight()/6 && y<= this.mainMenu.getCenterY() + this.mainMenu.getHalfHeight()/6);
    }

    private boolean onQuit(double x, double y){
        return (x >= this.mainMenu.getCenterX()-this.mainMenu.getHalfWidth()/3 && x <= this.mainMenu.getCenterX()+this.mainMenu.getHalfWidth()/3)
        &&  (y >= this.mainMenu.getCenterY()- 0.105 - this.mainMenu.getHalfHeight()/6 && y<= this.mainMenu.getCenterY() + 0.105 + this.mainMenu.getHalfHeight()/6);
    }
}