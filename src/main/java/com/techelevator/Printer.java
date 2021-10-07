package com.techelevator;

public class Printer {

    /**
     * @param string prints the given string to the console followed by a newline
     */
    public static void println(String string) {
        System.out.println(string);
    }

    /**
     * @param string prints the given string to the console without a newline
     */
    public static void print(String string) {
        System.out.print(string);
    }

    /**
     * prints an empty newline
     */
    public static void newLine() {
        System.out.println();
    }

    /**
     * @param num prints this many newlines
     */
    public static void newLine(int num) {
        for (num=num; num > 0; num--) {
            System.out.println();
        }
    }

}
