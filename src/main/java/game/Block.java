package game;

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
