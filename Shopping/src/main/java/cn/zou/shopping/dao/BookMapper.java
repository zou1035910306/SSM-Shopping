package cn.zou.shopping.dao;

import cn.zou.shopping.bean.Book;
import cn.zou.shopping.bean.BookExample;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.crypto.hash.Hash;

import java.util.HashMap;
import java.util.List;

public interface BookMapper {

    //通过书籍主键查找书籍
    Book selectByPrimaryKey(long bId);
    //获取所有书籍
    List<Book> getAllBook();
    //按价格降序列出所有书籍
    List<Book> getAllBookByPriceDESC();
    //按价格升序列出所有书籍
    List<Book> getAllBookByPriceASC();
    //查找该类别下所有书籍
    List<Book> getAllBookByType(Integer typeId);
    //通过书籍名字模糊查询书籍
    List<Book> getAllBookByName(String bookName);
    //删除书籍类别表中b_id为该书籍主键的行
    void deleteBook_Category(Long bookId);
    //删除书籍表中主键为该书籍主键的行
    void deleteBookByPrimary(Long bookId);
    //更新该书籍信息
    void updateBook(Book book);
    //在书籍表中保存该书籍信息
    int saveBook(Book book);
    //在书籍类别表中保存该书籍对应的信息
    int saveBookCategory(HashMap<String, Long> map);
    //更新对应的书籍的库存和销量
    int reduceBook(HashMap<String, Long> map);
    //查询对应数据的库存
    long checkBookStock(long bId);
    //根据书籍销量降序排序,列出五本
    List<Book> selectBookBySale();
}