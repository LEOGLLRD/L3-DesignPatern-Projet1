package org.example.Pion.PionsConcrets.Fabrique;

import org.example.Pion.InterfacePion;
import org.example.Pion.PionsConcrets.*;

public class FabriquePion {

    //Méthode pour la fabriquation d'un pion
    public static InterfacePion getPion(String type, int x, int y, int team) {
        if (type.equals("Pion")) return new Pion(x, y, team);
        if (type.equals("Tour")) return new Tour(x, y, team);
        if (type.equals("Roi")) return new Roi(x, y, team);
        if (type.equals("Reine")) return new Reine(x, y, team);
        if (type.equals("Cavalier")) return new Cavalier(x, y, team);
        if (type.equals("Fou")) return new Fou(x, y, team);
        else return null;
    }
}
