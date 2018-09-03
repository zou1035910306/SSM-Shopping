package cn.zou.shopping.bean;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 邹创基 on 2018/5/25 20:43
 *
 * @Description:
 */

@Component
public class AllOrder extends Order{
    private List<Detail> details;

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public AllOrder(List<Detail> details) {
        this.details = details;
    }

    public AllOrder() {
    }


}
