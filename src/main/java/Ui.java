import java.util.Scanner;

public class Ui implements Constants {
    private final Database database;
    private final Logic logic;

    public Ui() {
        database = Database.getInstance();
        logic = new Logic();
    }

    public void start() {
        getDataForSums();
        logic.doSums();
    }

    private void getDataForSums() {
        int from = askUserInt(MSG_ASK_FROM);
        database.add(KEY_FROM, from);
        int to = askUserInt(MSG_ASK_TO);
        database.add(KEY_TO, to);
    }

    private int askUserInt(String message) {
        Scanner scanner = new Scanner(System.in);
        Integer value = null;
        while (value == null) {
            try {
                System.out.print(message);
                String string = scanner.nextLine();
                value = Integer.parseInt(string);
            } catch (NumberFormatException e) {
                System.out.println(MSG_Number_Format_Exception);
            }
        }
        return value;
    }
}
