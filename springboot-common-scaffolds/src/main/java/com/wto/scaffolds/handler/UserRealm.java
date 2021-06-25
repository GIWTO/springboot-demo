package com.wto.scaffolds.handler;

import com.wto.scaffolds.mapper.SysMenuMapper;
import com.wto.scaffolds.mapper.SysUserMapper;
import com.wto.scaffolds.model.entity.SysUserEntity;
import com.wto.scaffolds.service.ShiroService;
import com.wto.scaffolds.util.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * <pre>
 * mesgType:UserRealm
 * message desc:
 *
 * create date: 2021/6/23 15:59
 * <pre>
 **/
@Component
public class UserRealm extends AuthorizingRealm {
    @Resource
    private SysUserMapper sysUserMapper ;
    @Resource
    private SysMenuMapper sysMenuMapper ;
    @Resource
    private ShiroService shiroService;
    /**
     * 授权(验证权限时调用)
     * 获取用户权限集合
     */
    @Override
    public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUserEntity user = (SysUserEntity)principals.getPrimaryPrincipal();
        if(user == null) {
            throw new UnknownAccountException("账号不存在");
        }
        //用户权限列表
        Set<String> permsSet = shiroService.getUserPermissions(user.getUserId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }
    /**
     * 认证(登录时调用)
     * 验证用户登录
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authToken;
        //查询用户信息
        SysUserEntity user = sysUserMapper.selectOne(token.getUsername());
        //账号不存在
        if(user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        //账号锁定
        if(user.getStatus() == 0){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo
                (user, user.getPassWord(),
                        ByteSource.Util.bytes(user.getSalt()),
                        getName());
        return info;
    }
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
        shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
        super.setCredentialsMatcher(shaCredentialsMatcher);
    }
}
