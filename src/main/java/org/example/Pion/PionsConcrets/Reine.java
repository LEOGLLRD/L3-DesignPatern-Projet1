package org.example.Pion.PionsConcrets;

import org.example.Pion.DeplacementStrategies.DeplacementReine;
import org.example.Pion.InterfacePion;

public class Reine extends InterfacePion {
    public Reine(int x, int y, int team) {
        super(x, y, team);
        this.deplacementStrategie = new DeplacementReine();
    }
    @Override
    public String toString() {
        return "--Reine-";
    }
}
