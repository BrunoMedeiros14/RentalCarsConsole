package utils;

import enums.Brand;
import enums.Color;
import enums.Gender;

import java.util.Arrays;

public class MenuTreatment {

    private MenuTreatment() {
    }

    public static Integer itemsTreatment(Integer totalMenuItems) {
        int n;

        while (true) {
            try {

                n = Integer.parseInt(Finals.scan.next());
                if (n > 0 || n < totalMenuItems) break;

                System.out.println("Enter a code between 0 and " + totalMenuItems);

            } catch (NumberFormatException e) {
                System.out.println("Enter only integers");
            }
        }

        return n;
    }

    public static String nameTreatment() {
        String name = "";

        while (name.length() < 1) {
            name = Finals.scan.next();

            if (name.length() == 0) {
                System.out.println("Enter a valid name.");
            }
        }

        return name;
    }

    public static Integer integerTreatment() {
        int n;

        while (true) {
            try {
                n = Integer.parseInt(Finals.scan.nextLine());
                if (n >= 0) break;

                System.out.println("Enter a valid id.");

            } catch (NumberFormatException e) {
                System.out.println("Enter only integers");
            }
        }

        return n;
    }

    public static Double doubleTreatment() {
        double n;

        while (true) {
            try {
                n = Double.parseDouble(Finals.scan.nextLine());
                if (n >= 0) break;

                System.out.println("Enter a valid price.");

            } catch (NumberFormatException e) {
                System.out.println("Enter only number, value.");
            }
        }

        return n;
    }

    public static String cpfTreatment() {
        String cpf = "";

        while (cpf.length() != 11) {
            cpf = Finals.scan.next();

            if (cpf.length() != 11) {
                System.out.println("Enter a valid cpf.");
            }
        }

        return cpf;
    }

    public static Gender genderTreatment() {
        Gender gender;
        while (true) {
            try {
                String value = Finals.scan.nextLine();
                gender = Gender.valueOf(value);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a correct value [Male, Female].");
            }
        }
        return gender;
    }

    public static Brand brandTreatment() {
        Brand brand;
        while (true) {
            try {
                String value = Finals.scan.nextLine();
                brand = Brand.valueOf(value);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a correct value " + Arrays.toString(Brand.values()) + ".");
            }
        }
        return brand;
    }

    public static boolean booleanTreatment() {
        String permission = Finals.scan.nextLine();
        return Arrays.stream(Finals.TRUES).toList().contains(permission);
    }

    public static Color colorTreatment() {
        Color color;
        while (true) {
            try {
                String value = Finals.scan.nextLine();
                color = Color.valueOf(value);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Enter a correct value " + Arrays.toString(Color.values()) + ".");
            }
        }
        return color;
    }

}
