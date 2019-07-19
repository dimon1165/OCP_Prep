package chapter1;

import chapter1.enumex.ExampleEnum;
import chapter1.hets.Hippo;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Hippo hippo = new Hippo("Hip", 20.33);
        System.out.println(hippo);
        ExampleEnum[] values = ExampleEnum.values();
        int ordinal = ExampleEnum.OnlyOnce.ordinal();
        System.out.println(ordinal);
        System.out.println(ExampleEnum.OnlyOnce);
        System.out.println(ExampleEnum.valueOf("OnlyOnce"));
        System.out.println(ExampleEnum.Twice.getOnlyOnce());

        ArrayDeque<String> greetings = new ArrayDeque<>();
        greetings.add("hello");
        greetings.add("hi");
        greetings.add("ola");
        greetings.pop();
        greetings.peek();
        while (greetings.peek() != null){
            System.out.println(greetings.pop());
        }

        Set<Number> numbers = new HashSet<>();
        numbers.add(new Integer(86));
        numbers.add(75);
        numbers.add(309L);
        numbers.add(null);
        Iterator iterator = numbers.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        TreeSet<String> strings = new TreeSet<>();
        strings.add("one");
        strings.add("One");
        strings.add("ONE");
        System.out.println(strings);
        System.out.println(strings.ceiling(strings.ceiling("On")));

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, null);

        map.merge(1, 3, (a, b) -> a + b);
        map.merge(3, 3, Integer::sum);
        System.out.println(map);

        Predicate predicate =(str ->str.equals("One"));
        Predicate predicate1 = (str1 -> str1.equals("Two"));
        boolean two = predicate.or(predicate1).test("Two");
        System.out.println(two);
    }
}