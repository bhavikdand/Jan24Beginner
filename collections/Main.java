package collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();

        map.put(100, "A");
        map.put(50, "B");
        map.put(1, "C");
        map.put(23, "D");
        map.put(57, "E");
        map.put(98, "F");

        for(Map.Entry<Integer, String> entries : map.entrySet()){
            System.out.println(entries.getKey() + " " + entries.getValue());
        }
        Set<Integer> set = new TreeSet<>();

        set.add(1);
        set.add(34);
        set.add(-1);
        set.add(-1);
        set.add(23);
        set.add(57);
        set.add(103);

        /*
        -1
        1
        34
        23
        103
        57
         */

        for(Integer i : set){
            System.out.println(i);
        }

        Queue<Integer> q = new ArrayDeque<>();

        List<Integer> l = new ArrayList<>();
        l.addAll(set);

        Collections.sort(l);
        System.out.println("Sorted"+ l);

        int i = Collections.binarySearch(l, 578345);
        if(i< 0){
            System.out.println("Item not present");
        }
        System.out.println("Index:" + i);

        Collections.shuffle(l);
        System.out.println("Shuffled"+ l);



        List<Integer> li =  Arrays.asList(1,4,6,7,8,230,234,356);
        int[] arr = new int[]{1,234,356,67,78,3452,234};
        Arrays.sort(arr);
        System.out.println("sorted arr:" + Arrays.toString(arr));
    }
}
