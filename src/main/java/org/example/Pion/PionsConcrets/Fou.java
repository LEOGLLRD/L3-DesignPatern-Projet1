package org.example.Pion.PionsConcrets;

import org.example.Pion.DeplacementStrategies.DeplacementFou;
import org.example.Pion.InterfacePion;

public class Fou extends InterfacePion {
    public Fou(int x, int y, int team) {
        super(x, y, team);
        this.deplacementStrategie = new DeplacementFou();
    }

    @Override
    public String toString() {
        return "---Fou--";
    }
}
