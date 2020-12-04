package tp1.logic;

import tp1.game.Controller;
import tp1.gameElements.Attackers.Dracula;
import tp1.gameElements.GameElement;
import tp1.gameElements.Player;
import tp1.gameElements.Attackers.Vampire;

import java.util.Random;

public class Game implements IPrintable{

    private Player player;
    private static Level lvl;
    private int cycle;
    private static final int slayerCost = 50;
    private static final int lightFlashCost = 50;
    private static final int garlicPushCost = 10;
    private static boolean exit = false;
    private static boolean gameOver = false;
    private static boolean vampiresWereAdded = false;
    private static boolean vampiresWin;
    private static boolean playerWins;
    private String[] info;
    private Long seed;
    private static Random random;
    private GameObjectBoard board;


    public Game(Long seed, Level level){
        this.seed = seed;
        lvl = level;
        vampiresWin = false;
        playerWins = false;
        initializeGame();
    }

    public void initializeGame(){
        cycle = 0;
        random = new Random(seed);
        player = new Player(slayerCost);
        board = new GameObjectBoard(this);
        info = new String[5];
        update();
    }

    public void reset(){
        board.vampireNumsReset();
        initializeGame();
    }

    @Override
    public String getInfo(){
        info[0] = "Cycle Number: " + cycle + "\n";
        info[1] = "Coins: " + player.getCoins() + "\n";

        if(!vampiresWereAdded){
            info[2] = "Remaining Vampires: " + lvl.getNumberOfVampires() + "\n";
        } else info[2] = "Remaining Vampires: " + Vampire.getVampiresRemaining() + "\n";

        info[3] = "Vampires on Board: " + Vampire.getVampiresOnBoard() + "\n";

        if(Dracula.draculaRise){
            info[4] = "Dracula has Risen! \n";
        } else info[4] = "";

        return info[0] + info[1] + info [2] + info[3] + info[4];
    }

    @Override
    public String getPositionToString(int x, int y){
        return board.toString(x,y);
    }

    public void update(){
        allowance();
        move();
        attack();
        removeDead();
        addVampire();
        gameOver();
        cycle += 1;
    }


    private void allowance(){
        if (random.nextFloat()<=0.5){
            player.receiveCoins(10);
        }
        generateIncome();
    }

    private void move() {
        board.move();
    }

    private void attack() {
        board.attack();
    }

    public boolean lightAttack(){
        if(player.getCoins() >= lightFlashCost){
            player.spendCoins(lightFlashCost);
            board.lightFlashAttack();
            update();
            return true;
        }else System.out.println("Not Enough Coins\n");

        return false;
    }

    public boolean garlicAttack(){
        if (player.getCoins() >= garlicPushCost){
            player.spendCoins(garlicPushCost);
            board.garlicPushAttack();
            update();
            return true;
        }else System.out.println("Not Enough Coins\n");

        return false;
    }

    public void explosionAttack(int posX, int posY) {
        board.explosionDamage(posX,posY);
    }

    private void removeDead() {
        board.removeDead();
    }

    private void addVampire() {
        board.addVampire();
    }

    public boolean addVampire(int x, int y){
        if(board.addVampire(x,y)){
            update();
            return true;
        } else System.out.println(Controller.invalidPositionMsg);

        return false;
    }

    public boolean addExplosiveVampire(int x, int y){
        if(board.addExplosiveVampire(x,y)){
            update();
            return true;
        } else System.out.println(Controller.invalidPositionMsg);

        return false;
    }


    public boolean addDracula(int x, int y){
        if(board.addDracula(x,y)){
            update();
            return true;
        } else System.out.println(Controller.invalidPositionMsg);

        return false;
    }

    private void generateIncome(){board.income();}

    public void receiveIncome(int n){ player.receiveCoins(n); }

    public void superCoins(){
        player.receiveCoins(1000);
        update();
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
            } else System.out.println(Controller.invalidPositionMsg);
        } else System.out.println("Not Enough Coins\n");

        return false;
    }

    public boolean addBloodBank(int x, int y, int cost){
        //To Change Later When Specification is Given
        if(cost != 0){
            if(board.addBloodBank(x,y,cost)){
                player.spendCoins(cost);
                update();
                return true;
            }else System.out.println(Controller.invalidPositionMsg);
        } else System.out.println("Cost Can't Be 0");
        return false;
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
