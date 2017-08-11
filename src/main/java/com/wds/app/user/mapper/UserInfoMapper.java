package com.wds.app.user.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.wds.app.SupperMapper;
import com.wds.app.user.entity.UserInfo;

import java.util.List;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-10 15:13
 */
public interface UserInfoMapper extends SupperMapper<UserInfo>{

    List<UserInfo> getUserInfosByPage(Pagination page);

    List<UserInfo> getUserInfoWithUserRolesByPage(Pagination page);
}
