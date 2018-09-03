package cn.zou.shopping.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 邹创基 on 2018/5/26 14:39
 *
 * @Description:
 */

public class DetailList implements Serializable {
    private List<Detail> details;

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public DetailList() {
        super();
    }

    public DetailList(List<Detail> details) {
        this.details = details;
    }
}
