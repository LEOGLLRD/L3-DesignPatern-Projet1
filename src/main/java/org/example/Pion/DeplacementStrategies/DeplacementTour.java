package org.example.Pion.DeplacementStrategies;

import org.example.Pion.InterfacePion;

import java.util.Arrays;

public class DeplacementTour implements DeplacementStrategie {

    @Override
    public boolean[][] preview(InterfacePion[][] echiquierState, int x, int y, int team) {
        //On initialise toutes les positions disponibles à false
        boolean[][] available = new boolean[8][8];
        for (int i = 0; i < available.length; i++) {
            //Remplie la matrice avec la valeur false
            Arrays.fill(available[i], false);
        }

        //Une Tour peut se déplacer verticalement ou horizontalement temps qu'elle ne rencontre rien

        //Boolean servant à savoir si un déplacement doit être stoppé
        //Exemple : si top est à true, cela veut dire qu'on a rencontré un pion en se déplaçant vers le haut,
        //donc on ne doit pas aller plus loin dans cette direction
        boolean top = false;
        boolean right = false;
        boolean left = false;
        boolean bottom = false;

        for (int i = 0; i < 7; i++) {

            //Vérification que l'on n'a pas déjà rencontré un pion en se déplaçant vers le haut
            if (!top) {
                //Vérification si on ne sort pas de l'échiquier
                if (x - i >= 0) {
                    //Vérification s'il n'y a pas de pion
                    if (echiquierState[x - i][y] == null) {
                        available[x - i][y] = true;
                    }
                    //Sinon vérification que le pion présent est de l'équipe adverse
                    else if (echiquierState[x - i][y].team != team) {
                        available[x - i][y] = true;
                        top = true;
                    }
                }
            }
            //Vérification que l'on n'a pas déjà rencontré un pion en se déplaçant vers la gauche
            if (!left) {
                //Vérification si on ne sort pas de l'échiquier
                if (y - i >= 0) {
                    //Vérification s'il n'y a pas de pion
                    if (echiquierState[x][y - i] == null) {
                        available[x][y - i] = true;
                    }
                    //Sinon vérification que le pion présent est de l'équipe adverse
                    else if (echiquierState[x][y - i].team != team) {
                        available[x][y - i] = true;
                        left = true;
                    }
                }
            }
            //Vérification que l'on n'a pas déjà rencontré un pion en se déplaçant vers la droite
            if (!right) {
                //Vérification si on ne sort pas de l'échiquier
                if (y + i <= 7) {
                    //Vérification s'il n'y a pas de pion
                    if (echiquierState[x][y + i] == null) {
                        available[x][y + i] = true;
                    }
                    //Sinon vérification que le pion présent est de l'équipe adverse
                    else if (echiquierState[x][y + i].team != team) {
                        available[x][y + i] = true;
                        right = true;
                    }
                }
            }
            //Vérification que l'on n'a pas déjà rencontré un pion en se déplaçant vers le bas
            if (!bottom) {
                //Vérification si on ne sort pas de l'échiquier
                if (x + i <= 7) {
                    //Vérification s'il n'y a pas de pion
                    if (echiquierState[x + i][y] == null) {
                        available[x + i][y] = true;
                    }
                    //Sinon vérification que le pion présent est de l'équipe adverse
                    else if (echiquierState[x + i][y].team != team) {
                        available[x + i][y] = true;
                        bottom = true;
                    }
                }
            }


        }

        //On retire la position actuelle du pion dans les positions ou il peut se rendre
        available[x][y] = false;

        return available;
    }

    @Override
    public boolean move(int i, int j) {


        return false;
    }
}
