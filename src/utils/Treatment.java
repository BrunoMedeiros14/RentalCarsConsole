package utils;

public class Treatment {
  public Integer numberTreatment(Integer totalMenu) {

    Integer n = 0;

    while (true) {

      try {
        n = Integer.parseInt(Finals.scan.next());
      } catch (NumberFormatException e) {
        System.out.println("Enter only integers");
        continue;
      }

      if (n < 1 || n > totalMenu) {
        System.out.println("Enter a code between 1 and " + totalMenu);
        continue;
      }

      break;
    }

    return n;
  }

}
