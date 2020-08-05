package com.dfec.redisshiroswagger.conf;

import com.dfec.redisshiroswagger.Service.ILoginService;
import com.dfec.redisshiroswagger.domain.Permission;
import com.dfec.redisshiroswagger.domain.Role;
import com.dfec.redisshiroswagger.domain.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author qsg
 * @version 1.0 v
 * @Classname MyRealm
 * @Date 2020/7/21 9:55
 * @Copyright DFEC
 **/
//用户认证
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private ILoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name = (String)principalCollection.getPrimaryPrincipal();
        User user = loginService.findByName(name);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取用户角色
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            String roleName = role.getRoleName();
            //添加角色
            simpleAuthorizationInfo.addRole(roleName);
            //获取某个角色权限
            List<Permission> permissions = role.getPermissions();
            for (Permission permission : permissions) {
                //添加权限
                simpleAuthorizationInfo.addStringPermission(permission.getPermission());
            }
        }

        return simpleAuthorizationInfo;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        User user = loginService.findByName(name);
        if(null==user)return null;
        else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword().toString(),super.getName());
            return simpleAuthenticationInfo;
        }
    }
}
