package org.example.Pion.DeplacementStrategies;

import org.example.Pion.InterfacePion;

import java.util.Arrays;

public class DeplacementFou extends DeplacementStrategie {

    @Override
    public boolean[][] preview(InterfacePion[][] echiquierState, int x, int y, int team) {
        //On initialise toutes les positions disponibles à false
        boolean[][] available = new boolean[8][8];
        for (int i = 0; i < available.length; i++) {
            //Remplie la matrice avec la valeur false
            Arrays.fill(available[i], false);
        }

        //Un Fou peut se déplacer diagonalement temps qu'il ne rencontre pas de pion

        //Boolean servant à savoir si un déplacement doit être stoppé
        //Exemple : si topleft est à true, cela veut dire qu'on a rencontré un pion en se déplaçant vers le haut gauche,
        //donc on ne doit pas aller plus loin dans cette direction
        boolean topleft = false;
        boolean topright = false;
        boolean bottomleft = false;
        boolean bottomright = false;

        for (int i = 1; i < 7; i++) {

            //Déplacement haut gauche
            //Si on n'a pas encore rencontré de pion dans cette direction, on continue
            if (!topleft) {
                //Vérification si on ne sort pas de l'échiquier
                if (x - i >= 0) {
                    if (y - i >= 0) {
                        //Vérification s'il n'y a pas de pion
                        if (echiquierState[x - i][y - i] == null) {
                            available[x - i][y - i] = true;
                        }
                        //Vérification si on rencontre un pion allié
                        else if (echiquierState[x - i][y - i].team == team) {
                            topleft = true;
                        }
                        //Sinon vérification que le pion présent est de l'équipe adverse
                        else if (echiquierState[x - i][y - i].team != team) {
                            available[x - i][y - i] = true;
                            topleft = true;
                        }
                    }
                }
            }

            //Déplacement haut droit
            //Si on n'a pas encore rencontré de pion dans cette direction, on continue
            if (!topright) {
                //Vérification si on ne sort pas de l'échiquier
                if (x - i >= 0) {
                    if (y + i <= 7) {
                        //Vérification s'il n'y a pas de pion
                        if (echiquierState[x - i][y + i] == null) {
                            available[x - i][y + i] = true;
                        }
                        //Vérification si on rencontre un pion allié
                        else if (echiquierState[x - i][y + i].team == team) {
                            topright = true;
                        }
                        //Sinon vérification que le pion présent est de l'équipe adverse
                        else if (echiquierState[x - i][y + i].team != team) {
                            available[x - i][y + i] = true;
                            topright = true;
                        }
                    }
                }
            }

            //Déplacement bas gauche
            //Si on n'a pas encore rencontré de pion dans cette direction, on continue
            if (!bottomleft) {
                //Vérification si on ne sort pas de l'échiquier
                if (x + i <= 7) {
                    if (y - i >= 0) {
                        //Vérification s'il n'y a pas de pion
                        if (echiquierState[x + i][y - i] == null) {
                            available[x + i][y - i] = true;
                        }
                        //Vérification si on rencontre un pion allié
                        else if (echiquierState[x + i][y - i].team == team) {
                           bottomleft = true;
                        }
                        //Sinon vérification que le pion présent est de l'équipe adverse
                        else if (echiquierState[x + i][y - i].team != team) {
                            available[x + i][y - i] = true;
                            bottomleft = true;
                        }
                    }
                }
            }

            //Déplacement bas droit
            //Si on n'a pas encore rencontré de pion dans cette direction, on continue
            if (!bottomright) {
                //Vérification si on ne sort pas de l'échiquier
                if (x + i <= 7) {
                    if (y + i <= 7) {
                        //Vérification s'il n'y a pas de pion
                        if (echiquierState[x + i][y + i] == null) {
                            available[x + i][y + i] = true;
                        }
                        //Vérification si on rencontre un pion allié
                        else if (echiquierState[x + i][y + i].team == team) {
                            bottomright = true;
                        }
                        //Sinon vérification que le pion présent est de l'équipe adverse
                        else if (echiquierState[x + i][y + i].team != team) {
                            available[x + i][y + i] = true;
                            bottomright = true;
                        }
                    }
                }
            }

        }

        //On retire la position actuelle du pion dans les positions ou il peut se rendre
        available[x][y] = false;

        return available;
    }

}
