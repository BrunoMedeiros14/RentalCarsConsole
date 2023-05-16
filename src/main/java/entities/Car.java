package entities;

import enums.Brand;
import enums.Color;

public class Car {

  private int carId;
  private Brand brand;
  private Color color;
  private Integer year;
  private Double price;
  private String factoryName;
  private int fk_keyOwnerId;

  public Car() {}

  public Car(
    Brand brand,
    Integer year,
    Color color,
    Double price,
    String factoryName
  ) {
    this.brand = brand;
    this.year = year;
    this.color = color;
    this.price = price;
    this.factoryName = factoryName;
  }

  public int getCarId() {
    return carId;
  }

  public void setCarId(int carId) {
    this.carId = carId;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + carId;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Car other = (Car) obj;
    if (carId != other.carId) return false;
    return true;
  }
}
