package cn.zou.shopping.dao;

import cn.zou.shopping.bean.Detail;
import cn.zou.shopping.bean.Order;

import java.util.List;

public interface OrderMapper {

    //插入订单
    int insert(Order order);
    //插入订单细节
    int insertDetail(Detail detail);
    //查询所有订单
    List<Order> getAllOrder();
    //查询订单该用户所属订单
    List<Order> getAllOrderByUser(Long id);
    //查询该订单所属细节
    List<Detail> getAllDetailByOrder(String id);
}