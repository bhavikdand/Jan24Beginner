package threads.demo1;

public class Example {

    public static void main(String[] args) {
        BasicThread basicThread = new BasicThread();
        System.out.println("Main thread: " + Thread.currentThread().getName());
        Thread t = new Thread(basicThread);
        t.start();
    }
}
