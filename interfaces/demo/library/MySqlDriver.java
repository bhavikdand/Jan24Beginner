package interfaces.demo.library;

import interfaces.demo.User;

public class MySqlDriver {

    public void insert(User u){
        System.out.println("Inserting into mysql db");
    }

    public void update(int id, User updated){
        System.out.println("Updating user with id" + id);
    }
}
