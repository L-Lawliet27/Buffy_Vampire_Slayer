package tp1.gameElements.Defenders;

import tp1.logic.Game;

public class BloodBank extends Defender {

    private int income;

    public BloodBank(Game game, int positionX, int positionY, int cost) {
        super(game, cost, 1, positionX, positionY, 0);
        income = (int) Math.ceil((cost * 0.1));
    }

    @Override
    public void generateIncome(){
        game.receiveIncome(income);
    }


    @Override
    public String toString() {
        return "B-B" + "[" + lives + "]";
    }
}
