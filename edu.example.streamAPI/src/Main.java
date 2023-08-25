import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

public class Main {
    public static List<Integer> ordenaLista(List<Integer> list) {
        return  list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        System.out.println(ordenaLista(numeros));
    }
}