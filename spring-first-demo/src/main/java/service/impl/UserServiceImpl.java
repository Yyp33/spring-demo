package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    //如果dao层数据库由mysql切换成oracle，如果不适用spring进行管理，
    // 那么所有使用new UserDaoImpl方法的地方都需要修改成new UserOracleDaoImpl
    // ,如果有200个使用的地方费时费力耦合度高，类与类之间的没有关联，关联关系都在spring容器中，实现了解耦
    // 而使用spring的话只需要修改配置或者注解里的实现即可，方便快捷，并且实现了控制反转，
    // 即现在类的实现是由自身创建，而使用spring容器之后，spring给创建接口的实现由spring管理，自己成了被动接受，
    // 由主动转为被动，控制反转
    //UserDao userDao = new UserDaoImpl();

    //使用依赖注入方式
    UserDao userDao;

    //配置文件中配置依赖注入需要提供get，set方法
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser() {
        userDao.getUser();
        return null;
    }
}
