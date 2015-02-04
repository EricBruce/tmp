package eric.yxs.newsit.service;

import java.util.List;

import eric.yxs.newsit.dao.UserDao;
import eric.yxs.newsit.model.User;

public class UserService {

    public static User  getUserById(String id) {

        return UserDao.getUserById(id);
    }

    public  static List<User> getUsers() {

        return UserDao.getUsers();
    }

    public static void delUserById(String id) {
        UserDao.delUserById(id);
    }



    public static void addUser(User user) {

        UserDao.addUser(user);
    }

    public static void updateUser(User user) {

        UserDao.updateUser(user);
    }

}