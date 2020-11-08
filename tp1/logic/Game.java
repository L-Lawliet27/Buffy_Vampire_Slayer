package tp1.logic;

import tp1.gameElements.Player;

import java.util.Random;

public class Game {

    private Player player;
    private Level lvl;
    private Long seed;
    private static int cycle;
    private static final int slayerCost = 50;
    private static boolean exit = false;
    private String[] info;
    private Random random;
    private GameObjectBoard board;


    public Game(Long seed, Level level){
        lvl = level;
        random = new Random(seed);
        initializeGame();
    }

    public void initializeGame(){
        cycle = 0;
        player = new Player(slayerCost);
        board = new GameObjectBoard(this);
        info = new String[3];
        update();
    }


    public String draw(){
        info[0] = "Cycle Number: " + cycle + "\n";
        info[1] = "Coins: " + player.getCoins() + "\n";
        info[2] = "Remaining Vampires: " + board.getRemainingVampires() + "\n";
        info[3] = "Vampires on Board: " + board.getVampiresOnBoard() + "\n";

        return info[0] + info[1] + info [2] + info[3];
    }

//    public String toString(int x, int y){
//        return board.toString(x,y);
//    }

    public String vampireToString(int x, int y){
        return board.vampireToString(x,y);
    }

    public String slayerToString(int x, int y){
        return board.slayerToString(x,y);
    }

    public void update(){
      //  attack();
        if (random.nextFloat()<=0.5 && cycle!=0){
            player.receiveCoins(10);
        }
        move();
        gameOver();
        cycle += 1;
    }


    private void move() {
        board.move();
        attack();
        removeDead();
        addVampire();
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


    public void addSlayer(int x, int y){
        if(player.getCoins() >= slayerCost) {
            board.addSlayer(x, y);
            player.spendCoins(slayerCost);
        }
    }

    public Level getLvl(){
        return lvl;
    }

    public Random getRandom(){
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

    public void bite(int posX, int posY, int damage) {
        board.slayerDamage(posX,posY,damage);
    }

    public void shoot(int posX, int posY, int damage) {
        board.vampireDamage(posX,posY,damage);
    }

    public boolean leftFree(int posX, int posY) {
        return board.leftFree(posX,posY);
    }

    public void exit(){
        exit = true;
        gameOver();
    }


    public void gameOver(){

        if(board.vampiresOnLeft()){
            System.out.println("Vampires Win");
            System.out.println("Game Over");

        } else if (board.getVampiresOnBoard() == 0 && board.getRemainingVampires() == 0){
            System.out.println("Player Wins");
            System.out.println("Game Over");

        } else if(exit){
            System.out.println("Game Over");
        }

    }


}
