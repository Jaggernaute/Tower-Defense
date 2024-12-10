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
        //TODO
        return false;
    }
    private void init(){
        //TODO
    }
    private void update(double deltaTimeSec){
        //TODO
    }
}