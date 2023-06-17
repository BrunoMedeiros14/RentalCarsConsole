package entities;

import java.util.Objects;

public class PhoneNumber {

    private int phoneId;
    private String ddd;
    private String number;

    private Owner owner;

    public PhoneNumber(String ddd, String number, Owner owner) {
        this.ddd = ddd;
        this.number = number;
        this.owner = owner;
    }

    public PhoneNumber() {

    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber that)) return false;
        return Objects.equals(ddd, that.ddd) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ddd, number);
    }

    @Override
    public String toString() {
        return '[' + ddd + "] " + number;
    }

}
