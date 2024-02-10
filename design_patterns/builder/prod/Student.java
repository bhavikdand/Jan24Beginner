package design_patterns.builder.prod;

public class Student {

    String name;
    String email;
    String phone;
    int age;

    private Student(Builder b) {
        this.age = b.age;
        this.phone = b.phone;
        this.email = b.email;
        this.name = b.name;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    static class Builder{
        String name;
        String email;
        String phone;
        int age;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Student build() throws Exception {
            if(this.age < 18){
                throw new Exception("Age cannot be <18");
            }
            if(this.name == null || this.email == null){
                throw  new Exception("Email or name is missing");
            }
            return new Student(this);
        }
    }
}
