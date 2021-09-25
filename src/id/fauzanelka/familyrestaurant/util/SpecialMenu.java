package id.fauzanelka.familyrestaurant.util;

public final class SpecialMenu extends RegularMenu implements Menu {
  protected Double discount;

  public SpecialMenu() {
  }

  public SpecialMenu(String code, String name, Integer price, Double discount) {
    super(code, name, price);
    this.discount = discount;
  }

  public Double getDiscount() {
    return discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }
}
