package tp1.gameElements;

import tp1.logic.Game;

public class Vampire extends GameElement{

    private static boolean vampiresOnLeft = false;
    private static int numberOfVampires;
    private static int vampiresRemaining;
    private static int vampiresOnBoard;
    private int cycleToMove;

    public Vampire(Game game, int positionX, int positionY){
        super(game,0,5, positionX, positionY, 0);
        numberOfVampires = game.getLvl().getNumberOfVampires();
        vampiresRemaining = numberOfVampires - 1;
        vampiresOnBoard++;
        cycleToMove = currentCycle + 2;
    }

    public Vampire(Game game, int lives, int positionX, int positionY) {
        super(game,0, lives, positionX, positionY, 0);
        numberOfVampires = game.getLvl().getNumberOfVampires();
        vampiresRemaining = numberOfVampires - 1;
        cycleToMove = currentCycle + 2;
    }

    @Override
    public void attack() {
    }

    @Override
    public void attack(GameElement gameElement) {
        bite(gameElement);
    }

    @Override
    public void move() {
        if(currentCycle == cycleToMove){
            setPosY(1);
            cycleToMove = currentCycle + 2;

        } else currentCycle++;

    }

    @Override
    public void receiveDamage() {



        //TODO
    }

    @Override
    public String toString() {
        return "V^V" + "[" + getLives() + "]";
    }

    private void bite(GameElement gameElement){
        gameElement.receiveDamage();
    }

    public void setVampiresOnLeft(){
        vampiresOnLeft = !vampiresOnLeft;
    }


    public boolean isVampiresOnLeft(){
        if(!vampiresOnLeft) return true;
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
}
