package views;

import utils.Finals;
import utils.MenuTreatment;
import utils.SqliteSeed;

public class Menu {

    public static void homeMenu() {
        Integer action = -1;
        while (action != 0) {
            System.out.println(Finals.CLEAN + Finals.HOME_MENU);
            action = MenuTreatment.itemsTreatment(5);

            Read actionMenu = new Read();

            switch (action) {
                case 1:
                    actionMenu.setCrud("read");
                    actionMenu.readItems();
                    break;
                case 2:
                    actionMenu.setCrud("create");
                    actionMenu.readItems();
                    break;
                case 3:
                    actionMenu.setCrud("update");
                    actionMenu.readItems();
                    break;
                case 4:
                    actionMenu.setCrud("delete");
                    actionMenu.readItems();
                    break;
                case 5:
                    SqliteSeed.seedSqlite();
                    break;
            }
        }
    }

}
