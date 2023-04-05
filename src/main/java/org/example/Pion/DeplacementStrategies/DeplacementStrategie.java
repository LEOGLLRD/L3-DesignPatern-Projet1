package org.example.Pion.DeplacementStrategies;

import org.example.Pion.InterfacePion;
import org.example.Pion.ObserverPion;

public abstract class DeplacementStrategie {


    //Methode prenant en entrée l'état de l'échiquier, ainsi que les coordonnées de la pièce courante
    //Retournant les différentes cases ou peut se rendre la pièce courante,
    //sous forme d'un tableau de boolean, une position sera false si on ne peut pas s'y rendre,
    //et true si à l'inverse, on peut

    //echiquier : Position de toutes les pièces
    //x : position sur l'axe vertical
    //y : position sur l'axz horizontal
    //team : équipe du pion

    public abstract boolean[][] preview(InterfacePion[][] echiquierState, int x, int y, int team);




}
