package game.mobs;

public class Enemy extends Mob{
    private int speed;
    private int reward;
    public Enemy(String name, int maxHealth, int atk, int atkSpeed, int range, int speed, int reward){
        super(name, maxHealth, atk, atkSpeed, range);
        this.speed = speed;
        this.reward = reward;
    }
}
