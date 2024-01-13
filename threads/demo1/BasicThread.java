package threads.demo1;

public class BasicThread implements Runnable{

    @Override
    public void run() {
        System.out.println("I am in new thread:" + Thread.currentThread().getName());
    }
}
