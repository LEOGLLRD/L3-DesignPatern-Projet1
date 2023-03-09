package org.example.Pion.DeplacementStrategies;

import org.example.Pion.InterfacePion;

import java.util.Arrays;

public class DeplacementTour implements DeplacementStrategie{

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

        for (int i = 0; i < 7; i++){

            //Vérification que l'on n'a pas déjà rencontré un pion
            if(!top){

            }

            if (!left){

            }


        }


        //Déplacement vertical vers le bas :

        for(int i = x; i < 7; i++){
            //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
            if(echiquierState[i][y] == null){
                available[i][y] = true;
            }
            //S'il y a un pion adverse, on compte la position comme accessible mais on quitte la boucle
            else if(echiquierState[i][y].team != team){
                available[i][y] = true;
                break;
            }

        }
        //Déplacement vertical vers le haut :

        for(int i = x; i > 0; i--){
            //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
            if(echiquierState[i][y] == null){
                available[i][y] = true;
            }
            //S'il y a un pion adverse, on compte la position comme accessible mais on quitte la boucle
            else if(echiquierState[i][y].team != team){
                available[i][y] = true;
                break;
            }

        }

        //Déplacement horizontal vers la gauche :

        for(int i = y; i > 0; i--){
            //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
            if(echiquierState[x][i] == null){
                available[x][i] = true;
            }
            //S'il y a un pion adverse, on compte la position comme accessible mais on quitte la boucle
            else if(echiquierState[x][i].team != team){
                available[x][i] = true;
                break;
            }

        }

        //Déplacement horizontal vers la droite :

        for(int i = y; i < 7; i++){
            //Vérification qu'il n'y a pas un pion allié sur le chemin, ou que la case est vide
            if(echiquierState[x][i] == null){
                available[x][i] = true;
            }
            //S'il y a un pion adverse, on compte la position comme accessible mais on quitte la boucle
            else if(echiquierState[x][i].team != team){
                available[x][i] = true;
                break;
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
