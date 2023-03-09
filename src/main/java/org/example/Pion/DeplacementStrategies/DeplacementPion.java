package org.example.Pion.DeplacementStrategies;

import org.example.Pion.InterfacePion;

import java.util.Arrays;

public class DeplacementPion implements DeplacementStrategie {

    boolean hasAlreadyPlayed = false;

    @Override
    public boolean[][] preview(InterfacePion[][] echiquierState, int x, int y, int team) {

        //On initialise toutes les positions disponibles à false
        boolean[][] available = new boolean[8][8];
        for (int i = 0; i < available.length; i++) {
            //Remplie la matrice avec la valeur false
            Arrays.fill(available[i], false);
        }



        if (team == 1) {
            //Verification que le pion n'est pas au bord
            if (x + (1) <= 7) {
                //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
                if (echiquierState[x + 1][y] == null) {
                    available[x + 1][y] = true;
                } else if (echiquierState[x + 1][y].team != team) {
                    available[x + 1][y] = true;
                }
            }
        } else {
            //Verification que le pion n'est pas au bord
            if (x - 1 >= 0) {
                //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
                if (echiquierState[x - 1][y] == null) {
                    available[x - 1][y] = true;
                } else if (echiquierState[x - 1][y].team != team) {
                    available[x - 1][y] = true;
                }
            }
        }

        //Si le pion n'a pas encore bougé, il peut avancer de deux
        if (!hasAlreadyPlayed) {

            if (team == 1) {
                //Verification que le pion n'est pas au bord
                //Verification que le pion n'est pas au bord
                if (x + (2) <= 7) {
                    //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
                    if (echiquierState[x + 2][y] == null) {
                        available[x + 2][y] = true;
                    } else if (echiquierState[x + 2][y].team != team) {
                        available[x + 2][y] = true;
                    }
                }
            } else {
                //Verification que le pion n'est pas au bord
                if (x - 2 >= 0) {
                    //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
                    if (echiquierState[x - 2][y] == null) {
                        available[x - 2][y] = true;
                    } else if (echiquierState[x - 2][y].team != team) {
                        available[x - 2][y] = true;
                    }
                }
            }

        }
        return available;
    }

    @Override
    public boolean move(int i, int j) {

        return false;
    }
}
