package access_modifiers.package_1;

public class Student {
    private String name;
    String email;

    protected int age;

    private void print(){
        System.out.println(this.name);
    }

    void cook(){
        print();
    }

}
