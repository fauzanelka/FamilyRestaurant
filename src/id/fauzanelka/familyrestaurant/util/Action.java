package id.fauzanelka.familyrestaurant.util;

import id.fauzanelka.familyrestaurant.action.*;

import java.util.HashMap;
import java.util.Map;

public enum Action implements Executable {
  AddRegularMenu(1, "Add Regular Menu") {
    @Override
    public void execute(Storable storage) {
      AddRegularMenuAction.getInstance().execute(storage);
    }
  },
  AddSpecialMenu(2, "Add Special Menu") {
    @Override
    public void execute(Storable storage) {
      AddSpecialMenuAction.getInstance().execute(storage);
    }
  },
  ShowAllMenu(3, "Show All Menu") {
    @Override
    public void execute(Storable storage) {
      ShowAllMenuAction.getInstance().execute(storage);
    }
  },
  DeleteRegularMenu(4, "Delete Regular Menu") {
    @Override
    public void execute(Storable storage) {
      DeleteRegularMenuAction.getInstance().execute(storage);
    }
  },
  DeleteSpecialMenu(5, "Delete Special Menu") {
    @Override
    public void execute(Storable storage) {
      DeleteSpecialMenuAction.getInstance().execute(storage);
    }
  },
  Exit(6, "Exit") {
    @Override
    public void execute(Storable storage) {
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