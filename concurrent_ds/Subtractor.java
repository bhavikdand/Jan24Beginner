package concurrent_ds;

import adder_subtractor.Count;

import java.util.concurrent.atomic.AtomicInteger;

public class Subtractor implements Runnable{

    private AtomicInteger ai;

    public Subtractor(AtomicInteger ai) {
        this.ai = ai;
    }

    @Override
    public void run() {
        for (int i=0; i<100000; i++){
            ai.decrementAndGet();
            System.out.println("Sub i" + i);
        }
    }
}
