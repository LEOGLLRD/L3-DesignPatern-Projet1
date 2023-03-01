package org.example.echiquier;

import org.example.Pion.Observer;
import org.example.Pion.InterfacePion;
import org.example.Pion.ObserverPion;
import org.example.Pion.PionsConcrets.*;

import java.util.ArrayList;
import java.util.List;

public class Echiquier implements Observable {

    List<InterfacePion> observers = new ArrayList<>();

    InterfacePion[][] echiquierState = new InterfacePion[8][8];

    public Echiquier(){
        startGame();
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer instanceof InterfacePion) {
            this.observers.add((InterfacePion) observer);


        }

    }

    @Override
    public void deleteObserver(Observer observer) {
        if (observer instanceof InterfacePion) {
            this.observers.remove((InterfacePion) observer);
        }
    }

    @Override
    public void notifyAllObservers() {
        for (InterfacePion pion : this.observers
        ) {
            pion.refresh(this);
        }
    }

    public void startGame() {

        //Ajout des pions sur l'échiquier

        //Ajout des pions du haut
        //Ajout des tours
        echiquierState[0][0] = new Tour(0, 0);
        echiquierState[0][7] = new Tour(0, 7);
        //Ajout des cavaliers
        echiquierState[0][1] = new Cavalier(0, 1);
        echiquierState[0][6] = new Cavalier(0, 6);
        //Ajout des fous
        echiquierState[0][2] = new Fou(0, 2);
        echiquierState[0][5] = new Fou(0, 5);
        //Ajout Roi et Reine
        echiquierState[0][3] = new Roi(0, 3);
        echiquierState[0][4] = new Reine(0, 4);
        //Ajout des pions
        for (int i=0; i < echiquierState[1].length; i++){
            echiquierState[1][i] = new Pion(1, i);
        }

        //Ajout des pions du bas
        //Ajout des tours
        echiquierState[7][0] = new Tour(7, 0);
        echiquierState[7][7] = new Tour(7, 7);
        //Ajout des cavaliers
        echiquierState[7][1] = new Cavalier(7, 1);
        echiquierState[7][6] = new Cavalier(7, 6);
        //Ajout des fous
        echiquierState[7][2] = new Fou(7, 2);
        echiquierState[7][5] = new Fou(7, 5);
        //Ajout Roi et Reine
        echiquierState[7][4] = new Roi(7, 4);
        echiquierState[7][3] = new Reine(7, 3);
        //Ajout des pions
        for (int i=0; i < echiquierState[6].length; i++){
            echiquierState[6][i] = new Pion(6, i);
        }


        //Maintenant on parcourt le tableau pour ajouter tous les pions en observers

        for (int i = 0; i < echiquierState.length; i++) {
            for (int j = 0; j < echiquierState[i].length; j++) {
                //On ajoute les observers
                if (echiquierState[i][j] != null) {
                    this.addObserver(echiquierState[i][j]);
                }
                continue;
            }
        }

        //Enfin on les notifie pour qu'ils se mettent tous à jour de l'état de l'échiquier
        notifyAllObservers();



    }

    public InterfacePion[][] getEchiquierState() {
        return this.echiquierState;
    }

    @Override
    public String toString() {

        String s = "";

        for (int i = 0; i < echiquierState.length; i++) {
            s += "[";
            for (int j = 0; j < echiquierState[i].length; j++) {
                if (echiquierState[i][j] != null) {
                    s += "[" + echiquierState[i][j].toString() + echiquierState[i][j].posX + ":" + echiquierState[i][j].posY + "]";
                }continue;
            }
            s += "]\n";
        }

        return s;
    }
}
