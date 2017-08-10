package com.wds.app.user.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 *
 * Created by wuds on 2017/7/28.
 */
@TableName(value = "user_info")
@Setter
@Getter
public class UserInfo extends Model<UserInfo>{

    private static final long serialVersionUID = 1109141237853117226L;

    @TableId
    private Long id;

    // 登录用户名
    private String name;

    // 昵称
    private String nickName;

    // 邮箱
    private String email;

    // 密码
    private String password;

    // 电话
    private String phone;

    // 创建时间
    private Date createTime;

    // 创建者
    private String createBy;

    // 修改时间
    private Date modifyTime;

    // 修改者
    private String modifyBy;

    // 是否删除
    private Boolean isDeleted;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
