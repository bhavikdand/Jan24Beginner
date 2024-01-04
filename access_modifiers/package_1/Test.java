package access_modifiers.package_1;



public class Test {

    public static void main(String[] args) {
        Student s = new Student();
        // System.out.println(s.name); Name has private access. cant access here
        System.out.println(s.email); // Can access because email is default.
        // s.print(); // print is private
        System.out.println(s.age); // age is protected
    }
}
