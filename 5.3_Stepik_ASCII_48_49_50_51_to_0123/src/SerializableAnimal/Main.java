package SerializableAnimal;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        Animal animal = new Animal("penguin");
        Animal animal2 = new Animal("cat");
        Animal animal3 = new Animal("dog");
        Animal [] arrAnimal = {animal,animal2,animal3};
        int size = arrAnimal.length;
        Path path = Paths.get("io2020.bin");

        Object o = serializeAnimalArray(size, arrAnimal);
        //deserializeAnimalArray(o);






    }


    public static Object serializeAnimalArray(int size, Animal [] arrAnimal) throws IOException {
        ObjectOutputStream objEnter = new ObjectOutputStream(new FileOutputStream("c:\\txt.txt"));
//        int objects = 0;
//        ObjectOutputStream objEnter = new ObjectOutputStream(new ByteArrayOutputStream(objects)) ;
        objEnter.writeInt(size);
        objEnter.writeObject(arrAnimal);

        for (int i = 0; i < arrAnimal.length; i++) {
            //System.out.println(arrAnimal[i]);
            objEnter.writeObject(arrAnimal[i]);


        }
        System.out.println(Arrays.toString(arrAnimal));

return objEnter;
    }

    public static Animal[] deserializeAnimalArray(byte[] data) throws IOException {
        boolean objAnimal;
        Animal[] arrAnimals;

        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data));
        try {
            objectInputStream.readInt();
        } catch (IllegalArgumentException ex1) {
            throw ex1;
        }

//        try {
//
////            for (int i = 0; i < data.length; i++) {
////               arrAnimals[i] = data[i].;
//
//            }
//
//        } catch (ClassNotFoundException ex2) {
//        }

        // your implementation here
        return new Animal[10];
    }



}

class Animal implements Serializable {

    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }


}

