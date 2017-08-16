package com.wds.app.user.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.wds.app.user.entity.UserInfo;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-10 16:36
 */
public interface IUserInfoService extends IService<UserInfo>{

    Page<UserInfo> getUserInfosByPage(Page<UserInfo> page);

    Page<UserInfo> getUserInfoWithUserRolesByPage(Page<UserInfo> page);
}
