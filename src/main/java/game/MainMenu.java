package game;

import java.io.IOException;

import std.StdDraw;

public class MainMenu{

    Block mainMenu;
    Interface map;
    public MainMenu(Interface map, Block mainMenu){
        this.mainMenu = mainMenu;
        this.map = map;
        double x;
        double y;
        for(;;){
            try{
                Thread.sleep(200);
            }
            catch(Exception e){}
            
            x = StdDraw.mouseX();
            y = StdDraw.mouseY();
            if((x >= this.mainMenu.getCenterX()-this.mainMenu.getHalfWidth()/3 && x <= this.mainMenu.getCenterX()+this.mainMenu.getHalfWidth()/3)
             &&  (y >= this.mainMenu.getCenterY()+ 0.105 - this.mainMenu.getHalfHeight()/6 && y<= this.mainMenu.getCenterY()+ 0.105 + this.mainMenu.getHalfHeight()/6)){
                StdDraw.clear();
                StdDraw.setPenColor(171, 171, 171);
                StdDraw.filledRectangle(this.mainMenu.getCenterX(), this.mainMenu.getCenterY()+ 0.105, this.mainMenu.getHalfWidth()/3, this.mainMenu.getHalfHeight()/6);
                map.drawMainMenu();
            }
            else if((x >= this.mainMenu.getCenterX()-this.mainMenu.getHalfWidth()/3 && x <= this.mainMenu.getCenterX()+this.mainMenu.getHalfWidth()/3)
            &&  (y >= this.mainMenu.getCenterY() - this.mainMenu.getHalfHeight()/6 && y<= this.mainMenu.getCenterY() + this.mainMenu.getHalfHeight()/6)){
                StdDraw.clear();
                StdDraw.setPenColor(171, 171, 171);
                StdDraw.filledRectangle(this.mainMenu.getCenterX(), this.mainMenu.getCenterY(), this.mainMenu.getHalfWidth()/3, this.mainMenu.getHalfHeight()/6);
                map.drawMainMenu();
            }
            else if((x >= this.mainMenu.getCenterX()-this.mainMenu.getHalfWidth()/3 && x <= this.mainMenu.getCenterX()+this.mainMenu.getHalfWidth()/3)
            &&  (y >= this.mainMenu.getCenterY()- 0.105 - this.mainMenu.getHalfHeight()/6 && y<= this.mainMenu.getCenterY() + 0.105 + this.mainMenu.getHalfHeight()/6)){
                StdDraw.clear();
                StdDraw.setPenColor(171, 171, 171);
                StdDraw.filledRectangle(this.mainMenu.getCenterX(), this.mainMenu.getCenterY()- 0.105, this.mainMenu.getHalfWidth()/3, this.mainMenu.getHalfHeight()/6);
                map.drawMainMenu();
            }
            else{
                StdDraw.clear();
                map.drawMainMenu();
            }
            

        }
    }
}