package personal.model;

import java.io.IOException;
import java.util.List;

public interface Repository {
    List<User> getAllUsers();
    String CreateUser(User user);
    void updateUser(User user);

    void deleteUser(User user, String ID) throws IOException;
    void deleteAllUser(List<User> users) throws IOException;
}
