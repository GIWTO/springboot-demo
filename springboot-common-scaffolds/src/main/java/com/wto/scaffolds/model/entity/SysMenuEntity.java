package com.wto.scaffolds.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.List;

/**
 * <pre>
 * mesgType:sysMenu
 * message desc:
 *
 * create date: 2021/6/23 16:26
 * <pre>
 **/
@Data
@Accessors(chain = true)
@ApiModel(description = "菜单")
@Alias("SysMenu")
@TableName("sys_menu")
public class SysMenuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    @ApiModelProperty(name = "menuId", value = "主键", dataType = "String", required = true)
    private Long menuId;

    @ApiModelProperty(name = "parentId", value = "父菜单ID，一级菜单为0", dataType = "Long", required = true)
    private Long parentId;

    @ApiModelProperty(name = "parentName", value = "菜单名称", dataType = "String", required = true)
    private String parentName;

    @ApiModelProperty(name = "name", value = "部门名称", dataType = "String", required = true)
    private String name;

    @ApiModelProperty(name = "url", value = "菜单URL", dataType = "String", required = true)
    private String url;

    @ApiModelProperty(name = "perms", value = "授权(多个用逗号分隔，如：user:list,user:create)", dataType = "String", required = true)
    private String perms;

    @ApiModelProperty(name = "type", value = "类型   0：目录   1：菜单   2：按钮", dataType = "Integer", required = true)
    private Integer type;

    @ApiModelProperty(name = "icon", value = "菜单图标", dataType = "String", required = true)
    private String icon;

    @ApiModelProperty(name = "orderNum", value = "排序", dataType = "String", required = true)
    private Integer orderNum;

    @TableField(exist=false)
    @ApiModelProperty(name = "open", value = "是否放开", dataType = "String", required = true)
    private Boolean open;

    @TableField(exist=false)
    @ApiModelProperty(name = "list", value = "部门名称", dataType = "String", required = true)
    private List<?> list;
}
