package id.fauzanelka.familyrestaurant.util;

import id.fauzanelka.familyrestaurant.action.*;

import java.util.HashMap;
import java.util.Map;

public enum Action implements Executable {
  AddRegularMenu(1, "Add Regular Menu") {
    @Override
    public void execute(Storable store) {
      AddRegularMenuAction.getInstance().execute(store);
    }
  },
  AddSpecialMenu(2, "Add Special Menu") {
    @Override
    public void execute(Storable store) {
      AddSpecialMenuAction.getInstance().execute(store);
    }
  },
  ShowAllMenu(3, "Show All Menu") {
    @Override
    public void execute(Storable store) {
      ShowAllMenuAction.getInstance().execute(store);
    }
  },
  DeleteRegularMenu(4, "Delete Regular Menu") {
    @Override
    public void execute(Storable store) {
      DeleteRegularMenuAction.getInstance().execute(store);
    }
  },
  DeleteSpecialMenu(5, "Delete Special Menu") {
    @Override
    public void execute(Storable store) {
      DeleteSpecialMenuAction.getInstance().execute(store);
    }
  },
  Exit(6, "Exit") {
    @Override
    public void execute(Storable store) {
      System.exit(0);
    }
  },
  ;

  private static final Map<Integer, Action> map = new HashMap<>();

  static {
    for (Action action : Action.values()) {
      map.put(action.key, action);
    }
  }

  private final Integer key;
  private final String value;

  Action(int key, String value) {
    this.key = key;
    this.value = value;
  }

  public static Action valueOf(int action) {
    return map.get(action);
  }

  public final Integer key() {
    return key;
  }

  public final String value() {
    return value;
  }
}