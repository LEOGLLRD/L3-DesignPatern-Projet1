package org.example.Pion.DeplacementStrategies;

import org.example.Pion.InterfacePion;

import java.util.Arrays;

public class DeplacementCavalier extends DeplacementStrategie {

    @Override
    public boolean[][] preview(InterfacePion[][] echiquierState, int x, int y, int team) {
        //On initialise toutes les positions disponibles à false
        boolean[][] available = new boolean[8][8];
        for (int i = 0; i < available.length; i++) {
            //Remplie la matrice avec la valeur false
            Arrays.fill(available[i], false);
        }

        //Un cavalier peut se déplacer en (x-1; y-2), (x-2; y-1), (x-2; y+1), (x-1; y+2), ||||| (x+1; y-2), (x+2; y-1), (x+2; y+1), (x+1; y+2)
        //On a donc 7 positions à vérifier

        //On vérifie pour tous les x-1

        if (x - 1 >= 0) {
            //On vérifie pour (x-1; y-2)
            if (y - 2 >= 0) {
                //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
                if (echiquierState[x - 1][y - 2] == null) {
                    available[x - 1][y - 2] = true;
                } else if (echiquierState[x - 1][y - 2].team != team) {
                    available[x - 1][y - 2] = true;
                }
            }
            //On vérifie pour (x-1; y+2)
            if (y + 2 <= 7) {
                //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
                if (echiquierState[x - 1][y + 2] == null) {
                    available[x - 1][y + 2] = true;
                } else if (echiquierState[x - 1][y + 2].team != team) {
                    available[x - 1][y + 2] = true;
                }
            }
        }

        //On vérifie pour tous les x-2

        if (x - 2 >= 0) {
            //On vérifie pour (x-2; y-1)
            if (y - 1 >= 0) {
                //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
                if (echiquierState[x - 2][y - 1] == null) {
                    available[x - 2][y - 1] = true;
                } else if (echiquierState[x - 2][y - 1].team != team) {
                    available[x - 2][y - 1] = true;
                }
            }
            //On vérifie pour (x-2; y+1)
            if (y + 1 <= 7) {
                //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
                if (echiquierState[x - 2][y + 1] == null) {
                    available[x - 2][y + 1] = true;
                } else if (echiquierState[x - 2][y + 1].team != team) {
                    available[x - 2][y + 1] = true;
                }
            }
        }

        //On vérifie pour tous les x+1

        if (x + 1 <= 7) {
            //On vérifie pour (x+1; y-2)
            if (y - 2 >= 0) {
                //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
                if (echiquierState[x + 1][y - 2] == null) {
                    available[x + 1][y - 2] = true;
                } else if (echiquierState[x + 1][y - 2].team != team) {
                    available[x + 1][y - 2] = true;
                }
            }
            //On vérifie pour (x+1; y+2)
            if (y + 2 <= 7) {
                //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
                if (echiquierState[x + 1][y + 2] == null) {
                    available[x + 1][y + 2] = true;
                } else if (echiquierState[x + 1][y + 2].team != team) {
                    available[x + 1][y + 2] = true;
                }
            }
        }

        //On vérifie pour tous les x+2

        if (x + 2 <= 7) {
            //On vérifie pour (x+2; y-1)
            if (y - 1 >= 0) {
                //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
                if (echiquierState[x + 2][y - 1] == null) {
                    available[x + 2][y - 1] = true;
                } else if (echiquierState[x + 2][y - 1].team != team) {
                    available[x + 2][y - 1] = true;
                }
            }
            //On vérifie pour (x+2; y+1)
            if (y + 1 <= 7) {
                //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
                if (echiquierState[x + 2][y + 1] == null) {
                    available[x + 2][y + 1] = true;
                } else if (echiquierState[x + 2][y + 1].team != team) {
                    available[x + 2][y + 1] = true;
                }
            }
        }

        return available;
    }
}
