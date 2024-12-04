package FindPrimeNumbers;

public class OptimizedPrimeFactorization implements Runnable{
    private int n;

    public OptimizedPrimeFactorization(int n) {
        this.n = n;
    }

    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        int count = 0;
        int number = 2;
        while (count < n) {
            if (isPrime(number)) {
                System.out.println(Thread.currentThread().getName() + " (optimized): Found prime " + number);
                count++;
            }
            number++;
        }
    }
}
