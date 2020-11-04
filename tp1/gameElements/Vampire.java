package tp1.gameElements;

import tp1.logic.Game;

public class Vampire{

    //TO DELETE ONCE INHERITANCE IS ALLOWED
    private int lives;
    private int posX;
    private int posY;
    private int damage;
    private int currentCycle;
    private boolean alive;
    private Game game;
    //TO DELETE ONCE INHERITANCE IS ALLOWED

    private static boolean vampiresOnLeft = false;
    private static int numberOfVampires;
    private static int vampiresRemaining;
    private static int vampiresOnBoard;
    private int cycleToMove;

    public Vampire(Game game, int positionX, int positionY){
        //super(game,0,5, positionX, positionY, 0);

        //TO DELETE ONCE INHERITANCE IS ALLOWED
        this.lives = 5;
        this.posX = positionX;
        this.posY = positionY;
        this.damage = 1;
        this.game = game;
        alive = true;
        //TO DELETE ONCE INHERITANCE IS ALLOWED

        currentCycle = game.getCycle();
        numberOfVampires = game.getLvl().getNumberOfVampires();
        vampiresRemaining = numberOfVampires - 1;
        vampiresOnBoard++;
        cycleToMove = currentCycle + 2;
    }

    public Vampire(Game game, int lives, int positionX, int positionY) {
        //super(game,0, lives, positionX, positionY, 0);
        numberOfVampires = game.getLvl().getNumberOfVampires();
        vampiresRemaining = numberOfVampires - 1;
        cycleToMove = currentCycle + 2;
    }

    //@Override
    public void attack(Slayer s) {

    }

//   // @Override
//    public void attack(GameElement gameElement) {
//        //bite(gameElement);
//    }

    //@Override
    public void move() {
        if(currentCycle == cycleToMove){
            posX--;
            cycleToMove = currentCycle + 2;

        } else currentCycle++;

    }

    //@Override
    public void receiveDamage() {



        //TODO
    }

    //@Override
    public String toString() {
        return "V^V" + "[" + lives + "]";
    }

//    private void bite(GameElement gameElement){
//        gameElement.receiveDamage();
//    }

    public void setVampiresOnLeft(){
        vampiresOnLeft = !vampiresOnLeft;
    }


    public boolean isVampiresOnLeft(){
        if(!vampiresOnLeft) return true;
        else return false;
    }

    //@Override
    public boolean isAlive() {
        if(!alive){
            vampiresOnBoard--;
            return false;
        }
        else return true;
    }


    public static int getVampiresRemaining() {
        return vampiresRemaining;
    }

    public static int getVampiresOnBoard() {
        return vampiresOnBoard;
    }


    //TO DELETE ONCE INHERITANCE IS ALLOWED
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setAlive(){
        alive = !alive;
    }

    public int getLives() {
        return lives;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public boolean confirmPosition(int x, int y){
        return posX==x && posY==y;
    }
    //TO DELETE ONCE INHERITANCE IS ALLOWED

}
