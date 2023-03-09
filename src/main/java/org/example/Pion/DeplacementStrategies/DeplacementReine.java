package org.example.Pion.DeplacementStrategies;

import org.example.Pion.InterfacePion;

import java.util.Arrays;

public class DeplacementReine implements DeplacementStrategie{

    @Override
    public boolean[][] preview(InterfacePion[][] echiquierState, int x, int y, int team) {

        //On initialise toutes les positions disponibles à false
        boolean[][] available = new boolean[8][8];
        for (int i = 0; i < available.length; i++) {
            //Remplie la matrice avec la valeur false
            Arrays.fill(available[i], false);
        }
        //Une Reine se déplace comme une Tour et un Fou

        //Gestion déplacement Tour
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

        //Gestion déplacement Fou
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

    @Override
    public boolean move(int i, int j) {

        return false;
    }
}
