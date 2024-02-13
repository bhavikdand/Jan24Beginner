package design_patterns.prototype_registry;

import java.util.Random;

public class Main {

    public static final String STUDENT_KEY = "STUDENT";
    public static final String INTELLIGENT_STUDENT_KEY = "INTELLIGENT_STUDENT";

    public static void main(String[] args) {
        setupRegistry();
        Student student = getStudent();
        Student clone = student.clone();

        StudentRegistry studentRegistry = StudentRegistry.getInstance();
        IntelligentStudent intStudent = (IntelligentStudent) studentRegistry.get(INTELLIGENT_STUDENT_KEY);
        IntelligentStudent cloneIntStudent = intStudent.clone();
    }

    public static void setupRegistry(){
        StudentRegistry studentRegistry = StudentRegistry.getInstance();
        Student prototypeStudent = new Student(20, "John Doe", "Stanford");
        IntelligentStudent prototypeIntelligentStudent = new IntelligentStudent(20, "Einstein", "Princeton", 180);
        studentRegistry.register(STUDENT_KEY, prototypeStudent);
        studentRegistry.register(INTELLIGENT_STUDENT_KEY, prototypeIntelligentStudent);
    }

    public static Student getStudent(){
        Random random = new Random();
        int n = random.nextInt();
        if(n%2==0){
            return new Student(20, "ABC", "XYZ");
        } else {
            return new IntelligentStudent(25, "DEF", "PQR", 100);
        }
    }
}
