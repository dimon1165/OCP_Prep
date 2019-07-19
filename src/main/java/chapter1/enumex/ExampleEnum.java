package chapter1.enumex;

public enum ExampleEnum {
    OnlyOnce("s"),
    Twice("s3");

    String onlyOnce;

    ExampleEnum(String s) {
        onlyOnce = s;
    }

    public String getOnlyOnce() {
        return onlyOnce;
    }
}
