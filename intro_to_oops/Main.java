package intro_to_oops;

public class Main {

    public static void main(String[] args) {
        Student mayurStudent = new Student();
        mayurStudent.name = "Mayur";
        mayurStudent.email = "mayur@gmail.com";
        mayurStudent.age = 25;
        mayurStudent.pauseCourse();

        Student bhavik = new Student();
        bhavik.name = "Bhavik";
        bhavik.changeBatch();
    }
}
