package com.skyblue.realm;

import com.skyblue.entity.SysMenu;
import com.skyblue.entity.SysUser;
import com.skyblue.mapper.SysMenuDao;
import com.skyblue.mapper.SysUserDao;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import org.apache.commons.lang.StringUtils ;

/**
 * @author TremBear
 * @email 1424479171@qq.com
 * @date 2018-05-24 14:18
 */

public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysUserDao sysUserDao;
    /**
     * 授权
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUser user = (SysUser)principals.getPrimaryPrincipal();
        Long userId = user.getUserId();

        List<String> permsList = null;
        System.out.println("--------success authorizater-------------");
        //系统管理员，拥有最高权限
        if(userId == 1){
            List<SysMenu> menuList = sysMenuDao.queryList(new HashMap<String, Object>());
            permsList = new ArrayList<>(menuList.size());
            for(SysMenu menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = sysUserDao.queryAllPerms(userId);
        }

        //用户权限列表
        Set<String> permsSet = new HashSet<String>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }
    /**
     * 认证
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        System.out.println("--------success authenticator-------------");
        //查询用户信息
        SysUser user = sysUserDao.queryByUserName(username);

        //账号不存在
        if(user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        //密码错误
        if(!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }

        //账号锁定
        if(user.getStatus() == 0){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
