package com.wds.app.user.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体
 * @author wdongsen@linesum.com
 * @data 2017-08-10 17:58
 */
@Setter
@Getter
public class SuperEntity<T extends Model> extends Model<T>{

    private static final long serialVersionUID = -6681997722988257864L;

    // 主键
    @TableId
    private Long id;

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
