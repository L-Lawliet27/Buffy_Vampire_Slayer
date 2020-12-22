package tp1.gameElements.Attackers;

import tp1.gameElements.IAttack;
import tp1.logic.Game;

public class Vampire extends Attacker {

    private static boolean vampiresOnLeft = false;
    private static int numberOfVampires;
    private static int vampiresRemaining;
    protected static int vampiresOnBoard;
    private static int subtractor = 1;
    private static boolean reseted = false;
    private int cycleToMove;

    public Vampire(Game game, int positionX, int positionY){
        super(game,0,5, positionX, positionY, 1);

        if(reseted || !Game.vampiresWereAdded){
            this.game.setVampiresWereAdded();
            numberOfVampires = Game.getLvl().getNumberOfVampires();
        }
        vampiresRemaining = numberOfVampires - subtractor;
        subtractor++;
        cycleToMove = currentCycle + 2;
        vampiresOnBoard++;
    }


    @Override
    public void attack() {
        if(alive){
            IAttack enemy = game.getEnemyInPosition(posX, posY-1);
            if(enemy != null) enemy.receiveVampireAttack(damage);
        }
    }

    @Override
    public boolean getAlive(){
        if(!alive){
            vampiresOnBoard--;
        }
        return alive;
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
        //else cycleToMove++;
    }


    @Override
    public String toString() {
        return "V^V" + "[" + lives + "]";
    }



//    public boolean isVampiresOnLeft(){
//        if(vampiresOnLeft) return true;
//        else return false;
//    }



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


    @Override
    public void receiveLightFlashAttack() {
        receiveSlayerAttack(lives);
        vampiresOnBoard--;
    }

    @Override
    public void receiveGarlicPush() {
        if(posY + 1 == game.getDimX()){
            receiveSlayerAttack(lives);
            vampiresOnBoard--;
        } else {
            currentCycle = game.getCycle();
            cycleToMove = currentCycle + 2;
            posY++;
        }
    }

    @Override
    public void receiveExplosion() {
        receiveSlayerAttack(1);
    }
}
