package access_modifiers.package_1;

public class JuniorStudent extends Student{

    void print(){
        // System.out.println(name); // name is private
        System.out.println(email);
        System.out.println(age);
    }
}
