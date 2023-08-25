import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;

public class Main {
    public static List<Integer> ordenaLista(List<Integer> list) {
        return  list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }

    public static int somaParesLista(List<Integer> list) {
        return (list.stream().filter(n -> n%2 == 0).toList()).stream().reduce(0, Integer::sum);
    }

    public static boolean verificaSeTodosSaoPositivos(List<Integer> list) {
        return list.stream().anyMatch(n -> n<0);
    }

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        System.out.println(ordenaLista(numeros));
        System.out.println(somaParesLista(numeros));
        System.out.println("Todos da lista são  positivos? " + (verificaSeTodosSaoPositivos(numeros) ? "Não" : "Sim"));
    }
}