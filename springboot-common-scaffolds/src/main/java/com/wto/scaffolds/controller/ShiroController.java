package com.wto.scaffolds.controller;

import com.wto.scaffolds.mapper.SysMenuMapper;
import com.wto.scaffolds.util.ShiroUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <pre>
 * mesgType:ShiroController
 * message desc:
 *
 * create date: 2021/6/23 17:12
 * <pre>
 **/
@RestController
public class ShiroController {
    private static Logger logger = LoggerFactory.getLogger(ShiroController.class) ;

    @Resource
    private SysMenuMapper sysMenuMapper ;
    /**
     * 登录测试
     * http://localhost:8080/scaffolds/userLogin?userName=admin&passWord=admin
     */
    @GetMapping("/userLogin")
    public String userLogin (
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "passWord") String passWord){
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
            subject.login(token);
            logger.info("登录成功");
        return "login success";
    }

    /**
     * 服务器每次重启请求该接口之前必须先请求上面登录接口
     * http://localhost:8080/scaffolds/menu/list 获取所有菜单列表
     * 权限要求：sys:user:shiro
     */
    @PostMapping("/menu/list")
    @RequiresPermissions("sys:user:shiro")
    public List list(){
        return sysMenuMapper.selectList() ;
    }

    /**
     * 用户没有该权限，无法访问
     * 权限要求：ccc:ddd:bbb
     */
    @PostMapping("/menu/list2")
    @RequiresPermissions("ccc:ddd:bbb")
    public List list2(){
        return sysMenuMapper.selectList() ;
    }

    /**
     * 退出测试
     */
    @PostMapping("/userLogOut")
    public String logout (){
        ShiroUtils.logout();
        return "success" ;
    }

    @PostMapping("/NoAuth")
    public String notAuth (){
        logger.info("没有权限");
        return "NoAuth" ;
    }

}
