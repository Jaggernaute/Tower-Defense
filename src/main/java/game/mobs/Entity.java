package game.mobs;
import game.Coordonate;

public abstract class Entity{
    private String name;
    private int maxHealth;
    private int currentHealth;
    private int atk;
    

    private int atkSpeed;
    private int range;
    private Element element;
    private Coordonate coordonate;

    public Entity(String name, int maxHealth, int atk, int atkSpeed, int range){
        this.name = name;
        this.maxHealth = maxHealth;
        this.atk = atk;
        this.atkSpeed = atkSpeed;
        this.range = range;
    };

    public Element getElement(){
        return this.element;
    }
    public int checkVulnerability(Element element){
        return 0;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAtk() {
        return atk;
    }

    public int getAtkSpeed() {
        return atkSpeed;
    }

    public int getRange() {
        return range;
    }

    public Coordonate getCoordonate() {
        return coordonate;
    }

    public void setCoordonate(Coordonate coordonate) {
        this.coordonate = coordonate;
    }

}