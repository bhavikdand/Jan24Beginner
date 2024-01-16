package doubts;

import java.util.*;

public class carsort {

    public static void main(String[] args) {
        List<Car> list = Arrays.asList(new Car(10), new Car(5), new Car(15));
        Collections.sort(list);
        System.out.println(list);
    }
}

class Car implements Comparable<Car>, Iterable<Car>{
    int speed;
    int price;

    public Car(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Car o) {
        return o.price - this.price;
    }

    @Override
    public String toString() {
        return "Price:" + this.price;
    }

    @Override
    public Iterator<Car> iterator() {
        return null;
    }
}
