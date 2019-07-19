package chapter1.innerclasses;

public class Outer_StaticNestedClass {
    private static String EXPLANATION = "Static class same as usual class but with next restrictions: \n" +
            " - Any access modifiers; \n" +
            " - Can extend any class; \n" +
            " - Can be abstract and final; \n" +
            " - Can not access instance members of enclosing class; \n" +
            " - Can not access local variables of enclosing class; \n" +
            " - Can declare static fields.";
}
