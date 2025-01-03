package game.mobs;

public class Tower extends Entity{
    private int cost;
    public Tower(String name, int maxHealth, int atk, int atkSpeed, int range, int cost){
        super(name, maxHealth, atk, atkSpeed, range);
        this.cost = cost;
    }
    public int getCost() {
        return cost;
    }
}