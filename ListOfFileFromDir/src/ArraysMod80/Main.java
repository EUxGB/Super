package ArraysMod80;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] myArray = new int[50];

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = (int) (Math.random() * 200);

        }
        System.out.println(Arrays.toString(myArray));
        System.out.println("Ищем кол-во пар удовлетворящих условию. (a-b)mod(N) и (а или в) >100 Введите N \n");

        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            System.out.println("Введено число " + N);
            int[] arraysMod_0_99 = new int[N];
            int[] arraysMod_100_infinity = new int[N];
            for (int i = 0; i < myArray.length; i++) {
                if (myArray[i] <= 100) arraysMod_0_99[(myArray[i] % N)] = arraysMod_0_99[(myArray[i] % N)] + 1;
                else arraysMod_100_infinity[(myArray[i] % N)] = arraysMod_100_infinity[(myArray[i] % N)] + 1;
            }

            System.out.println(Arrays.toString(arraysMod_0_99) + "<- Количество чисел с остатком от деления на " + N + " от 0 до 100");
            System.out.println(Arrays.toString(arraysMod_100_infinity) + "<- Количество чисел с остатком от деления на " + N + " от 100 до  бесконечности");
            int par = 0;
            for (int i = 0; i < N; i++) {
                par =(arraysMod_100_infinity[i] * (arraysMod_100_infinity[i] - 1)) / 2
                        + (arraysMod_0_99[i] * arraysMod_100_infinity[i])
                        + par;


            }
            System.out.println("Количество пар удовлетворяющих условию = " +par);


        }
    }
}
