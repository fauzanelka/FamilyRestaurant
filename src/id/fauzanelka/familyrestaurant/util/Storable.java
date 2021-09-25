package id.fauzanelka.familyrestaurant.util;

import java.util.Map;

public interface Storable {
  Map<String, RegularMenu> getRegularMenus();

  Map<String, SpecialMenu> getSpecialMenus();

  void addRegularMenu(String code, RegularMenu menu);

  void addSpecialMenu(String code, SpecialMenu menu);

  void removeRegularMenu(String code);

  void removeSpecialMenu(String code);

  public enum MenuType {
    RegularMenu,
    SpecialMenu
  }
}
