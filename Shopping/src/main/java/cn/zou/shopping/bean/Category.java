package cn.zou.shopping.bean;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Category {
    private Long cId;

    private String name;

    private Integer parentId;

    private Date uptime;

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public Category() {
    }

}