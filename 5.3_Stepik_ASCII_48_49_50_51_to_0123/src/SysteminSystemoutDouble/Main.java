package SysteminSystemoutDouble;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        double d = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            try {
                d += Double.parseDouble(scanner.next());
            } catch (java.lang.Exception ex) {
            }
        }
        System.out.printf("%6f", d);
    }
}

