package client;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import eric.yxs.newsit.model.User;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by eric on 15-1-31.
 */
public class TestClient {
    private static String serverUri = "http://localhost:8080/webapp";

    private static void addUser(User user) {
        System.out.println("*****add User****");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(serverUri + "/users");
        Response response = target.request().
                buildPost(Entity.entity(user, MediaType.APPLICATION_JSON))
                .invoke();
        response.close();
    }

    private static void delUser(String id) {
        System.out.println("******delete user ****");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(serverUri + "/users/" + id);
        Response response = target.request().delete();
    }

    private static void updateUser(User user) {
        System.out.println("**** update user ****");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(serverUri + "/users");
        Response response = target.request().
                buildPut(Entity.entity(user, MediaType.APPLICATION_JSON))
                .invoke();
        response.close();
    }

    private static void getUserById(String id) {
        System.out.println("***8 get by id***");
        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
        WebTarget target = client.target(serverUri + "/users/" + id);
        Response response = target.request().get();
        User user = response.readEntity(User.class);
        System.out.println(user.getId() + ":" + user.getUserName());
        response.close();
    }

    private static void getAllUsers() {
        System.out.println("**** get all users");
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(serverUri + "/users");
        Response response = target.request().get();
        String value = response.readEntity(String.class);
        System.out.println(value);
        response.close();
    }

    public static void main(String[] args) {
        User user = new User("006", "tianyi", "12355123891");
        addUser(user);
        getAllUsers();
        user = new User("006", "tianyi", "33");
        String id = user.getId();
        updateUser(user);
        getUserById(id);
        getAllUsers();
        delUser(id);
        getAllUsers();
    }
}
