package automobile.data;

import automobile.model.Bmw;
import automobile.model.Car;
import automobile.model.Mercedes;

import java.util.Arrays;
import java.util.List;

public interface Constants {
    enum MenuEnum {
        ADD(TXT_ADD),
        REMOVE(TXT_REMOVE),
        SHOW(TXT_SHOW),
        SORT(TXT_SORT),
        EXIT(TXT_EXIT);

        public final String label;

        MenuEnum(String label) {
            this.label = label;
        }
    }

    List<Class<? extends Car>> carType = Arrays.asList(
            Bmw.class,
            Mercedes.class);

    String TXT_ADD = "Add";
    String TXT_REMOVE = "Remove";
    String TXT_SHOW = "Show";
    String TXT_SORT = "Sort";
    String TXT_EXIT = "Exit";
    String TXT_BMW = "BMW";
    String TXT_MERCEDES = "Mercedes";
    String TXT_COLON = ":";

    String SEPARATOR_LINE = "------------------------------------------------------------------------------------------";

    String MSG_CHOICE = "Type a choice:";
    String MSG_INCORRECT_CHOICE = "There is no such menu. Please make a selection from the list";
    String MSG_ALL_CARS = "All cars: ";
    String MSG_EMPTY_DB = "No one car in database";
    String MSG_REMOVE = "Choice number of car to delete";
    String MSG_REMOVE_RESULT = "Result of removing: ";
    String MSG_SORT = "Type 0 for ascending sort and another integer for descending";
    String MSG_ADD = "Choice number of car type";
    String MSG_ADDED = "Added:";
    String MSG_ASC = "Ascending sort";
    String MSG_DESC = "Descending sort";
    String MSG_NUMBER_FORMAT_EXEPTION = "\n\t\tValue must be integer\n";

    int SPEED_STEP = 5;
    int VIN_LENGTH = 10;
    int ENGINE_MIN = 1;
    int ENGINE_MAX = 5;
}
