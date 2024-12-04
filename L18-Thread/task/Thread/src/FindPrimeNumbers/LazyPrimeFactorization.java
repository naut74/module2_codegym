package FindPrimeNumbers;

public class LazyPrimeFactorization implements Runnable {
    private final int n;

    public LazyPrimeFactorization(int n) {
        this.n = n;
    }
    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void run() {
        int count = 0;
        int number = 2;
        while (count < n) {
            if (isPrime(number)) {
                System.out.println(Thread.currentThread().getName() + " (lazy): Found prime " + number);
                count++;
            }
            number++;
        }
    }
}
