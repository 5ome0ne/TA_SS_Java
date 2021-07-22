import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

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
        database.add(KEY_EVEN, even);
        database.add(KEY_ODD, odd);
    }

    public ArrayList<Integer> doFibonacci() {
        int n = database.get(KEY_FIB_N);
        int to = database.get(KEY_TO);
        int f1 = to % 2 == 0 ? to - 1 : to;
        int f2 = to % 2 == 0 ? to : to - 1;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(f1);
        stack.push(f2);
        for (int i = 0; i < n - 2; i++) {
            f2 = stack.pop();
            f1 = stack.pop();
            stack.push(f1);
            stack.push(f2);
            stack.push(f1 + f2);
        }

        int odd = 0;
        int even = 0;
        for (int i : stack) {
            if (i % 2 != 0) odd++;
            if (i % 2 == 0) even++;
        }
        database.add(KEY_ODD_PERS, (int) (((float) odd / stack.size()) * 100));
        database.add(KEY_EVEN_PERS, (int) (((float) even / stack.size()) * 100));

        return new ArrayList<>(stack);
    }
}
