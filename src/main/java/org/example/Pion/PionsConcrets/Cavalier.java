package org.example.Pion.PionsConcrets;

import org.example.Pion.DeplacementStrategies.DeplacementCavalier;
import org.example.Pion.InterfacePion;

public class Cavalier extends InterfacePion {


    public Cavalier(int x, int y, int team) {
        super(x, y, team);
        this.deplacementStrategie = new DeplacementCavalier();
    }
}
