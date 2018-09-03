package cn.zou.shopping.service;

import cn.zou.shopping.bean.Book;
import cn.zou.shopping.bean.Msg;

import java.util.List;

/**
 * Created by 邹创基 on 2018/5/21 9:41
 *
 * @Description:
 */

public interface BookService {

    //通过书籍主键查找书籍，返回Msg对象
    public Msg getBookByPrimary(long id);
    //通过书籍主键查找书籍，返回Book对象
    public Book getBook(long id);
    //按价格降序列出所有书籍
    List<Book> getAllBookByPriceDESC();
    //按价格升序列出所有书籍
    List<Book> getAllBookByPriceASC();
    //获取所有书籍,返回List对象
    public List<Book> getAllBook();
    //获取书籍的类别,返回List对象
    public List<Book> getAllBookByType(Integer typeId);
    //通过书籍名字模糊查询书籍,返回List对象
    public List<Book> getAllBookByName(String bookName);
    //删除该主键所对应的书籍所有的信息
    public Msg deleteBook(Long bookId);
    //更新该书籍信息
    public void updateBook(Book book);
    //在书籍类别表中保存该书籍对应的信息
    public void saveBook(Book book,long cId);
    //根据书籍销量降序排序,列出五本
    public List<Book> selectBookBySale();
}
