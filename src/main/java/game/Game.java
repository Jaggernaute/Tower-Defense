package game;

public class Game{

    public void launch (){
        init();
        long previousTime = System.currentTimeMillis ();
        while(isGameRunning ()){
        long currentTime = System.currentTimeMillis ();
        double deltaTimeSec = (double)(currentTime - previousTime)/1000;
        previousTime = currentTime;
        update(deltaTimeSec);
        }
    }
    private boolean isGameRunning (){
        //TODO is the game running ?
        return false;
    }
    private void init(){
        //TODO init
    }
    private void update(double deltaTimeSec){
        //TODO update
    }
}