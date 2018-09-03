package cn.zou.shopping.service.Impl;

import cn.zou.shopping.bean.Allint;
import cn.zou.shopping.bean.Detail;
import cn.zou.shopping.bean.Order;
import cn.zou.shopping.dao.BookMapper;
import cn.zou.shopping.dao.OrderMapper;
import cn.zou.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by 邹创基 on 2018/5/25 20:59
 *
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    BookMapper bookMapper;

    @Override
    @Transactional(rollbackFor = {Exception.class},propagation = Propagation.REQUIRED,readOnly = false)
    public String create(Allint allint, Order order, List<Detail> details) throws Exception {
        //调用创建订单服务前补全用户信息
        //从cookie中取得购物车的内容，然后获取用户信息
        String orderId = new Date().getTime() + UUID.randomUUID().toString().substring(0, 5);
        order.setoId(orderId);
        orderMapper.insert(order);
        int i = 0;
        for (Detail detail : details) {
            long bId = allint.getInts().get(i);
            long stock = bookMapper.checkBookStock(bId);
            long bookNum = detail.getBookNum();
            if (stock < bookNum) {
                throw new Exception();
            }
            //补全订单明细信息并存储
            detail.setoId(orderId);
            orderMapper.insertDetail(detail);
            //减少书本库存，增加书本销量
            HashMap<String, Long> map = new HashMap<>();
            map.put("stock", (long) detail.getBookNum());
            map.put("bId", allint.getInts().get(i));
            bookMapper.reduceBook(map);
            i = i + 1;
        }
        return orderId;
    }

    @Override
    public List<Order> getAllOrder() {
        return orderMapper.getAllOrder();
    }

    @Override
    public List<Order> getAllOrderByUser(Long id) {
        return orderMapper.getAllOrderByUser(id);
    }

    @Override
    public List<Detail> getAllDetailByOrder(String id) {
        return orderMapper.getAllDetailByOrder(id);
    }
}
