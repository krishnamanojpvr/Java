// 1. create a task
// 2. create a thread
// 3. assign the thread to the task
// 4. start the thread
import java.util.Scanner;
class Task1 implements Runnable {
    Scanner sc = new Scanner(System.in);
    public void run() {
        System.out.println("Enter the number");
        int n = sc.nextInt();

        for (int i = 1; i < n; i++) {
            System.out.println("Counter: " + i + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Task2 implements Runnable {
    public void run() {
        for (int i = 500; i < 601; i++) {
            System.out.println("Counter: " + i + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Task3 implements Runnable {
    public void run() {
        for (int i = 1000; i < 1101; i++) {
            System.out.println("Counter: " + i + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TestThread{
    public static void main(String[] args) {
        Task1 ta1 = new Task1();
        Task2 ta2 = new Task2();
        Task3 ta3 = new Task3();
        Thread t1 = new Thread(ta1);
        Thread t2 = new Thread(ta2);
        Thread t3 = new Thread(ta3);
        t1.start();
        t2.start();
        t3.start();
    }
}