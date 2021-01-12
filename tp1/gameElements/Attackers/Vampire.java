package tp1.gameElements.Attackers;

import tp1.gameElements.IAttack;
import tp1.logic.Game;

public class Vampire extends Attacker {

    private static final int cost = 0;
    private static final int lives = 5;
    private static final int damage = 1;
    private static final String avatar = "V^V";
    private static final String stringLabel = "V";

    private static boolean vampiresOnLeft = false;
    private static int numberOfVampires;
    private static int vampiresRemaining;
    protected static int vampiresOnBoard;
    private static int subtractor = 1;
    private static boolean reseted = false;

    protected Vampire(Game game, int lives, int positionX, int positionY, int damage, String avatar,
                      String stringLabel){
        super(game,cost,lives,positionX,positionY,damage, avatar, stringLabel);

        if(reseted || !Game.vampiresWereAdded){
            this.game.setVampiresWereAdded();
            numberOfVampires = Game.getLvl().getNumberOfVampires();
        }

        vampiresRemaining = numberOfVampires - subtractor;
        subtractor++;
        vampiresOnBoard++;
    }

    public Vampire(Game game, int positionX, int positionY){
        super(game,cost,lives, positionX, positionY, damage, avatar, stringLabel);

        if(reseted || !Game.vampiresWereAdded){
            this.game.setVampiresWereAdded();
            numberOfVampires = Game.getLvl().getNumberOfVampires();
        }
        vampiresRemaining = numberOfVampires - subtractor;
        subtractor++;
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
            if(vampiresOnBoard > 0) {
                vampiresOnBoard--;
            }
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
       /* if(vampiresOnBoard > 0) {
            vampiresOnBoard--;
        }*/
    }


    @Override
    public void receiveGarlicPush() {
        if(posY + 1 == game.getDimX()){
            receiveSlayerAttack(lives);
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
