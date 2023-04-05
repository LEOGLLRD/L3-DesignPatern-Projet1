package org.example.echiquier;

import org.example.Pion.Observer;
import org.example.Pion.InterfacePion;
import org.example.Pion.PionsConcrets.Fabrique.FabriquePion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Echiquier implements Observable {

    final int JOUEUR1 = 1;
    final int JOUEUR2 = 2;

    //Tableau des positions horizontales
    String[] posH = {"A", "B", "C", "D", "E", "F", "G", "H"};
    //Tableau des positions verticales
    String[] posV = {"1", "2", "3", "4", "5", "6", "7", "8"};

    //Liste de tous les observers
    List<InterfacePion> observers = new ArrayList<>();

    //Etat de l'échiquer, la position de tous les pions
    InterfacePion[][] echiquierState = new InterfacePion[8][8];

    static Echiquier single = null;


    protected Echiquier() {
        startGame();
    }

    public static synchronized Echiquier getInstance() {
        if (single == null) {
            single = new Echiquier();
        }
        return single;
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer instanceof InterfacePion) {
            this.observers.add((InterfacePion) observer);

        }

    }

    @Override
    public void deleteObserver(Observer observer) {
        if (observer instanceof InterfacePion) {
            this.observers.remove((InterfacePion) observer);
        }
    }

    @Override
    public void notifyAllObservers() {
        for (InterfacePion pion : this.observers
        ) {
            pion.refresh(this);
        }
    }

    //Méthode de lancement du jeu
    public void startGame() {

        //Ajout des pions sur l'échiquier

/////////////////////Ajout des pions du haut//////////////////////////
        //Ajout des tours
        echiquierState[0][0] = FabriquePion.getPion("Tour", 0, 0, JOUEUR1);
        echiquierState[0][7] = FabriquePion.getPion("Tour", 0, 7, JOUEUR1);
        //Ajout des cavaliers
        echiquierState[0][1] = FabriquePion.getPion("Cavalier", 0, 1, JOUEUR1);
        echiquierState[0][6] = FabriquePion.getPion("Cavalier", 0, 6, JOUEUR1);
        //Ajout des fous
        echiquierState[0][2] = FabriquePion.getPion("Fou", 0, 2, JOUEUR1);
        echiquierState[0][5] = FabriquePion.getPion("Fou", 0, 5, JOUEUR1);
        //Ajout Roi et Reine
        echiquierState[0][4] = FabriquePion.getPion("Roi", 0, 4, JOUEUR1);
        echiquierState[0][3] = FabriquePion.getPion("Reine", 0, 3, JOUEUR1);

        //Ajout des pions
        for (int i = 0; i < echiquierState[1].length; i++) {
            echiquierState[1][i] = FabriquePion.getPion("Pion", 1, i, JOUEUR1);
        }

//////////////////////////Ajout des pions du bas///////////////////////
        //Ajout des tours
        echiquierState[7][0] = FabriquePion.getPion("Tour", 7, 0, JOUEUR2);
        echiquierState[7][7] = FabriquePion.getPion("Tour", 7, 7, JOUEUR2);
        //Ajout des cavaliers
        echiquierState[7][1] = FabriquePion.getPion("Cavalier", 7, 1, JOUEUR2);
        echiquierState[7][6] = FabriquePion.getPion("Cavalier", 7, 6, JOUEUR2);
        //Ajout des fous
        echiquierState[7][2] = FabriquePion.getPion("Fou", 7, 2, JOUEUR2);
        echiquierState[7][5] = FabriquePion.getPion("Fou", 7, 5, JOUEUR2);
        //Ajout Roi et Reine
        echiquierState[7][4] = FabriquePion.getPion("Roi", 7, 4, JOUEUR2);
        echiquierState[7][3] = FabriquePion.getPion("Reine", 7, 3, JOUEUR2);

        //Ajout des pions
        for (int i = 0; i < echiquierState[6].length; i++) {
            echiquierState[6][i] = FabriquePion.getPion("Pion", 6, i, JOUEUR2);
        }


        //Maintenant, on parcourt le tableau pour ajouter tous les pions en observers

        for (int i = 0; i < echiquierState.length; i++) {
            for (int j = 0; j < echiquierState[i].length; j++) {
                //On ajoute les observers
                if (echiquierState[i][j] != null) {
                    this.addObserver(echiquierState[i][j]);
                }
            }
        }

        //Enfin, on les notifie pour qu'ils se mettent tous à jour de l'état de l'échiquier
        notifyAllObservers();

        //On instancie un Scanner
        Scanner sc = new Scanner(System.in);
        int player = 1;
        //Boucle de jeu
        while (true) {

            System.out.println("Joueur " + player + ", à vous de jouer : ");
            InterfacePion pion = null;
            String ans = "";
            boolean ansOk1 = false;
            //Demande au joueur 1 quel pion il veut jouer
            //On boucle tant que l'on n'obtient pas de réponse valide
            while (!ansOk1) {
                System.out.println(this.toString());
                System.out.println("Joueur " + player + ", choisissez le pion que vous voulez jouer : ");
                ans = sc.nextLine();
                //Vérification si la réponse est valide
                if (checkIfAnswerIsOK(ans)) {
                    //Conversion de la réponse en x,y
                    int x = Integer.parseInt(String.valueOf(ans.charAt(1))) - 1;
                    int y = convertPosH(String.valueOf(ans.charAt(0)));
                    System.out.println("Vous avez choisi la position : (" + x + ", " + y + ")");
                    //Vérification si le joueur possède un pion à cette position
                    pion = echiquierState[x][y];
                    System.out.println("pion : " + pion.toString());
                    System.out.println("echiquier du pion : \n" + pion.echiquier.toString());
                    if (pion.team != player) {
                        System.out.println("Aucun pion vous appartenant n'est à cette position !");
                    } else {
                        ansOk1 = true;
                    }


                } else {
                    System.out.println("Vous n'avez pas bien préciser votre pion");
                }

            }

            //Récupération des déplacements possibles
            boolean[][] deplacementsPossibles = pion.deplacementStrategie.preview(echiquierState, pion.posX, pion.posY, pion.team);
            displayEchiquierTypeArray(deplacementsPossibles);

            String ans2 = "";
            boolean ansOk2 = false;
            //Demande au joueur 1 ou il veut déplacer son pion
            //On boucle tant que l'on n'obtient pas de réponse valide
            while (!ansOk2) {
                System.out.println("Joueur " + player + ", choisissez maintenant ou vous voulez jouer : ");
                ans = sc.nextLine();
                //Vérification si la réponse est valide
                if (checkIfAnswerIsOK(ans)) {
                    //Conversion de la réponse en x,y
                    int x = Integer.parseInt(String.valueOf(ans.charAt(1))) - 1;
                    int y = convertPosH(String.valueOf(ans.charAt(0)));
                    //Vérification le déplacement a été réalisé
                    if (movePion(pion, x, y)) {
                        System.out.println("Déplacement Réalisé !");
                        ansOk2 = true;
                    } else {
                        System.out.println("Vous ne pouvez bouger votre pion ici !");
                    }

                } else {
                    System.out.println("Vous n'avez pas bien préciser votre déplacement");
                }

            }

            if (ansOk1 && ansOk2) {
                player = togglePlayer(player);
            }


        }

    }

    //Converti la position horizontale en integer
    public int convertPosH(String c) {
        switch (c) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            case "E":
                return 4;
            case "F":
                return 5;
            case "G":
                return 6;
            case "H":
                return 7;
            default:
                return -1;
        }
    }

    //Vérifie si un caractère est contenu dans le tableau des positions verticales
    public boolean checkIfCharInPosV(String c) {
        for (int i = 0; i < posV.length; i++) {
            if (c.equals(posV[i])) return true;
        }
        return false;
    }

    //Vérifie si un caractère est contenu dans le tableau des positions horizontales
    public boolean checkIfCharInPosH(String c) {
        for (int i = 0; i < posH.length; i++) {
            if (c.equals(posH[i])) return true;
        }
        return false;
    }

    //Retourne l'état actuel de l'échiquier, la position de tous les pions
    public InterfacePion[][] getEchiquierState() {
        return this.echiquierState;
    }

    //Méthode d'affichage de l'échiquier
    @Override
    public String toString() {

        String s = "";

        s += "\t\t[-----A----]\t\t";
        s += "\t\t[-----B----]\t\t";
        s += "\t\t[-----C----]\t\t";
        s += "\t\t[-----D----]\t\t";
        s += "\t\t[-----E----]\t\t";
        s += "\t\t[-----F----]\t\t";
        s += "\t\t[-----G----]\t\t";
        s += "\t\t[-----H----]\t\t\n";
        for (int i = 0; i < echiquierState.length; i++) {
            s += (i + 1) + "[";
            for (int j = 0; j < echiquierState[i].length; j++) {
                if (echiquierState[i][j] != null) {
                    s += "\t\t[" + echiquierState[i][j].toString() + ":" + echiquierState[i][j].team + "]\t\t";
                }
                else {
                    s += "\t\t[---null---]\t\t";
                }
            }
            s += "]" + (i + 1) + "\n";
        }

        return s;
    }

    //Méthode qui vérifie si la réponse pour le déplacement est valide
    public boolean checkIfAnswerIsOK(String ans) {
        //Vérification qu'il y a bien deux caractères
        if (ans.length() != 2) return false;
        //Vérification si les deux caractères sont valides
        return checkIfCharInPosH(String.valueOf(Character.toUpperCase(ans.charAt(0)))) && checkIfCharInPosV(String.valueOf(Character.toUpperCase(ans.charAt(1))));
    }

    //Permet de permutter les joueurs
    public int togglePlayer(int i) {
        if (i == 1) return 2;
        else return 1;
    }

    public static void displayEchiquierTypeArray(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    //Méthode qui déplace un pion vers une position (x,y)
    //Retourne vrai si succès
    //Retourne faux si déplacement impossible
    public boolean movePion(InterfacePion pion, int x, int y) {
        //Récupération des déplacements possibles
        boolean[][] deplacementsPossibles = pion.deplacementStrategie.preview(echiquierState, pion.posX, pion.posY, pion.team);

        //Vérification le déplacement est possible
        if (deplacementsPossibles[x][y]) {
            //Si le déplacement est réalisé à un endroit où il y a un pion
            if (echiquierState[x][y] != null) {
                //On retire le pion qui doit être supprimé des observateurs
                observers.remove(echiquierState[x][y]);
            }
            //On retire le pion courant de sa position actuelle
            echiquierState[pion.posX][pion.posY] = null;
            //Et on déplace le pion courant à sa nouvelle position
            echiquierState[x][y] = pion;
            //Enfin, on notifie tous les observateurs du changement, et retourne vrai
            notifyAllObservers();
            return true;

        }
        return false;

    }
}
