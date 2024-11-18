package game.mobs;

public abstract class Mob{
    private String name;
    private int maxHealth;
    private int currentHealth;
    private int atk;
    private int atkSpeed;
    private int range;
    private Element element;

    public Mob(){};

    public Element getElement(){
        return this.element;
    }
    public int checkVulnerability(Element element){}
}