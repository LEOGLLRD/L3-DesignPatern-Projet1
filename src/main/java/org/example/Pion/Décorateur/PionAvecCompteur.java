package org.example.Pion.Décorateur;

import org.example.Pion.InterfacePion;

public class PionAvecCompteur extends DecorateurPion {

    int pionsMange = 0;

    public PionAvecCompteur(InterfacePion pion) {
        super(pion);
    }


    public void incrPionsMange() {
        pionsMange++;
    }

    public int getPionsMange() {
        return pionsMange;
    }

    @Override
    public String toString() {
        return pion.toString();
    }
}
