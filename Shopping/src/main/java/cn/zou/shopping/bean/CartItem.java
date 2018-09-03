package cn.zou.shopping.bean;

/**
 * Created by 邹创基 on 2018/5/23 13:13
 *
 * @Description:购物车类
 */

public class CartItem {
    private long id;
    private long b_id;
    private String author;
    private String book_image;
    private String book_name;
    private int price;
    private String pubilshing;
    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getB_id() {
        return b_id;
    }

    public void setB_id(long b_id) {
        this.b_id = b_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook_image() {
        return book_image;
    }

    public void setBook_image(String book_image) {
        this.book_image = book_image;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public String getPubilshing() {
        return pubilshing;
    }

    public void setPubilshing(String pubilshing) {
        this.pubilshing = pubilshing;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartItem() {
    }

    public CartItem(String author, String book_image, String book_name, int price, String pubilshing, int quantity) {
        this.author = author;
        this.book_image = book_image;
        this.book_name = book_name;
        this.price = price;
        this.pubilshing = pubilshing;
        this.quantity = quantity;
    }

    public CartItem(long id, String author, String book_image, String book_name, int price, String pubilshing, int quantity) {
        this.id = id;
        this.author = author;
        this.book_image = book_image;
        this.book_name = book_name;
        this.price = price;
        this.pubilshing = pubilshing;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", book_image='" + book_image + '\'' +
                ", book_name='" + book_name + '\'' +
                ", price=" + price +
                ", pubilshing='" + pubilshing + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
