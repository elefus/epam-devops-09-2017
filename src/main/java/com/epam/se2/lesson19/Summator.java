package com.epam.se2.lesson19;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Summator {

    private final String delimiter;

    public Summator(String delimiter) {
        this.delimiter = delimiter;
    }

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sum = (Integer x, Integer y) -> {
            return x + y;
        };
        BiFunction<Integer, Integer, Integer> subtraction = (x, y) -> x - y;

        BinaryOperator<Integer> sum2 = (x, y) -> x + y;
        BinaryOperator<Integer> subtraction2 = (x, y) -> x - y;

        Function<Integer, Integer> subtract10 = value -> value - 10;
        BiFunction<Integer, Integer, Integer> func = sum2.andThen(subtract10);
        Integer apply = func.apply(20, 30);

        BinaryOperator<String> sumString = Summator::concat;
        String result = sumString.apply("1", "2");
        System.out.println(result);

        Summator summator = new Summator("-");
        BinaryOperator<String> sumWithDelimiter = summator::concatWithDelimiter;
        sumWithDelimiter.apply("1", "2");

        Summator summator2 = new Summator("~");
        sumWithDelimiter = summator2::concatWithDelimiter;
        sumWithDelimiter.apply("1", "2");

        SummatorFactory factory = new SummatorFactoryImpl();
        Summator summator1 = factory.create("~");
        Summator summator3 = factory.create("-");

        SummatorFactory constructorReference = Summator::new;
        constructorReference.create(",");
    }

    public static String concat(String left, String right) {
        return left + right;
    }

    public String concatWithDelimiter(String left, String right) {
        return left + delimiter + right;
    }

    public long sum(long left, long right) {
        return left + right;
    }
}

@FunctionalInterface
interface SummatorFactory {

    Summator create(String delimiter);
}

class SummatorFactoryImpl implements SummatorFactory {

    @Override
    public Summator create(String delimiter) {
        return new Summator(delimiter);
    }
}