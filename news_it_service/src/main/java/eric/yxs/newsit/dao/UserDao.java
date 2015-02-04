package eric.yxs.newsit.dao;

import java.util.ArrayList;
import java.util.List;

import eric.yxs.newsit.model.User;
import util.MongoDBUtils;

public class UserDao {

    private UserDao() {
    }

    private static List<User> users = new ArrayList<User>();

    public static void addUser(User u) {
        //users.add(u);
        MongoDBUtils.insertUserData(u);
    }

    public static User getUserById(String id) {
        return MongoDBUtils.findUserByID(id);
    /*for (User u : users) {
      if (u.getId().equals(id)) {
        return u;
      }
    }
    return null;*/

    }

    public static List<User> getUsers() {
        return MongoDBUtils.findUsers();
    }

    public static void delUserById(String id) {
        MongoDBUtils.removeByID(id);
    /*User user = null;
    for (User u : users) {
      if (u.getId().equals(id)) {
        user = u;
      }
    }

    if (user != null) {
      users.remove(user);
    }*/
    }

    public static void updateUser(User user) {
/*
    for (User u : users) {
      if (u.getId().equals(user.getId())) {
        u.setUserName(user.getUserName());
        u.setPhone(user.getPhone());
      }
    }*/
        MongoDBUtils.updateByUser(user);

    }


}