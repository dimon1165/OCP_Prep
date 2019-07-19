package chapter4;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        // TERMINAL OPERATIONS
        // - allMatch/anyMatch/noneMatch ;
        // - collect;
        // - count;
        // - findAny,findFirst;
        // - foreach;
        // - min/max;
        // - reduce.

        //count -> long. Reduces, because return only one result
        Stream<String> stream = Stream.of("monkey", "gorilla", "bonobo");
        long count = stream.count();
        System.out.println(count);

        // min -> Optional
        Stream<String> stream1 = Stream.of("monkey", "ape", "bonobo");
        Comparator<String> stringComparator = Comparator.comparingInt(String::length);
        Comparator<String> stringComparator1 = String::compareTo;
        Optional<String> min = stream1.min(stringComparator);

        //max -> Optional
        Stream<String> stream2 = Stream.of("monkey", "ape", "bonobo");
        Optional<String> max = stream2.max(stringComparator1);
        System.out.println(min);
        System.out.println(max);

        //findAny -> Optional
        Stream<String> stream3 = Stream.of("monkey", "ape", "bonobo");
        Optional<String> findAny = stream3.filter(x -> x.startsWith("a")).findAny();
        System.out.println(findAny);

        //findFirst -> Optional
        Stream<String> stream4 = Stream.of("monkey", "ape", "bonobo");
        Optional<String> findFirst = stream4.filter(x -> x.contains("o")).findFirst();
        System.out.println(findFirst);

        //allMatch -> boolean
        Stream<String> stream5 = Stream.of("monkey", "2o", "bonobo");
        Predicate<String> predicate = x -> x.contains("o");
        boolean allMatch = stream5.allMatch(predicate);

        //anyMatch -> boolean
        Stream<String> stream6 = Stream.of("monkey", "2", "bonobo");
        boolean anyMatch = stream6.anyMatch(predicate);

        //noneMatch -> boolean
        Stream<String> stream7 = Stream.of("monkey", "2", "bonobo");/**/
        boolean noneMatch = stream7.noneMatch(x -> x.contains("4"));
        System.out.println(allMatch + " " + anyMatch + " " + noneMatch);

        //REDUCE
        //reduce -> accepts BinaryOperator that accepts (T, T) -> return T, and first T is s1
        Stream<String> wolf = Stream.of("w", "o", "l", "f");
        String helloWolf = wolf.reduce("Hello ", (s1, s2) -> s2.concat(s1));
        System.out.println(helloWolf);

        //reduce without identity
        Stream<String> wolf1 = Stream.of("w", "o", "l", "f");
        Optional<String> reduce = wolf1.reduce((s1, s2) -> s1.concat(s2));
        System.out.println(reduce);

        //reduce 3 variables
        Stream<Integer> wolf2 = Stream.of(3, 5, 7, 10, 4);
        Integer reduce1 = wolf2.reduce(1, (s1, s2) -> s1 * s2, Integer::sum);
        System.out.println(reduce1);

        //COLLECT
        Stream<String> wolfStream = Stream.of("w", "o", "l", "f");
        StringBuilder hi = wolfStream.collect(() -> new StringBuilder("Hi "), StringBuilder::append, StringBuilder::append);
        System.out.println(hi);

        Stream<String> wolfStream1 = Stream.of("w", "o", "l", "f");
        TreeSet<String> collect = wolfStream1.collect(Collectors.toCollection(TreeSet::new));

        Stream<String> wolfStream2 = Stream.of("w", "o", "l", "f");
        Set<String> collect1 = wolfStream2.collect(Collectors.toSet());


        // INTERMEDIATE OPERATIONS
        // - filter ;
        // - distinct;
        // - limit and skip;
        // - map;
        // - flatMap;
        // - sorted;
        // - peek.

        // distinct -> returns stream with duplicates values removed
        Stream<String> stringStream = Stream.of("duck", "duck", "duck", "goose");
        stringStream.distinct().forEach(System.out::println);

        //limit, skip ->  make stream smaller
        Stream<Integer> iterateStream = Stream.iterate(1, n -> n + 1);
        iterateStream.skip(9).limit(1).forEach(System.out::println);

        // map (Function)
        Stream<String> mapStream = Stream.of("monkey", "gorilla", "bonobo");
        mapStream.map(String::length).forEach(System.out::print);

        //flatMap(Function) -> take each element of stream and makes it top level
        List<String> list1 = new ArrayList<>(Arrays.asList("monkey", "gorilla", "bonobo"));
        List<String> list2 = new ArrayList<>(Arrays.asList("MamaGorilla", "BabyGorilla"));
        Stream<List<String>> listsStream = Stream.of(list1, list2);
        listsStream.flatMap(Collection::stream).forEach(System.out::println);

        //sorted - () or (function)
        Stream<String> listsStream1 = Stream.of("monkey", "gorilla", "bonobo");
        listsStream1.sorted(Comparator.reverseOrder()).forEach(System.out::println);
        //peek -> use for debugging


        //PRIMITIVES
        Stream<Integer> integerStream = Stream.of(1, 2, 5);
        int sum = integerStream.mapToInt(x -> x).sum();
        System.out.println(sum);

        IntStream forStats = Stream.of(1, 2, 4, 5).mapToInt(x -> x);
        IntSummaryStatistics statistics = forStats.summaryStatistics();
        System.out.println(statistics);

        Stream<String> collectors = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println(collectors.collect(Collectors.averagingInt(String::length)));

        Stream<String> streamM = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<Character>> collect2 = streamM.collect(groupingBy(String::length, mapping(s -> s.charAt(0), toList())));
        System.out.println(collect2);

        Stream<String> stream8 = Stream.iterate("", (s) -> s + "1"); // ""+"1"="1", "1"+"1"="11", "11"+"1"="111"
        stream8.limit(2).map(x -> x + "2").forEach(System.out::println);

        Predicate<? super String> predicate1 = s -> s.startsWith("g");
        Stream<String> generate = Stream.generate(() -> "growl! ").limit(1);
        Stream<String> generate1 = Stream.generate(() -> "growl! ").limit(1);
        boolean anyMatch1 = generate.anyMatch(predicate1);
        boolean allMatch1 = generate1.allMatch(predicate1);
        System.out.println(anyMatch1 +" "+ allMatch1);

        Stream<String> gen = Stream.generate(() -> "growl! ");
        boolean allMatch2 = gen.allMatch(String::isEmpty);
        System.out.println(allMatch2);


    }
}