package com.company.maker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

 public class CoffeMaker {

    private static CoffeMaker instance=null;

    public static CoffeMaker getInstance(){
        if (instance==null){
            instance= new CoffeMaker();
        }
        return instance;
    }

    public static final int MAX_USES = 5;
    private float sugarAmount;
    private float waterAmount;
    private float beansAmount;

    private int useCount;


    private CoffeMaker() {
    }

    private CoffeMaker(float water, float sugar, float beans) {
        waterAmount = water;
        sugarAmount = sugar;
        beansAmount = beans;
    }


    public void fillProducts(float water, float sugar, float beans) {
        waterAmount += water;
        sugarAmount += sugar;
        beansAmount += beans;
    }


    public void makeCoffe(String coffeType) {
        if (!isReady()) return;
        StringBuilder builder = new StringBuilder("");

        switch (coffeType.toLowerCase()) {
            case "black":
                sugarAmount -= 10;
                beansAmount -= 20;
                waterAmount -= 0.25f;
                builder.append("                        (\n" +
                        "                          )     (\n" +
                        "                   ___...(-------)-....___\n" +
                        "               .-\"\"       )    (          \"\"-.\n" +
                        "         .-'``'|-._             )         _.-|\n" +
                        "        /  .--.|   `\"\"---...........---\"\"`   |\n" +
                        "       /  /    |                             |\n" +
                        "       |  |    |                             |\n" +
                        "        \\  \\   |                             |\n" +
                        "         `\\ `\\ |                             |\n" +
                        "           `\\ `|                             |\n" +
                        "           _/ /\\                             /\n" +
                        "          (__/  \\                           /\n" +
                        "       _..---\"\"` \\                         /`\"\"---.._\n" +
                        "    .-'           \\                       /          '-.\n" +
                        "   :               `-.__             __.-'              :\n" +
                        "   :                  ) \"\"---...---\"\" (                 :\n" +
                        "    '._               `\"--...___...--\"`              _.'\n" +
                        "  jgs \\\"\"--..__                              __..--\"\"/\n" +
                        "       '._     \"\"\"----.....______.....----\"\"\"     _.'\n" +
                        "          `\"\"--..,,_____            _____,,..--\"\"`\n" +
                        "                        `\"\"\"----\"\"\"`");
                break;
            case "latte":
                sugarAmount -= 20;
                beansAmount -= 40;
                waterAmount -= 0.33f;
                System.out.println("");

                break;
            case "esspresso":
                sugarAmount -= 10;
                beansAmount -= 40;
                waterAmount -= 0.1f;
                break;
        }
        useCount++;
        sugarAmount = Math.max(sugarAmount, 0);
        waterAmount = Math.max(waterAmount, 0);
        beansAmount = Math.max(beansAmount, 0);

    }


    public void washMaker() {
        this.useCount = 0;
    }


    public boolean isReady() {

        boolean result = true;
        if (useCount >= MAX_USES) {
            result = false;
            System.out.println("Truksta resursu");
        }
        if (waterAmount <= 0) {
            result = false;
            System.out.println("Truksta vandens");
        }
        if (sugarAmount <= 0) {
            result = false;
            System.out.println("Truksta cukraus");
        }
        if (beansAmount <= 0) {
            result = false;
            System.out.println("Truksta pupeliu");
        }

        return true;
    }


    public void showProducts() {
        System.out.println("=========Product status=========");
        System.out.println("Sugar amount left:" + sugarAmount);
        System.out.println("Water amount left:" + waterAmount);
        System.out.println("Beans amount left:" + beansAmount);

    }


    public void showStatus() {
        System.out.println("=========Maker status============");
        System.out.println("Usages left:" + (MAX_USES - this.useCount));
        System.out.println("is machine ready:" + isReady());
        this.showProducts();
    }


    public float getWater() {
        return this.waterAmount;
    }


    public void setWater(float value) {
        this.waterAmount = value;
    }


    public float getBeans() {
        return this.beansAmount;
    }


    public void setBeans(float value) {
        this.beansAmount = value;
    }


    public float getSugar() {
        return this.sugarAmount;
    }


    public void setSugar(float value) {
        this.sugarAmount = value;
    }

    public void issaugotiBusena() {
        System.out.println("=========Maker status============");
        System.out.println("Usages left:" + (MAX_USES - this.useCount));
        System.out.println("is machine ready:" + isReady());
        this.showProducts();


        FileWriter writer = null;
        try {
            writer = new FileWriter("tekstas1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer.write("=========Maker status============ \n");
            writer.write("Usages left:" + (MAX_USES - this.useCount) + "\n");
            writer.write("is machine ready:" + isReady() + "\n");
            writer.write("Sugar amount left:" + sugarAmount + "\n");
            writer.write("Water amount left:" + waterAmount + "\n");
            writer.write("Beans amount left:" + beansAmount + "\n");
            writer.write("is machine ready:" + isReady() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}





