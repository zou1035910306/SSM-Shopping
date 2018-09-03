package cn.zou.shopping.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class Detail implements Serializable{
    private Long odId;

    private String bookName;

    private Integer bookPrice;

    private Integer bookNum;

    private String oId;

    private Date uptime;

    public Long getOdId() {
        return odId;
    }

    public void setOdId(Long odId) {
        this.odId = odId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public Detail() {
    }

    public Detail(String bookName, Integer bookPrice, Integer bookNum) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookNum = bookNum;
    }

    public Detail(Long odId, String bookName, Integer bookPrice, Integer bookNum, String oId, Date uptime) {
        this.odId = odId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookNum = bookNum;
        this.oId = oId;
        this.uptime = uptime;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "odId=" + odId +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookNum=" + bookNum +
                ", oId='" + oId + '\'' +
                ", uptime=" + uptime +
                '}';
    }
}