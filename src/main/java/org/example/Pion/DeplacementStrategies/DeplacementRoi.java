package org.example.Pion.DeplacementStrategies;

import org.example.Pion.InterfacePion;

public class DeplacementRoi implements DeplacementStrategie{


    @Override
    public InterfacePion[][] preview(InterfacePion[][] echiquierState, int x, int y) {
        return new InterfacePion[0][];
    }

    @Override
    public void move(int i, int j) {

    }

}
