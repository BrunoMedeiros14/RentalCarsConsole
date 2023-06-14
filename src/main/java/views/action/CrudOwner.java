package views.action;

import entities.Owner;
import enums.Gender;
import utils.Finals;
import utils.MenuTreatment;

import java.util.Set;

public class CrudOwner extends Crud {

    private final String MAIN_ITEM = "owner";

    @Override
    public void read() {
        System.out.printf(Finals.TYPE_MENU + "\n", "read", MAIN_ITEM);
        int action = MenuTreatment.itemsTreatment(2);
        switch (action) {
            case 1 -> readById();
            case 2 -> readAll();
            default -> {
            }
        }
    }

    private void readById() {
        System.out.println("Input the " + MAIN_ITEM + " id:");
        int id = MenuTreatment.integerTreatment();
        Owner owner = ownerDAO.getOwnerById(id);
        Finals.printSuccess(owner.toString());
    }

    private void readAll() {
        Set<Owner> owners = ownerDAO.getAllOwners();
        owners.forEach(owner -> {
            System.out.println(owner.getName() + ":");
            System.out.printf("Id: %s - age: %s - CPF: %s - gender: %s\n", owner.getOwnerId(), owner.getAge(),
                              owner.getCpf(), owner.getGender()
            );
        });
    }

    @Override
    public void save() {
        System.out.println("What is the owner name?");
        String name = MenuTreatment.nameTreatment();
        System.out.println("What is the owner age?");
        int age = MenuTreatment.integerTreatment();
        System.out.println("What is the owner cpf?");
        String cpf = MenuTreatment.cpfTreatment();
        System.out.println("What is the owner gender?");
        Gender gender = MenuTreatment.genderTreatment();

        Owner owner = new Owner(name, age, cpf, gender);
        ownerDAO.createOwner(owner);

        Finals.printSuccess(owner + "\n inserido no banco de dados com sucesso.");
    }

    @Override
    public void update() {
        Owner owner = ownerConfirmationById("update");

        System.out.println("Do you want to update the name?");
        if (MenuTreatment.booleanTreatment()) {
            System.out.println("Insert new owner name");
            owner.setName(MenuTreatment.nameTreatment());
        }
        System.out.println("Do you want to update the age?");
        if (MenuTreatment.booleanTreatment()) {
            System.out.println("Insert new owner age");
            owner.setAge(MenuTreatment.integerTreatment());
        }
        System.out.println("Do you want to update the CPF?");
        if (MenuTreatment.booleanTreatment()) {
            System.out.println("Insert new owner CPF");
            owner.setCpf(MenuTreatment.cpfTreatment());
        }

        if (ownerDAO.updateOwner(owner) == 1) Finals.printSuccess("Successfully update.");
    }

    @Override
    public void delete() {
        Owner owner = ownerConfirmationById("delete");

        if (ownerDAO.deleteOwner(owner.getOwnerId()) == 1) Finals.printSuccess("Successfully delete.");
    }
}
