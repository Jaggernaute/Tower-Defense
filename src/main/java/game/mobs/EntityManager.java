package game.mobs;

import java.util.LinkedList;

public class EntityManager{
    //TODO Attributs
    LinkedList<Enemy> activeMobs;
    LinkedList<Tower> activeTowers;
    LinkedList<Projectile> activeProjectile;

    //TODO Constructeur
    public EntityManager(){

    }

    public void createEnemy(String name){
        switch (name){
            case "Minion" :
                this.activeMobs.add(new Enemy("Minion", 10, 3, 0, 0, Element.NEUTRAL, 1, 1));
                break;
            
            case "WindGrognard" :
                this.activeMobs.add(new Enemy("Wind Grognard", 1, 7, 2, 5, Element.AIR, 2, 1));
                break;
            
            case "WaterBrute" :
            this.activeMobs.add(new Enemy("Water Brute", 30, 5, 1, 3, Element.WATER, 1, 3));
                break;

            case "EarthBrute" :
            this.activeMobs.add(new Enemy("Earth Brute", 30, 5, 1, 3, Element.EARTH, 1, 3));
                break;
            
            case "FireGrognard" :
            this.activeMobs.add(new Enemy("Fire Grognard", 1, 7, 2, 3, Element.FIRE, 2, 1));
                break;
            //TODO add bonus Mobs

            case "Boss" :
            this.activeMobs.add(new Enemy("Boss", 150, 100, 10, 2, Element.FIRE, 0.5, 100));
        }
    }

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