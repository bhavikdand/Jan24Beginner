package contructors;

public class Client {
    public static void main(String[] args) {
//        Student s = new Student(); //Expected 2 arguments but found 0
//        Student s = new Student( 27, "Bhavik");
//        Student s1 = new Student(28, "XYZ");

        int age = 30;
        boolean b = true;
        Student s = new Student();
        s.setAge(30);
        s.setName("Bhavik");

        printStudent(s);
//
//
        System.out.println("After print student:" + s.name);
        Student copy = new Student(s);
        // copy.age = s.age;
        System.out.println(copy.name);
    }

    public static void printStudent(Student s){
//        System.out.println(s.age);
        System.out.println(s.name);
        s.name = "Shashank";
    }
}
