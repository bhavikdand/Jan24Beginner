package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {
        NumberPrinter np = new NumberPrinter();
//        Thread t = new Thread(np);
//        //t.run();
//        t.start();
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        /*
        Creates a thread pool that creates new threads as needed,
        but will reuse previously constructed threads when they are available.
         These pools will typically improve the performance of programs that execute
         many short-lived asynchronous tasks. Calls to execute will reuse previously
         constructed threads if available. If no existing thread is available,
         a new thread will be created and added to the pool. Threads that have not
         been used for sixty seconds are terminated and removed from the cache.
         Thus, a pool that remains idle for long enough will not consume any resources.
         Note that pools with similar properties but different details
         (for example, timeout parameters) may be created using ThreadPoolExecutor
         constructors.
Returns:
the newly created thread pool
         */
        for (int i=0; i<10; i++){
            executorService.execute(np);
        }
        executorService.shutdown();

    }
}
