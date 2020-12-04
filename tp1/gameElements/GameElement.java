package tp1.gameElements;

import tp1.logic.Game;

public abstract class GameElement implements IAttack {

    protected int cost;
    protected int lives;
    protected int posX;
    protected int posY;
    protected int damage;
    protected int currentCycle;
    protected boolean alive;
    protected Game game;

    public GameElement(Game game, int cost, int lives, int positionX, int positionY, int damage){
        this.cost = cost;
        this.lives = lives;
        this.posX = positionX;
        this.posY = positionY;
        this.damage = damage;
        this.game = game;
        currentCycle = game.getCycle();
        alive = true;
    }

    public abstract void move();

    public abstract String toString();

    public boolean isAlive(){
        if(alive) return true;
        else return false;
    }

    public abstract void generateIncome();

    public boolean getAlive(){
        return alive;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public boolean confirmPosition(int x, int y){
        return posX==x && posY==y;
    }

}
