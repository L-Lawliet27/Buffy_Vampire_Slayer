package tp1.gameElements.Attackers;

import tp1.gameElements.GameElement;
import tp1.logic.Game;

public class Attacker extends GameElement {

    protected int cycleToMove;

    public Attacker(Game game, int cost, int lives, int positionX, int positionY, int damage, String avatar,
                    String stringLabel) {
        super(game, cost, lives, positionX, positionY, damage, avatar);
        cycleToMove = currentCycle + 2;
        this.stringLabel = stringLabel;
    }


    @Override
    public void move() {
        //LEAVE EMPTY
    }


    @Override
    public void generateIncome() {
        //LEAVE EMPTY
    }

    @Override
    public String stringify(){
        return String.format(stringLabel +";"+ posY + ";" + posX + ";"+ getLives() + ";" + getCycleTillMove() + "%n");
    }


    @Override
    public void attack() {
        //LEAVE EMPTY
    }

    @Override
    public boolean receiveSlayerAttack(int damage) {
        reduceLives(damage);
        if(lives<=0) alive = false;
        return true;
    }


    @Override
    public boolean receiveVampireAttack(int damage) {
        return false;
    }


    protected int getCycleTillMove(){
        if(cycleToMove == currentCycle+1) {
            return 0;
        } else return cycleToMove - currentCycle;
    }


}
