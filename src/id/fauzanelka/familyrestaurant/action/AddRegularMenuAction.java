package id.fauzanelka.familyrestaurant.action;

import id.fauzanelka.familyrestaurant.util.RegularMenu;
import id.fauzanelka.familyrestaurant.util.Storable;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddRegularMenuAction implements Executable {
  private static AddRegularMenuAction instance;

  public static AddRegularMenuAction getInstance() {
    if (instance == null) {
      instance = new AddRegularMenuAction();
    }

    return instance;
  }

  public void execute(Storable store) {
    Scanner sc = new Scanner(System.in);
    RegularMenu menu = new RegularMenu();

    do {
      System.out.printf("%s", "Input menu code [Rxxx]: ");
      menu.setCode(sc.nextLine());
    } while (!menu.getCode().matches("R[0-9]\\d{2}$"));

    do {
      System.out.printf("%s", "Input menu name [5-20]: ");
      menu.setName(sc.nextLine());
    } while (!menu.getName().matches("[a-zA-Z0-9 ]{5,20}$"));

    do {
      System.out.printf("%s", "Input menu price [10000-100000]: ");
      try {
        menu.setPrice(sc.nextInt());
      } catch (InputMismatchException e) {
        sc.next();
      }
    } while (menu.getPrice() <= 10000 || menu.getPrice() >= 100000);

    store.addRegularMenu(menu.getCode(), menu);
    System.out.printf("%s%n%n", "Add success!");
  }
}
