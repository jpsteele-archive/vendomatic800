package com.techelevator;

import java.io.IOException;

public class Printer {
    public static String bla = "\\\\\\\\";


    private static String ascii1 = "___    __           _________            ______  ___      __________           _____________________ ";
    private static String ascii2 = "__ |  / /_________________  /_____       ___   |/  /_____ __  /___(_)______    __( __ )_  __ \\_  __ \\";
    private static String ascii3 = "__ | / /_  _ \\_  __ \\  __  /_  __ \\________  /|_/ /_  __ `/  __/_/ /_  ___/    _  __  |  / / /  / / /";
    private static String ascii4 = "__ |/ / /  __/  / / / /_/ / / /_/ //_____/  /  / / / /_/ // /_ _/ / / /__      / /_/ // /_/ // /_/ / ";
    private static String ascii5 = "_____/  \\___//_/ /_/\\__,_/  \\____/       /_/  /_/  \\__,_/ \\__/ /_/  \\___/      \\____/ \\____/ \\____/  ";
    private static String[] asciiStrings = {ascii1, ascii2, ascii3, ascii4, ascii5};

    public static void splashScreen() {
        for (String string : asciiStrings) {
            for (int i = 0; i <= 100; i++) {
                System.out.print(string.charAt(i));
            }
            System.out.println();
            try {Thread.sleep(300);}
            catch (InterruptedException ignored) {}
        }
    }

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
