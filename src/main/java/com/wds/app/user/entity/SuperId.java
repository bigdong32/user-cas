package com.wds.app.user.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-11 9:55
 */
@Setter
@Getter
public class SuperId<T extends Model> extends Model<T>{

    private static final long serialVersionUID = -4948320909935601967L;

    @TableId
    private Long id;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
