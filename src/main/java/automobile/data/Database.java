package automobile.data;

import automobile.model.Car;

import java.util.*;

public class Database {
    private SortedSet<Car> db;
    private static Database instance;

    private Database() {
        this.db = new TreeSet<>((Comparator.comparingInt(Car::hashCode)));
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void sortAscending() {
        SortedSet<Car> dbNewSort = new TreeSet<>(((o1, o2) -> o2.hashCode() - o1.hashCode()));
        dbNewSort.addAll(db);
        db = dbNewSort;
    }

    public void sortDescending() {
        SortedSet<Car> dbNewSort = new TreeSet<>((Comparator.comparingInt(Car::hashCode)));
        dbNewSort.addAll(db);
        db = dbNewSort;
    }

    public Set<Car> getCars() {
        return Collections.unmodifiableSet(db);
    }

    public int getCarsCount() {
        return db.size();
    }

    public boolean removeCar(int index) {
        List<Car> list = new ArrayList<>(db);
        if (index < 0 || index >= list.size()) return false;
        return db.remove(list.get(index));
    }

    public Car addCar(Class<? extends Car> aClass) {
        Car car = null;
        try {
            car = aClass.newInstance();
            db.add(car);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return car;
    }
}
