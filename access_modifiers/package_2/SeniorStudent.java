package access_modifiers.package_2;

import access_modifiers.package_1.Student;

public class SeniorStudent extends Student {

    void print(){
        // System.out.println(name);
//        System.out.println(email); // Diff packages
        System.out.println(age); // Diff package, child can access protected members.

    }
}
