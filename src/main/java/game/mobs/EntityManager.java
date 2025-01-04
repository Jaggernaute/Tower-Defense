package game.mobs;

import java.util.LinkedList;

public class EntityManager{
    //TODO Attributs
    LinkedList<Enemy> activeMobs;
    LinkedList<Tower> activeTowers;

    //TODO Constructeur
    public EntityManager(){}

    public void createEnemy(){}

    public void createTower(String name){
        switch (name){
            case "Archer" :
                this.activeTowers.add(new Tower("Archer", 30, 5, 1, 2, Element.NEUTRAL, 20));
                break;
            
            case "WindCaster" :
                this.activeTowers.add(new Tower("Wind Caster", 30, 5, 1.5, 6, Element.AIR, 50));
                break;
            
            case "WaterCaster" :
            this.activeTowers.add(new Tower("Water Caster", 30, 3, 1, 4, Element.WATER, 50));
                break;

            case "EarthCaster" :
            this.activeTowers.add(new Tower("Earth Caster", 50, 7, 0.5, 2.5, Element.EARTH, 100));
                break;
            
            case "FireCaster" :
            this.activeTowers.add(new Tower("Fire Caster", 30, 10, 0.5, 2.5, Element.FIRE, 100));
                break;
            //TODO add bonus towers
        }
    }
}