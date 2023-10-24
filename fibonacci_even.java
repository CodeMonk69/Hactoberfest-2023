import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FibonacciEvenNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of Fibonacci numbers you want: ");
        int n = scanner.nextInt();

        List<Long> fibonacciNumbers = generateFibonacci(n);
        System.out.println("First " + n + " Fibonacci numbers: " + fibonacciNumbers);

        List<Long> evenNumbers = filterEven(fibonacciNumbers);
        System.out.println("Even numbers from the sequence: " + evenNumbers);
    }

    private static List<Long> generateFibonacci(int n) {
        if (n <= 0) return new ArrayList<>();

        return Stream.iterate(new long[]{0, 1}, t -> new long[]{t[1], t[0] + t[1]})
                     .limit(n)
                     .map(t -> t[0])
                     .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    private static List<Long> filterEven(List<Long> list) {
        return list.stream()
                   .filter(number -> number % 2 == 0)
                   .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
