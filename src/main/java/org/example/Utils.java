package org.example;

import java.util.Collection;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class Utils {
    public static <T> Stream<T> streamCheck(Collection<T> collection) {
        if (Objects.isNull(collection)) {
            return Stream.empty();
        }
        return collection.stream();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressToContinue() {
        Scanner input = new Scanner(System.in);
        System.out.println("Press any key to continue: ");
        if (input.nextLine() != "") {
            return;
        }
    }

    public static String getStringInput(String message, Scanner input) {
        System.out.println(message);
        return input.nextLine();
    }

    public static int getIntegerInput(String message, Scanner input) {
        System.out.println(message);
        return input.nextInt();
    }
}
