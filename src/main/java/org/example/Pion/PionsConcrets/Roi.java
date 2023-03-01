package org.example.Pion.PionsConcrets;

import org.example.Pion.DeplacementStrategies.DeplacementRoi;
import org.example.Pion.InterfacePion;

public class Roi extends InterfacePion {
    public Roi(int x, int y) {
        super(x, y);
        this.deplacementStrategie = new DeplacementRoi();

    }
}
