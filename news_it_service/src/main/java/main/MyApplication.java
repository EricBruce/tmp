package main;

import eric.yxs.newsit.resource.UserResource;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by eric on 15-1-31.
 */
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(UserResource.class);
        return classes;
    }
}
