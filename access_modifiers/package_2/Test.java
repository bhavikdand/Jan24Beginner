package access_modifiers.package_2;


import access_modifiers.package_1.Student;

class Test {

    public static void main(String[] args) {
        Student s = new Student();
        //System.out.println(s.email); //'email' is not public in 'access_modifiers.package_1.Student'. Cannot be accessed from outside package
        // System.out.println(s.age); //'age' has protected access in 'access_modifiers.package_1.Student'

    }
}
