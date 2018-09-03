package cn.zou.shopping.bean;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Book {
    private Long bId;

    private String author;

    private String bookImage;

    private String bookName;

    private Integer price;

    private Integer totalPage;

    private String pubilshing;

    private Long stock;

    private Long sale;

    private Date uptime;

    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage == null ? null : bookImage.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public String getPubilshing() {
        return pubilshing;
    }

    public void setPubilshing(String pubilshing) {
        this.pubilshing = pubilshing == null ? null : pubilshing.trim();
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Long getSale() {
        return sale;
    }

    public void setSale(Long sale) {
        this.sale = sale;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public Book() {
    }

    public Book(String author, String bookImage, String bookName, Integer price, Integer totalPage, String pubilshing, Long stock, Long sale) {
        this.author = author;
        this.bookImage = bookImage;
        this.bookName = bookName;
        this.price = price;
        this.totalPage = totalPage;
        this.pubilshing = pubilshing;
        this.stock = stock;
        this.sale = sale;
    }

    public Book(Long bId, String author, String bookImage, String bookName, Integer price, Integer totalPage, String pubilshing, Long stock, Long sale) {
        this.bId = bId;
        this.author = author;
        this.bookImage = bookImage;
        this.bookName = bookName;
        this.price = price;
        this.totalPage = totalPage;
        this.pubilshing = pubilshing;
        this.stock = stock;
        this.sale = sale;
    }
}
