package org.example.echiquier;

import org.example.Pion.Observer;

public interface Observable {

    //Méthode d'ajout d'un nouvel observer
    public void addObserver(Observer observer);

    //Méthode de suppression d'un observer
    public void deleteObserver(Observer observer);

    //Méthode d'appel à la mise à jour des observers
    public void notifyAllObservers();
}
