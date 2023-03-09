package org.example;

import org.example.echiquier.Echiquier;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Echiquier echiquier = new Echiquier();
        System.out.println(echiquier.toString());
        System.out.println(echiquier.getEchiquierState()[1][0].toString());
        System.out.println(Arrays.deepToString(echiquier.getEchiquierState()[1][0].deplacementStrategie.preview(echiquier.getEchiquierState(), 1, 0, 1)));
    }
}