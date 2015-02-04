package eric.yxs.newsit.service;

import com.mongodb.DBObject;
import eric.yxs.newsit.dao.MongoDBDao;
import eric.yxs.newsit.model.News;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedisPool;
import util.MongoBeanUtil;
import util.RedisUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * news eric.yxs.newsit.dao.service impl
 * <p/>
 * Created by eric on 15-1-31.
 */
@Service
public class NewsService implements INewsService {
    @Resource
    MongoDBDao mongoDBDao;
    @Resource
    ShardedJedisPool shardedJedisPool;

    @Value("${mongo_db}")
    private String db;
    @Value("${mongo_collection}")
    private String collection;
    @Value("${redis.digg.key}")
    private String diggKey;


    @Override
    public List<News> getAllNews() {

        List<News> result = new ArrayList<News>();
        // TODO query param
        List<DBObject> list = mongoDBDao.find(db, collection, null, null, -1);
        try {
            for (DBObject o : list) {
                News news = new News();
                MongoBeanUtil.dbObject2Bean(o, news);
                result.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public News getNews(String id) {
        String[] keys = new String[]{"_id"};
        Object[] values = new Object[]{new ObjectId(id)};
        List<DBObject> re = mongoDBDao.find(db, collection, keys, values, 1);
        try {
            if (re.size() == 1) {
                News news = new News();
                return MongoBeanUtil.dbObject2Bean(re.get(0), news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int diggNews(String id) {
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.setShardedJedisPool(shardedJedisPool);
        if (redisUtil.isMemberOfSortedSet(diggKey, id)) {
            redisUtil.incrbyWithSortedSet(diggKey, id);
        } else {
            redisUtil.addWithSortedSet(diggKey, 1, id);
        }
        return 0;
    }

}
