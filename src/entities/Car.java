package entities;

import enums.Brand;
import enums.Color;

public class Car {

  private int pk_carId;
  private Brand brand;
  private Color color;
  private Integer year;
  private Double price;
  private String factoryName;
  private int fk_keyOwnerId;

  public Car() {
  }

  public Car(Brand brand, Integer year, Color color, Double price, String factoryName) {
    this.brand = brand;
    this.year = year;
    this.color = color;
    this.price = price;
    this.factoryName = factoryName;
  }

  public int getPk_carId() {
    return pk_carId;
  }

  public void setPk_carId(int pk_carId) {
    this.pk_carId = pk_carId;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getFactoryName() {
    return factoryName;
  }

  public void setFactoryName(String factoryName) {
    this.factoryName = factoryName;
  }

  public int getFk_keyOwnerId() {
    return fk_keyOwnerId;
  }

  public void setFk_keyOwnerId(int fk_keyOwnerId) {
    this.fk_keyOwnerId = fk_keyOwnerId;
  }

}
