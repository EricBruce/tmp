package eric.yxs.newsit.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by eric on 15-1-31.
 */
public class News implements Serializable {

    private static final long serialVersionUID = -2043163111968186779L;
    private String _id;
    private String title;
    private String desc;
    private String link;
    private String imageUrl;
    private String time;

    public News() {
    }

    public News(String title, String desc, String link, String imageUrl, String time) {

        this.title = title;
        this.desc = desc;
        this.link = link;
        this.imageUrl = imageUrl;
        this.time = time;
    }
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", link='" + link + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
