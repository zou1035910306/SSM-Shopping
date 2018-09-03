package cn.zou.shopping.controller;

import cn.zou.shopping.bean.*;
import cn.zou.shopping.service.CartService;
import cn.zou.shopping.service.OrderService;
import cn.zou.shopping.utils.CookieUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 邹创基 on 2018/5/25 16:55
 *
 * @Description:
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    CartService cartService;
    @Autowired
    OrderService orderService;

    @RequestMapping("/toindex")
    public String showOrderCart(HttpServletRequest request, HttpServletResponse response, Model model) {

        //去购物车商品列表
        List<CartItem> list = cartService.getCartItemList(request, response);
        //传递给页面
        model.addAttribute("cartList", list);
        return "order/order-cart";
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public String createOrder(Allint allint,Order order, DetailList detailList, Model model, HttpServletRequest request, HttpServletResponse response) {
        try {
            //从session中取得用户信息
            User user = (User) request.getSession().getAttribute("user");
            //在order对象中补全用户信息
            order.setuId(user.getuId());
            order.setOrderStatus(1);
            order.setUsername(user.getUsername());
            //调用服务
            String orderId = orderService.create(allint,order, detailList.getDetails());
            CookieUtil.deleteCookie(request, response, "ZouCart");
            model.addAttribute("orderId", orderId);
            model.addAttribute("dat a", new DateTime().plusDays(3).toString("yyyy-MM-dd"));
            return "redirect:/book/toindex";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "创建订单出错,请稍后重试！");
            model.addAttribute("data", new DateTime().plusDays(3).toString("yyyy-MM-dd"));
            return "commons/error";
        }
    }

    @RequestMapping(value = "/myOrder/{uId}", method = RequestMethod.GET)
    public String myOrder(@PathVariable("uId") Long uId, Model model) {
        List<Order> orders = orderService.getAllOrderByUser(uId);
        model.addAttribute("orders", orders);
        return "order/order";
    }

    @RequestMapping(value = "/getAllDetailByOrder/{oId}", method = RequestMethod.GET)
    public String getAllDetailByOrder(@PathVariable("oId") String oId, Model model) {
        List<Detail> details = orderService.getAllDetailByOrder(oId);
        model.addAttribute("details", details);
        return "order/orderDetail";
    }
}
