package eric.yxs.newsit.model;

import java.io.Serializable;

/**
 * Created by eric on 15-2-1.
 */
public class DiggObj implements Serializable {

    private static final long serialVersionUID = 2776457767590977954L;

    private String id;
    private int dugg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDugg() {
        return dugg;
    }

    public void setDugg(int dugg) {
        this.dugg = dugg;
    }

    @Override
    public String toString() {
        return "DiggObj{" +
                "id='" + id + '\'' +
                ", dugg=" + dugg +
                '}';
    }
}
