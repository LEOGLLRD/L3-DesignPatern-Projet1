package org.example.Pion;

import org.example.Pion.DeplacementStrategies.DeplacementStrategie;
import org.example.echiquier.Echiquier;
import org.example.echiquier.Observable;

import java.awt.*;

public abstract class InterfacePion extends ObserverPion {

    //Position du pion
    public int posX;
    public int posY;
    //Stratégie de Déplacement
    protected DeplacementStrategie deplacementStrategie;
    //1 pour equipe 1, et 2 pour equipe 2
    int team;

    InterfacePion[][] echiquierState;


    public InterfacePion(int x, int y) {
        this.setPos(x, y);
    }


    //Donne la couleur du pion en fonction de l'équipe
    Color getColor() {
        if (this.team == 1) {
            return Color.white;
        } else {
            return Color.black;
        }
    }

    //Donne au pion sa position
    public void setPos(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    //Modifie l'état courant de l'échiquier
    public void setEchiquierState(InterfacePion[][] echiquierState) {
        this.echiquierState = echiquierState;
    }

    @Override
    public void refresh(Observable observable) {
        if (observable instanceof Echiquier) {
            this.echiquier = (Echiquier) observable;
            setEchiquierState(this.echiquier.getEchiquierState());
        }
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
