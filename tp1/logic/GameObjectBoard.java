package tp1.logic;

import tp1.gameElements.*;

import java.util.ArrayList;

public class GameObjectBoard implements ElemLogic {

    private final Level level;
    private SlayerList slayerList;
    private VampireList vampireList;
    private Game game;
    private final int VampirePosY;
    private ArrayList<GameElement> gameElements;
    private static int nElements;
    private static int nVampiresAdded;


    public GameObjectBoard(Game game){
        this.game = game;
        this.level = game.getLvl();
        slayerList = new SlayerList();
        vampireList = new VampireList(level.getNumberOfVampires());
        gameElements = new ArrayList<GameElement>();
        nElements = 0;
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


    public String slayerToString(int x, int y){
        return slayerList.slayerToString(x,y);
    }


    public String vampireToString(int x, int y){
        return vampireList.vampireToString(x,y);
    }



    private void instantiateVampires(){
        for (int i = 0; i < level.getNumberOfVampires(); i++) {
            addVampire();
        }
    }

    public void addVampire(){
        if(nVampiresAdded < level.getNumberOfVampires()) {
            if (canAddVampire()) {
                int posX = initialVampirePosition(game.getDimY());
                
                if (!vampireList.vampireHere(posX, VampirePosY)) {
                    vampireList.addVampire(game, posX, VampirePosY);
                    nVampiresAdded++;
                }
            }
        }
    }


    public boolean addSlayer(int x, int y){
        if(!vampireList.vampireHere(x,y)){
            return slayerList.addSlayer(game,x,y);
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
        vampireList.removeDeadVampires();
        slayerList.removeDeadSlayers();
    }

    public int getRemainingVampires(){
        return Vampire.getVampiresRemaining();
    }

    public int getVampiresOnBoard(){
        return Vampire.getVampiresOnBoard();
    }

    public void attack() {
        vampireList.attack();
        slayerList.attack();
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
                }//for-1
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


    public boolean vampiresOnLeft(){
        return Vampire.onLeft();
    }


//    private void removeDead(GameElement[] gameElements){
//        for (int i = 0; i < nElements; i++) {
//            if(!gameElements[i].isAlive()){
//                gameElements[i].setAlive();
//                removeGameElements(i);
//                nElements--;
//            }
//        }
//    }


    private boolean isLeftFree(int x, int y){
        for (GameElement e: gameElements) {
            if(sameCoords(e.getPosX(), e.getPosY(), x, y-1)){
                return false;
            }
        }
        return true;
    }




}
