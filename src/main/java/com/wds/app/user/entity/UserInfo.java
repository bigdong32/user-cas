package com.wds.app.user.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 用户信息
 *
 * Created by wuds on 2017/7/28.
 */
@TableName(value = "user_info")
@Setter
@Getter
public class UserInfo extends SuperEntity<UserInfo>{

    private static final long serialVersionUID = 1109141237853117226L;

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

    // 用户权限列表
    @TableField(exist = false)
    private List<UserRole> userRoles;

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", userRoles=" + userRoles +
                '}';
    }
}
