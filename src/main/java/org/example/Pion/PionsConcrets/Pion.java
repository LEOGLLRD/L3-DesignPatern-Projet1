package org.example.Pion.PionsConcrets;

import org.example.Pion.DeplacementStrategies.DeplacementPion;
import org.example.Pion.InterfacePion;

public class Pion extends InterfacePion {

    public Pion(int posX, int posY) {
        super(posX, posY);
        this.deplacementStrategie = new DeplacementPion();
    }
}
