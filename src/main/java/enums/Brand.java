package enums;

public enum Brand {
    Honda, Ford, Hyundai, Volkswagen, Chevrolet, Audi, Mazda, Toyota, BMW, Volvo, Jaguar, Mitsubishi, Lexus, Nissan, Kia, Subaru, Fiat;

    public static Brand fromValue(String value) {
        for (Brand brand : Brand.values()) {
            if (brand.toString().equals(value)) {
                return brand;
            }
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }
}
