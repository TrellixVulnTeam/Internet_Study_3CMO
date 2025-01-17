package chapter04;

import java.util.function.Supplier;

public class Chapter4Section1 {
    public static void main(String[] args) {
        Supplier<String> myStringSupplier = () -> "hello worl!";
        System.out.println(myStringSupplier.get());

        Supplier<Double> myRandomDubleSupplier = () -> Math.random();
        System.out.println(myRandomDubleSupplier.get());

        printRandomDoubles(myRandomDubleSupplier, 5);
    }

    public static void printRandomDoubles(Supplier<Double> randomSuppier,
                                          int count) {

        for (int i = 0; i < count; i++) {
            System.out.println(randomSuppier.get());
        }
    }

}
