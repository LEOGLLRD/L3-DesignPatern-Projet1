package org.example.Pion.Décorateur;

import org.example.Pion.InterfacePion;

public abstract class DecorateurPion extends InterfacePion {
    public InterfacePion pion;
    public InterfacePion[][] echiquierState;


    public DecorateurPion(InterfacePion pion) {
        super(pion.posX, pion.posY, pion.team);
        this.pion = pion;
        this.deplacementStrategie = pion.deplacementStrategie;
        this.echiquierState = pion.echiquierState;
    }



}
