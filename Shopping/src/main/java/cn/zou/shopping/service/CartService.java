package cn.zou.shopping.service;

import cn.zou.shopping.bean.CartItem;
import cn.zou.shopping.bean.Msg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 邹创基 on 2018/5/23 12:55
 *
 * @Description:
 */

public interface CartService {
    //添加购物车商品
    Msg addCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
    //获取购物车信息
    List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);
    //删除购物车商品
    Msg deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
    //更新购物车数据
    Msg updateItem(long itemId, int quantity, HttpServletRequest request, HttpServletResponse response);
}