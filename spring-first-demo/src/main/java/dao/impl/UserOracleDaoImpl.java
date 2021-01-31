package dao.impl;

import dao.UserDao;
import entity.User;
import service.UserService;

public class UserOracleDaoImpl implements UserDao {

    public User getUser() {
        System.out.println("查询Oracle数据库");
        return null;
    }
}
