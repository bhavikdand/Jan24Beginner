package static_demo;

import java.util.Date;

public class Example {

    public static void main(String[] args) {
        System.out.println(A.b);
        A.b=1;
        A obj = new A();
        obj.a = 1;
        System.out.println(obj.b); //Static member 'static_demo.A.b' accessed via instance reference
        A.print();
        obj.print();
        DateUtils.printDate(new Date());
    }
}

class A {

    static {
        b = 1;
        System.out.println("Static block complete");
    }
    int a;
    static int b;

    static void print(){
        System.out.println("Print");
        System.out.println(b);
        // System.out.println(a); Not allowed
    }

    void doSomething(){
        System.out.println(a);
        System.out.println(b);
    }
}

class DateUtils{
    // Utility methods are generally marked static
    public static void printDate(Date d){
        System.out.println(d);
    }

    public static void manipulateDate(Date d){

    }
}
