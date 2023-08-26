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

    public static boolean todosDistintos(List<Integer> list) {
        return list.stream().distinct().toList().size() == list.size();
    }

    public static List<Integer> agruparMultiplos(List<Integer> list, int multiplo) {
        return list.stream().filter(n -> n%multiplo == 0 && n%2 == 1).collect(toList());
    }
    public static List<Integer> juntarMultiplosDes10(List<Integer> numeros) {
        List<Integer> agrupado = new ArrayList<>();
        agrupado.addAll(agruparMultiplos(numeros, 3));
        agrupado.addAll(agruparMultiplos(numeros, 5));
        return agrupado.stream().distinct().sorted().collect(toList());
    }

    public static List<Integer> quadrados(List<Integer> list) {
         return list.stream().map(n -> n*n).collect(toList());
    }

    public static List<Integer> filtrarIntervalo(List<Integer> list, int min, int max) {
        return list.stream()
                .filter(n -> n > min)
                .filter(n -> n < max)
                .collect(toList());
    }

    public static List<Integer> filtrarPrimos(List<Integer> list) {
        List<Integer> primes = new ArrayList<>();
        for(Integer numb : list) {
            boolean prime = true;
            for(int n = 2; n <= numb/2; n++) {
                if(numb%n == 0){
                    prime = false;
                    break;
                }
            }
            if(prime) primes.add(numb);
        }

        return primes;
    }

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4, 3, -3);

        System.out.println(ordenaLista(numeros));
        System.out.println(somaParesLista(numeros));
        System.out.println("Todos da lista são  positivos? " + (verificaSeAlgumNegativo(numeros) ? "Não" : "Sim"));
        System.out.println(removerImpares(numeros));
        System.out.println(calculaMedia(numeros.stream().filter(n -> n > 5).collect(toList())));
        System.out.println("Algum item da lista é maior que 10? " + ((verificaMaior(numeros, 10)) ? "Sim" : "Não"));
        System.out.println("2º Número máximo: " + retornaMaximo(ordenaListaReverso(numeros).stream()
                                                                                .skip(1).collect(toList())));
        System.out.println("Soma de todos os dígitos: " + somaTodosDigitos(numeros));
        System.out.println("Todos são distintos? " + (todosDistintos(numeros) ? "Sim" : "Não"));
        System.out.println("Agrupar múltiplos de 3 e 5: " + juntarMultiplosDes10(numeros));
        System.out.println("Soma dos quadrados: " + quadrados(numeros).stream().reduce(0, Integer::sum));
        System.out.println("Produto da lista: " + numeros.stream().reduce(1, (n1, n2) -> n1*n2 ));
        System.out.println("Filtrar intervalo: " + filtrarIntervalo(numeros, 4, 9));
        System.out.println("Filtrar maior primo: " + filtrarPrimos(numeros).stream().max(Comparator.naturalOrder()));
        System.out.println("Contém negativo? " + (verificaSeAlgumNegativo(numeros) ? "Sim" : "Não"));
    }
}