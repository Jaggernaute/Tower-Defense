package game;

import game.exceptions.GameException;
import game.exceptions.MapException;

/***
 * Object Block
 * <p>
 * This object represent an area to display
 * <p>
 */
public class Block {
    private double centerX;
    private double centerY;
    private double halfHeight;
    private double halfWidth;
    Corner cornerTopLeft;
    Corner cornerTopRight;
    Corner cornerBotLeft;
    Corner cornerBotRight;
    Corner[] corners;

    /***
     * A simple class to represent a corner
     * <p>
     * This class represent a corener thanks to his 2 attributes representing respectively the position in the x-axe and the y-axe
     * <p>
     */
    protected class Corner{
        double X;
        double Y;
        public Corner(double X, double Y){
            this.X = X;
            this.Y = Y;
        }
        public void setX(double X){
            this.X = X;
        }
        public void setY(double Y){
            this.Y = Y;
        }
        public double getX(){
            return this.X;
        }
        public double getY(){
            return this.Y;
        }
    }

    /*** 
        * Create an Object Block
        * <p>
        *  This methode create an Object Block representing an area to to draw for the game.
        * </p>
        * @param centerX a double representing the position on the x-axe of the center of the area
        * @param centerY a double representing the position on the y-axe of the center of the area
        * @param halfHeight a double reprensenting the half of the height(y-axe) of the area
        * @param halfWidth a double reprensenting the half of the width(x-axe) of the area
     */
    public Block(double centerX, double centerY, double halfHeight, double halfWidth){
        this.centerX = centerX;
        this.centerY = centerY;
        this.halfHeight = halfHeight;
        this.halfWidth = halfWidth;
        this.setCorners();
        corners = new Corner[]
            {
                cornerTopLeft,
                cornerTopRight,
                cornerBotLeft,
                cornerBotRight
            };
    }

    public double getCenterX(){
        return this.centerX;
    }

    public double getCenterY(){
        return this.centerY;
    }

    public double getHalfHeight(){
        return this.halfHeight;
    }

    public double getHalfWidth(){
        return this.halfWidth;
    }

    public void setCenterX(double centerX){
        this.centerX = centerX;
        this.setCorners();
    }

    public void setCenterY(double centerY){
        this.centerY = centerY;
        this.setCorners();
    }

    public void setHalfHeight(double halfHeight){
        this.halfHeight = halfHeight;
        this.setCorners();
    }

    public void setHalfWidth(double halfWidth){
        this.halfWidth = halfWidth;
        this.setCorners();
    }

    private void setCorners(){
        setCornerTopLeft();
        setCornerTopRight();
        setCornerBotLeft();
        setCornerBotRight();
    }

    private void setCornerTopLeft(){
        this.cornerTopLeft = new Corner(
            this.centerX - halfWidth,
            this.centerY + halfHeight
            );
    }
    private void setCornerTopRight(){
        this.cornerTopRight = new Corner(
            this.centerX + halfWidth, 
            this.centerY + halfHeight
            );
    }
    private void setCornerBotLeft(){
        this.cornerBotLeft = new Corner(
            this.centerX - halfWidth, 
            this.centerY - halfHeight
            );
    }

    private void setCornerBotRight(){
        this.cornerBotRight = new Corner( 
            this.centerX + halfWidth, 
            this.centerY - halfHeight
        );
    }

    public Corner[] getCorners(){
        return this.corners;
    }
}
