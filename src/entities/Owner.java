package entities;

import enums.Gender;

public class Owner {

  private int ID;
  private String name;
  private int age;
  private String cpf;
  private Gender gender;

  public Owner() {
  }

  public Owner(String name, int age, String cpf, Gender gender) {

    this.name = name;
    this.age = age;
    this.cpf = cpf;
    this.gender = gender;
  }

  public int getID() {
    return ID;
  }

  public void setID(int iD) {
    ID = iD;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

}