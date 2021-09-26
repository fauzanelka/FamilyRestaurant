package id.fauzanelka.familyrestaurant.action;

import id.fauzanelka.familyrestaurant.util.Storable;

import java.util.Scanner;

public class DeleteSpecialMenuAction implements Executable {
  private static DeleteSpecialMenuAction instance;

  public static DeleteSpecialMenuAction getInstance() {
    if (instance == null) {
      instance = new DeleteSpecialMenuAction();
    }

    return instance;
  }

  public void execute(Storable store) {
    Scanner sc = new Scanner(System.in);
    String menuCode;
    boolean isMenuExist;

    do {
      do {
        System.out.printf("%s", "Input menu code [Sxxx]: ");
        menuCode = sc.nextLine();
      } while (!menuCode.matches("S[0-9]\\d{2}$"));

      isMenuExist = store.getSpecialMenus().containsKey(menuCode);
      if (!isMenuExist) {
        System.out.printf("%s%n", "Code is wrong!");
      }
    } while (!isMenuExist);

    store.removeSpecialMenu(menuCode);
    System.out.printf("%s%n%n", "Delete success!");
  }
}
