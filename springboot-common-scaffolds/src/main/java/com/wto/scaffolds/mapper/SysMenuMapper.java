package com.wto.scaffolds.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wto.scaffolds.model.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {
    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<SysMenuEntity> queryListParentId(Long parentId);

    /**
     * 查询全部数据
     */
    List<SysMenuEntity> selectList () ;

    /**
     * 获取不包含按钮的菜单列表
     */
    List<SysMenuEntity> queryNotButtonList();
}
