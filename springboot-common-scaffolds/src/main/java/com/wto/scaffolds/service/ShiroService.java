package com.wto.scaffolds.service;

import java.util.Set;

/**
 * <pre>
 * mesgType:ShiroService
 * message desc: 权限接口类
 *
 * create date: 2021/6/24 14:49
 * <pre>
 **/
public interface ShiroService {
    /**
     * 获取用户权限
     * @param id
     * @return
     */
    Set<String> getUserPermissions(Long id);
}
