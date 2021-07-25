package utils;

import automobile.data.Constants;

import java.awt.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

public class Utils implements Constants {
    static Utils instance;
    Scanner scanner;

    private Utils() {
        this.scanner = new Scanner(System.in);
    }

    public static Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    public static Color getRandomColor() {
        Random rand = new Random();

        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b);
    }

    public static int getRandomInt(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public String readConsoleString(String message) {
        if (message != null) System.out.print(message);
        return scanner.nextLine();
    }

    public MenuEnum valueOfMenuEnum(String inputValue) {
        MenuEnum choice = null;
        try {
            choice = MenuEnum.valueOf(inputValue.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println(MSG_INCORRECT_CHOICE);
        }
        return choice;
    }

    public void printSeparator() {
        System.out.println(SEPARATOR_LINE);
    }

    public int readConsoleInt(String message) {
        Integer value = null;
        while (value == null) {
            try {
                System.out.print(message);
                String string = scanner.nextLine();
                value = Integer.parseInt(string);
            } catch (NumberFormatException e) {
                System.out.println(MSG_NUMBER_FORMAT_EXEPTION);
            }
        }
        return value;
    }

    public static String generatingRandomString(int length) {
        byte[] array = new byte[length];
        new Random().nextBytes(array);

        return new String(array, StandardCharsets.UTF_8);
    }
}
