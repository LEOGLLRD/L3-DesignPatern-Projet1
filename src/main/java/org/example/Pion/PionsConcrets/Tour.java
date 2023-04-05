package org.example.Pion.PionsConcrets;

import org.example.Pion.DeplacementStrategies.DeplacementTour;
import org.example.Pion.InterfacePion;

public class Tour extends InterfacePion {
    public Tour(int x, int y, int team){
        super(x, y, team);
        this.deplacementStrategie = new DeplacementTour();
    }
    @Override
    public String toString() {
        return "--Tour--";
    }
}
