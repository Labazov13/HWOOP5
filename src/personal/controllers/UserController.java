package personal.controllers;

import personal.model.Repository;
import personal.model.User;

import java.io.IOException;
import java.util.List;

public class UserController {
    private final Repository repository;

    public UserController(Repository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.CreateUser(user);
    }

    public User readUser(String userId) throws Exception {
        List<User> users = repository.getAllUsers();
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        throw new Exception("User not found");
    }

    public List<User> getUsers(){
        return repository.getAllUsers();
    }

    public void deleteUser(String userID) throws IOException {
        List<User> users = repository.getAllUsers();
        for(User user : users){
            if(user.getId().equals(userID)){
                repository.deleteUser(user, userID);
            }
        }
    }
    public void deleteAllUser() throws IOException {
        List<User> users = repository.getAllUsers();
        repository.deleteAllUser(users);

    }

    public void updateUser(User updateUser) {
        repository.updateUser(updateUser);
    }
}
