package entities;

import java.util.Objects;

public class PhoneNumber {

    private String ddd;
    private String number;

    public PhoneNumber(String ddd, String number) {
        this.ddd = ddd;
        this.number = number;
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
