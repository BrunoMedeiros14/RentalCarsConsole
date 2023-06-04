package enums;

public enum Color {
    White, Black, Red, Orange, Blue, Silver, Gray, Green, Yellow, Cian;

    public static Color fromValue(String value) {
        for (Color color : Color.values()) {
            if (color.toString().equals(value)) {
                return color;
            }
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }
}
