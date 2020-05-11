package Lamda;

import java.util.Scanner;
import java.util.function.*;

interface ReturnObject<T> {
    T getValue();

}

interface Squaring<V extends Number> {
    V getSquare(V t);
}

public class Main {
    public static void main(String[] args) {


        ReturnObject returnObject;
        Squaring<Double> squaring;

        returnObject = () -> 123;
        System.out.println(returnObject.getValue());

        returnObject = () -> "move";
        System.out.println(returnObject.getValue());

        squaring = (e) -> e * e;
        System.out.println(squaring.getSquare(5.56461315556));
        System.out.println();
        System.out.println(myS(squaring, 5.0));


        // Стандартные функциональные интерфейсы
        {//Predicate<T> проверяет выполнения условия
            Predicate<String> stringPredicate = (t) -> t instanceof String;
            System.out.println(stringPredicate.test("Petr"));
            //Consumer<T> потребитель, получает и ничего не возвращате
            Consumer<Integer> integerConsumer = (i) -> System.out.println(i);
            integerConsumer.accept(10);
            //Function <T,R> представляет переход от объекта T в R
            Function<Integer, Double> doubleFunction = t -> Double.valueOf(t);
            System.out.println(doubleFunction.apply(5));
            //Supplier<T> поставщик ничего не принримает , только поставляет
//        Supplier<String> text = () -> {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Введите текст");
//            return scanner.nextLine();
//        };
//        System.out.println(text.get());
            //UnaryOperator<T> принимает один элеимент типа Т осуществляет операцию над ним и возвращает его
            UnaryOperator<Double> integerUnaryOperator = t -> Math.sqrt(t);
            System.out.println(integerUnaryOperator.apply(5.0));
            //BinaryOperator<T> принримает два объекта типа Т и возвращает один объект типа Т
            BinaryOperator<Double> doubleBinaryOperator = (t, v) -> Math.pow(t, v);
            System.out.println(doubleBinaryOperator.apply(5.4, 5.5));
        }

        Supplier<String> stringSupplier = () -> "123";
        System.out.println(supDouble(stringSupplier, "oops"));

    }

    static String supDouble(Supplier s, String string) {
        return  s.get() + " " + string;


    }


    static Double myS(Squaring sq, Double d) {

        return (Double) sq.getSquare(d);
    }


}
