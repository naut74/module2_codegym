package CircleQueueDemo;

class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enQueue(int value) {
        Node newNode = new Node(value);
        if (front == null) {
            front = rear = newNode;
            rear.next = front;
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
        System.out.println("Added " + value + " to the queue.");
    }

    public void deQueue() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }

        int value;
        if (front == rear) {
            value = front.data;
            front = rear = null;
        } else {
            value = front.data;
            front = front.next;
            rear.next = front;
        }
        System.out.println("Removed " + value + " from the queue.");
    }

    public void displayQueue() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }

        Node temp = front;
        System.out.print("Queue elements: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);
        System.out.println();
    }
}

