package tp1.gameElements.Attackers;

import tp1.logic.Game;

public class Dracula extends Vampire{

    private static final int damage = 3;
    private static final int lives = 5;
    public static boolean draculaRise = false;

    public Dracula(Game game, int positionX, int positionY) {
        super(game, lives, positionX, positionY, damage);
        draculaRise = true;
    }

    @Override
    public boolean receiveSlayerAttack(int damage) {
        reduceLives(damage);
        if(getLives()<=0){
            alive = false;
            draculaRise = false;
        }
        return true;
    }

    @Override
    public String toString() { return "V-V" + "[" + getLives() + "]"; }

    @Override
    public String stringify(){
        return "D;"+ posX + ";" + posY + ";" + getCycleTillMove() + "\n";
    }


    @Override
    public void receiveLightFlashAttack() {
        receiveSlayerAttack(0);
    }
}
