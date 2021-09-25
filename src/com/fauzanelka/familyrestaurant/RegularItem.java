package com.fauzanelka.familyrestaurant;

public class RegularItem {
    private String code;
    private String name;
    private int price;

    public RegularItem(String code, String name, int price) {
        this.setCode(code);
        this.setName(name);
        this.setPrice(price);
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
