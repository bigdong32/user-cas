package com.wds.app.user.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-11 11:28
 */
@TableName(value = "user_role")
@Setter
@Getter
public class UserRole extends SuperEntity<UserRole>{

    private static final long serialVersionUID = -8239453232695333393L;

    // 角色名
    private String name;
}
