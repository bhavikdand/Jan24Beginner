package design_patterns.singleton;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Boolean> map = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<10000; i++){
            Runnable r = () -> {
                //System.out.println("Name:" + Thread.currentThread().getName());
                DBConnection dbc = DBConnection.getInstance();
//                map.put(dbc.toString(), true);
//                System.out.println(dbc.toString());
                // Thread t = new Thread(r);
                // t.start();
                // t.join();
                set.add(dbc.toString());
            };
            executorService.execute(r);
        }
        executorService.shutdown();
        System.out.println("O/P:" + set.size());
        for(String s: set){
            System.out.println(s);
        }
    }
}
