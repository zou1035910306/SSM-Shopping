package cn.zou.shopping.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class Order implements Serializable{
    private String oId;

    private Integer orderStatus;

    private String targetAddress;

    private String telephone;

    private Integer price;

    private String description;

    private Long uId;

    private String username;

    private Date uptime;

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(String targetAddress) {
        this.targetAddress = targetAddress == null ? null : targetAddress.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Order() {
    }

    public Order(String targetAddress, String telephone, Integer price, String description) {
        this.targetAddress = targetAddress;
        this.telephone = telephone;
        this.price = price;
        this.description = description;
    }

    public Order(Integer orderStatus, String targetAddress, String telephone, Integer price, String description, Long uId, String username) {
        this.orderStatus = orderStatus;
        this.targetAddress = targetAddress;
        this.telephone = telephone;
        this.price = price;
        this.description = description;
        this.uId = uId;
        this.username = username;
    }

    public Order(String oId, Integer orderStatus, String targetAddress, String telephone, Integer price, String description, Long uId, String username) {
        this.oId = oId;
        this.orderStatus = orderStatus;
        this.targetAddress = targetAddress;
        this.telephone = telephone;
        this.price = price;
        this.description = description;
        this.uId = uId;
        this.username = username;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oId='" + oId + '\'' +
                ", orderStatus=" + orderStatus +
                ", targetAddress='" + targetAddress + '\'' +
                ", telephone='" + telephone + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", uId=" + uId +
                ", username='" + username + '\'' +
                ", uptime=" + uptime +
                '}';
    }
}