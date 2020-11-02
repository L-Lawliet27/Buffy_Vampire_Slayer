package tp1.gameElements;

import tp1.logic.Game;

public abstract class GameElement {

    private int cost;
    private int lives;
    private int posX;
    private int posY;
    private int damage;
    private boolean alive;
    private Game game;

    GameElement(Game game, int cost, int lives, int positionX, int positionY, int damage){
        this.cost = cost;
        this.lives = lives;
        this.posX = positionX;
        this.posY = positionY;
        this.damage = damage;
        this.game = game;
        alive = true;
    }

    public abstract void attack();

    public abstract void attack(GameElement gameElement);

    public abstract void move();

    public abstract void receiveDamage();

    public abstract String toString();

    public boolean isAlive(){
        if(alive) return true;
        else return false;
    }

    public void setAlive(){
        alive = !alive;
    }

    public boolean getAlive(){
        return alive;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int x){
        this.posX = x;
    }

    public int getLives() {
        return lives;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
