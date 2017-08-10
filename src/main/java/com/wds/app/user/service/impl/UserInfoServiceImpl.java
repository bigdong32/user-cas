package com.wds.app.user.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wds.app.user.entity.UserInfo;
import com.wds.app.user.mapper.UserInfoMapper;
import com.wds.app.user.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-10 16:44
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService{
}
