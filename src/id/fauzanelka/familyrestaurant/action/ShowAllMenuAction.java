package id.fauzanelka.familyrestaurant.action;

import id.fauzanelka.familyrestaurant.util.RegularMenu;
import id.fauzanelka.familyrestaurant.util.SpecialMenu;
import id.fauzanelka.familyrestaurant.util.Storable;

import java.util.Collections;

public class ShowAllMenuAction implements Executable {
  private static ShowAllMenuAction instance;

  public static ShowAllMenuAction getInstance() {
    if (instance == null) {
      instance = new ShowAllMenuAction();
    }

    return instance;
  }

  public void execute(Storable storage) {
    System.out.printf("%s%n", "Regular Menu");
    System.out.printf("%s%n", String.join("", Collections.nCopies(56, "=")));
    System.out.printf(
      "%-3s | %-4s | %-32s | %-6s |%n",
      "No.",
      "Kode",
      "Nama",
      "Harga"
    );
    System.out.printf("%s%n", String.join("", Collections.nCopies(56, "=")));
    int menuIndex = 1;
    if (storage.getRegularMenus().size() > 0) {
      for (RegularMenu menu : storage.getRegularMenus().values()) {
        System.out.printf(
          "%-3d | %-4s | %-32s | %-6d |%n",
          menuIndex,
          menu.getCode(),
          menu.getName(),
          menu.getPrice()
        );
        ++menuIndex;
      }
    } else {
      System.out.printf("%s%n", "Menu kosong");
    }

    System.out.println();

    System.out.printf("%s%n", "Special Menu");
    System.out.printf("%s%n", String.join("", Collections.nCopies(65, "=")));
    System.out.printf(
      "%-3s | %-4s | %-32s | %-6s | %-6s |%n",
      "No.",
      "Kode",
      "Nama",
      "Harga",
      "Diskon"
    );
    menuIndex = 1;
    if (storage.getSpecialMenus().size() > 0) {
      System.out.printf("%s%n", String.join("", Collections.nCopies(65, "=")));
      for (SpecialMenu menu : storage.getSpecialMenus().values()) {
        System.out.printf(
          "%-3d | %-4s | %-32s | %-6d | %-6d |%n",
          menuIndex,
          menu.getCode(),
          menu.getName(),
          menu.getPrice(),
          menu.getDiscount().intValue() * 100
        );
        ++menuIndex;
      }
    } else {
      System.out.printf("%s%n", "Menu kosong");
    }

    System.out.println();
  }
}
