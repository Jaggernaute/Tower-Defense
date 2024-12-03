package src.main.java.game;

public class Case extends Block{
    int type;

    public Case(int type, double centerX, double centerY, double halfHeight, double halfWidth){
        super(centerX, centerY, halfHeight, halfWidth);
        this.type = type;
    }
}
