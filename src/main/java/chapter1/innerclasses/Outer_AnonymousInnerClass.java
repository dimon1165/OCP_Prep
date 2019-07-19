package chapter1.innerclasses;

public class Outer_AnonymousInnerClass {
    private String EXPLANATION = "It is local inner class without name. Should have exactly one superclass or interface";

    interface SaleTodayOnly {
        public int dollarsOff();
    }

    public int doSomthing(int bestPrice) {
        SaleTodayOnly saleTodayOnly = new SaleTodayOnly() {
            public int dollarsOff() {
                System.out.println(EXPLANATION);
                return 3;
            }
        };
        return bestPrice - saleTodayOnly.dollarsOff();
    }
}