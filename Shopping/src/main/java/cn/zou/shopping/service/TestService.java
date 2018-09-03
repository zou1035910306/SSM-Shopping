package cn.zou.shopping.service;

import cn.zou.shopping.bean.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 邹创基 on 2018/6/21 12:29
 *
 * @Description:
 */
public interface TestService {
    //测试事务
    public void addUser(User user);
}
