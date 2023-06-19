package enums;

public enum Brand {
    HONDA(0, "Honda"), FORD(1, "Ford"), HYUNDAI(2, "Hyundai"), VOLKSWAGEN(3, "Volkswagen"), CHEVROLET(
            4, "Chevrolet"), AUDI(5, "Audi"), MAZDA(6, "Mazda"), TOYOTA(7, "Toyota"), BMW(8, "BMW"), VOLVO(
            9, "Volvo"), JAGUAR(
            10, "Jaguar"), MITSUBISHI(11, "Mitsubishi"), LEXUS(12, "Lexus"), NISSAN(13, "Nissan"), KIA(
            14, "Kia"), SUBARU(
            15, "Subaru"), FIAT(16, "Fiat");

    private final Integer cod;
    private final String description;

    Brand(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public static Brand toEnum(Integer cod) {
        if (cod == null) return null;

        for (Brand brand : Brand.values()) {
            if (cod.equals(brand.getCod())) return brand;
        }

        throw new IllegalArgumentException("Invalid id: " + cod);
    }

    public static Brand toEnum(String value) {
        if (value == null) return null;

        for (Brand brand : Brand.values()) {
            if (value.equals(brand.getDescription())) return brand;
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
