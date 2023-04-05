package org.example.Pion.PionsConcrets;

import org.example.Pion.DeplacementStrategies.DeplacementRoi;
import org.example.Pion.InterfacePion;

public class Roi extends InterfacePion {
    public Roi(int x, int y, int team) {
        super(x, y, team);
        this.deplacementStrategie = new DeplacementRoi();

    }
    @Override
    public String toString() {
        return "---Roi--";
    }

}
