package com.wds.app.user.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-11 14:28
 */
@TableName(value = "user_role_permission")
@Setter
@Getter
public class UserRolePermission extends SuperEntity<UserRolePermission>{

    private static final long serialVersionUID = -2589826446581059300L;

    // 用户角色标识
    private Long userRoleId;

    // 用户权限标识
    private Long userPermissionId;
}
