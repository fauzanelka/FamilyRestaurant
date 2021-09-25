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

  public void execute(Storable storage) {
    Scanner sc = new Scanner(System.in);
    String menuCode = null;
    boolean isMenuExist = false;

    do {
      do {
        System.out.printf("%s", "Input menu code [Sxxx]: ");
        menuCode = sc.nextLine();
      } while (!menuCode.matches("S[0-9]\\d{2}$"));

      isMenuExist = storage.getSpecialMenus().containsKey(menuCode);
      if (!isMenuExist) {
        System.out.printf("%s%n", "Code is wrong!");
      }
    } while (!isMenuExist);

    storage.removeSpecialMenu(menuCode);
    System.out.printf("%s%n%n", "Delete success!");
  }
}
