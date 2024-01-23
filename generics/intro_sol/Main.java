package generics.intro_sol;

public class Main {

    public static void main(String[] args) {
        Printer<Integer> ip = new Printer<>(10);
        int i = ip.get();

        Printer<String> sp = new Printer<>("Hello");

//        Printer<Double> dp = new Printer<>("String"); // This fails because of compile time checks
        Printer<Double> dp = new Printer<>(23d);
        double d = dp.get();

        Pair<String, Integer> si = new Pair<>("String", 1);
        String first = si.getFirst();
        Integer second = si.getSecond();

        Pair<Integer, Pair<String, Integer>> pair = new Pair<>(1, si);
        Pair<String, Integer> second1 = pair.getSecond();

        Pair<Integer, Student> rollNumber = new Pair<>(1, new Student(20, "ABC"));


    }
}

class Student{
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
