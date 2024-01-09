package polymorphism;

public class Example {

    public static void main(String[] args) {
        A obj = new C();
        System.out.println(obj.a);
        System.out.println(obj.b);
        // System.out.println(obj.c);
        // System.out.println(obj.d);

        obj = new B();
        System.out.println(obj.a);
        System.out.println(obj.b);
//         System.out.println(obj.c);
//         System.out.println(obj.d);

        B b = new C();
        System.out.println(b.a);
        System.out.println(b.b);
        System.out.println(b.c);
        // System.out.println(b.d);
    }
}

class A{
    int a,b;
}

class B extends A{
    int c;
}

class C extends B {
    int d;
}
