package views.action;

import dao.OwnerDAO;
import entities.Owner;
import utils.MenuTreatment;

abstract public class Crud {

    protected OwnerDAO ownerDAO = new OwnerDAO();

    public abstract void read();

    public abstract void save();

    public abstract void update();

    public abstract void delete();

    protected Owner ownerConfirmationById(String action) {
        Owner owner;

        while (true) {
            System.out.println("What is the owner id?");
            int id = MenuTreatment.integerTreatment();
            owner = ownerDAO.getOwnerById(id);
            if (owner.getName() == null) {
                System.out.println("Owner does not exist.");
                continue;
            }

            System.out.println("this owner you want to " + action + "?\n" + owner);
            boolean permission = MenuTreatment.booleanTreatment();
            if (permission) return owner;
        }
    }

}
