package views;

import utils.Finals;
import utils.MenuTreatment;
import utils.SqliteSeed;
import views.action.Crud;
import views.action.CrudCar;
import views.action.CrudOwner;

public class Menu {

    private Crud actionMenu;

    public void homeMenu() {
        int action = -1;
        while (action != 0) {
            System.out.println(Finals.CLEAN + Finals.HOME_MENU);
            action = MenuTreatment.itemsTreatment(5);

            if (action != 5 && action != 0) getAction(Finals.POSSIBLE_ACTIONS[action]);

            if (actionMenu == null) continue;

            switch (action) {
                case 1 -> actionMenu.read();
                case 2 -> actionMenu.save();
                case 3 -> actionMenu.update();
                case 4 -> actionMenu.delete();

                case 5 -> SqliteSeed.seedSqlite();
                default -> System.out.println("Thank you for using our system.");
            }
        }
    }

    private void getAction(String text) {

        int item = -1;

        System.out.printf(Finals.CLEAN + Finals.ACTION_MENU + "\n", text);
        item = MenuTreatment.itemsTreatment(2);

        switch (item) {
            case 2 -> actionMenu = new CrudOwner();
            case 1 -> actionMenu = new CrudCar();
            default -> actionMenu = null;
        }

    }

}
