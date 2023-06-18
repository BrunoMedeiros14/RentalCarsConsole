package enums;

public enum Gender {
    MALE(0, "Male"), FEMALE(1, "Female");

    private final Integer cod;
    private final String description;

    Gender(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public static Gender toEnum(Integer cod) {
        if (cod == null) return null;

        for (Gender gender : Gender.values()) {
            if (cod.equals(gender.getCod())) return gender;
        }

        throw new IllegalArgumentException("Invalid id: " + cod);
    }

    public static Gender toEnum(String value) {
        if (value == null) return null;

        for (Gender gender : Gender.values()) {
            if (gender.toString().equals(value)) return gender;
        }

        throw new IllegalArgumentException("Invalid status value: " + value);
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }
}
