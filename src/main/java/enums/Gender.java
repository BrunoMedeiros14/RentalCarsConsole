package enums;

public enum Gender {
    Male, Female;

    public static Gender fromValue(String value) {
        for (Gender gender : Gender.values()) {
            if (gender.toString().equals(value)) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }
}
