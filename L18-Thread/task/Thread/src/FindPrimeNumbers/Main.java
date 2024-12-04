package FindPrimeNumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        OptimizedPrimeFactorization optimizedPrime = new OptimizedPrimeFactorization(n);
        LazyPrimeFactorization lazyPrime = new LazyPrimeFactorization(n);

        Thread thread1 = new Thread(optimizedPrime, "Thread-1");
        Thread thread2 = new Thread(lazyPrime, "Thread-2");

        thread1.start();
        thread2.start();

        scanner.close();
    }
}
