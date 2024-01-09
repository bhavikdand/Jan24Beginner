package inheritance.example_2;

public class Example {

    public static void main(String[] args) {
        C c = new C();
    }
}

class A{

    public A() {
        System.out.print("A");
    }
}

class B extends A{

//    private B() {
//        System.out.print("B");
//    }
}

class C extends B{

    public C() { //There is no default constructor available in 'inheritance.example_2.B'
        System.out.print("C");
    }
}

