package core.java;

import java.util.function.BiConsumer;

interface Interface1 {
    void apply();
}
public class InterfaceDriver {
    public static void main(String[] args) {
        Interface1 interface1 = () -> System.out.println("hello world");

        BiConsumer<String, String> biConsumer = (s1, s2) -> System.out.println(s1+ " " + s2);
        biConsumer.accept("abc", "def");

        interface1.apply();
    }
}
