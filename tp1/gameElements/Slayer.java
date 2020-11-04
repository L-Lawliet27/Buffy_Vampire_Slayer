package tp1.gameElements;

import tp1.logic.Game;

public class Slayer {

    protected int cost;
    protected int lives;
    protected int posX;
    protected int posY;
    protected int damage;
    protected int currentCycle;
    protected boolean alive;
    protected Game game;


    public Slayer(Game game, int positionX, int positionY){
        //super(game,50,3, positionX, positionY, 0);
        this.cost = 50;
        this.lives = 3;
        this.posX = positionX;
        this.posY = positionY;
        this.damage = 1;
        this.game = game;
        currentCycle = game.getCycle();
        alive = true;
    }

//    public Slayer(Game game, int cost, int lives, int positionX, int positionY) {
//        //super(game, cost, lives, positionX, positionY, 0);
//    }

    public void receiveDamage(int damage) {
        lives = lives - damage;
        if(lives <= 0) setAlive();
    }

    //@Override
    public void attack() {
        game.shoot(posX,posY,damage);
    }

//   // @Override
//    public void attack(GameElement gameElement) {
//
//    }

    //@Override
    public void move() {/*LEAVE EMPTY*/}

    //@Override
    public String toString() {
        return "<->" + "[" + lives + "]";
    }

        //TO DELETE ONCE INHERITANCE IS ALLOWED
            public int getPosX() {
                return posX;
            }

            public int getPosY() {
                return posY;
            }

            public void setAlive(){
                alive = !alive;
            }

            public int getLives() {
                return lives;
            }

            public void setDamage(int damage) {
                this.damage = damage;
            }
            public boolean confirmPosition(int x, int y){
                return posX==x && posY==y;
            }

    public boolean isAlive(){
        if(alive) return true;
        else return false;
    }

    //TO DELETE ONCE INHERITANCE IS ALLOWED


}
