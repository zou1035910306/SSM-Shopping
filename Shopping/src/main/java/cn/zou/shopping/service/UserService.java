package cn.zou.shopping.service;

import cn.zou.shopping.bean.Msg;
import cn.zou.shopping.bean.User;

import java.util.List;

/**
 * Created by 邹创基 on 2018/5/21 9:43
 *
 * @Description:
 */

public interface UserService {
    //通过主键获取用户
    public User selectByPrimary(long id);
    //获得所有普通用户
    public List<User> getAllUserRoleUser();
    //获得所有管理员
    public List<User> getAllAdminRoleAdmin();
    //通过用户名查找用户
    public User selectByUsername(String username);
    //通过用户名模糊查找用户
    public List<User> selectBylikeUsername(String username);
    //获得用户权限
    public List<String> getRoles(String username);
    //检查是否有用户已使用该用户名
    public boolean checkUser(String username);
    //注册普通用户
    public void saveUser(User user);
    //冻结用户
    public Msg deleteUser(Integer id);
    //解冻用户
    public Msg startUser(Integer id);
    //更新用户信息
    public Msg updateUser(User user);
}
