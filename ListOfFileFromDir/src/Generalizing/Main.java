package Generalizing;

public class Main {

    public static void main(String[] args) {
        Parent<String> stringParent = new Parent<>("Hello");
        Parent<Integer> integerParent = new Parent<>(5);

        Child1<String> stringChild1 = new Child1<>("Hello");
        Child1<Integer> integerChild1 = new Child1<>(5);

        Child2<String> stringChild2 = new Child2<>("Hello");
        Child2<Integer> integerChild2 = new Child2<>(5);


        System.out.println("stringParent instanceof Parent " + (integerParent instanceof Parent<?>));


        System.out.println();
        System.out.println("stringChild1 instanceof Child1 " + (stringChild1 instanceof Child1<?>));
        System.out.println("stringChild1 instanceof Parent " + (stringChild1 instanceof Parent<?>));
        System.out.println();
        System.out.println("stringChild1 instanceof Child2 " + (stringChild2 instanceof Child2<?>));
        System.out.println("stringChild1 instanceof Parent " + (stringChild2 instanceof Parent<?>));

        System.out.println();
//        System.out.println("stringChild1 instanceof Child1 " + ((stringChild1 instanceof Child1<String>)));
//        System.out.println("stringChild1 instanceof Parent " + ((Parent<String>)stringChild1 instanceof Parent<String>));
    }
}
