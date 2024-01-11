package interfaces.demo.good_implementation;

import interfaces.demo.User;

public class UserService {
    static DbOperations db = new MySqlDbOps();

    public User saveUser(User u){
       return db.insert(u);
    }

    public User update(int id,User updated){
        return db.update(id, updated);
    }

    public static void main(String[] args) {
        db.insert(new User());
        db.update(1, new User());
    }
}
