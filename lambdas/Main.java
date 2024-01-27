package lambdas;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
        A a = new A(){
            public void show(){
                System.out.println("I am overridden");
            }
        };
        a.show();



        B b = new B() {
            public void demo(){
                System.out.println("I am in demo");
            }
        };
        b.demo();

        B bLambda = () -> System.out.println("I am in demo lambda");
        bLambda.demo();

        C cLambda = n -> {
            int sq = n * n;
            System.out.println(sq);
        };
        cLambda.square(5);

        // When you want to return something from lambda
        // And your lambda body has only 1 loc, then even return is optional
        D dLambda = x -> x*x;
        System.out.println("D:" + dLambda.square(5));

        E eLambda = (x,y) -> x + y;
        System.out.println("E:" + eLambda.add(25 , 26));

        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println("I am in thread: " + Thread.currentThread().getName());
            }
        };
        Thread t = new Thread(r);
        t.start();

        Runnable rLambda = ()  -> System.out.println("I am in a thread made by Lambda");
        Thread tLambda = new Thread(rLambda);
        tLambda.start();
    }

    public static void doSomething(int n){

    }


}

class A {
    public void show(){
        System.out.println("I am in A");
    }
}

//@FunctionalInterface
interface B{
    public void demo();
//    public void demo2(); // Multiple non-overriding abstract methods found in interface lambdas.B
}

interface C{
    public void square(int n);
}

interface D {
    public int square(int n);
}

interface E {
    public int add(int a, int b);
}
