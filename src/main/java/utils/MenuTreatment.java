package utils;

public class MenuTreatment {

  public static Integer itemsTreatment(Integer totalMenuItems) {
    Integer n = 0;

    while (true) {
      try {
        n = Integer.parseInt(Finals.scan.next());
      } catch (NumberFormatException e) {
        System.out.println("Enter only integers");
        continue;
      }

      if (n < 0 || n > totalMenuItems) {
        System.out.println("Enter a code between 0 and " + totalMenuItems);
        continue;
      }

      break;
    }

    return n;
  }

  public static Integer idTreatment() {
    Integer n = 0;

    while (true) {
      try {
        n = Integer.parseInt(Finals.scan.next());
      } catch (NumberFormatException e) {
        System.out.println("Enter only integers");
        continue;
      }

      if (n <= 0) {
        System.out.println("Enter a valid id.");
        continue;
      }

      break;
    }

    return n;
  }
}
