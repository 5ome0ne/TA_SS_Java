import utils.Utils;

import java.util.*;

public class Ui implements Constants {
    private final Database database;
    private final Logic logic;
    private final Utils utils;

    public Ui() {
        database = Database.getInstance();
        utils = Utils.getInstance();
        logic = new Logic();
    }

    public void start() {
        doSum();
        doFibonacci();
    }

    private void doSum() {
        getDataForSums();
        logic.doSums();
        System.out.println("Sum of even: " + database.get(KEY_EVEN));
        System.out.println("Sum of  odd: " + database.get(KEY_ODD));
    }

    private void getDataForSums() {
        int from = utils.readConsoleInt(MSG_ASK_FROM);
        database.add(KEY_FROM, from);
        int to = utils.readConsoleInt(MSG_ASK_TO);
        database.add(KEY_TO, to);
    }

    private void doFibonacci() {
        getDataForFibonacci();
        ArrayList<Integer> listFib = logic.doFibonacci();
        Collections.reverse(listFib);
        System.out.println(Arrays.toString(listFib.toArray()));
        System.out.println("Percentage of  odd Fibonacci numbers: " + database.get(KEY_ODD_PERS) + "%");
        System.out.println("Percentage of even Fibonacci numbers: " + database.get(KEY_EVEN_PERS) + "%");
    }

    private void getDataForFibonacci() {
        int from = utils.readConsoleInt(MSG_ASK_FIB_N);
        database.add(KEY_FIB_N, from);
    }
}
