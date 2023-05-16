package views;

import java.lang.reflect.Method;
import utils.Finals;
import utils.MenuTreatment;

public class Read {

  private String crud;
  private Integer item = -1;
  private Integer search;

  public void readItems() {
    while (item != 0) {
      System.out.println(Finals.CLEAN + Finals.ACTION_MENU);
      item = MenuTreatment.itemsTreatment(2);
      if (item == 0) break;

      System.out.println(Finals.CLEAN + Finals.TYPE_MENU);
      search = MenuTreatment.itemsTreatment(2);
      switch (search) {
        case 1:
          readItemsById();
          item = 0;
          break;
        case 2:
          readAllItems();
          item = 0;
          break;
        case 0:
          continue;
      }
    }
  }

  public void readItemsById() {
    System.out.println(Finals.CLEAN + "What is the Id?");
    // Integer id = MenuTreatment.idTreatment();
    // if (item == 1) "car";
    // else if (item == 2) "Owner"
  }

  public void readAllItems() {}

  public String getCrud() {
    return crud;
  }

  public void setCrud(String crud) {
    this.crud = crud;
  }

  public static Object methodByString(String methodToGet) {
    try {
      Read readMenu = new Read();

      Method method = Read.class.getMethod(methodToGet);

      return method.invoke(readMenu);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return methodToGet;
  }
}
