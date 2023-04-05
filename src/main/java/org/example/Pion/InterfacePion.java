package org.example.Pion;

import org.example.Pion.DeplacementStrategies.DeplacementStrategie;
import org.example.echiquier.Echiquier;
import org.example.echiquier.Observable;

import java.awt.*;

public abstract class InterfacePion extends ObserverPion {

    //Position du pion
    public int posX; // deplacement vertical
    public int posY; // deplacement horizontal

    public DeplacementStrategie deplacementStrategie; // Stratégie de Déplacement

    public int team; // 1 pour equipe du haut, et 2 pour equipe du bas

    public InterfacePion[][] echiquierState;


    protected InterfacePion(int x, int y, int team) {
        this.setPos(x, y);
        this.team = team;
    }


    //Donne la couleur du pion en fonction de l'équipe
    public Color getColor() {
        if (this.team == 1) {
            return Color.white;
        } else {
            return Color.black;
        }
    }

    //Permet de modifier la position du pion
    public void setPos(int x, int y) {
        this.posX = x;
        this.posY = y;
    }

    //Modifie l'état courant de l'échiquier
    public void setEchiquierState(InterfacePion[][] echiquierState) {
        this.echiquierState = echiquierState;
    }

    //Ordonne au pion de se mettre jour via son Observable
    @Override
    public void refresh(Observable observable) {
        if (observable instanceof Echiquier) {
            this.echiquier = (Echiquier) observable;
            setEchiquierState(this.echiquier.getEchiquierState());
        }
    }

    //Retourne le nom de la classe
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
