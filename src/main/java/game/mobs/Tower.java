package game.mobs;

public class Tower extends Entity{
    private int cost;
    public Tower(String name, int maxHealth, int atk, double atkSpeed, double range, Element element, int cost){
        super(name, maxHealth, atk, atkSpeed, range, element);
        this.cost = cost;
    }
    public int getCost() {
        return cost;
    }
}