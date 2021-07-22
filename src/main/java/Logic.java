public class Logic implements Constants {
    private final Database database;

    public Logic() {
        database = Database.getInstance();
    }

    public void doSums() {
        int from = database.get(KEY_FROM);
        int to = database.get(KEY_TO);
        int odd = 0;
        int even = 0;
        for (int i = from; i <= to; i++) {
            if (i % 2 == 0) {
                even += i;
                continue;
            }
            odd += i;
        }
        System.out.println("Sum of even: " + even);
        System.out.println("Sum of  odd: " + odd);
    }
}
