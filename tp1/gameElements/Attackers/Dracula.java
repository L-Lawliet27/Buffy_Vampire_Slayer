package tp1.gameElements.Attackers;

import tp1.logic.Game;

public class Dracula extends Vampire{

    public static boolean draculaRise = false;

    public Dracula(Game game, int positionX, int positionY) {
        super(game, positionX, positionY);
        damage = 3;
        draculaRise = true;
    }

    @Override
    public boolean receiveSlayerAttack(int damage) {
        lives -= damage;
        if(lives<=0){
            alive = false;
            draculaRise = false;
        }
        return true;
    }

    @Override
    public String toString() { return "V-V" + "[" + lives + "]"; }


    @Override
    public void receiveLightFlashAttack() {
        receiveSlayerAttack(0);
    }
}
