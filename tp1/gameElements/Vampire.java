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
    private static int subtractor = 1;
    private static boolean reseted = false;
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

        if(vampiresRemaining == 0 && subtractor == 1|| reseted){
            this.game.setVampiresWereAdded();
            numberOfVampires = game.getLvl().getNumberOfVampires();
        }
        vampiresRemaining = numberOfVampires - subtractor;

        //TO DELETE ONCE INHERITANCE IS ALLOWED

        currentCycle = game.getCycle();

        subtractor++;
        cycleToMove = currentCycle + 2;

        vampiresOnBoard++;

    }

    public Vampire(Game game, int lives, int positionX, int positionY) {
        //super(game,0, lives, positionX, positionY, 0);
        numberOfVampires = game.getLvl().getNumberOfVampires();
        vampiresRemaining = numberOfVampires - 1;
        cycleToMove = currentCycle + 2;
    }

    //@Override
    public void attack() {
            game.bite(posX,posY,damage);
    }

//   // @Override
//    public void attack(GameElement gameElement) {
//        //bite(gameElement);
//    }


    //@Override
    public void move() {

        currentCycle++;
        if(game.leftFree(posX,posY)) {

            if (currentCycle == cycleToMove) {
                posY--;
                cycleToMove = currentCycle + 2;

                if (posY == -1){
                    vampiresOnLeft = true;
                    //game.gameOver();
                }

            }
            //else currentCycle++;

        }//if
        else cycleToMove++;
    }

    //@Override
    public void receiveDamage(int damage) {
        lives = lives - damage;
        if(lives<=0) alive = false;
    }

    //@Override
    public String toString() {
        return "V^V" + "[" + lives + "]";
    }

//    private void bite(GameElement gameElement){
//        gameElement.receiveDamage();
//    }



    public boolean isVampiresOnLeft(){
        if(vampiresOnLeft) return true;
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

    public int getLives() {
        return lives;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public static void vampireNumsReset(){
        vampiresRemaining = 0;
        vampiresOnBoard=0;
        subtractor = 1;
        reseted = true;
    }

    public boolean confirmPosition(int x, int y){
        return posX==x && posY==y;
    }
    //TO DELETE ONCE INHERITANCE IS ALLOWED

}
