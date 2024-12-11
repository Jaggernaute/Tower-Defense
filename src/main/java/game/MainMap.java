package game;

public class MainMap {
    Case[][] mapCases;
    int offsetX;
    int offsetY;
    
    public MainMap(String mapLink){
        //lecture de la map et assignation des tailles sizeY et sizeX
        int sizeX = 0;
        int sizeY = 0;
        if(sizeX <= 10 && sizeY <= 10){
            this.mapCases =  new Case[10][10];
            this. offsetX = (10 - sizeX)/2;
            this. offsetY = (10 - sizeY)/2;
        }
        else{
            //throw mapOutOfBoundException
        }
    }
    
}
