package eric.yxs.newsit.resource;

import eric.yxs.newsit.model.News;
import eric.yxs.newsit.service.NewsService;

import javax.annotation.Resource;
import javax.inject.Singleton;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by eric on 15-2-1.
 */
@Singleton
@Path("/news")
public class NewsResource {
    @Resource
    NewsService newsService;

    @GET
    @Produces({"application/json", "application/xml"})
    public List<News> getNews() {
        List<News> list = newsService.getAllNews();
        return list;
    }

    @POST
    @Produces({"application/json", "application/xml"})
    public void diggNews(@PathParam("id") String id) {
        newsService.diggNews(id);
    }
}



