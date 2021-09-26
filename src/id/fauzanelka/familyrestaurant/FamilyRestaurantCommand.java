package id.fauzanelka.familyrestaurant;

import id.fauzanelka.familyrestaurant.util.Action;
import id.fauzanelka.familyrestaurant.util.Store;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FamilyRestaurantCommand {
  private Store store = Store.getInstance();

  public void run() {
    Scanner sc = new Scanner(System.in);
    Action choice = null;

    do {
      do {
        System.out.printf("%s%n", "Family Restaurant");
        System.out.printf("%s%n", String.join("", Collections.nCopies(22, "=")));
        for (Action action :
          Action.values()) {
          System.out.printf("%d. %s%n", action.key(), action.value());
        }
        System.out.printf("%s", "Choice [1-6]: ");
        try {
          choice = Action.valueOf(sc.nextInt());
        } catch (InputMismatchException e) {
          sc.next();
        }
      } while (choice == null);

      choice.execute(store);
    } while (choice != Action.Exit);
  }
}
