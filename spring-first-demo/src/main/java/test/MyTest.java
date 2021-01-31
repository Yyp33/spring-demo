package test;

import service.UserService;
import service.impl.UserServiceImpl;

public class MyTest {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.getUser();
    }
}
