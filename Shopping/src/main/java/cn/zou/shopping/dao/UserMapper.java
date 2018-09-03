package cn.zou.shopping.dao;

import cn.zou.shopping.bean.User;

import java.util.List;

public interface UserMapper {
    //获取普通用户
    List<User> getAllUserRoleUser();
    //获取管理员
    List<User> getAllAdminRoleAdmin();
    //通过主键找到用户
    public User selectByPrimary(long id);
    //通过名字找到用户
    User selectByUsername(String username);
    //通过名字模糊查找用户
    List<User> selectBylikeUsername(String username);
    //获取当前用户所有角色
    List<String> getRoles(String username);
    //检查是否已经存在此用户名
    long checkUser(String username);
    //保存注册用户
    int saveUser(User user);
    //为用户设置默认角色
    int setUserRole(Long uId);
    //将用户的Status更改为2
     void deleteUser(Integer id);
     //将用户的Status更改为1
     void startUser(Integer id);
    //更新用户信息
    void updateUser(User user);
}