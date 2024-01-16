package executors;

public class NumberPrinter implements Runnable{
    @Override
    public void run() {
        System.out.println("I am a new task on " + Thread.currentThread().getName());
        for (int i=0; i<10; i++){
            System.out.println("i=" + i+", thread:" + Thread.currentThread().getName());
        }
    }
}
