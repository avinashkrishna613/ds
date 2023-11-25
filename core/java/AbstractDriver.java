package core.java;
abstract class AbstractClass1 {
    abstract void apply();
}

public class AbstractDriver {
    public static void main(String[] args) {
        AbstractClass1 abstractClass1 = new AbstractClass1() {
            @Override
            void apply() {
                System.out.println("hello world");
            }
        };

        abstractClass1.apply();
    }
}
