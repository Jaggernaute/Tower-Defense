package game.mobs;

public class Enemy extends Entity{
    private int speed;
    private int reward;
    public Enemy(String name, int maxHealth, int atk, double atkSpeed, double range, Element element, int speed, int reward){
        super(name, maxHealth, atk, atkSpeed, range, element);
        this.speed = speed;
        this.reward = reward;
    }
    public int getSpeed() {
        return speed;
    }
    public int getReward() {
        return reward;
    }
}
