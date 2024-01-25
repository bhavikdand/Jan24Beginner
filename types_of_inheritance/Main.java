package types_of_inheritance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CCC obj = new CCC();
        obj.someLogic();

    }
}

class A{
    public void display(){
        System.out.println("A");
    }
}

class B extends  A{
   public void display(){
       System.out.println("B");
   }
}

class C extends A{
    public void display(){
        System.out.println("C");
    }
}

//class D extends A,B{ // Class cannot extend multiple classes
//
//    void doSomething(){
//        display();
//    }
//}


interface AA{
    int a();
}

interface  BB {
    int a();
}

class ABC implements AA,BB{

    @Override
    public int a() {
        return 0;
    }
}

// Multiple inheritance is allowed for interfaces and not for classes
class XYZ extends A implements AA,BB,Runnable{

    @Override
    public void run() {

    }

    @Override
    public int a() {
        return 0;
    }
}

interface CC{

    int a =5;
    public static final int b= 10;

    default void doSomething(){
        System.out.println("I am a default method");
    }
    public void a();
}

class CCC implements CC {

    @Override
    public void a() {

    }

    public void doSomething(){
        System.out.println("I am in class");
    }

    public void someLogic(){
        doSomething();
    }

}