package enums;

public enum Color {
    WHITE(1, "White"), BLACK(2, "Black"), RED(3, "Red"), ORANGE(4, "Orange"), BLUE(5, "Blue"), SILVER(
            6, "Silver"), GRAY(7, "Gray"), GREEN(8, "Green"), YELLOW(9, "Yellow"), CIAN(10, "Cian");

    private final Integer cod;
    private final String description;

    Color(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public static Color toEnum(Integer cod) {
        if (cod == null) return null;

        for (Color color : Color.values()) {
            if (cod.equals(color.getCod())) return color;
        }

        throw new IllegalArgumentException("Invalid id: " + cod);
    }

    public static Color toEnum(String value) {
        if (value == null) return null;

        for (Color color : Color.values()) {
            if (color.toString().equals(value)) return color;
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
