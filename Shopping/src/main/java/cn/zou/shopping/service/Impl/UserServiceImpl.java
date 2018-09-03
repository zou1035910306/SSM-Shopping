package cn.zou.shopping.service.Impl;

import cn.zou.shopping.bean.Msg;
import cn.zou.shopping.bean.User;
import cn.zou.shopping.dao.UserMapper;
import cn.zou.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 邹创基 on 2018/5/17 10:51
 *
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<User> getAllUserRoleUser(){
        return userMapper.getAllUserRoleUser();
    }

    @Override
    public List<User> getAllAdminRoleAdmin() {
        return userMapper.getAllAdminRoleAdmin();
    }

    /**
     * 通过主键查找用户
     * @param id
     * @return
     */
    @Override
    public User selectByPrimary(long id) {
        return userMapper.selectByPrimary(id);
    }

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    @Override
    public User selectByUsername(String username){
        return userMapper.selectByUsername(username);
    }

    @Override
    public List<User> selectBylikeUsername(String username) {
        return userMapper.selectBylikeUsername(username);
    }

    /**
     * 根据用户名获取用户角色
     * @param username
     * @return
     */
    @Override
    public List<String> getRoles(String username){
        return userMapper.getRoles(username);
    }

    /**
     * 检查是否已经存在此用户名
     * @param username
     * @return
     */
    @Override
    public boolean checkUser(String username) {
        return userMapper.checkUser(username)==0;
    }

    /**
     * 保存注册用户
     * @param user
     */
    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
        userMapper.setUserRole(user.getuId());
    }

    /**
     * 将用户的Status更改为2
     * @param id
     */
    public Msg deleteUser(Integer id){
        try {
            userMapper.deleteUser(id);
            return Msg.success();
        } catch (Exception e) {
            return Msg.fail();
        }
    }

    /**
     * 将用户的Status更改为1
     * @param id
     */
    public Msg startUser(Integer id) {
        try {
            userMapper.startUser(id);
            return Msg.success();
        } catch (Exception e) {
            return Msg.fail();
        }
    }

    /**
     * 更改用户信息
     * @param user
     * @return
     */
    @Override
    public Msg updateUser(User user) {
        userMapper.updateUser(user);
        return Msg.success();
    }

}
