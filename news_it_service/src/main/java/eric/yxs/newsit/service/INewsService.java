package eric.yxs.newsit.service;

import eric.yxs.newsit.model.News;

import java.util.List;

/**
 * news eric.yxs.newsit.dao.service
 * <p/>
 * Created by eric on 15-1-31.
 */
public interface INewsService {

    /**
     * get all news
     *
     * @return
     */
    public List<News> getAllNews();

    /**
     * get news by id
     *
     * @param id
     * @return
     */
    public News getNews(String id);

    /**
     * digg(or undigg) a news (by click page's button)
     *
     * @param id
     * @return
     */
    public int diggNews(String id);


}
