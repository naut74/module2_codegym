package DisplayNumbers;

public class Main {
    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();

        evenThread.start();

        try {
            evenThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting for EvenThread");
        }

        oddThread.start();

        try {
            oddThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting for OddThread");
        }
        System.out.println("All threads are finished");
    }
}
