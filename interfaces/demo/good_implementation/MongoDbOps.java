package interfaces.demo.good_implementation;

import interfaces.demo.User;
import interfaces.demo.library.MongoDriver;

public class MongoDbOps implements DbOperations{

    MongoDriver db = new MongoDriver();

    public User insert(User user) {
        db.save(user);
        return user;
    }

    public User update(int id, User user) {
        db.update(id, user, false);
        return user;
    }
}
