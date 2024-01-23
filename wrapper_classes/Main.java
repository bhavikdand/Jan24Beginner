package wrapper_classes;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int num = 10;
        Integer wrappedNum = num; // Autoboxing

        int n = wrappedNum; // Unboxing

        Integer i = new Integer(10); // Unnecessary boxing
        // Integer i = 10;

//        List<int> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        Boolean b = false;
    }
}
