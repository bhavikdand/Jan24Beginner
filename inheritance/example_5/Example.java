package inheritance.example_5;

public class Example {

    public static void main(String[] args) {
        Instructor i = new Instructor("Bhavik", "b@d.com", "Mar23 Beginner");
    }
}

class User {
    String name;
    String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

class Instructor extends User{
    String batch;

    public Instructor(String name, String email, String batch){
        super(name, email);
        this.batch = batch;

    }
}
