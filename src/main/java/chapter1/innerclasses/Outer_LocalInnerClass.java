package chapter1.innerclasses;

public class Outer_LocalInnerClass {
    private static String EXPLANATION = "Class defined in method and does not exists until method is invoked.\n" +
            "And goes out of scope when method returns. Which is means that you can create instance of it only \n" +
            "within method. Behave same as method variable." +
            "Has following parameters: \n" +
            " - dont have access specifier; \n" +
            " - can not be static and can not declare static fields; \n" +
            " - have access to all fields and methods of enclosing class; \n" +
            " - don't have access to local variables of method unless they final or effectively final.";
    private int length = 5;

    private void calculate() {
        final int width = 5;

         class Inner {
            private void multiply() {
                System.out.println(EXPLANATION);
                System.out.println(length * width);
            }
        }
        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        Outer_LocalInnerClass outerLocalInnerClass = new Outer_LocalInnerClass();
        outerLocalInnerClass.calculate();
    }
}
