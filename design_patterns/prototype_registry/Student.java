package design_patterns.prototype_registry;

public class Student implements Cloneable{
    private int age;
    private String name;
    private String university;

    public Student(int age, String name, String university) {
        this.age = age;
        this.name = name;
        this.university = university;
    }

    public Student(Student original){
        this.name = original.name;
        this.age = original.age;
        this.university = original.university;
    }

    protected Student clone() {
        return new Student(this);
    }
}
