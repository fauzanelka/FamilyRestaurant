package id.fauzanelka.familyrestaurant.util;

public class RegularMenu implements Menu {
  protected String code;
  protected String name;
  protected Integer price;

  public RegularMenu() {
  }

  public RegularMenu(String code, String name, Integer price) {
    this.code = code;
    this.name = name;
    this.price = price;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }
}
