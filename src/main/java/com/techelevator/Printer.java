package com.techelevator;

public class Printer {

    public static void println(String string) {
        System.out.println(string);
    }

    public static void print(String string) {
        System.out.print(string);
    }

    public static void newLine() {
        System.out.println();
    }

    public static void newLine(int num) {
        for (num=num; num > 0; num--) {
            System.out.println();
        }
    }

}
