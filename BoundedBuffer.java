class Buffer {
    int a;
    boolean produced = false;

    public synchronized void produce(int x) {
        while (produced) { 
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        a = x;
        System.out.println("Product " + a + " is produced.");
        produced = true;
        notify();
    }

    public synchronized void consume() {
        while (!produced) { 
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Product " + a + " is consumed.");
        produced = false;
        notify();
    }
}
class Producer extends Thread {
    Buffer b;

    public Producer(Buffer b) {
        this.b = b;
    }

    public void run() {
        System.out.println("Producer starts producing...");
        for (int i = 1; i <= 10; i++) {
            b.produce(i);
        }
    }
}

class Consumer extends Thread {
    Buffer b;

    public Consumer(Buffer b) {
        this.b = b;
    }

    public void run() {
        System.out.println("Consumer starts consuming...");
        for (int i = 1; i <= 10; i++) {
            b.consume();
        }
    }
}

public class BoundedBuffer {
    public static void main(String[] args) {
        // Create Buffer object.
        Buffer b = new Buffer();
        // creating producer thread.
        Producer p = new Producer(b);
        // creating consumer thread.
        Consumer c = new Consumer(b);
        // starting threads.
        p.start();
        c.start();
    }
}
