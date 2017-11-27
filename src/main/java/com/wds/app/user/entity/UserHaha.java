package com.wds.app.user.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-09-19 10:47
 */
@TableName(value = "user_haha")
@Setter
@Getter
public class UserHaha extends SuperId<UserHaha> {

    private static final long serialVersionUID = 5582360122057587113L;

    private Date createTime;

}
