package id.fauzanelka.familyrestaurant.util;

import java.util.HashMap;
import java.util.Map;

public class Store implements Storable {
  private static Store instance;
  protected Map<String, RegularMenu> regularMenuMap = new HashMap<>();
  protected Map<String, SpecialMenu> specialMenuMap = new HashMap<>();

  public static Store getInstance() {
    if (instance == null) {
      instance = new Store();
    }

    return instance;
  }

  public Map<String, RegularMenu> getRegularMenus() {
    return regularMenuMap;
  }

  public Map<String, SpecialMenu> getSpecialMenus() {
    return specialMenuMap;
  }

  public void addRegularMenu(String code, RegularMenu menu) {
    regularMenuMap.put(code, menu);
  }

  public void addSpecialMenu(String code, SpecialMenu menu) {
    specialMenuMap.put(code, menu);
  }

  public void removeRegularMenu(String code) {
    regularMenuMap.remove(code);
  }

  public void removeSpecialMenu(String code) {
    specialMenuMap.remove(code);
  }
}
