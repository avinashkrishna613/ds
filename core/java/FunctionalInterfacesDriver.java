package core.java;

import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface FunctionalInterface1 {
      String apply(String argument);
}

public class FunctionalInterfacesDriver {
    public static void main(String[] args) {
        FunctionalInterface1 interface1 = new FunctionalInterface1() {
            @Override
            public String apply(String argument) {
                return argument.toUpperCase();
            }
        };
        System.out.println(interface1.apply("hello world"));

        // sole purpose of functional interface are to enable functional programming in java
        // these interfaces allow to pass behaviour as an argument to methods
        // below syntax is called as method reference
        List<String> stringList = List.of("ac", "de", "gh").stream().map(interface1::apply).collect(Collectors.toList());
        System.out.println(stringList);
    }
}
