package game.mobs;

public class Enemy extends Entity{
    private double speed;
    private int reward;
    public Enemy(String name, int maxHealth, int atk, double atkSpeed, double range, Element element, double speed, int reward){
        super(name, maxHealth, atk, atkSpeed, range, element);
        this.speed = speed;
        this.reward = reward;
    }
    public double getSpeed() {
        return speed;
    }
    public int getReward() {
        return reward;
    }
}
