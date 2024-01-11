package interfaces.demo.bad_implementation;

import interfaces.demo.User;
import interfaces.demo.library.MySqlDriver;

public class BadUserServiceWithSql {
    MySqlDriver db;

    public User saveUser(User u){
        db.insert(u);
        return u;
    }

    public User update(int id,User updated){
        db.update(id, updated);
        return updated;
    }

}
