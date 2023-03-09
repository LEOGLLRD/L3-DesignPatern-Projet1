package org.example.Pion.DeplacementStrategies;

import org.example.Pion.InterfacePion;
import org.example.Pion.ObserverPion;

public interface DeplacementStrategie {


    //Methode prenant en entrée l'état de l'échiquier, ainsi que les coordonnées de la pièce courante
    //Retournant les différentes cases ou peut se rendre la pièce courante,
    //sous forme d'un tableau de boolean, une position sera false si on ne peut pas s'y rendre,
    //et true si à l'inverse, on peut

    //echiquier : Position de toutes les pièces
    //x : position sur l'axe vertical
    //y : position sur l'axz horizontal
    //team : équipe du pion

    boolean[][] preview(InterfacePion[][] echiquierState, int x, int y, int team);

    //Méthode pour déplacer le pion à une nouvelle position.
    //Retourne faux si le pion a pu être déplacé, faux sinon.
    boolean move(int i, int j);



}
