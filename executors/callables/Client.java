package executors.callables;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws Exception{
        RandomNumberGenerator rg = new RandomNumberGenerator();
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> integerFuture= executorService.submit(rg);
        System.out.println("I am processing something else");
        System.out.println("I am still processing something else");
        Integer randomVal = integerFuture.get();
        System.out.println("Random value is" + randomVal);
        executorService.shutdown();
    }
}
