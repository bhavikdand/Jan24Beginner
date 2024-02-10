package design_patterns.builder.basic;

public class Client {

    public static void main(String[] args) throws Exception{
        Builder builder = new Builder();
        builder.setAge(20);
        builder.setName("Bhavik");
        builder.setEmail("b@d.com");
        builder.setPhone("+123");

        Student s = new Student(builder);
        System.out.println("DEBUG");

        A.B b = new A().new B();
        b.b = "val";
        System.out.println(b.b);

        A.C c = new A.C();

    }
}

class A {
    int a;
    class B{
        String b;
    }

    static class C { // static inner class
        double c;
    }
}
