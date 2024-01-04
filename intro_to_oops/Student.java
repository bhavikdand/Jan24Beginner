package intro_to_oops;

public class Student {
    String name;

    String email;

    int age;

    void changeBatch(){
        System.out.println(this.name + " is changing their batch.");
    }

    void pauseCourse(){
        System.out.println(this.name + " is pausing their course.");
    }
}
