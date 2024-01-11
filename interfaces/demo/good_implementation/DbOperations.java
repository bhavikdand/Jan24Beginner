package interfaces.demo.good_implementation;

import interfaces.demo.User;

public interface DbOperations {

    User insert(User user);

    User update(int id, User user);
}
