package org.example.Pion.DeplacementStrategies;

import org.example.Pion.InterfacePion;

import java.util.Arrays;

public class DeplacementPion implements DeplacementStrategie {

    boolean hasAlreadyPlayed = false;

    @Override
    public boolean[][] preview(InterfacePion[][] echiquierState, int x, int y, int team) {

        boolean[][] available = new boolean[8][8];
        for(int i = 0; i < available.length; i++){
            //Remplie la matrice avec la valeur false
            Arrays.fill(available[i], false);
        }



        //Si le pion n'a pas encore bougé, il peut avancer de deux

            if (team == 1) {
                //Verification que le pion n'est pas au bord
                if (x + (1) <= 8) {
                    available[x + 1][y] = true;
                }
            } else {
                //Verification que le pion n'est pas au bord
                if (x - 1 >= 0) {
                    available[x - 1][y] = true;
                }
            }


        if (!hasAlreadyPlayed){

            if (team == 1) {
                //Verification que le pion n'est pas au bord
                if (x + (2) <= 8) {
                    available[x + 2][y] = true;
                }
            } else {
                //Verification que le pion n'est pas au bord
                if (x - 2 >= 0) {
                    available[x - 2][y] = true;
                }
            }

        }
        return available;
    }

    @Override
    public void move(int i, int j) {

    }
}
