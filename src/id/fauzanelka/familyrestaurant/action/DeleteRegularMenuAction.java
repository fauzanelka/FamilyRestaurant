package id.fauzanelka.familyrestaurant.action;

import id.fauzanelka.familyrestaurant.util.Storable;

import java.util.Scanner;

public class DeleteRegularMenuAction implements Executable {
  private static DeleteRegularMenuAction instance;

  public static DeleteRegularMenuAction getInstance() {
    if (instance == null) {
      instance = new DeleteRegularMenuAction();
    }

    return instance;
  }

  public void execute(Storable storage) {
    Scanner sc = new Scanner(System.in);
    String menuCode = null;
    boolean isMenuExist = false;

    do {
      do {
        System.out.printf("%s", "Input menu code [Rxxx]: ");
        menuCode = sc.nextLine();
      } while (!menuCode.matches("R[0-9]\\d{2}$"));

      isMenuExist = storage.getRegularMenus().containsKey(menuCode);
      if (!isMenuExist) {
        System.out.printf("%s%n", "Code is wrong!");
      }
    } while (!isMenuExist);

    storage.removeRegularMenu(menuCode);
    System.out.printf("%s%n%n", "Delete success!");
  }
}
