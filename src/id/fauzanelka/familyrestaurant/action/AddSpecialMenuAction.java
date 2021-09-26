package id.fauzanelka.familyrestaurant.action;

import id.fauzanelka.familyrestaurant.util.SpecialMenu;
import id.fauzanelka.familyrestaurant.util.Storable;

import java.util.*;

public class AddSpecialMenuAction implements Executable {
  private static AddSpecialMenuAction instance;

  public static AddSpecialMenuAction getInstance() {
    if (instance == null) {
      instance = new AddSpecialMenuAction();
    }

    return instance;
  }

  public void execute(Storable store) {
    Scanner sc = new Scanner(System.in);
    SpecialMenu menu = new SpecialMenu();

    do {
      System.out.printf("%s", "Input menu code [Sxxx]: ");
      menu.setCode(sc.nextLine());
    } while (!menu.getCode().matches("S[0-9]\\d{2}$"));

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

    List<Double> allowedDiscount = new ArrayList<>(Arrays.asList(0.1, 0.25, 0.5));
    do {
      System.out.printf("%s", "Input menu discount [10% | 25% | 50%]: ");
      try {
        menu.setDiscount(((Integer) sc.nextInt()).doubleValue() / 100);
      } catch (InputMismatchException e) {
        sc.next();
      }
    } while (!allowedDiscount.contains(menu.getDiscount()));

    store.addSpecialMenu(menu.getCode(), menu);
    System.out.printf("%s%n%n", "Add success!");
  }
}
