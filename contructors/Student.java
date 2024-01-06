package contructors;

public class Student {

    private int age;
     String name;

    public Student() {
        this.age = 20;
        this.name = "XYZ";
    }

    public Student(Student s){
        this.name = s.name;
        this.age= s.age;
    }


//    public Student(int age, String name) {
//        this.age = age;
//        this.name = name;
//    }

    public Student(int age1, String name1) { // No need of this keyword here
        age = age1;
        name = name1;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
