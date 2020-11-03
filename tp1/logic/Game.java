package tp1.logic;

import tp1.gameElements.Player;
import tp1.printer.GameObjectBoard;

import java.lang.reflect.Array;
import java.util.Random;

public class Game {

    private Player player;
    private Level lvl;
    private Long seed;
    private static int cycle;
    private String[] info;
    private Random random;
    private GameObjectBoard board;


    public Game(Long seed, Level level){
        this.seed = seed;
        lvl = level;
        random = new Random();
    }

    public void initializeGame(){
        cycle = 0;
        player = new Player(50);
        board = new GameObjectBoard(this);
        info = new String[3];
    }


    public String draw(){
        info[0] = "Cycle Number: " + cycle + "\n";
        info[1] = "Coins: " + player.getCoins() + "\n";
        info[2] = "Remaining Vampires: " + board.getRemainingVampires() + "\n";
        info[3] = "Vampires on Board: " + board.getVampiresOnBoard() + "\n";

        return info[0] + info[1] + info [2] + info[3];
    }

    public String toString(int x, int y){
        return board.toString(x,y);
    }

    public void update(){}

    public void attack(){}

    public void addVampire(){}

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


}
