package synchronized_block;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{

    Count count;
    final Object lock;

    public Adder(Count count, Object lock) {
        this.count = count;
        this.lock = lock;
    }


    @Override
    public void run() {
        for(int i=0; i<100000; i++){
            synchronized (lock) {
                count.num++;
            }
        }
    }
}
