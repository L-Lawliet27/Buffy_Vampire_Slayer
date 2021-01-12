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
    protected String avatar;
    protected String stringLabel;
    protected Game game;

    public GameElement(Game game, int cost, int lives, int positionX, int positionY, int damage, String avatar){
        this.cost = cost;
        this.lives = lives;
        this.posX = positionX;
        this.posY = positionY;
        this.damage = damage;
        this.game = game;
        this.avatar = avatar;
        currentCycle = game.getCycle();
        alive = true;
    }

    public abstract void move();

    public String toString() {
        return avatar + "[" + lives + "]";
    }

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

    public abstract String stringify();

    protected void reduceLives(int damage){
        lives -= damage;
    }

    protected int getLives(){
        return lives;
    }



}
