package com.company;

import com.company.maker.CoffeMaker;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    /*Papildyti kavos aparata šiuo funkcionalumu:
    - vartojas pats įveda kavos pavadinimą
    - kai tikrinama ar aparatas pasiruošęs, pranešti jei kažko trūksta ir ar reikia valyti įskaitant ir prieš gaminant kavą
    - visur naudoti string builder
    - prideti "ASCII art" kavos puodeliams, naudoti string builder
    - pildant aparatą iš vartotojo pasiimti kiekius kiek papildys*/



    /*Sukurti meniu punkta kuris leistu aparato busena issaugoti tekstineme faile. Panaudoti git branch ir github pull request*/


    public static void main(String[] args) {
        Main obj = new Main();
        obj.dirbam();
    }

    private void showMenu1() {
        System.out.println("Iveskite kavos pavadinima is pateikto meniu");
        System.out.println("black");
        System.out.println("latte");
        System.out.println("esspresso");
    }

    private void showMenu2() {
        System.out.println("0 - baigti darba, o gal ir ne");
        System.out.println("1 - rodyti aparato busena");
        System.out.println("2 - plauti aparata");
        System.out.println("3 - pildyti produktus");
        System.out.println("4-issaugoti aparato busena");
    }

    private void dirbam() {
        CoffeMaker aparatas = new CoffeMaker();
        Scanner sc = new Scanner(System.in);
        boolean arTesti = true;
        do {
            showMenu1();

            String pasirinkimas1 = sc.next();

            switch (pasirinkimas1) {


                case "black":
                    aparatas.makeCoffe("black");
                    break;
                case "latte":
                    aparatas.makeCoffe("latte");
                    break;
                case "espreso":
                    aparatas.makeCoffe("espresso");
                    break;
            }
            showMenu2();
            int pasirinkimas2 = sc.nextInt();
            switch (pasirinkimas2) {
                case 0:
                    arTesti = false;
                    break;
                case 1:
                    aparatas.showStatus();
                    //aparatas.issaugotiBusena();
                    break;
                case 2:
                    aparatas.washMaker();
                    break;
                case 3:
                    System.out.println("iveskite kiek reikia vandens");
                    float water = sc.nextFloat();
                    System.out.println("iveskite kiek reikia cukraus");
                    float sugar = sc.nextFloat();
                    System.out.println("iveskite kiek reikia pupeliu");
                    float beens = sc.nextFloat();
                    aparatas.fillProducts(water, sugar, beens);
                    break;
                case 4:
                    System.out.println("issaugomi duomenys");
                    aparatas.issaugotiBusena();
                    break;
            }

        } while (arTesti);
    }
}
