package org.example.Pion.DeplacementStrategies;

import org.example.Pion.InterfacePion;

import java.util.Arrays;

public class DeplacementRoi implements DeplacementStrategie {


    @Override
    public boolean[][] preview(InterfacePion[][] echiquierState, int x, int y, int team) {

        //On initialise toutes les positions disponibles à false
        boolean[][] available = new boolean[8][8];
        for (int i = 0; i < available.length; i++) {
            //Remplie la matrice avec la valeur false
            Arrays.fill(available[i], false);
        }

        //Un Roi peut se déplacer d'une case dans toutes les directions autour de lui
        //On a donc 7 vérifications à faire

        //Vérification pour le déplacement vers les 3 cases du dessus
        if (x - 1 >= 0) {
            //Vérification pour la case au-dessus à gauche
            if (y - 1 >= 0) {
                //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
                if (echiquierState[x - 1][y - 1] == null) {
                    available[x - 1][y - 1] = true;
                } else if (echiquierState[x - 1][y - 1].team != team) {
                    available[x - 1][y - 1] = true;
                }
            }
            //Vérification pour la case au-dessus au milieu
            //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
            if (echiquierState[x - 1][y] == null) {
                available[x - 1][y] = true;
            } else if (echiquierState[x - 1][y].team != team) {
                available[x - 1][y] = true;
            }

            //Vérification pour la case au-dessus à droite
            if (y + 1 <= 7) {
                //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
                if (echiquierState[x - 1][y + 1] == null) {
                    available[x - 1][y + 1] = true;
                } else if (echiquierState[x - 1][y + 1].team != team) {
                    available[x - 1][y + 1] = true;
                }
            }

        }

        //Vérification pour le déplacement sur les côtés sur le même axe horizontal que la position actuelle
        //Vérification pour la case juste à gauche
        if (y - 1 >= 0) {
            //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
            if (echiquierState[x][y - 1] == null) {
                available[x][y - 1] = true;
            } else if (echiquierState[x][y - 1].team != team) {
                available[x][y - 1] = true;
            }
        }
        //Vérification pour la case juste à droite
        if (y + 1 <= 7) {
            //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
            if (echiquierState[x][y + 1] == null) {
                available[x][y + 1] = true;
            } else if (echiquierState[x][y + 1].team != team) {
                available[x][y + 1] = true;
            }
        }

        //Vérification pour le déplacement vers les 3 cases en dessous
        if (x + 1 <= 7) {
            //Vérification pour la case au-dessus à gauche
            if (y - 1 >= 0) {
                //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
                if (echiquierState[x + 1][y - 1] == null) {
                    available[x + 1][y - 1] = true;
                } else if (echiquierState[x + 1][y - 1].team != team) {
                    available[x + 1][y - 1] = true;
                }
            }
            //Vérification pour la case au-dessus au milieu
            //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
            if (echiquierState[x + 1][y] == null) {
                available[x + 1][y] = true;
            } else if (echiquierState[x + 1][y].team != team) {
                available[x + 1][y] = true;
            }

            //Vérification pour la case au-dessus à droite
            if (y + 1 <= 7) {
                //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
                if (echiquierState[x + 1][y + 1] == null) {
                    available[x + 1][y + 1] = true;
                } else if (echiquierState[x - 1][y + 1].team != team) {
                    available[x + 1][y + 1] = true;
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
