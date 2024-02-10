package design_patterns.builder.basic;

public class Student {
    String name;
    String email;
    String phone;
    int age;

    public Student(Builder builder) throws Exception {
        if(builder.age < 18){
            throw new Exception("Age cannot be <18");
        }
        this.age = builder.age;
        this.name = builder.name;
        this.phone = builder.phone;
        this.email = builder.email;
    }

}
