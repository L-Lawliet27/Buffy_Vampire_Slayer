package tp1.gameElements;

import tp1.logic.Game;

public class Vampire extends GameElement{

    private static boolean vampiresOnLeft = false;
    private static int numberOfVampires;
    private static int vampiresRemaining;
    private static int vampiresOnBoard;
    private static int subtractor = 1;
    private static boolean reseted = false;
    private int cycleToMove;

    public Vampire(Game game, int positionX, int positionY){
        super(game,0,5, positionX, positionY, 1);

        if(vampiresRemaining == 0 && subtractor == 1|| reseted){
            this.game.setVampiresWereAdded();
            numberOfVampires = this.game.getLvl().getNumberOfVampires();
        }
        vampiresRemaining = numberOfVampires - subtractor;
        subtractor++;
        cycleToMove = currentCycle + 2;
        vampiresOnBoard++;
    }

   /* public Vampire(Game game, int lives, int positionX, int positionY) {
        super(game,0, lives, positionX, positionY, 0);
        numberOfVampires = game.getLvl().getNumberOfVampires();
        vampiresRemaining = numberOfVampires - 1;
        cycleToMove = currentCycle + 2;
    }*/

    @Override
    public void attack() {
        if(alive){
            IAttack enemy = game.getEnemyInPosition(posX, posY-1);
            if(enemy != null) enemy.receiveVampireAttack(damage);
        }
    }


    @Override
    public void move() {
        currentCycle++;
            if (currentCycle == cycleToMove) {
                posY--;
                cycleToMove = currentCycle + 2;

                if (posY == -1){
                    vampiresOnLeft = true;
                    //game.gameOver();
                }//if-2

            }//if-1
        else cycleToMove++;
    }


    @Override
    public boolean receiveSlayerAttack(int damage) {
        lives = lives - damage;
        if(lives<=0) alive = false;
        return true;
    }

    @Override
    public String toString() {
        return "V^V" + "[" + lives + "]";
    }

    public boolean isVampiresOnLeft(){
        if(vampiresOnLeft) return true;
        else return false;
    }

    @Override
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

    public static void vampireNumsReset(){
        vampiresRemaining = 0;
        vampiresOnBoard=0;
        subtractor = 1;
        reseted = true;
    }


    public static boolean onLeft(){
        return vampiresOnLeft;
    }

}
