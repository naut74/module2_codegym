package CircleQueueDemo;

public class Solution {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);

        queue.displayQueue();

        queue.deQueue();
        queue.deQueue();

        queue.displayQueue();

        queue.enQueue(50);

        queue.displayQueue();
    }
}

