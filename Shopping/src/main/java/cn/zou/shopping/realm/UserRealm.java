package cn.zou.shopping.realm;

import cn.zou.shopping.bean.User;
import cn.zou.shopping.service.Impl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

/**
 * Created by 邹创基 on 2018/5/19 18:19
 *
 * @Description:
 */

public class UserRealm extends AuthorizingRealm{
    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * 登录之后用于授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(new HashSet<>(userServiceImpl
                .getRoles(username)));
        return authorizationInfo;
    }


    /**
     * 用于验证身份
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();
        User user = userServiceImpl.selectByUsername(username);
        if(user == null||user.getStatus()==2 ) {
            //找不到账号或已被冻结
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(), //用户名
                user.getPassword(),
                getName()  //realm name
        );

        return authenticationInfo;
    }
}
