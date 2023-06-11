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

            ActionCar actionMenu = new ActionCar();

            switch (action) {
                case 1 -> {
                    actionMenu.setCrud("read");
                    actionMenu.readItems();
                }
                case 2 -> {
                    actionMenu.setCrud("create");
                    actionMenu.readItems();
                }
                case 3 -> {
                    actionMenu.setCrud("update");
                    actionMenu.readItems();
                }
                case 4 -> {
                    actionMenu.setCrud("delete");
                    actionMenu.readItems();
                }
                case 5 -> SqliteSeed.seedSqlite();
            }
        }
    }

}
