package com.wds.app.user.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-11 14:24
 */
@TableName(value = "user_permission")
@Setter
@Getter
public class UserPermission extends SuperEntity<UserPermission>{

    private static final long serialVersionUID = -5215557099707725992L;

    // 权限名称
    private String name;

    // 资源项
    private String resources;
}
