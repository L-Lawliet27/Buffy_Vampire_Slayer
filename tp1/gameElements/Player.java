package tp1.gameElements;

public class Player {

    private int coins;

    public Player(int initialCoins){
        this.coins = initialCoins;
    }

    public void spendCoins(int price){
        if(coins >= price){
            coins -= price;
        }
    }

    public void receiveCoins(int allowance){
        coins += allowance;
    }

    public int getCoins() {
        return coins;
    }
}
