package com.wto.scaffolds.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wto.scaffolds.model.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {
    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    Set<String> queryAllPerms(Long userId);

    /**
     * 根据用户名查询用户
     */
    SysUserEntity selectOne (@Param("userName") String userName) ;

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);
}
