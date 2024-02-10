package design_patterns.builder.prod;

import design_patterns.builder.prod.Student;

public class Client {

    public static void main(String[] args) throws Exception{
        /*
        1. Get rid of 2 classes and have a single class.
        2. Make Builder as static inner class
        3. Create a static method in Student (getBuilder), which return obj of builder
        4. We changed the return type of setters to Builder. // Method Chaining
        5. We will create build method inside Builder
         */
        Student s = Student.getBuilder()
                .setAge(25)
                .setPhone("+123")
                .setName("Bhavik")
                .setEmail("b@d.com")
                .build();


    }
}
