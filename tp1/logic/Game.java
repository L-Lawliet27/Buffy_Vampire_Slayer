package tp1.logic;

import tp1.gameElements.GameElement;
import tp1.gameElements.Player;
import tp1.gameElements.Vampire;

import java.util.Random;

public class Game {

    private Player player;
    private static Level lvl;
    private int cycle;
    private static final int slayerCost = 50;
    private static boolean exit = false;
    private static boolean gameOver = false;
    private static boolean vampiresWereAdded = false;
    private static boolean notEnoughCoins = false;
    private static boolean vampiresWin;
    private static boolean playerWins;
    private String[] info;
    private static Random random;
    private GameObjectBoard board;


    public Game(Long seed, Level level){
        lvl = level;
        random = new Random(seed);
        vampiresWin = false;
        playerWins = false;
        initializeGame();
    }

    public void initializeGame(){
        cycle = 0;
        player = new Player(slayerCost);
        board = new GameObjectBoard(this);
        info = new String[4];
        update();
    }

    public void reset(){
        board.vampireNumsReset();
        initializeGame();
    }


    public String draw(){
        info[0] = "Cycle Number: " + cycle + "\n";
        info[1] = "Coins: " + player.getCoins() + "\n";
        if(!vampiresWereAdded){
            info[2] = "Remaining Vampires: " + lvl.getNumberOfVampires() + "\n";
        } else info[2] = "Remaining Vampires: " + Vampire.getVampiresRemaining() + "\n";

        info[3] = "Vampires on Board: " + Vampire.getVampiresOnBoard() + "\n";

        return info[0] + info[1] + info [2] + info[3];
    }

    public String toString(int x, int y){
        return board.toString(x,y);
    }

//    public String vampireToString(int x, int y){
//        return board.vampireToString(x,y);
//    }
//
//    public String slayerToString(int x, int y){
//        return board.slayerToString(x,y);
//    }

    public void update(){
      //  attack();
        if (random.nextFloat()<=0.5){
            player.receiveCoins(10);
        }
        move();
        attack();
        removeDead();
        addVampire();
        gameOver();
        cycle += 1;
    }


    private void move() {
        board.move();
    }

    private void attack() {
        board.attack();
    }

    private void removeDead() {
        board.removeDead();
    }

    private void addVampire() {
        board.addVampire();
    }

    public void setVampiresWereAdded(){
        vampiresWereAdded = !vampiresWereAdded;
    }

    public boolean addSlayer(int x, int y){
        if(player.getCoins() >= slayerCost) {
            if(board.addSlayer(x, y)){
                player.spendCoins(slayerCost);
                update();
                return true;
            } return false;
        }
        setNotEnoughCoins();
        return false;
    }

    public void setNotEnoughCoins() {
        notEnoughCoins = !notEnoughCoins;
    }

    public static boolean getEnoughCoins(){
        return notEnoughCoins;
    }

    public static Level getLvl(){
        return lvl;
    }

    public static Random getRandom(){
        return random;
    }

    public int getDimX(){
        return lvl.getDim_x();
    }

    public int getDimY(){
        return lvl.getDim_y();
    }

    public int getCycle(){
        return cycle;
    }

    public GameElement getEnemyInPosition(int x, int y){
        return board.getElement(x,y);
    }

    public GameElement getEnemyInRow(int x, int y){
        return board.enemyInRow(x,y);
    }


    public void exit(){
        exit = true;
        gameOver();
    }

    public void gameOver(){
        if(Vampire.onLeft() && !gameOver){
            vampiresWin = true;
            gameOver = true;

        } else if (vampiresWereAdded && Vampire.getVampiresOnBoard() == 0
                && Vampire.getVampiresRemaining() == 0){
            playerWins = true;
            gameOver = true;

        } else if(exit){
            gameOver = true;
        }
    }

    public boolean isOver(){
        return gameOver;
    }

    public void winnerMessage(){
        if(vampiresWin){
            System.out.println("Vampires Win\n");
        } else if(playerWins){
            System.out.println("Player Wins\n");
        } else System.out.println("Nobody Wins...\n");
    }


}
