package DisplayNumbers;

public class EvenThread extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 != 0) {
                    System.out.println(i);
                    Thread.sleep(15);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        System.out.println("Thread run is over");
    }
}