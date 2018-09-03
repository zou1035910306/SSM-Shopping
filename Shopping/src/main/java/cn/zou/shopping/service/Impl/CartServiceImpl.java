package cn.zou.shopping.service.Impl;

import cn.zou.shopping.bean.Book;
import cn.zou.shopping.bean.CartItem;
import cn.zou.shopping.bean.Msg;
import cn.zou.shopping.service.BookService;
import cn.zou.shopping.service.CartService;
import cn.zou.shopping.utils.CookieUtil;
import cn.zou.shopping.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 邹创基 on 2018/5/23 19:01
 *
 * @Description:
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    BookService bookService;

    /**
     * 添加购物车商品
     *
     * @param itemId
     * @param request
     * @param response
     * @return
     */
    @Override
    public Msg addCartItem(long itemId, HttpServletRequest request, HttpServletResponse response) {
        //取商品信息
        CartItem cartItem = null;
        //收取购物车商品列表
        List<CartItem> itemList = getCartItemList(request);
        //判断购物车商品列表是否存在此商品
        for (CartItem item : itemList) {
            //如果存在此商品
            if (item.getId() == itemId) {
                //增加商品数量
                item.setQuantity(item.getQuantity() + 1);
                cartItem = item;
                break;
            }
        }
        if (cartItem == null) {
            cartItem = new CartItem();
            Msg msg = bookService.getBookByPrimary(itemId);
            if (msg.getCode() == 100) {
                Book book = (Book) msg.getExtend().get("book");
                cartItem.setQuantity(1);
                cartItem.setB_id(book.getbId());
                cartItem.setId(book.getbId());
                cartItem.setAuthor(book.getAuthor());
                cartItem.setBook_image(book.getBookImage());
                cartItem.setBook_name(book.getBookName());
                cartItem.setPrice(book.getPrice());
                cartItem.setPubilshing(book.getPubilshing());
            }
            //添加到购物车列表
            itemList.add(cartItem);
        }
        CookieUtil.setCookie(request, response, "ZouCart", JsonUtils.objectToJson(itemList), true);
        return Msg.success();
    }

    /**
     * 获取购物车信息
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    public List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response) {
        //从cookies中取得商品列表
        String cartJson = CookieUtil.getCookieValue(request, "ZouCart", true);
        if (cartJson == null) {
            return new ArrayList<>();
        }
        //把json转换成商品列表
        try {
            List<CartItem> list = JsonUtils.jsonToList(cartJson, CartItem.class);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * 删除购物车商品
     *
     * @param itemId
     * @param request
     * @param response
     * @return
     */
    @Override
    public Msg deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response) {
        //从cookies中获取购物车列表
        List<CartItem> itemList = getCartItemList(request);
        //从列表中找到此商品
        for (CartItem cartItem : itemList) {
            if (cartItem.getId() == itemId) {
                itemList.remove(cartItem);
                break;
            }
        }
        //把购物车列表重新写入cookies
        CookieUtil.setCookie(request, response, "ZouCart", JsonUtils.objectToJson(itemList), true);
        return Msg.success();
    }

    /**
     * 更新购物车数据
     *
     * @param itemId
     * @param quantity
     * @param request
     * @param response
     * @return
     */
    @Override
    public Msg updateItem(long itemId, int quantity, HttpServletRequest request, HttpServletResponse response) {
        List<CartItem> itemList = getCartItemList(request);
        for (CartItem cartItem : itemList) {
            if (cartItem.getId() == itemId) {
                cartItem.setQuantity(quantity);
                break;
            }
        }
        CookieUtil.setCookie(request, response, "ZouCart", JsonUtils.objectToJson(itemList), true);
        return Msg.success();
    }

    /**
     * 从cookies中取商品列表
     *
     * @param request
     * @return
     */
    private List<CartItem> getCartItemList(HttpServletRequest request) {
        //从cookie中取商品列表
        String cartJson = CookieUtil.getCookieValue(request, "ZouCart", true);
        if (cartJson == null) {
            return new ArrayList<>();
        }
        //把json转换成商品列表
        try {
            List<CartItem> list = JsonUtils.jsonToList(cartJson, CartItem.class);
            if(list==null){
                list = new ArrayList<>();
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
