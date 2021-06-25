package com.wto.scaffolds.model.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;

/**
 * <pre>
 * mesgType:User
 * message desc:
 *
 * create date: 2021/6/23 16:00
 * <pre>
 **/
@Data
@Accessors(chain = true)
@Alias("SysUser")
@TableName("sys_user")
public class SysUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "userid",type = AUTO)
    @ApiModelProperty(name = "userId", value = "用户id", dataType = "Long", required = true)
    private Long userId;

    @ApiModelProperty(name = "userName", value = "用户名称", dataType = "String", required = true)
    private String userName;

    @ApiModelProperty(name = "passWord", value = "用户密码", dataType = "String", required = true)
    private String passWord;

    @ApiModelProperty(name = "salt", value = "盐", dataType = "String", required = true)
    private String salt;

    @ApiModelProperty(name = "email", value = "用户邮箱", dataType = "String", required = true)
    private String email;

    @ApiModelProperty(name = "mobile", value = "用户手机", dataType = "String", required = true)
    private String mobile;

    @ApiModelProperty(name = "status", value = "用户状态", dataType = "String", required = true)
    private Integer status;

    @TableField(exist=false)
    @ApiModelProperty(name = "roleIdList", value = "用户角色列表", dataType = "List", required = true)
    private List<Long> roleIdList;

    @ApiModelProperty(name = "createTime", value = "用户注册时间", dataType = "Date", required = true)
    private Date createTime;

    @ApiModelProperty(name = "deptId", value = "部门Id", dataType = "Long", required = true)
    private Long deptId;

    @TableField(exist=false)
    @ApiModelProperty(name = "deptName", value = "部门名称", dataType = "String", required = true)
    private String deptName;
}
