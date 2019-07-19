package chapter3;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodsClass {
    // Generics could not contains primitive values!!!

    // <T> - formal parameter that goes before return type Always; public static <T> T ship(T t) {} - will not compile.
    //  T  - return type;
    private static <T> T ship(T t) {
        System.out.println("Preparing " + t);
        return t;
    }

    public static void addSound(List<? super String> list) {
//        public void addSound(List<?> list){
//        list.add("Quack"); - does not compile
//        - unbound generics are immutable;
//        - upper-bound generics are immutable (extends);
        list.add("s");
    }


    public static void main(String[] args) {
        ship(100);
        ship("hi");

        List<String> strings = new ArrayList<>();
        strings.add("tweet");
        List<Object> objects = new ArrayList<>(strings);
        addSound(objects);
        addSound(strings);

        List list = new ArrayList();
        list.add(5);
        Object o = list.get(0);
    }
}