package tp1.logic;

import tp1.gameElements.*;

import java.util.ArrayList;

public class GameObjectBoard implements IElemLogic {

    private final Level level;
    private Game game;
    private final int VampirePosY;
    private ArrayList<GameElement> gameElements;
    private static int nVampiresAdded;


    public GameObjectBoard(Game game){
        this.game = game;
        this.level = Game.getLvl();
        gameElements = new ArrayList<GameElement>();
        VampirePosY = game.getDimX()-1;
        nVampiresAdded = 0;
        //instantiateVampires();
    }

    public void vampireNumsReset(){
        Vampire.vampireNumsReset();
        game.setVampiresWereAdded();
    }


    public String toString(int x, int y){
        if(getElement(x,y) != null){
            return getElement(x,y).toString();
        }
        return "";
    }

//    private void instantiateVampires(){
//        for (int i = 0; i < level.getNumberOfVampires(); i++) {
//            addVampire();
//        }
//    }

    public void addVampire(){
        if(nVampiresAdded < level.getNumberOfVampires()) {
            if (canAddVampire()) {
                int posX = initialVampirePosition(game.getDimY());
                if (!elementHere(posX, VampirePosY)) {
                    gameElements.add(new Vampire(game,posX,VampirePosY));
                    nVampiresAdded++;
                }//if-3
            }//if-2
        }//if-1
    }


    public boolean addSlayer(int x, int y){
        if(!elementHere(x,y) && !outOfBounds(game.getDimX(), y)){
            gameElements.add(new Slayer(game,x,y));
            return true;
        }
        return false;
    }

    public void move(){
        for (GameElement e : gameElements) {
            if(isLeftFree(e.getPosX(),e.getPosY())){
                e.move();
            }
        }
    }

    public void removeDead(){
        gameElements.removeIf(e -> !e.getAlive());
    }


    public void attack() {
        for (GameElement e : gameElements) {
            e.attack();
        }
    }


    public GameElement getElement(int x, int y) {
        for (GameElement e : gameElements) {
            if(e.confirmPosition(x,y)){
                return e;
            }
        }
        return null;
    }

    public GameElement enemyInRow(int x, int y){
        for (GameElement e : gameElements) {
            if(sameRow(e.getPosX(), x)){
                for (int j = y; j <= e.getPosY(); j++) {
                    if(elementHere(e.getPosX(), j) && e.receiveSlayerAttack(0)){
                        return e;
                    }//if-2
                }//for
            }//if-1
        }//foreach
        return null;
    }


    private boolean elementHere(int ex, int y){
        for (GameElement e : gameElements) {
            if (e.confirmPosition(ex,y)){
                return true;
            }
        }
        return false;
    }



    private boolean isLeftFree(int x, int y){
        for (GameElement e: gameElements) {
            if(sameCoords(e.getPosX(), e.getPosY(), x, y-1)){
                return false;
            }
        }
        return true;
    }




}
