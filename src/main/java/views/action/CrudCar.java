package views.action;

import dao.CarDAO;
import entities.Car;
import entities.Owner;
import enums.Brand;
import enums.Color;
import utils.Finals;
import utils.MenuTreatment;

import java.util.Set;

public class CrudCar extends Crud {

    private final String MAIN_ITEM = "car";
    private final CarDAO carDAO = new CarDAO();

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
        Car car = carDAO.getCarById(id);
        Finals.printSuccess(car.toString());
    }

    private void readAll() {
        Set<Car> cars = carDAO.getAllCars();
        cars.forEach(car -> {

            System.out.printf("%s [%s]:\n   ", car.getBrand(), car.getCarId());
            System.out.printf("Owner: %s - year: %s - color: %s - price: %.2f - factory: %s\n",
                              car.getOwner().getName(), car.getYear(), car.getColor(), car.getPrice(),
                              car.getFactoryName()
            );
        });
    }

    @Override
    public void save() {
        Owner owner = ownerConfirmationById("for the car");

        System.out.println("What is the brand of the car?");
        Brand brand = MenuTreatment.brandTreatment();
        System.out.println("What year is the car?");
        int year = MenuTreatment.integerTreatment();
        System.out.println("What color is the car?");
        Color color = MenuTreatment.colorTreatment();
        System.out.println("What is the price of car?");
        Double price = MenuTreatment.doubleTreatment();
        System.out.println("What is the car factory");
        String factory = MenuTreatment.nameTreatment();

        Car car = new Car(brand, year, color, price, factory);
        car.setOwner(owner);

        Integer insertCar = carDAO.createCar(car);

        if (insertCar > 0) Finals.printSuccess(car + "\n inserido no banco de dados com sucesso.");
    }

    @Override
    public void update() {
        Car car = carConfirmationById("update");

        System.out.println("Do you want to update the brand?");
        if (MenuTreatment.booleanTreatment()) {
            System.out.println("Insert new car brand:");
            car.setBrand(MenuTreatment.brandTreatment());
        }
        System.out.println("Do you want to update the year?");
        if (MenuTreatment.booleanTreatment()) {
            System.out.println("Insert the new year:");
            car.setYear(MenuTreatment.integerTreatment());
        }
        System.out.println("Do you want to update the color?");
        if (MenuTreatment.booleanTreatment()) {
            System.out.println("Insert new car color:");
            car.setColor(MenuTreatment.colorTreatment());
        }
        System.out.println("Do you want to update the price?");
        if (MenuTreatment.booleanTreatment()) {
            System.out.println("Insert new price:");
            car.setPrice(MenuTreatment.doubleTreatment());
        }
        System.out.println("Do you want to update the factory?");
        if (MenuTreatment.booleanTreatment()) {
            System.out.println("Insert new factory name:");
            car.setFactoryName(MenuTreatment.nameTreatment());
        }

        if (carDAO.updateCar(car) == 1) Finals.printSuccess("Successfully update.");
    }

    @Override
    public void delete() {
        Car car = carConfirmationById("delete");

        if (carDAO.deleteCar(car.getCarId()) == 1) Finals.printSuccess("Successfully delete.");
    }

    protected Car carConfirmationById(String action) {
        Car car;

        while (true) {
            System.out.println("What is id car?");
            int id = MenuTreatment.integerTreatment();
            car = carDAO.getCarById(id);
            if (car.getBrand() == null) {
                System.out.println("Car does not exist.");
                continue;
            }

            System.out.println("this car you want to " + action + "?\n" + car);
            boolean permission = MenuTreatment.booleanTreatment();
            if (permission) return car;
        }
    }

}
