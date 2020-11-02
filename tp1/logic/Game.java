package tp1.logic;

import tp1.gameElements.Player;

import java.util.Random;

public class Game {

    private Player player;
    private Level lvl;
    private Long seed;
    private int cycle;
    private Random random;


    public Game(Long seed, Level level){
        this.seed = seed;
        lvl = level;
        random = new Random();
    }


    public void draw(){}

    public void update(){}

    public void attack(){}

    public void addVampire(){}

    public void gameObjectBoard(){}

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



}
