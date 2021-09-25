package com.fauzanelka.familyrestaurant;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<RegularItem> regularItems = new ArrayList<>();

    public static void addRegularMenu() {
        Scanner in = new Scanner(System.in);

        String menuCode = null;

        do {
            System.out.print("Input Menu Code [R...]: ");
            try {
                menuCode = in.next();
            } catch (InputMismatchException e) {
                in.next();
                System.out.println();
            }
        } while (!menuCode.matches("^R[0-9]\\d{0,2}$"));

        String menuName = null;
        do {
            System.out.print("Input Menu Name [5-20]: ");
            try {
                menuName = in.next();
            } catch (InputMismatchException e) {
                in.next();
                System.out.println();
            }
        } while (!menuName.matches("^[a-zA-Z0-9]{5,20}$"));

        int menuPrice = 0;
        do {
            System.out.print("Input Menu Price [10000-100000]: ");

            try {
                menuPrice = in.nextInt();
            } catch (InputMismatchException e) {
                 in.next();
                System.out.println();
            }
        } while(menuPrice < 10000 || menuPrice > 100000);

        regularItems.add(new RegularItem(menuCode, menuName, menuPrice));
    }

    public static void addSpecialMenu() {
        // TODO
    }

    public static void showAllMenu() {
        System.out.println("Regular Menu");
        System.out.println("===");
        System.out.println("No. | Kode | Nama | Harga");
        System.out.println("===");
        for (int i = 0; i < regularItems.size(); i++) {
            System.out.printf(
                    "%d | %s | %s | %d %n",
                    i + 1,
                    regularItems.get(i).getCode(),
                    regularItems.get(i).getName(),
                    regularItems.get(i).getPrice()
            );
        }
    }

    public static void deleteRegularMenu() {
        System.out.println("Delete Regular Menu");
        System.out.println("===");

        Scanner in = new Scanner(System.in);
        String menuCode = null;

        boolean isDeleted = false;
        do {
            do {
                System.out.print("Input Menu Code [R...]: ");
                try {
                    menuCode = in.next();
                } catch (InputMismatchException e) {
                    in.next();
                    System.out.println();
                }
            } while (!menuCode.matches("^R[0-9]\\d{0,2}$"));

            for (int i = 0; i < regularItems.size(); i++) {
                if (regularItems.get(i).getCode().equals(menuCode)) {
                    regularItems.remove(i);
                    isDeleted = true;
                    System.out.println("Delete Success!");
                }
            }

            if (!isDeleted) {
                System.out.println("Code is Wrong");
            }
        } while (!isDeleted);
    }

    public static void deleteSpecialMenu() {
        System.out.println("Delete special menu test");
    }

    public static void main(String[] args) {
        int choice = 0;
        List<Integer> choices = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6)
        );
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("Family Restaurant");
            System.out.println("====");
            System.out.println("1. Add Regular Menu");
            System.out.println("2. Add Special Menu");
            System.out.println("3. Show All Menu");
            System.out.println("4. Delete Regular Menu");
            System.out.println("5. Delete Special Menu");
            System.out.println("6. Exit");

            do {
                try {
                    System.out.print("Choice [1-6]: ");
                    choice = in.nextInt();
                } catch (InputMismatchException e) {
                    in.next();
                }
            } while (!choices.contains(choice));

            switch (choice) {
                case 1: // Add Regular Menu
                    addRegularMenu();
                    break;
                case 2: // Add Special Menu
                    addSpecialMenu();
                    break;
                case 3: // Show All Menu
                    showAllMenu();
                    break;
                case 4: // Delete Regular Menu
                    deleteRegularMenu();
                    break;
                case 5: // Delete Special Menu
                    deleteSpecialMenu();
                    break;
                case 6: // Exit
                    break;
            }

        } while (choice != 6);

        in.close();
    }
}
