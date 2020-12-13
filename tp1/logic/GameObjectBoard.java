package tp1.logic;

import tp1.gameElements.*;
import tp1.gameElements.Attackers.Dracula;
import tp1.gameElements.Attackers.ExplosiveVampire;
import tp1.gameElements.Attackers.Vampire;
import tp1.gameElements.Defenders.BloodBank;
import tp1.gameElements.Defenders.Slayer;

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


    public boolean addVampire(int x, int y){
        if(nVampiresAdded < level.getNumberOfVampires()) {
            if (!elementHere(x, y) && !outOfBounds(game.getDimX(), y)) {
                gameElements.add(new Vampire(game, x, y));
                nVampiresAdded++;
                return true;
            }
        }
        return false;
    }

    public boolean addDracula(int x, int y){
        if(nVampiresAdded < level.getNumberOfVampires()) {
            if (!elementHere(x, y) && !outOfBounds(game.getDimX(), y) && !Dracula.draculaRise) {
                gameElements.add(new Dracula(game, x, y));
                nVampiresAdded++;
                return true;
            }
        }
        return false;
    }

    public boolean addExplosiveVampire(int x, int y){
        if(nVampiresAdded < level.getNumberOfVampires()) {
            if (!elementHere(x, y) && !outOfBounds(game.getDimX(), y)) {
                gameElements.add(new ExplosiveVampire(game, x, y));
                nVampiresAdded++;
                return true;
            }
        }
        return false;
    }



    public void addVampire(){
        if(nVampiresAdded < level.getNumberOfVampires()) {

            //Adding Regular Vampire
            if (canAddVampire()) {
                int posX = initialVampirePosition(game.getDimY());
                if (!elementHere(posX, VampirePosY)) {
                    gameElements.add(new Vampire(game, posX, VampirePosY));
                    nVampiresAdded++;
                }//if-3
            }//if-2
        }

        if(nVampiresAdded < level.getNumberOfVampires()) {
            //Adding Dracula
            if (canAddVampire() && !Dracula.draculaRise) {
                int posX = initialVampirePosition(game.getDimY());
                if (!elementHere(posX, VampirePosY)) {
                    gameElements.add(new Dracula(game, posX, VampirePosY));
                    nVampiresAdded++;
                }//if-3
            }//if-2
        }

        if(nVampiresAdded < level.getNumberOfVampires()) {
            //Adding Explosive Vampire
            if (canAddVampire()) {
                int posX = initialVampirePosition(game.getDimY());
                if (!elementHere(posX, VampirePosY)) {
                    gameElements.add(new ExplosiveVampire(game, posX, VampirePosY));
                    nVampiresAdded++;
                }//if-3
            }//if-2
        }

    }


    public boolean addSlayer(int x, int y){
        if(!elementHere(x,y) && !outOfBounds(game.getDimX(), y)){
            gameElements.add(new Slayer(game,x,y));
            return true;
        }
        return false;
    }

    public boolean addBloodBank(int x, int y, int cost){
        if(!elementHere(x,y) && !outOfBounds(game.getDimX(), y)){
            gameElements.add(new BloodBank(game,x,y,cost));
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

    public void income(){
        for (GameElement e : gameElements) {
            e.generateIncome();
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

    public void lightFlashAttack(){
        for (GameElement e: gameElements) {
            e.receiveLightFlashAttack();
        }
    }

    public void garlicPushAttack(){
        for (GameElement e: gameElements) {
            e.receiveGarlicPush();
        }
    }


    public void explosionDamage(int posX, int posY){
        for (int i = posX - 1; i <= posX + 1; i++) {
            for (int j = posY - 1; j <= posY + 1; j++) {
                GameElement e = getElement(i,j);
                if(e != null) e.receiveExplosion();
            }//for-2
        }//for-1
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
