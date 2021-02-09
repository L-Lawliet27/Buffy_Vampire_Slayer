package tp1.logic;

import tp1.exceptions.*;
import tp1.gameElements.Attackers.Dracula;
import tp1.gameElements.IAttack;
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
    public static boolean vampiresWereAdded = false;
    private static boolean vampiresWin;
    private static boolean playerWins;
    private String[] info;
    private String[] stringy;
    private Long seed;
    private static Random random;
    private GameObjectBoard board;

    private static final String lightCoinsMessage = String.format("LightFlash Cost is " + lightFlashCost + ": Not Enough Coins%n");
    private static final String garlicCoinsMessage = String.format("GarlicPush Cost is " + garlicPushCost + ": Not Enough Coins%n");
    private static final String vampFailMessage = "Failed to Add Vampire";
    private static final String vampExFailMessage = "Failed to Add Explosive Vampire";
    private static final String dracFailMessage = "Failed to Add Dracula";
    private static final String slayFailMessage = "Failed to Add Slayer";
    private static final String slayCoinsMessage = "Slayer Cost is " + slayerCost + ": Not Enough Coins";
    private static final String bankFailMessage = "Failed to Add Bloodbank";
    private static final String bankCostMessage = String.format("Cost CANNOT be Lower than 5 Coins%n");
    private static final String bankCoinsMessage = String.format("Not Enough Coins to Add a BloodBank%n");


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
        stringy = new String[7];
        //update();

    }

    public void reset(){
        board.vampireNumsReset();
        initializeGame();
    }

    @Override
    public String getInfo(){
        info[0] = String.format("Cycle Number: " + cycle + "%n");
        info[1] = String.format("Coins: " + player.getCoins() + "%n");

        if(!vampiresWereAdded){
            info[2] = String.format("Remaining Vampires: " + lvl.getNumberOfVampires() + "%n");
        } else info[2] = String.format("Remaining Vampires: " + Vampire.getVampiresRemaining() + "%n");

        info[3] = String.format("Vampires on Board: " + Vampire.getVampiresOnBoard() + "%n");

        if(Dracula.draculaRise){
            info[4] = String.format("Dracula has Risen!%n");
        } else info[4] = "";

        StringBuilder stInf = new StringBuilder();
        for (String i : info) {
            stInf.append(i);
        }

        return stInf.toString();
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

    public boolean lightAttack() throws NotEnoughCoinsException{
        if(player.getCoins() >= lightFlashCost){
            player.spendCoins(lightFlashCost);
            board.lightFlashAttack();
            update();
            return true;
        }else throw new NotEnoughCoinsException(lightCoinsMessage);

    }

    public boolean garlicAttack() throws NotEnoughCoinsException {
        if (player.getCoins() >= garlicPushCost){
            player.spendCoins(garlicPushCost);
            board.garlicPushAttack();
            update();
            return true;
        }else throw new NotEnoughCoinsException(garlicCoinsMessage);

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

    public boolean addVampire(int x, int y) throws CommandExecuteException {
        try {
            if (board.addVampire(x, y)) {
                return true;
            }
        } catch (NoMoreVampiresException e){
            System.out.println("[DEBUG]: " + e.getMessage());
            throw new CommandExecuteException(vampFailMessage);
        } catch (InvalidPositionException i){
            System.out.println("[DEBUG]: " + "Position (" + y + "," + x + "): " + i.getMessage());
            throw new CommandExecuteException(vampFailMessage);
        }
        return false;
    }

    public boolean addExplosiveVampire(int x, int y) throws CommandExecuteException {
        try {
            if (board.addExplosiveVampire(x, y)) {
                return true;
            }
        } catch (NoMoreVampiresException e){
            System.out.println("[DEBUG]: " + e.getMessage());
            throw new CommandExecuteException(vampExFailMessage);
        } catch (InvalidPositionException i){
            System.out.println("[DEBUG]: " + "Position (" + y + "," + x + "): " + i.getMessage());
            throw new CommandExecuteException(vampExFailMessage);
        }

        return false;
    }


    public boolean addDracula(int x, int y) throws CommandExecuteException {
        try {
            if (board.addDracula(x, y)) {
                return true;
            }
        }catch (NoMoreVampiresException e){
            System.out.println("[DEBUG]: " + e.getMessage());
            throw new CommandExecuteException(dracFailMessage);
        } catch (InvalidPositionException i){
            System.out.println("[DEBUG]: " + "Position (" + y + "," + x + "): " + i.getMessage());
            throw new CommandExecuteException(dracFailMessage);
        }
        return false;
    }

    private void generateIncome(){board.income();}

    public void receiveIncome(int n){ player.receiveCoins(n); }

    public void superCoins(){
        player.receiveCoins(1000);
    }

    public void setVampiresWereAdded(){
        vampiresWereAdded = !vampiresWereAdded;
    }

    public boolean addSlayer(int x, int y) throws CommandExecuteException, NotEnoughCoinsException {

        if (player.getCoins() >= slayerCost) {
            try {
                if (board.addSlayer(x, y)) {
                    player.spendCoins(slayerCost);
                    update();
                    return true;
                }
            } catch (InvalidPositionException e) {
                System.out.println("[DEBUG]: " + "Position (" + y + "," + x + "): " + e.getMessage());
                throw new CommandExecuteException(slayFailMessage);
            }
        } else throw new NotEnoughCoinsException(slayCoinsMessage);

        return false;
    }

    public boolean addBloodBank(int x, int y, int cost) throws CommandExecuteException, NotEnoughCoinsException {
        if(player.getCoins() >= cost) {
            if (cost >= 5) {
                try {
                    if (board.addBloodBank(x, y, cost)) {
                        player.spendCoins(cost);
                        update();
                        return true;
                    }
                }catch (InvalidPositionException e){
                    System.out.println("[DEBUG]: " + "Position (" + x + "," + y + "): " + e.getMessage());
                    throw new CommandExecuteException(bankFailMessage);
                }
            } else throw new NotEnoughCoinsException(bankCostMessage);
        } else throw new NotEnoughCoinsException(bankCoinsMessage);
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

    public IAttack getEnemyInPosition(int x, int y){
        return board.getEnemy(x,y);
    }

    public IAttack getEnemyInRow(int x, int y){
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

    public String winnerMessage(){
        if(vampiresWin){
            return "Vampires Win";
        } else if(playerWins){
            return "Player Wins";
        } else return "Nobody Wins...";
    }


    public String stringify() {
        stringy[0] = String.format("Buffy the Vampire Slayer v3.0 %n%n");
        stringy[1] = String.format("Number of Cycles: " + cycle + "%n");
        stringy[2] = String.format("Level: " + getLvl().name() + "%n");
        stringy[3] = String.format("Coins: " + player.getCoins() + "%n");
        if(!vampiresWereAdded){
            stringy[4] = String.format("Remaining Vampires: " + lvl.getNumberOfVampires() + "%n");
        } else stringy[4] = String.format("Remaining Vampires: " + Vampire.getVampiresRemaining() + "%n");
        stringy[5] = String.format("Vampires on Board: " + Vampire.getVampiresOnBoard() + "%n%n");
        stringy[6] = String.format("GameElement Objects:%n");

        StringBuilder str = new StringBuilder();
        for (String m: stringy) {
            str.append(m);
        }

        return str.toString() + board.stringify();

    }
}
