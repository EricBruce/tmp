package eric.yxs.newsit.resource;

import com.alibaba.fastjson.JSON;
import eric.yxs.newsit.model.News;
import eric.yxs.newsit.service.NewsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/news")
public class NewsResource {
    @Resource
    NewsService newsService;

    @GET
    public String getNews() {
        List<News> list = newsService.getAllNews();
        return JSON.toJSONString(list);
    }

    @POST
    @Path("{id}")
    public Response diggNews(@PathParam("id") String id) {
        newsService.diggNews(id);
        return Response.status(200).entity("OK").build();
    }


    @Path("/hello")
    @GET
    public Response hello() {
        return Response.status(200).entity("Hello World").build();
    }
}



