package org.example;

import java.util.Scanner;

public class Utils {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressToContinue(){
        Scanner input = new Scanner(System.in);
        System.out.println("Press any key to continue: ");
        if(input.nextLine() != ""){
            return;
        }
    }

    public static String getStringInput(String message, Scanner input){
        System.out.println(message);
        return input.nextLine();
    }

    public static int getIntegerInput(String message, Scanner input){
        System.out.println(message);
        return input.nextInt();
    }
}
