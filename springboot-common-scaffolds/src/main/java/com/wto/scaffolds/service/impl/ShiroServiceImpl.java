package com.wto.scaffolds.service.impl;

import com.wto.scaffolds.mapper.SysUserMapper;
import com.wto.scaffolds.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <pre>
 * mesgType:ShiroServiceImpl
 * message desc:
 *
 * create date: 2021/6/24 14:50
 * <pre>
 **/
@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public Set<String> getUserPermissions(Long id) {
        Set<String> perms = sysUserMapper.queryAllPerms(id);
        return perms;
    }
}
