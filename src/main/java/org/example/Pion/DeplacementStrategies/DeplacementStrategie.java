package org.example.Pion.DeplacementStrategies;

import org.example.Pion.InterfacePion;
import org.example.Pion.ObserverPion;

public interface DeplacementStrategie {


    //Methode prenant en entrée l'état de l'échiquier, ainsi que les coordonnées de la pièce courante
    //Retournant les différentes cases ou peut se rendre la pièce courante
    InterfacePion[][] preview(InterfacePion[][] echiquierState, int x, int y);

    void move(int i, int j);



}
