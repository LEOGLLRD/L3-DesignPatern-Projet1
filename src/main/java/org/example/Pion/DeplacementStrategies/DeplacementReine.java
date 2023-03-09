package org.example.Pion.DeplacementStrategies;

import org.example.Pion.InterfacePion;

public class DeplacementReine implements DeplacementStrategie{

    @Override
    public boolean[][] preview(InterfacePion[][] echiquierState, int x, int y, int team) {

        //Une Reine se déplace comme une Tour et un Fou

        return null;
    }

    @Override
    public boolean move(int i, int j) {

        return false;
    }
}
