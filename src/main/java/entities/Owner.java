package entities;

import enums.Gender;

public class Owner {

    private int ownerId;
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

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ownerId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Owner other = (Owner) obj;
        if (ownerId != other.ownerId) return false;
        return true;
    }

    @Override
    public String toString() {
        return ("Owner [ownerId=" + ownerId + ", name=" + name + ", age=" + age + ", cpf=" + cpf + ", gender=" + gender + "]");
    }

}
