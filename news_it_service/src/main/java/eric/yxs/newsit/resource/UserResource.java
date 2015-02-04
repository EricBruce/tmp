package eric.yxs.newsit.resource;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import eric.yxs.newsit.model.User;
import eric.yxs.newsit.service.UserService;

@Singleton
@Path("/users")
public class UserResource {

    @GET
    @Produces({"application/json", "application/xml"})
    public List<User> getMyResources() {
        List<User> users = UserService.getUsers();
        return users;
    }

    @GET
    @Path("/list")
    @Produces({"application/json", "application/xml"})
    public List<User> getListOfUsers() {
        List<User> users = UserService.getUsers();
        return users;
    }

    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    public User getUser(@PathParam("id") String id) {
        User u = UserService.getUserById(id);
        return u;
    }

    @PUT
    //@Path("/ids/{id}")
    @Consumes({"application/json", "application/xml"})
    public void putUser(User user) {

        UserService.updateUser(user);

    }

    @POST
    //@Path("/ids/{id}")
    @Consumes({"application/json", "application/xml"})
    public void postUser(User user) {

        UserService.addUser(user);

    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") String id) {
        UserService.delUserById(id);
    }

}