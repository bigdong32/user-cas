package com.wds.app.user.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wds.app.user.entity.UserInfo;
import com.wds.app.user.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * DESCRIPTION
 *
 * @author wdongsen@linesum.com
 * @data 2017-08-10 16:25
 */
@RestController
public class UserInfoController {

    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping("/getAll")
    public void testU(){
        UserInfo userInfo = new UserInfo();
        List<UserInfo> userInfos = userInfo.selectAll();
        userInfos.forEach(userInfoEntity -> {
            System.out.println(userInfoEntity.getName());
        });

        List<UserInfo> userInfoList = iUserInfoService.selectList(null);
        userInfoList.forEach(userInfo1 -> {
            System.out.println(userInfo1.getName());
        });
    }
}
