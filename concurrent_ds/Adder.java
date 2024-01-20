package concurrent_ds;

import adder_subtractor.Count;

import java.util.concurrent.atomic.AtomicInteger;

public class Adder implements Runnable{

    AtomicInteger ai;

    public Adder(AtomicInteger ai) {
        this.ai = ai;
    }


    @Override
    public void run() {
        for(int i=0; i<100000; i++){
            ai.incrementAndGet();
            System.out.println("Add i" + i);
        }
    }
}
