package com.fauzanelka.familyrestaurant;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Family Restaurant");
        System.out.println("====");
        System.out.println("1. Add Regular Menu");
        System.out.println("2. Add Special Menu");
        System.out.println("3. Show All Menu");
        System.out.println("4. Delete Regular Menu");
        System.out.println("5. Delete Special Menu");
        System.out.println("6. Exit");

        Integer choice = 0;
        List<Integer> choices = new ArrayList<Integer>(
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );
        Scanner in = new Scanner(System.in);
        do {
            try {
                System.out.printf("%nChoice [1-6]: ");
                choice = in.nextInt();
            } catch (InputMismatchException e) {
                in.next();
            }
        } while (!choices.contains(choice));

        switch (choice) {
            case 1: // Add Regular Menu
                break;
            case 2: // Add Special Menu
                break;
            case 3: // Show All Menu
                break;
            case 4: // Delete Regular Menu
                break;
            case 5: // Delete Special Menu
                break;
            case 6: // Exit
                System.exit(0);
                break;
        }
    }
}
