package com.wds.app.user.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-11 11:22
 */
@TableName(value = "user_info_role")
@Setter
@Getter
public class UserInfoRole extends SuperEntity<UserInfoRole>{

    private static final long serialVersionUID = 4172672606683618813L;

    // 用户信息标识
    private Long userInfoId;

    // 用户角色标识
    private Long userRoleId;
}
