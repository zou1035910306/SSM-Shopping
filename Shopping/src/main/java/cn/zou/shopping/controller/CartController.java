package cn.zou.shopping.controller;

import cn.zou.shopping.bean.CartItem;
import cn.zou.shopping.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 邹创基 on 2018/5/23 12:50
 *
 * @Description:购物车Controller
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping("/add/{itemId}")
    public String addCartItem(@PathVariable Long itemId, HttpServletRequest request, HttpServletResponse response) {
        cartService.addCartItem(itemId, request, response);
        return "cart/success";
    }

    @RequestMapping("/cart")
    public String toCart(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<CartItem> list = cartService.getCartItemList(request, response);
        model.addAttribute("cartList", list);
        return "cart/cartList";
    }

    @RequestMapping("/delete/{itemId}")
    public String deleteCartItem(@PathVariable Long itemId, HttpServletRequest request, HttpServletResponse response) {
        cartService.deleteCartItem(itemId, request, response);
        return "redirect:/cart/cart";
    }

    @RequestMapping("/updateQuantity/{itemId}/{itemQuantity}")
    public String updateQuantity(@PathVariable("itemId") Long itemId, @PathVariable("itemQuantity") Integer quantity,
                                 HttpServletRequest request, HttpServletResponse response) {
        cartService.updateItem(itemId, quantity, request, response);
        return "redirect:/cart/cart";
    }
}
