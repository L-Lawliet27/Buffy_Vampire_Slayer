package tp1.gameElements.Defenders;

import tp1.logic.Game;

public class BloodBank extends Defender {

    private int income;
    private static final int lives = 1;
    private static final int damage = 0;

    public BloodBank(Game game, int positionX, int positionY, int cost) {
        super(game, cost, lives, positionX, positionY, damage);
        income = (int) Math.ceil((cost * 0.1));
    }

    @Override
    public void generateIncome(){
        game.receiveIncome(income);
    }


    @Override
    public String toString() {
        return "B-B" + "[" + cost + "]";
    }

    @Override
    public String stringify(){
        return "B;"+ posX + ";" + posY + ";" + getLives() + ";" + cost + "\n";
    }
}
