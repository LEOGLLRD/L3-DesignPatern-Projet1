package org.example.Pion.PionsConcrets;

import org.example.Pion.DeplacementStrategies.DeplacementPion;
import org.example.Pion.InterfacePion;

public class Pion extends InterfacePion {

    public Pion(int posX, int posY, int team) {
        super(posX, posY, team);
        this.deplacementStrategie = new DeplacementPion();
    }

    @Override
    public String toString() {
        return "--Pion--";
    }
}
