package automobile.view;

import automobile.data.Constants;
import automobile.data.Database;
import automobile.model.Car;
import utils.Utils;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Ui implements Constants {
    private final Utils utils;
    private final Database database;

    public Ui() {
        this.utils = Utils.getInstance();
        this.database = Database.getInstance();
    }

    public void show() {
        MenuEnum choice;
        do {
            utils.printSeparator();
            System.out.println(MSG_CHOICE);
            Arrays.stream(MenuEnum.values()).forEach((menu) -> System.out.println(menu.label));
            String inputValue = utils.readConsoleString(TXT_COLON);
            utils.printSeparator();
            choice = utils.valueOfMenuEnum(inputValue);
            doChoice(choice);
        } while (choice != MenuEnum.EXIT);
    }

    private void doChoice(MenuEnum choice) {
        if (choice == null) return;
        switch (choice) {
            case ADD:
                System.out.println(TXT_ADD);
                addCar();
                break;
            case REMOVE:
                removeCar();
                break;
            case SHOW:
                showCars();
                break;
            case SORT:
                sortCars();
                break;
            case EXIT:
                System.out.println(TXT_EXIT);
                System.exit(0);
        }
    }

    private void addCar() {
        utils.printSeparator();
        Car car = database.addCar(carType.get(getAddCarNumber()));
        System.out.println(MSG_ADDED);
        System.out.println(car);
    }

    private int getAddCarNumber() {
        Integer number = null;
        while (number == null) {
            System.out.println(MSG_ADD);
            carType.forEach((cl) -> System.out.println(carType.indexOf(cl) + 1 + TXT_COLON + cl.getSimpleName()));
            int numberSelect = utils.readConsoleInt(TXT_COLON);
            if (numberSelect > 0 && numberSelect <= carType.size()) {
                number = numberSelect - 1;
            } else {
                System.out.println(MSG_INCORRECT_CHOICE);
            }
        }
        return number;
    }

    private void removeCar() {
        utils.printSeparator();
        int count = database.getCarsCount();
        if (count == 0) {
            System.out.println(MSG_EMPTY_DB);
            return;
        }
        int index = getRemoveCarNumber();
        boolean result = database.removeCar(index);
        System.out.println(MSG_REMOVE_RESULT + result);
        utils.printSeparator();
    }

    private int getRemoveCarNumber() {
        Integer number = null;
        Set<Car> cars = database.getCars();
        while (number == null) {
            System.out.println(MSG_REMOVE);
            AtomicInteger atomicInteger = new AtomicInteger(1);
            cars.forEach((car) -> System.out.println(atomicInteger.getAndIncrement() + TXT_COLON + car.toString()));
            int numberSelect = utils.readConsoleInt(TXT_COLON);
            if (numberSelect > 0 && numberSelect <= cars.size()) {
                number = numberSelect - 1;
            } else {
                System.out.println(MSG_INCORRECT_CHOICE);
            }
        }
        return number;
    }

    private void showCars() {
        utils.printSeparator();
        Set<Car> cars = database.getCars();
        if (cars.size() == 0) {
            System.out.println(MSG_EMPTY_DB);
            return;
        }
        System.out.println(MSG_ALL_CARS);
        for (Car car : cars) {
            for (Class<? extends Car> carClass : carType) {
                if (car.getClass() == carClass) System.out.println((carClass.cast(car)));
            }
        }
        utils.printSeparator();
    }

    private void sortCars() {
        utils.printSeparator();
        System.out.println(MSG_SORT);
        int choice = utils.readConsoleInt(TXT_COLON);
        if (choice == 0) {
            System.out.println(MSG_ASC);
            database.sortAscending();
        } else {
            System.out.println(MSG_DESC);
            database.sortDescending();
        }
        utils.printSeparator();
    }
}
