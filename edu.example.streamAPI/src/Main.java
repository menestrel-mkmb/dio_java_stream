import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

public class Main {
    public static List<Integer> ordenaLista(List<Integer> list) {
        return  list.stream().sorted(Comparator.naturalOrder()).collect(toList());
    }
    public static List<Integer> ordenaListaReverso(List<Integer> list) {
        return  list.stream().sorted(Comparator.reverseOrder()).collect(toList());
    }

    public static int retornaMaximo(List<Integer> list) {
        return list.stream().mapToInt(n -> n).max().orElseThrow(NoSuchElementException::new);
    }

    public static int somaParesLista(List<Integer> list) {
        return (list.stream().filter(n -> n%2 == 0).toList()).stream().reduce(0, Integer::sum);
    }

    public static boolean verificaSeAlgumNegativo(List<Integer> list) {
        return list.stream().anyMatch(n -> n<0);
    }

    public static List<Integer> removerImpares(List<Integer> list) {
        return list.stream().filter(n -> n % 2 == 0).collect(toList());
    }

    public static double calculaMedia(List<Integer> list) {
        double valor = list.stream().reduce(0, Integer::sum);
        return valor/list.size();
    }

    public static boolean verificaMaior(List<Integer> list, int num) {
        return list.stream().anyMatch(n -> n>num);
    }

    public static int somaTodosDigitos(List<Integer> list) {
        char[] charArray = list.toString().toCharArray();
        int digitos = 0;
        for(char c : charArray) { if(Character.isDigit(c)) digitos += Character.getNumericValue(c); }
        return digitos;
    }

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3);

        System.out.println(ordenaLista(numeros));
        System.out.println(somaParesLista(numeros));
        System.out.println("Todos da lista são  positivos? " + (verificaSeAlgumNegativo(numeros) ? "Não" : "Sim"));
        System.out.println(removerImpares(numeros));
        System.out.println(calculaMedia(numeros.stream().filter(n -> n > 5).collect(toList())));
        System.out.println("Algum item da lista é maior que 10? " + ((verificaMaior(numeros, 10)) ? "Sim" : "Não"));
        System.out.println("2º Número máximo: " + retornaMaximo(ordenaListaReverso(numeros).stream()
                                                                                .skip(1).collect(toList())));
        System.out.println("Soma de todos os dígitos: " + somaTodosDigitos(numeros));
    }
}