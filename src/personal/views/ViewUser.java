package personal.views;

import personal.controllers.UserController;
import personal.model.FileOperationImpl;
import personal.model.RepositoryFile;
import personal.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewUser {

    private UserController userController;
    private ValidateData validateData = new ValidateData();

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) {
                    return;
                }
                switch (com) {
                    case CREATE:
                        createUser();
                        break;
                    case READ:
                        readUser();
                        break;
                    case LIST:
                        printAllUsers();
                        break;
                    case UPDATE:
                        updateUser();
                    case DELETE:
                        deleteUser();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void deleteUser() throws IOException {
        String id = prompt("Введите ID пользователя(0 - удаление всей записной книги): ");
        if(id.equals("0")){
            userController.deleteAllUser();
        }
        userController.deleteUser(id);
    }

    private void createUser() {
        userController.saveUser(inputUser());
    }

    private User inputUser() {
        String firstName;
        String lastName;
        String phone;
        do {
            firstName = prompt("Имя: ");
        }
        while (validateData.checkFirstName(firstName));
        do {
            lastName = prompt("Фамилия: ");
        }
        while (validateData.checkLastName(lastName));

        do {
            phone = prompt("Номер телефона: ");
        }
        while (validateData.checkPhone(phone));
        return new User(firstName, lastName, phone);
    }

    private String readUser() {
        String id = prompt("Идентификатор пользователя: ");
        try {
            User user = userController.readUser(id);
            System.out.println(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    private void updateUser() {
        String id = readUser();
        User updateUser = inputUser();
        updateUser.setId(id);
        userController.updateUser(updateUser);
    }

    private void printAllUsers() {
        List<User> userList = userController.getUsers();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
