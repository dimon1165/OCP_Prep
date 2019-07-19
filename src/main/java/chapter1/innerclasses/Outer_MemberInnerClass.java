package chapter1.innerclasses;

import java.io.Serializable;

public class Outer_MemberInnerClass {
    private String explanation = "Member Inner Class  - > defined at the member level of class. \n" +
            "Has following parameters:\n" +
            "- can be declared public, protected, private or default; \n" +
            "- can extend any class and implement interfaces; \n" +
            "- can be abstract or final; \n" +
            "- can access members of outer class including private; \n" +
            "- CANNOT declare static fields.";

    public class MemberInnerClass implements Serializable {
        private void printHi() {
            System.out.println(explanation);
        }
    }

    private void callInner() {
        MemberInnerClass memberInnerClass = new MemberInnerClass();
        memberInnerClass.printHi();
    }

    public static void main(String[] args) {
        Outer_MemberInnerClass outerClass = new Outer_MemberInnerClass();
        Outer_MemberInnerClass.MemberInnerClass innerClass = outerClass.new MemberInnerClass();
        innerClass.printHi();
    }
}
