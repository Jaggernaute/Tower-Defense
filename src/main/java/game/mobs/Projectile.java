package game.mobs;

import game.Coordonate;

public class Projectile {
    double damage;
    Coordonate destination;
    Coordonate departure;
    Coordonate actual;
    double speed;
    Element element;

    public Projectile(double damage, Coordonate destination, Coordonate departure, double speed, Element element){
        this.damage = damage;
        this.destination = destination;
        this.departure = departure;
        this.actual = departure;
        this.speed = speed;
        this.element = element;
    }

    //TODO atDestination
    public boolean atDestination(){
        if(this.actual == this.destination){
            return true;
        }
        return false;
    }

    //TODO forward : change actual coordonate to actual coordonate + speed on the vector (departure -> destination)
    public void forward(){}
}
