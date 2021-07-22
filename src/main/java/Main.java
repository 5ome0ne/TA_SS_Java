import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello, type you name: ");
        String nameSurname = scanner.nextLine();
        System.out.println("Hello " + nameSurname + "!");
    }
}
