package com.jk.config;

import com.jk.bean.Staff;
import com.jk.service.ShiroService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Resource
    private ShiroService shiroService;

    /**
     * 授权器
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Staff staff = (Staff) principals.getPrimaryPrincipal();
        List<String> list = shiroService.getPermission(staff.getUsername());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(list);
        return info;
    }

    /**
     * 认证器
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        Staff staff = shiroService.getUser(username);
        if (!username.equals(staff.getUsername())){
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(staff,staff.getPassword(),this.getName());
        return info;
    }
}
