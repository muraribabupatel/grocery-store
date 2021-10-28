package com.example.grocerymart.Model;

public class Vegetable {
  private String name;
  private int price;
  private int image;

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

    public String getImage() {
        return String.valueOf(image);
    }

    public void setImage(int image) {
        this.image = image;
    }
}
