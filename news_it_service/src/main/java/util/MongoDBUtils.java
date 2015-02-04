package util;

import java.util.ArrayList;
import java.util.List;

import eric.yxs.newsit.model.User;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;

public class MongoDBUtils {

    public static Mongo mongo = null;

    public static DB db = null;
    private static String dbName = "UserAdmin";
    private static String mongodbServerAddress = "127.0.0.1:27017";
    private static String colName = "User";

    public static DBCollection getDBCollection() {
        try {
            if (mongo == null) {

                List<ServerAddress> addList = new ArrayList<ServerAddress>();
                String[] addrs = mongodbServerAddress.split(";");
                for (String address : addrs) {
                    ServerAddress addr = new ServerAddress(address);
                    addList.add(addr);
                }
                mongo = new Mongo(addList);
                // mongodb连接池数
                MongoOptions opt = mongo.getMongoOptions();
                opt.connectionsPerHost = 400;
                opt.threadsAllowedToBlockForConnectionMultiplier = 20;
                opt.maxWaitTime = 5000;
                opt.socketTimeout = 0;
                opt.connectTimeout = 15000;

            }

            if (db == null) {
                db = mongo.getDB(dbName);
            }

        } catch (Exception e) {

        }
        return db.getCollection(colName);
    }

    public static User findUserByID(String id) {

        DBCollection coll = null;

        coll = getDBCollection();


        DBCursor cur = coll.find(new BasicDBObject("id", id));
        User user = new User();
        if (cur.size() > 0) {

            while (cur.hasNext()) {

                DBObject o = (DBObject) cur.next();

                String userName = o.get("username").toString();

                String phone = o.get("phone").toString();
                user.setId(id);
                user.setPhone(phone);
                user.setUserName(userName);
            }
        }

        return user;
    }

    public static List<User>  findUsers() {

        DBCollection coll = null;
        DBObject queryType = null;

        coll = getDBCollection();

        List<User> users=new ArrayList<User>();
        DBCursor cur = coll.find();

        if (cur.size() > 0) {

            while (cur.hasNext()) {
                User user = new User();
                DBObject o = (DBObject) cur.next();

                String id = o.get("id").toString();
                String userName = o.get("username").toString();

                String phone = o.get("phone").toString();
                user.setId(id);
                user.setPhone(phone);
                user.setUserName(userName);
                users.add(user);
            }
        }

        return users;
    }

    public static void removeByID(String value) {

        DBCollection coll = null;
        try {
            coll = getDBCollection();
            coll.remove(new BasicDBObject().append("id", value));
        } catch (Exception e) {

        }

    }

    public static void insertUserData(User user) {

        DBCollection dbCol = null;
        try {
            dbCol = getDBCollection();

            List<DBObject> dbList = new ArrayList<DBObject>();
            BasicDBObject subscribe = new BasicDBObject();

            subscribe.put("id", user.getId());
            subscribe.put("username", user.getUserName());
            subscribe.put("phone", user.getPhone());

            dbList.add(subscribe);
            dbCol.insert(dbList);
        } catch (Exception e) {

        }
    }

    public static void updateByUser(User user) {

        DBCollection coll = null;
        try {
            coll = getDBCollection();

            BasicDBObject newDocument3 = new BasicDBObject().append("$set",
                    new BasicDBObject().append("username", user.getUserName())
                            .append("phone", user.getPhone()));

            coll.update(new BasicDBObject().append("id", user.getId()), newDocument3);

        } catch (Exception e) {

        }

    }

    public static void close() {
        try {
            if (mongo != null) {
                mongo.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}